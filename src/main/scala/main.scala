import dsl.{QuizDSL, QuestionType, Difficulty}

object Main extends App {
  import QuizDSL._

  val myQuiz = quiz { q =>
    q.question("What is the capital of France?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
        a.answer("Paris", correct = true)
          .answer("London")
          .answer("Berlin")
          .answer("Madrid")
          .build()
      }
      .question("Which planet is known as the Red Planet?", QuestionType.MultipleChoice, Difficulty.Medium) { a =>
        a.answer("Mars", correct = true)
          .answer("Earth")
          .answer("Jupiter")
          .answer("Venus")
          .build()
      }
  }

  println(myQuiz)
}
