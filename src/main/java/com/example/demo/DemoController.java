package com.example.demo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.*;
import org.noear.solon.core.handle.Result;

@Controller
@Slf4j
public class DemoController {

    @Inject
    private TaskService taskService;

    private int flag = 0;

//    @Mapping("/hello")
//    public String hello(@Param(defaultValue = "world") String name) {
//        return String.format("Hello %s!", name);
//    }
//
//    @Mapping("/hello2")
//    public ModelAndView hello2(@Param(defaultValue = "world") String name) {
//        return new ModelAndView("hello2.ftl").put("name", name);
//    }

    @Mapping("/test1")
    @Post
    public Result<Void> test(Test1 test1) {
        log.info(JSONUtil.toJsonStr(test1));
        return Result.succeed();
    }

    @Post
    @Mapping("/start-task")
    public Result<Void> startTask(TaskParam taskParam) {
        if (++flag < 3) {
            log.info("flag={}---------------------------", flag);
            return Result.failure(7002, "重试");
        } else {
            flag = 0;
            taskService.asyncTest(taskParam);
            return Result.succeed();
        }
    }


}