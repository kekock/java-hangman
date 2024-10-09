# Hangman Game
## Overview
#### This is a simple text-based Hangman game implemented in Java. The goal of the game is for the player to guess a secret word, one letter at a time. If the player makes too many incorrect guesses, they lose the game, and a graphical representation of a hangman is shown to track the progress of the game.

## Features
- Displays the hangman stage for each incorrect guess.
- Reads a list of secret words from a text file (```listOfWords.txt```).
- Allows the player to input one letter at a time.
- Tracks the number of wins and losses.
- Displays the secret word if the player loses the game.
- Allows the player to restart or exit the game after each round.

## How to Play
1. Run the game.
2. Choose option ```1``` to start the game.
3. Guess letters one by one.
4. The game will display the current state of the secret word and the hangman drawing.
5. If you guess all letters correctly before the hangman is fully drawn, _**you win**_.
6. If the hangman is fully drawn before you guess the word, **_you lose_**.

## Project Structure
### Classes
- **DisplayStatus**: Manages the hangman stages and displays the current hangman status.
- **FileReader**: Reads the list of words from a file (```listOfWords.txt```).
- **Game**: Main class that handles the game logic, including input validation, guess processing, and tracking wins and losses.
- **Menu**: Handles the game menu, including starting, restarting, and exiting the game.
- **WordManager**: Manages the current secret word, including selecting a word and revealing letters as the player guesses correctly.

## Files
```src/main/resources/listOfWords.txt```: A text file containing the list of words for the game.

## Running the Project
- Ensure you have Java installed on your system.
- Clone the repository and navigate to the project directory.
- Make sure the ```listOfWords.txt``` file is present in ```src/main/resources/```.
- Compile the Java classes and run the Start class as the entry point of the application.
```bash
javac src/*.java
java src.Start
```

## Example Output
```vbnet
Welcome to the hangman game! Insert number 1 to start or 2 to exit.
1
The secret word is: ######. Now guess the characters!
```
As you make incorrect guesses, the hangman drawing updates:

```vbnet
    +---+
    |   |
    O   |
   /|   |
        |
        |
  =======
You're wrong! More attempts left: 6
```
## Customizing the Word List
To change the words used in the game:

1. Open listOfWords.txt.
2. Add or modify the words in the file (one word per line).