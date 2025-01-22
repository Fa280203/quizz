# Projet Scala : Création d'un DSL pour un Quiz

Bienvenue dans notre projet Scala. Ce projet met en place un DSL (Domain-Specific Language) permettant de définir des quiz de manière intuitive. Voici comment nous avons organisé le projet et les étapes à suivre pour l'utiliser.

## Fonctionnalités

- Création de quiz avec plusieurs questions et différents types de réponses.
- Validation des quiz pour s'assurer qu'ils ont au moins une réponse correcte par question.
- Export des quiz au format JSON.
- Tests unitaires pour valider le fonctionnement du DSL.

## Structure du projet

Voici comment nous avons organisé les fichiers et dossiers :

- **src/main/scala/dsl** : Contient les fichiers principaux du DSL (QuizDSL, QuizBuilder, QuizValidator, QuizExporter, etc.).
- **src/test/scala/dsl** : Contient les tests unitaires.
- **build.sbt** : Fichier de configuration SBT pour gérer les dépendances.

## Prérequis

Nous avons besoin des outils suivants :

1. **Java** : JDK 8 ou supérieur.
2. **Scala** : Version 3.3.4.
3. **SBT** : Pour construire et exécuter le projet.

## Dépendances

Nous utilisons les bibliothèques suivantes :

- **ScalaTest** : Pour les tests unitaires.
- **Circe** : Pour exporter les quiz en JSON.

Toutes les dépendances sont déclarées dans le fichier `build.sbt`.

## Comment utiliser le projet ?

1. **Cloner le projet**

```bash
git clone <lien_du_dépôt>
cd quizz
```

2. **Compiler le projet**

```bash
sbt compile
```

3. **Exécuter le projet**

Nous avons inclus un exemple dans le fichier `Main.scala`. Pour l'exécuter :

```bash
sbt run
```

4. **Lancer les tests**

Pour vérifier que tout fonctionne comme prévu :

```bash
sbt test
```

## Exemples

### Création d'un quiz

Voici à quoi ressemble un quiz avec notre DSL :

```scala
val myQuiz = quiz { q =>
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
```

### Exporter en JSON

Pour convertir un quiz en JSON :

```scala
val json = QuizExporter.exportToJson(myQuiz)
println(json)
```

## Tests unitaires

Nous avons ajouté plusieurs tests unitaires pour vérifier le fonctionnement de notre DSL, notamment :

- Création d'un quiz valide.
- Validation des quiz sans réponses correctes.
- Export en JSON.
- Gestion des quiz vides.

Pour lancer les tests :

```bash
sbt test
```

## Améliorations possibles

- Ajouter des types de questions supplémentaires (par exemple : réponses ouvertes).
- Améliorer la gestion des erreurs.
- Intégrer une interface utilisateur pour créer des quiz plus facilement.



