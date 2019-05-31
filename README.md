## Apache Kafka
Kafka is a message Broker for Producer and Consumer.<br>
Producer publish message, and Consumer subscribe.

## Install - local server is Mac OS
```.bash
brew install kafka
```

## Run zookeeper / kafka
```.bash
# To have launchd start zookeeper / kafka now and restart at login:
$ brew services start zookeeper
$ brew services start kafka

# Or, if you don't want/need a background service you can just run:
$ zkServer start
$ zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
```

## Run application
```bash
$ sbt run
```

## Notes
- kafka supports port number `9092`
