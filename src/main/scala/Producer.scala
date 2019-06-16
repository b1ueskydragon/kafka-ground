import java.util.Scanner

import Funcs._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object Producer extends App with ProducerConfigs {

  lazy val producer = new KafkaProducer[String, String](properties)

  producer.send(new ProducerRecord(topic, "key", "producer start"))

  lazy val sc = new Scanner(System.in)

  using(sc, producer) { (_, _) =>
    retry() {
      producer.send(new ProducerRecord(topic, "key", sc.nextLine))
    }
  }

}
