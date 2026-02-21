# Capital Game

Educational Java project to practice file reading, `HashMap` usage, randomness, user interaction and basic file writing through a simple quiz game.

## Objective

- Read country-capital pairs from `countries.txt`
- Store them in a `HashMap<String, String>` (key = country, value = capital)
- Implement a 10-question quiz with random countries
- Track score and save user name + score to `classification.txt`

## How It Works

1. Loads data from `countries.txt` (format: `Country,Capital`)
2. Stores all pairs in a `HashMap`
3. Asks for the user's name
4. Runs 10 random questions (different countries each time)
5. Checks answers (case-insensitive recommended)
6. Shows final score
7. Appends result to `classificacio.txt`

## Project Structure
```text
src/
├── CapitalGame.java       # Game logic and HashMap handling
├── Main.java              # Program entry point
├── countries.txt          # Input file (must be present)
└── classification.txt      # Output file (created/updated automatically)
```

## How to Run
```bash
1. Place `countries.txt` in the `src` folder (or adjust the file path in code)
2. Compile and run:

javac src/*.java
java -cp src Main
```

## Example Execution
```text
What's your name?:  Maria
Question 1: What is the capital of France?
Paris
Correct! (+1 point)

Question 2: What is the capital of Japan?
tokyo
Correct! (case-insensitive)

...

Final score: 8/10
Result saved to classification.txt
```
## Expected content of classification.txt
```text
textMaria - 8/10
Joan - 6/10
```