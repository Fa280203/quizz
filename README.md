# Projet Scala : Création d'un DSL pour un Quiz

Bienvenue dans notre projet de quiz créé en Scala. Ce projet met en place un DSL (Domain-Specific Language) permettant de définir des quiz de manière intuitive. Voici comment nous avons organisé le projet et les étapes à suivre pour l'utiliser.

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

## Exemples d'utilisation

### Création d'un quiz

Voici comment créer un quiz avec notre DSL :

```scala
val myQuiz = quiz { q =>
  q.question("Quelle est la capitale de la France ?", QuestionType.MultipleChoice, Difficulty.Easy) { a =>
      a.answer("Paris", correct = true)
        .answer("Londres")
        .build()
    }
    .question("Quelle planète est connue comme la planète rouge ?", QuestionType.MultipleChoice, Difficulty.Medium) { a =>
      a.answer("Mars", correct = true)
        .answer("Terre")
        .answer("Jupiter")
        .build()
    }
}
```

### Exporter en JSON

Pour convertir un quiz en JSON et le partager :

```scala
val json = QuizExporter.exportToJson(myQuiz)
println(json)
```

Ces exemples montrent comment utiliser facilement notre DSL pour créer et exporter des quiz.

## Choix de conception

- **Immutabilité** : Nous avons utilisé des `case classes` pour garantir que les objets comme `Quiz`, `Question` et `Answer` soient immuables. Cela évite les erreurs liées à des modifications imprévues.
- **Fonctions pures** : Les fonctions, comme celles utilisées pour valider ou exporter les quiz, n'ont pas d'effets de bord. Cela améliore la fiabilité et facilite les tests.
- **Simplicité d'utilisation** : La syntaxe est conçue pour être claire et intuitive, même pour les utilisateurs qui ne sont pas experts en programmation.

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

## Pourquoi ce projet ?

Créer un DSL pour les quiz est intéressant car les quiz sont largement utilisés dans l'éducation, les évaluations professionnelles et les jeux. Voici ce que nous voulions accomplir :

- **Simplifier la création de quiz** : Offrir une syntaxe simple et intuitive pour que tout le monde puisse créer des quiz rapidement.
- **Faciliter la validation** : Aider à éviter les erreurs en vérifiant que chaque question a une réponse correcte.
- **Partager les quiz facilement** : Grâce à l'export JSON, les quiz peuvent être réutilisés ou intégrés dans d'autres systèmes.

