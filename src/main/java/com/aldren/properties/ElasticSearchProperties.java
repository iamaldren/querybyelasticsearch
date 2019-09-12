package com.aldren.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "es")
public class ElasticSearchProperties {

    private String[] instances;

    private String connection;

    private String username;

    private String password;

}
