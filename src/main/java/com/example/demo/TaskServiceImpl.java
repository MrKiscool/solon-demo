package com.example.demo;


import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.scheduling.annotation.Async;

@Slf4j
@Component
public class TaskServiceImpl implements TaskService {

    @Async
    @Override
    public void asyncTest(TaskParam taskParam) {
        log.info("start task---------------------------");
        try {
            Thread.sleep(1000 * Long.parseLong(taskParam.getSleepSeconds()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String s = HttpUtil.get(taskParam.getCallbackUrl());
        log.info("s={}", s);
    }
}
