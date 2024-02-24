package com.betrayal.amazons3test.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectStorageConfiguration {

    @Value("${spring.amazon.key_id}")
    private String keyId;

    @Value("${spring.amazon.secret_key}")
    private String secretKey;

    private static final String ENDPOINT = "https://storage.yandexcloud.net";
    private static final String REGION = "ru-central1";

    @Bean
    public AmazonS3 amazonS3(){
        AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(keyId, secretKey)
                    )
                )
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                        ENDPOINT, REGION
                    )
                ).build();

        return amazonS3;
    }
}
