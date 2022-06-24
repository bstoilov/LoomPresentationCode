//package com.loom.web;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@EnableAsync
//@Configuration
//public class ServerThreadConfig {
//    @Bean
//    public ThreadPoolTaskExecutor customPool() {
//        return new CustomThreadPoolTaskExecutor();
//    }
//
//    static class CustomThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
//        private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
//
//        @Override
//        public void execute(Runnable task) {
//            executorService.execute(task);
//        }
//    }
//
//}
