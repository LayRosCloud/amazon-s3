package com.betrayal.amazons3test;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AmazonS3TestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AmazonS3TestApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }

}
