// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "1.0.9"

// Version of Scala used by the project
scalaVersion := "2.11.5"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.31-R7"

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
