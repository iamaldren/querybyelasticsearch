package com.aldren.config;

import com.aldren.properties.ElasticSearchProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class ElasticSearchConfiguration {

    @Autowired
    private ElasticSearchProperties props;

    @Bean
    public RestHighLevelClient restHighLevelClient() {

        List<HttpHost> nodes = new ArrayList<>();
        Arrays.stream(props.getInstances()).forEach(instance -> {
            String[] instancesProps = instance.split(":");
            nodes.add(new HttpHost(instancesProps[0], Integer.parseInt(instancesProps[1]), props.getConnection()));
        });

        RestClientBuilder restClientBuilder = RestClient.builder(nodes.toArray(new HttpHost[nodes.size()]));

        if(!props.getUsername().isEmpty() && !props.getPassword().isEmpty()) {
            CredentialsProvider credentials = new BasicCredentialsProvider();
            credentials.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(props.getUsername(), props.getPassword()));
            restClientBuilder.setHttpClientConfigCallback(clientBuilder -> clientBuilder.setDefaultCredentialsProvider(credentials));
        } else {
            log.warn("No credentials provided for Elastic Search. Connection will be \"no authentication\"");
        }

        restClientBuilder.setFailureListener(new RestClient.FailureListener() {
            @Override
            public void onFailure(Node node) {
                log.error("Error connecting to node: {}", node.toString());
            }
        });

        //restClientBuilder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);

        return new RestHighLevelClient(restClientBuilder);
    }

}
