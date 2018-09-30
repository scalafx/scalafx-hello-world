// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "8.0.181-R13"

// Version of Scala used by the project
scalaVersion := "2.12.7"

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.181-R13"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8", "-feature")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
