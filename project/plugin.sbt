scalacOptions ++= Seq("-unchecked", "-deprecation")

// [https://github.com/sbt/sbteclipse]
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")

// [https://github.com/scala/scala3-example-project/blob/master/project/plugins.sbt]
addSbtPlugin("ch.epfl.lamp" % "sbt-dotty" % "0.5.1")