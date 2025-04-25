package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TaskParam {

    @JsonProperty("task_name")
    private String taskName;

    @JsonProperty("sleep_seconds")
    private String sleepSeconds;

    @JsonProperty("callback_url")
    private String callbackUrl;
}
