package com.example.demo.design.proxy;

/**
 * 实现代理逻辑调用的方法
 * @author yangkaile
 * @date 2019-06-07 18:14:16
 */
public class BookController {
    public static void main(String[] args){
        ProxyCglib cglib = new ProxyCglib();
        BookService bookService = (BookService) cglib.getInstance(new BookService());
        bookService.addBook(1,"Java");
    }
}
