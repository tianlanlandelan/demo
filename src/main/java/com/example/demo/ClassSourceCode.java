package com.example.demo;

public @interface ClassSourceCode {
    String packageName();
    String extend();
    String[] implement();
    String description();
    String comparableClass();
}
