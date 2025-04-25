package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Get;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Result;
import org.noear.solon.scheduling.annotation.Async;

@Controller
@Slf4j
public class DemoController {
    @Mapping("/hello")
    public String hello(@Param(defaultValue = "world") String name) {
        return String.format("Hello %s!", name);
    }
    
    @Mapping("/hello2")
    public ModelAndView hello2(@Param(defaultValue = "world") String name) {
        return new ModelAndView("hello2.ftl").put("name", name);
    }

    @Get
    @Mapping("start-task")
    @Async
    public Result<Void> startTask(TaskParam taskParam) {
        try {
            log.info("start task---------------------------");
            Thread.sleep(1000 * Long.parseLong(taskParam.getSleepSeconds()));
        } catch (InterruptedException e) {
            return Result.failure(500, e.getMessage());
        }
        return Result.succeed();
    }
}