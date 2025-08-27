package dev.safwan.productservice.filter;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/trace")
public class tracingController {
    private final Logger log= LoggerFactory.getLogger(tracingController.class);
    @GetMapping("/api2")
    public String hello() {
        log.info("Service B received request — doing some work [traceId={}, spanId={}]",
                MDC.get("traceId"), MDC.get("spanId"));
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Thread was interrupted while simulating work", e);
        }
        log.info("Service B finished work [traceId={}, spanId={}]",
                MDC.get("traceId"), MDC.get("spanId"));

        return "hello from B";
    }
}
