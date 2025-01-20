package dsl

enum QuestionType:
  case MultipleChoice, TrueFalse

enum Difficulty:
  case Easy, Medium, Hard

case class Answer(text: String, correct: Boolean = false)

case class Question(
                     prompt: String,
                     qType: QuestionType,
                     difficulty: Difficulty,
                     answers: List[Answer]
                   )

case class Quiz(questions: List[Question])
