// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "25.0.2-R37"

// Version of Scala used by the project
scalaVersion := "3.8.2"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "25.0.2-R37"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
