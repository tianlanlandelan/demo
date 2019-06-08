package com.example.demo.designpattern.proxy;

/**
 * 用来测试代理模式的Server层代码
 * @author yangkaile
 * @date 2019-06-07 18:07:31
 */
public class BookService {
    public BookEntity addBook(int id,String name){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(id);
        bookEntity.setName(name);
        System.out.println("新增图书:" + bookEntity);
        return bookEntity;
    }
}
