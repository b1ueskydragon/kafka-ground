import java.util.{Properties, Scanner}

import com.typesafe.config.ConfigFactory.load
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer extends App {

  val topic = load.getString("topic")

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](properties)

  producer.send(new ProducerRecord(topic, "key", "producer start"))

  lazy val sc = new Scanner(System.in)

  try {
    while (sc.hasNext) {
      producer.send(new ProducerRecord(topic, "key", sc.nextLine))
    }
  } finally {
    sc.close()
    producer.close()
  }

}
