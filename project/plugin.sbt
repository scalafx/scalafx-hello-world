scalacOptions ++= Seq("-unchecked", "-deprecation")

// [https://github.com/sbt/sbteclipse]
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.4.1")