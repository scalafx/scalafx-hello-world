// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "26.0.0-R38"

// Version of Scala used by the project
scalaVersion := "3.8.4"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "26.0.0-R38"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
