import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

val scalaTestVersion = "3.2.19"

lazy val root = (project in file("."))
  .settings(
    name := "quizz",

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
      "org.scalatest" %% "scalatest-flatspec" % scalaTestVersion % "test"

    ),
      libraryDependencies += "io.circe" %% "circe-generic" % "0.14.5",
      libraryDependencies += "io.circe" %% "circe-parser" % "0.14.5",
      libraryDependencies ++= Seq(
        "io.circe" %% "circe-core" % "0.14.5",
        "io.circe" %% "circe-generic" % "0.14.5",
        "io.circe" %% "circe-parser" % "0.14.5"
    )


  )
