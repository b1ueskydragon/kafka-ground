import java.util.Properties

import com.typesafe.config.ConfigFactory.load

trait Configs {

  lazy val properties = new Properties()

  val topic: String = "topic".conf
  properties.put("bootstrap.servers", s"localhost:${"zk.port".conf}")

  implicit class RichLoad(path: String) {
    def conf: String = load.getString(path)
  }

}

trait ConsumerConfigs extends Configs {
  properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("group.id", "group.name".conf)
}

trait ProducerConfigs extends Configs {
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
}