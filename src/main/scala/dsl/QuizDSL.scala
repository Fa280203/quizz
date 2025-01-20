package dsl

class QuizBuilder(private val questions: List[Question] = List.empty) {
  def question(prompt: String, qType: QuestionType, difficulty: Difficulty)(
    block: QuestionBuilder => Question
  ): QuizBuilder =
    val question = block(new QuestionBuilder(prompt, qType, difficulty))
    new QuizBuilder(questions :+ question)

  def build(): Quiz = Quiz(questions)
}

class QuestionBuilder(
                       prompt: String,
                       qType: QuestionType,
                       difficulty: Difficulty
                     ) {
  private val answers = List.newBuilder[Answer]

  def answer(text: String, correct: Boolean = false): QuestionBuilder =
    answers += Answer(text, correct)
    this

  def build(): Question = Question(prompt, qType, difficulty, answers.result())
}

object QuizDSL {
  def quiz(block: QuizBuilder => QuizBuilder): Quiz =
    block(new QuizBuilder()).build()
}
