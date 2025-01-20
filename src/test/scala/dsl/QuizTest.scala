package dsl

import org.scalatest.funsuite.AnyFunSuite

class QuizTests extends AnyFunSuite {

  import dsl.QuizDSL._
  import dsl.{QuizValidator, QuestionType, Difficulty}

  test("Quiz creation and validation") {
    val myQuiz: Quiz = quiz { q =>
      q.question("What is the capital of France?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
        a.answer("Paris", correct = true)
          .answer("London")
          .build()
      }
    }

    assert(myQuiz.questions.size == 1)
    assert(myQuiz.questions.head.answers.size == 2)
    assert(QuizValidator.validateQuiz(myQuiz))
  }
}

