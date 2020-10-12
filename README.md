# Twitter Streaming Analyze using Java 8, Kafka, Spark Streaming and Hive
A demo project for Big Data Technology using Spark Streaming to analyze popular hashtags from Twitter.
Twitter feeds us data from the Twitter Streaming API and fed the to Kafka.
Our Consumer receives data from Kafka and then processes it in a stream using 
Spark Streaming and store the into Hive where I can run different Hive SQL queries.


## Requirements
* Apache Maven 3.x
* JVM 8
* Docker machine
* Docker Compose
* Registered a Twitter Application. 

## Quickstart guide

1. Register to Twitter to get the twitter API KEY

2. Change Twitter configuration in `\producer\src\main\resources\application.yml` with your API Key, client Id and Secret Id.

3. If this the first time you are running this project, the following command will 

```
~> /bin/zsh  /Users/fabrice/Desktop/Final\ Project/start.sh
```

5. Check all the containers which are running using the following command.

```
~> docker ps 
```

6. Run producer and consumer app with:
```
~> mvn spring-boot:run
```

##Quick Links

- [Spark-Web-UI](http://localhost:3040/)
- [HBase](http://localhost:60010/)
- [Kafka-Manager](http://localhost:9000/)

