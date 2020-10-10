package com.study.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.study.entity.Book;

import java.util.List;

/**
 * @author Administrator
 */
public interface BookService extends IService<Book> {
    /**
     * 保存书籍信息
     *
     * @param book
     * @return
     */
    @Override
    boolean save(Book book);

    /**
     * 查询全部书籍信息
     *
     * @return
     */
    List<Book> getBookList();
}
