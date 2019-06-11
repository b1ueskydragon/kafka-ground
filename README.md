## Apache Kafka
Kafka is a message Broker for Producer and Consumer.<br>
Producer publish message, and Consumer subscribe.

### Install - local server is Mac OS
```.bash
brew install kafka
```

### Run zookeeper / kafka
```.bash
# To have launchd start zookeeper / kafka now and restart at login:
$ brew services start zookeeper
$ brew services start kafka

# Or, if you don't want/need a background service you can just run:
$ zkServer start
$ zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties
```

### Run a scala application
```bash
$ sbt run
```


## Kafka console

#### where is it
```.bash
$ which kafka-console-consumer
# /usr/local/bin/kafka-console-consumer
```

### Run producer on the Terminal
```.bash
$ kafka-console-producer.sh --broker-list localhost:9092 --topic BoarBearBeer
```

### Run consumer on a new Terminal
```.bash
$ kafka-console-consumer --topic BoarBearBeer --from-beginning --bootstrap-server localhost:9092
```


## Chat
```.bash
## Terminal 1 ##
## $ kafka-console-producer --topic BoarBearBeer --broker-list localhost:9092 ## 

> Hi I'm a Boar
>
```

```.bash
## Terminal 2 ##
## $ kafka-console-consumer --topic BoarBearBeer --from-beginning --bootstrap-server localhost:9092 ##

> Hi I'm a Boar

```

## Notes
- kafka supports port number `9092`
