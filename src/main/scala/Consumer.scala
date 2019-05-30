import java.util.{Collections, Properties}

import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App {

  val topic = "boar bear beer"

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("group.id", "groupA")

  val consumer = new KafkaConsumer[String, String](properties)

  consumer.subscribe(Collections.singletonList(topic))

  (1 to 10).foreach { i =>
    val records = consumer.poll(3000)
    println(s"print counts; $i")

    records.forEach { j =>
      println(s"print records; $j")
    }
  }

}
