// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "21.0.0-R32"

// Version of Scala used by the project
scalaVersion := "3.3.1"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "21.0.0-R32"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

