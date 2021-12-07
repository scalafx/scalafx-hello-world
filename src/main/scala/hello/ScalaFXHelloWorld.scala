package hello

import scalafx.application.JFXApp3
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.*
import scalafx.scene.paint.Color.*
import scalafx.scene.text.Text

import scala.language.implicitConversions

object ScalaFXHelloWorld extends JFXApp3 :

  override def start(): Unit =

    stage = new JFXApp3.PrimaryStage :
      //    initStyle(StageStyle.Unified)
      title = "ScalaFX Hello World"
      scene = new Scene :
        fill = Color.rgb(38, 38, 38)
        content = new HBox :
          padding = Insets(50, 80, 50, 80)
          children = Seq(
            new Text :
              text = "Scala"
              style = "-fx-font: normal bold 100pt sans-serif"
              fill = new LinearGradient(endX = 0, stops = Stops(Red, DarkRed))
            ,
            new Text :
              text = "FX"
              style = "-fx-font: italic bold 100pt sans-serif"
              fill = new LinearGradient(endX = 0, stops = Stops(White, DarkGray))
              effect = new DropShadow :
                color = DarkGray
                radius = 15
                spread = 0.25
          )
