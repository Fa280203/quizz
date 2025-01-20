package dsl

import io.circe.generic.auto._
import io.circe.syntax._

object QuizExporter {
  def exportToJson(quiz: Quiz): String = quiz.asJson.noSpaces
}
