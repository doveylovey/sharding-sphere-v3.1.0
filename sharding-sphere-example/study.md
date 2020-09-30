# sharding-sphere-example 学习笔记

### 在使用 IDEA + Git 提代码时，会报 "Filename too long" 错，解决办法如下：
```text
局部设置(对当前项目有效)：git config core.longpaths true
全局设置(对所有项目有效)：git config --system core.longpaths true
查看设置结果：git config core.longpaths
```

### 参考文章
- ShardingSphere之分库&分表：https://blog.csdn.net/justry_deng/article/details/90815986
- 【分库分表】sharding-jdbc—分片策略：https://www.cnblogs.com/mr-yang-localhost/p/8313360.html
