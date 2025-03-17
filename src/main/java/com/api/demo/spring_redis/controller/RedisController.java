package com.api.demo.spring_redis.controller;

import com.api.demo.spring_redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/add")
    public void saveToRedis(@RequestParam String key, @RequestParam String value) {
        log.info("SET redis key: " + key + " value: " + value);
        redisService.saveData(key, value);
    }

    @GetMapping("/get")
    public String getDataFromRedis(@RequestParam String key) {
        log.info("GET redis key: " + key);
        return redisService.getData(key);
    }

    @DeleteMapping("/delete")
    public void deleteFromRedis(@RequestParam String key) {
        log.info("DELETE redis key: " + key);
        redisService.deleteData(key);
    }
}
