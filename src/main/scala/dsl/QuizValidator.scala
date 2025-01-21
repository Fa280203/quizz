package dsl

object QuizValidator {
  def validateQuiz(quiz: Quiz): Boolean =
    quiz.questions.nonEmpty && quiz.questions.forall(q => q.answers.exists(_.correct))
}
