import java.util.Collections

import Funcs.retry
import org.apache.kafka.clients.consumer.KafkaConsumer

object Consumer extends App with ConsumerConfigs {

  lazy val consumer = new KafkaConsumer[String, String](properties)

  consumer.subscribe(Collections.singletonList(topic))

  retry() {
    val records = consumer.poll(3000)
    records.forEach(record => println(s"${record.value} (offset: ${record.offset})"))
    consumer.commitSync()
  }

  consumer.close()

}
