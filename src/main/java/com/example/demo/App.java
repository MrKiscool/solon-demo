package com.example.demo;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.scheduling.annotation.EnableAsync;

@EnableAsync
@SolonMain
public class App {
    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}