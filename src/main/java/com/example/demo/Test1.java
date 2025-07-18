package com.example.demo;

import cn.hutool.core.lang.UUID;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Data
public class Test1 {

    private String version;

    private String request_id;

    private String task_type;

    private Integer stream_output;

    private DataInfo data_info;

    private DataParams data_params;

    @Data
    public class DataInfo {

        private String modal;

        private String type;

        private String data;
    }

    @Data
    public class DataParams {

        private String modal;

        private Integer frame_num;

        private Float confidence_threshold;
    }

    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("/home/liuyuhangwx1/wechat_2025-05-07_155933_771.png");
//        String base64 = Base64.getEncoder().encodeToString(Files.readAllBytes(path));
//        System.out.println(base64);
        String requestId = UUID.fastUUID().toString();
        System.out.println(requestId);
    }
}
