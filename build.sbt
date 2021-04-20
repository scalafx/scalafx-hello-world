// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "15.0.1-R22-SNAPSHOT"

// Version of Scala used by the project
val scala2Version = "2.13.5"
val scala3Version = "3.0.0-RC2"
scalaVersion := scala3Version

// To cross compile with Scala 3 and Scala 2
crossScalaVersions := Seq(scala3Version, scala2Version)

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "15.0.1-R22-SNAPSHOT"
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += Resolver.mavenLocal

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.ScalaFXHelloWorld")

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true

// Determine OS version of JavaFX binaries
lazy val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}

// Add JavaFX dependencies
lazy val javaFXModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
libraryDependencies ++= javaFXModules.map( m=>
  "org.openjfx" % s"javafx-$m" % "15.0.1" classifier osName
)
