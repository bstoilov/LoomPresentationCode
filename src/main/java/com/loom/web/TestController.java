//package com.loom.web;
//
//import java.time.LocalTime;
//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import javax.annotation.security.PermitAll;
//import org.springframework.http.MediaType;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@RestController
//@RequestMapping(value = "/api/v1/test")
//public class TestController {
//
//    @Async("customPool")
//    @PermitAll
//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    public CompletableFuture<String> test() throws InterruptedException {
//        Thread.sleep(500);
//        return CompletableFuture.completedFuture("The Meaning of life is 42");
//    }
//
//
//    @GetMapping("/sse")
//    public SseEmitter streamSSE() {
//        SseEmitter emitter = new SseEmitter();
//        ExecutorService sseMvcExecutor = Executors.newVirtualThreadPerTaskExecutor();
//        sseMvcExecutor.execute(() -> {
//            try {
//                while (true) {
//                    SseEmitter.SseEventBuilder event = SseEmitter.event()
//                        .data("SSE time -> " + LocalTime.now().toString())
//                        .id(UUID.randomUUID().toString())
//                        .name("Custom SSE");
//                    emitter.send(event);
//                    Thread.sleep(500);
//                }
//            } catch (Exception ex) {
//                emitter.completeWithError(ex);
//            }
//        });
//        return emitter;
//    }
//}