import java.util.{Collections, Properties}

import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App {

  val topic = "BoarBearBeer"

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("group.id", "groupA")

  val consumer = new KafkaConsumer[String, String](properties)

  consumer.subscribe(Collections.singletonList(topic))

  try {
    while (true) {
      val records = consumer.poll(3000)
      records.forEach(record => println(s"${record.value} (offset: ${record.offset})"))
      consumer.commitSync()
    }
  } finally {
    consumer.close()
  }

}
