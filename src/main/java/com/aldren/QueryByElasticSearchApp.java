package com.aldren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class QueryByElasticSearchApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(QueryByElasticSearchApp.class, args);
    }
}
