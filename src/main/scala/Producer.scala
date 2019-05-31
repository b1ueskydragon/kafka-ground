import java.util.{Date, Properties}

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer extends App {

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val topic = "BoarBearBeer"

  val producer = new KafkaProducer[String, String](properties)

  (1 to 50).foreach { i =>
    val record = new ProducerRecord(topic, "key", s"producer record; $i")
    producer.send(record)
  }

  val record = new ProducerRecord(topic, "key", s"final; ${new Date}")
  producer.send(record)

  producer.close()

}
