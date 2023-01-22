# Tic Tac Toe Game : X/O and Numerical

## Description

The assignment uses Object Oriented Programming to create Tic Tac Toe games where two players plays against each other sharing the same computer. 
The players have option to choose between two versions of TicTacToe Game: The X/O TicTacToe or The Numerical TicTacToe. 

The Games can be played as:

1. X/O TicTacToe : Using Command-Line and GUI (Graphical-User Interface) <br>
2. Numerical TicTacToe : GUI <br>

The program consists of 8 classes in the tictactoe package: <br>
Please note that only the principal classes have been described here </br>

TicTacToe.java : This class is mainly concerned for the workings of the normal tictactoe game (i.e. X/O). All the necessary methods that are required to support the working have been provided in this class (for example: creating the board for the game, getWinner() to check for the winner, takeTurn() to place the piece onto the board, switchPlayer() to change the turn of players, etc.)

NumTicTacToe.java : This class is concerned for the workings of the Numerical tictactoe game. All the necessary methods that are required to support the working have been provided in this class (for example: creating the board for the game, getWinner() to check for the winner, takeTurn() to place the piece onto the board, switchPlayer() to change the turn of players, etc.)

TextUI.java : This class is where the main is called for X/O TicTacToe Game. This is the only class responsible for the User-Interaction. This class runs the game by asking the user for valid inputs, and displaying the user with meaningful messages. 

TicTacToeView.java : TicTacToeView class is used to run the program with a graphical-user-interface. It is has features like Reset, Save, Load, Play a Numerical TicTacToe game.


It is recommended that the player be familiar with the rules of Numerical TicTacToe game by searching online. 


## Executing program

To build the program, the user must enter:
```
gradle run
```
To run the X/O TicTacToe Game program:
```
java -cp build/classes/java/main tictactoe.TextUI
```
To run the GUI TicTacToe Game program:
```
java -jar build/libs/A3.jar
```
To create Javadoc:
```
gradle javadoc
```

Sample Output of TicTacToe Game as GUI :

![tictactoeview](game-tictactoe/assets/tictactoeview.png)

![message](game-tictactoe/assets/message.png)

![menubar](game-tictactoe/assets/filesave.png)


Sample Output of X/O TicTacToe Game run on Command-line :

$ gradle build <br>
$ gradle run <br>
$ java -cp build/classes/java/main tictactoe.TextUI<br>

Let's start the game<br>

Player 1 please indicate where you would like to put your token.<br>
across? (0 to quit)<br>
1<br>
down?<br>
1<br>
 X    <br>
      <br>
      <br>
<br>
Player 2 please indicate where you would like to put your token.<br>
across? (0 to quit)<br>
2<br>
down?<br>
2<br>
 X    <br>
   O  <br>
      <br>
<br>
Player 1 please indicate where you would like to put your token.<br>
across? (0 to quit)<br>
1<br>
down?<br>
2<br>
 X    <br>
 X O  <br>
      <br>
<br>
Player 2 please indicate where you would like to put your token.<br>
across? (0 to quit)<br>
2<br>
down?<br>
1<br>
 X O  <br>
 X O  <br>
      <br>
<br>
Player 1 please indicate where you would like to put your token.<br>
across? (0 to quit)<br>
1<br>
down?<br>
3<br>
 X O  <br>
 X O  <br>
 X    <br>
<br>
The winner of the game is Player 1<br>


## Limitations

1. The program has not been implemented with the Numerical TicTacToe Game properly for the GUI yet. <br>
2. The program doesn't support the loading of a gaming from another file. <br>

## Acknowledgement/References

The program makes reference from the codes provided by the Professor. <br>
