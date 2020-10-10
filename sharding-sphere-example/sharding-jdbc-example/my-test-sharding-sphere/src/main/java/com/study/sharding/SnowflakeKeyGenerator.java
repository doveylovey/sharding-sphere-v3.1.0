package com.study.sharding;

import io.shardingsphere.core.keygen.KeyGenerator;

import java.util.Random;

/**
 * @author Administrator
 */
public class SnowflakeKeyGenerator implements KeyGenerator {
    /**
     * 开始时间截(2015-01-01)
     */
    private final long twepoch = 1420041600000L;

    /**
     * 机器 id 所占的位数
     */
    private final long workerIdBits = 5L;

    /**
     * 数据标识 id 所占的位数
     */
    private final long dataCenterIdBits = 5L;

    /**
     * 支持的最大机器 id，结果是 31(这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 支持的最大数据标识 id，结果是 31
     */
    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

    /**
     * 序列在 id 中占的位数
     */
    private final long sequenceBits = 12L;

    /**
     * 机器 id 向左移 12 位
     */
    private final long workerIdShift = sequenceBits;

    /**
     * 数据标识 id 向左移 7 位(12+5)
     */
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /**
     * 时间截向左移 22 位(5+5+12)
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    /**
     * 生成序列的掩码，这里为 4095(0b111111111111=0xfff=4095)
     */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作机器 id(0~31)
     */
    private long workerId;

    /**
     * 数据中心 id(0~31)
     */
    private long dataCenterId;

    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成 id 的时间截
     */
    private long lastTimestamp = -1L;

    private Random random = new Random();

    public SnowflakeKeyGenerator() {
    }

    /**
     * 构造函数
     *
     * @param workerId     工作 id(0~31)
     * @param dataCenterId 数据中心 id(0~31)
     */
    public SnowflakeKeyGenerator(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("data center Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成 id 的时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * Generate key.
     *
     * @return generated key
     */
    @Override
    public Number generateKey() {
        long timestamp = timeGen();
        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        // 时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        // 上次生成ID的时间截
        lastTimestamp = timestamp;
        long result = ((timestamp - twepoch) << timestampLeftShift) | (dataCenterId << datacenterIdShift) | (workerId << workerIdShift) | sequence;
        int randomNum = random.nextInt(10);
        // 移位并通过或运算拼到一起组成64位的ID
        return result + randomNum;
    }

    /*public static void main(String[] args) {
        SnowflakeKeyGenerator generator = new SnowflakeKeyGenerator(0, 0);
        for (int i = 0; i < 20; i++) {
            System.out.println(generator.generateKey());
        }
    }*/
}
