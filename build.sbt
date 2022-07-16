// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "18.0.1-R28"

// Version of Scala used by the project
scalaVersion := "2.13.8"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "18.0.1-R28"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

