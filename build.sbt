name := "kafka-ground"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka_2.11" % "1.1.1",
  "org.slf4j" % "slf4j-log4j12" % "1.7.25" % Compile
)
