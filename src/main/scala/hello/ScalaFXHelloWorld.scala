package hello

import javafx.{application => jfxa, stage => jfxs}
import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text
import scalafx.stage.Stage

import scala.language.implicitConversions

class ScalaFXHelloWorld extends jfxa.Application {
  def start(jfxPrimaryStage: jfxs.Stage): Unit = {
    val primaryStage: Stage = jfxPrimaryStage
    primaryStage.title = "ScalaFX Hello World"
    primaryStage.scene = new Scene {
      fill = Color.rgb(38, 38, 38)
      content = new HBox {
        padding = Insets(50, 80, 50, 80)
        children = Seq(
          new Text {
            text = "Scala"
            style = "-fx-font: normal bold 100pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Red, DarkRed))
          },
          new Text {
            text = "FX"
            style = "-fx-font: italic bold 100pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(White, DarkGray)
            )
            effect = new DropShadow {
              color = DarkGray
              radius = 15
              spread = 0.25
            }
          }
        )
      }
    }
    primaryStage.show()
  }
}
