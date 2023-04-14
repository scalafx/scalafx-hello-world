// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "20.0.0-R31"

// Version of Scala used by the project
scalaVersion := "2.13.10"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "20.0.0-R31"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

