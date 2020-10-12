package com.twitter.producer.config;import lombok.Data;import org.springframework.boot.context.properties.ConfigurationProperties;import org.springframework.stereotype.Component;/** * Twitter Properties specific to Twitter Social properties. * * <p> * Properties are configured in the application.yml file. * </p> * @author fabrice */@Data@Component@ConfigurationProperties(prefix = "spring.social.twitter", ignoreUnknownFields = false)public class TwitterProperties {    private String appId;    private String appSecret;    private String accessToken;    private String accessTokenSecret;}