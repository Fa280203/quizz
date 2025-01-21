package dsl

import org.scalatest.funsuite.AnyFunSuite

class QuizTests extends AnyFunSuite {

  import dsl.QuizDSL._
  import dsl.{QuizValidator, QuizExporter, QuestionType, Difficulty}

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

  test("Quiz creation with multiple questions and answers") {
    val myQuiz2: Quiz = quiz { q =>
      q.question("What is the capital of France?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
          a.answer("Paris", correct = true)
            .answer("London")
            .build()
        }
        .question("Which planet is known as the Red Planet?", QuestionType.MultipleChoice, Difficulty.Medium) { a =>
          a.answer("Mars", correct = true)
            .answer("Earth")
            .answer("Jupiter")
            .build()
        }
    }

    assert(myQuiz2.questions.size == 2)
    assert(myQuiz2.questions.head.answers.size == 2)
    assert(myQuiz2.questions.last.answers.size == 3)
    assert(QuizValidator.validateQuiz(myQuiz2))
  }

  test("Validation fails for quiz with no correct answers") {
    val invalidQuiz = quiz { q =>
      q.question("What is 2 + 2?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
        a.answer("3")
          .answer("5")
          .build()
      }
    }

    assert(!QuizValidator.validateQuiz(invalidQuiz))
  }

  test("Validation fails for empty quiz") {
    val emptyQuiz: Quiz = quiz { _ => new QuizBuilder() }
    assert(emptyQuiz.questions.isEmpty)
    assert(!QuizValidator.validateQuiz(emptyQuiz))
  }

  test("Export quiz to JSON format") {
    val myQuiz3: Quiz = quiz { q =>
      q.question("What is the capital of France?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
        a.answer("Paris", correct = true)
          .answer("London")
          .build()
      }
    }

    val json = QuizExporter.exportToJson(myQuiz3)
    assert(json.contains("What is the capital of France?"))
    assert(json.contains("Paris"))
    assert(json.contains("London"))
  }

  test("Create a quiz with no answers") {
    val quizWithNoAnswers: Quiz = quiz { q =>
      q.question("What is the square root of 16?", QuestionType.MultipleChoice, Difficulty.Medium) { _ =>
        new QuestionBuilder("What is the square root of 16?", QuestionType.MultipleChoice, Difficulty.Medium).build()
      }
    }

    assert(quizWithNoAnswers.questions.size == 1)
    assert(quizWithNoAnswers.questions.head.answers.isEmpty)
    assert(!QuizValidator.validateQuiz(quizWithNoAnswers))
  }
}
