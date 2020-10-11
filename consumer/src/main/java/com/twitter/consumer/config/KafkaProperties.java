package com.twitter.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Kafka properties.
 * @author fabrice
 */
@Component
@ConfigurationProperties(prefix = "spring.kafka", ignoreUnknownFields = false)
public class KafkaProperties {

    private String bootstrapServers;

    private Template template = new Template();

    private Consumer consumer = new Consumer();

    /**
     * The type Template.
     */
    public final class Template{

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
     * The type Consumer.
     */
    public final class Consumer {

        private String groupId;

        /**
         * Gets group id.
         *
         * @return the group id
         */
        public String getGroupId() {
            return groupId;
        }

        /**
         * Sets group id.
         *
         * @param groupId the group id
         */
        public void setGroupId(String groupId) {
            this.groupId = groupId;
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

    /**
     * Gets consumer.
     *
     * @return the consumer
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     * Sets consumer.
     *
     * @param consumer the consumer
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
