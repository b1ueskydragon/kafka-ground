import java.util.Collections

import Funcs._
import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App with ConsumerConfigs {

  lazy val consumer = new KafkaConsumer[String, String](properties)

  consumer.subscribe(Collections.singletonList(topic))

  using(consumer) { _ =>
    retry() {
      val records = consumer.poll(3000)
      records.forEach(record => println(s"${record.value} (offset: ${record.offset})"))
      consumer.commitSync()
    }
  }

}
