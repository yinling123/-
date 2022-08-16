package com.example.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 4; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        System.out.println(Thread.currentThread().getName() + "进行检测");
                    }
                }
            });
        }
    }
}
