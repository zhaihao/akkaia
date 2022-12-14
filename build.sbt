version          := "0.1.0"
scalaVersion     := "2.13.10"
name             := "akkaia"
organization     := "me.ooon"

Global / excludeLintKeys := Set(idePackagePrefix)

idePackagePrefix := Some("me.ooon.akkaia")

enablePlugins(MultiJvmPlugin)

MultiJvm / unmanagedSourceDirectories := Seq(baseDirectory(_ / "src/cluster/scala")).join.value
MultiJvm / jvmOptions                 := Seq("-Xmx128M")
MultiJvm / multiJvmMarker             := "Jvm"

libraryDependencies ++= Seq(NSCALA, OS_LIB, SQUANTS, ORISON, TYPESAFE_CONFIG, PLAY_JSON)
libraryDependencies ++= Seq(SCALA_TEST, LOG, AKKA).flatten

excludeDependencies ++= Seq(
  ExclusionRule("org.slf4j", "slf4j-log4j12"),
  ExclusionRule("log4j", "log4j")
)

configs(MultiJvm)