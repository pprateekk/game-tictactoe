package tictactoe;

import java.util.Iterator;
import boardgame.Grid;

public class TicTacToe extends boardgame.BoardGame implements boardgame.Saveable{
    private int currentPlayer = 1;
    private String gameStateMessage;
    private boolean done = false;

    private Grid gridAdd;

    /**
     * This is the constructor used for this class.
     * @param wide  width of the board
     * @param tall  height of the board
     */
    public TicTacToe(int wide, int tall) {
        super(wide, tall);

    }


    /**
     * This method returns the current player whose turn is to play
     * @return currentPlayer the current player
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * set's the state to either true or false, to check if the game should be continued or not
     * @param state the current state
     */
    public void setGameOver(boolean state) {
        done = state;
    }


    /**
     * This method puts the piece onto the board.
     * @param across across index, 1 based
     * @param down  down index, 1 based
     * @param input  String input from game
     * @return false
     */
    @Override
    public boolean takeTurn(int across, int down, String input) {
        setValue(across, down, input);
        return false;

    }

    /**
     * This is just as a stub (used for Numerical TicTacToe)
     * @param across across index, zero based
     * @param down  down index, zero based
     * @param input  int input from game
     * @return false
     */
    @Override
    public boolean takeTurn(int across, int down, int input) {

        return false;

    }

    /**
     * This method is used to set the grid of the game
     * @param grid the grid is passed
     */
    @Override
    public void setGrid(boardgame.Grid grid) { //used full package name instead of import
        super.setGrid(grid);
        setGameOver(false); //resets done boolean
    }

    /**
     * This method returns the bool value of done: true or false
     * @return returns true or false
     */
    @Override
    public boolean isDone() {

        return done;

    }

    /**
     * This method checks for the winner in the game.
     * return 1: if player 1 is the winner
     * return 2: if player 2 is the winner
     * return 0: no one wins
     * @return int either 1, 2, or 0
     */
    @Override
    public int getWinner() {
        getCurrentPlayer();
//        switchPlayer();
        int diagonalWinner = 0;
        int horizontalWinner = 0;
        int verticalWinner = 0;
        diagonalWinner = diagonalWin();
//        System.out.println("DIAGONAL WIN:" + diagonalWinner);
        horizontalWinner = horizontalWin();
        verticalWinner = verticalWin();
//        if (forWinner.isFull()){
//            return 0;
        if (currentPlayer == 1 && diagonalWinner == 1) {
            return 1;
        } else if (currentPlayer == 1 && horizontalWinner == 1) {
            return 1;
        } else if (currentPlayer == 1 && verticalWinner == 1) {
            return 1;
        }
        if (currentPlayer == 2 && diagonalWinner == 2){
            return 2;
        } else if(currentPlayer == 2 && horizontalWinner == 2){
            return 2;
        } else if (currentPlayer == 2 && verticalWinner == 2){
            return 2;
        }
        return 0;
    }

    /**
     * This is used to get the message of current state of the game.
     * @return String what the message is
     */
    @Override
    public String getGameStateMessage() {
        setGameStateMessage(nextPlayerMessage()); //added this
        return gameStateMessage;

    }

    public void switchPlayer() {
        if (getCurrentPlayer() == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    private void setGameStateMessage(String msg) {
        gameStateMessage = msg;
    }

    private String nextPlayerMessage() {
        String player = "Player 1";
        if (getCurrentPlayer() == 2) {    //previously currentPlayer == 2
            player = "Player 2";
        }
        return (player + " please indicate where you would like to put your token.");
    }

    /**
     * This is the create a new grid depending on what the input is: Numerical or Normal TTT
     * @param kind if 1: XOGrid else Numerical Grid
     * @param wide the width
     * @param tall the height
     * @return GameGrid returns the new grid.
     */
    public static GameGrid newGrid(int kind, int wide, int tall) {
        if (kind == 1) {
            return new XOGrid(wide, tall);
        } else {
            return new NumTTTGrid(wide, tall);
        }
    }

    /**
     * This method is used to get the individual piece from the board.
     * @param across horizontal
     * @param down vertical
     * @return String the piece from the board.
     */
    public String getCell(int across, int down) {
        gridAdd = getGrid();
        return gridAdd.getValue(across, down);
    }

    /**
     * This method is used to find the winner across the game (horizontally).
     * @return int 1 (player 1) or 2 (player 2)
     */
    public int horizontalWin() {
        for (int i = 1; i <= 3; i++) {
            if (getCell(1, i) == getCell(2, i)
                    && getCell(2, i) == getCell(3, i)
                    && getCell(3, i) == "X") {
                return 1;
            } else if (getCell(1, i) == getCell(2, i)
                    && getCell(2, i) == getCell(3, i)
                    && getCell(3, i) == "O") {
                return 2;
            }
        }
        return 0;
    }

    /**
     * This method is used to find the winner down the game (vertically).
     * @return int 1 (player 1) or 2 (player 2)
     */
    public int verticalWin() {
        for (int i = 1; i <= 3; i++) {
            if (getCell(i, 1) == getCell(i, 2)
                    && getCell(i, 2) == getCell(i, 3)
                    && getCell(i, 3) == "X") {
                return 1;
            } else if (getCell(i, 1) == getCell(i, 2)
                    && getCell(i, 2) == getCell(i, 3)
                    && getCell(i, 3) == "O") {
                return 2;
            }
        }

        return 0;

    }

    /**
     * This method is used to find the winner diagonally in the game.
     * @return int 1 (player 1) or 2 (player 2)
     */
    public int diagonalWin() {
        //check for winner downward diagonal
        if (getCell(1, 1) == getCell(2, 2)
                && getCell(2, 2) == getCell(3, 3)
                && getCell(3, 3) == "X") {
            return 1;
        } else if (getCell(1, 1) == getCell(2, 2)
                && getCell(2, 2) == getCell(3, 3)
                && getCell(3, 3) == "O") {
            return 2;
        }

        //check for winner upward diagonal
        if (getCell(1, 3) == getCell(2, 2)
                && getCell(2, 2) == getCell(3, 1)
                && getCell(3, 1) == "X") {
            return 1;
        } else if (getCell(1, 3) == getCell(2, 2)
                && getCell(2, 2) == getCell(3, 1)
                && getCell(3, 1) == "O") {
            return 2;
        }

        return 0;

    }

    /**
     * This method is used to facilitate the saving of the contents to a file
     * @return String the string that is to be saved in the file.
     */
    public String getStringToSave(){
        String stringToReturn = "";
        String player = "";
        if (getCurrentPlayer() == 1) {
            player = "X";
        } else{
            player = "O";
        }
        stringToReturn = "" + player + "\n";
        for (int i = 1; i <= 3; i++){
            for (int j = 1; j <= 3; j++){
                if (getCell(i,j) == "X"){
                    stringToReturn = stringToReturn + "X" + ",";
                } else if (getCell(i,j) == "O") {
                    stringToReturn = stringToReturn + "0" + ",";
                } else {
                    stringToReturn = stringToReturn + ",";
                }
            }
            stringToReturn = stringToReturn + "\n";
        }
        return stringToReturn;
    }

    /**
     * This method is used to facilitate the loading of the contents from a file
     * @param toLoad the string which has to be loaded.
     */
    public void loadSavedString(String toLoad){

    }
}