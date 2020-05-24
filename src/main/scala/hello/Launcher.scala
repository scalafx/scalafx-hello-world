package hello

import javafx.{application => jfxa}

/**
 * A proxy launcher for `ScalaFXHelloWorld` to avoid issues with false error about missing JavaFX modules.
 *
 * When starting directly an JavaFX application class in Java 11, like `HyperGrabApp`, an error is generated:
 * {{{
 *   Error: JavaFX runtime components are missing, and are required to run this application
 * }}}
 * The issue to some extend is discussed here:
 * [[http://mail.openjdk.java.net/pipermail/openjfx-dev/2018-June/021977.html]]
 * A work around is to start application from additional "Launcher" class.
 *
 * Note that there are no errors when ScalaFX JFXApp is used as it starts Application indirectly.
 */
object Launcher extends App {
  // Launch the actual application class
  jfxa.Application.launch(classOf[ScalaFXHelloWorld], args: _*)
}
