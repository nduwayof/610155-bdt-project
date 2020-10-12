package com.twitter.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Kafka properties.
 * @author fabrice
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.kafka", ignoreUnknownFields = false)
public class KafkaProperties {

    private String bootstrapServers;

    private Template template = new Template();

    /**
     * The type Template.
     */
    @Data
    public static class Template{

        private String defaultTopic;

        /**
         * Gets default topic.
         *
         * @return the default topic
         */
        public String getDefaultTopic() {
            return defaultTopic;
        }

        /**
         * Sets default topic.
         *
         * @param defaultTopic the default topic
         */
        public void setDefaultTopic(String defaultTopic) {
            this.defaultTopic = defaultTopic;
        }
    }

    /**
     * Gets bootstrap servers.
     *
     * @return the bootstrap servers
     */
    public String getBootstrapServers() {
        return bootstrapServers;
    }

    /**
     * Sets bootstrap servers.
     *
     * @param bootstrapServers the bootstrap servers
     */
    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    /**
     * Gets template.
     *
     * @return the template
     */
    public Template getTemplate() {
        return template;
    }

    /**
     * Sets template.
     *
     * @param template the template
     */
    public void setTemplate(Template template) {
        this.template = template;
    }
}
