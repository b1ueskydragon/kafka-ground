import java.util.Scanner

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer extends App with ProducerConfigs {

  lazy val producer = new KafkaProducer[String, String](properties)

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
