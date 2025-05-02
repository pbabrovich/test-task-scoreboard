# Football Scoreboard (Java + TDD)

This project is an in-memory scoreboard library implemented in Java using Test-Driven Development (TDD). It allows tracking live football matches, updating scores, and retrieving a summary of ongoing matches sorted by score and recency.

---

## ✅ Features

- Start a match with two distinct team names
- Prevent the same team from playing in multiple matches simultaneously
- Update scores during a match
- Finish a match and remove it from the scoreboard
- Generate a summary of active matches:
    - Sorted by total score (descending)
    -  Most recently started match appears first

---

## 🧪 Technologies

- Java 17
- JUnit 5
- Maven
- GitHub Actions (CI)
- Clean Code & TDD principles

---


## 🧠 MatchKey Purpose

The `MatchKey` class uniquely identifies each match by combining the home and away team names. It is used as a composite key in a `HashMap` to:

- Enable constant-time (O(1)) access to match data
- Ensure no team can play in two matches at the same time
- Enforce input validation (non-null, non-blank, distinct teams)

This design ensures efficient, consistent, and valid match management within the scoreboard.

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/football-scoreboard.git
cd football-scoreboard
```

### 2. Basic usage example

```java
import task.scoreboard.ScoreBoard;

public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreboard = new ScoreBoard();

        // Start a match
        scoreboard.startMatch("Mexico", "Canada");

        // Update the score
        scoreboard.updateScore("Mexico", "Canada", 2, 1);

        // Start another match
        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 3, 2);

        // Retrieve and print match summary
        scoreboard.getSummary().forEach(System.out::println);

        // Finish a match
        scoreboard.finishMatch("Mexico", "Canada");
    }
}
```
---

## Potential Improvements

While the current version of the scoreboard meets the core requirements, there are several areas for future enhancement:

- **Persistent storage**  
  Store matches in a database (e.g. PostgreSQL, MongoDB) to retain data across restarts.

- **UI**  
  Build a simple frontend/console app to visualize and interact with ongoing matches in real-time.

- **Concurrency support**  
  Make the scoreboard thread-safe using synchronized collections or concurrent data structures.

- **More flexible sorting**  
  Allow optional sorting by kickoff time, alphabetical order, or filtered by team.

- **Note on Branching**  
  For the purpose of this individual task, all commits have been pushed directly to the `main` branch to keep the workflow simple and linear. In a production or team environment, proper branching strategies (e.g., feature branches, pull requests, code review) should be followed.