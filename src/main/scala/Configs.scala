import java.util.Properties

trait Configs {

  lazy val properties = new Properties()

  val topic: String = "topic".conf

  val port: String = "zk.port".conf

  val groupName: String = "group.name".conf

  properties.put("bootstrap.servers", s"localhost:$port")

  implicit class RichLoad(path: String) {
    def conf: String = com.typesafe.config.ConfigFactory.load.getString(path)
  }

}

trait ConsumerConfigs extends Configs {
  properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("group.id", groupName)
}

trait ProducerConfigs extends Configs {
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
}