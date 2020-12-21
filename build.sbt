// Name of the project
name := "ScalaFX Hello World"

// Project version
version := "15.0.1-R20"

// Version of Scala used by the project
val dottyVersion = "0.24.0-RC1"
val scala213Version = "2.13.4"
scalaVersion := dottyVersion

// To cross compile with Dotty and Scala 2
crossScalaVersions := Seq(dottyVersion, scala213Version)

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "15.0.1-R20"
resolvers += Resolver.sonatypeRepo("snapshots")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature")

mainClass := Some("hello.Launcher")

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
