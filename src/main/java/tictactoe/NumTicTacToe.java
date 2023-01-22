package tictactoe;

import boardgame.Grid;

public class NumTicTacToe extends boardgame.BoardGame {

    private int currentPlayer = 1;              //this is the current player
    private String gameStateMessage;
    private boolean done = false;

    private Grid gridAdd;                       //for getCell

    /**
     * This is the constructor for this class.
     * @param wide  width of the board
     * @param tall  height of the board
     */

    public NumTicTacToe(int wide, int tall) {
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
     * This is just for the design.
     * @param across across index, 1 based
     * @param down  down index, 1 based
     * @param input  String input from game
     * @return false returns true or false
     */
    @Override
    public boolean takeTurn(int across, int down, String input) {
        return false;

    }

    /**
     * This method puts the piece onto the board.
     * @param across across index, zero based
     * @param down  down index, zero based
     * @param input  int input from game
     * @return returns false
     */
    @Override
    public boolean takeTurn(int across, int down, int input) {
        setValue(across, down, input);
        return false;

    }

    /**
     * This mwthod just sets the grid.
     * @param grid  the grid is passed
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
        int diagonalWinner = 0;
        int horizontalWinner = 0;
        int verticalWinner = 0;
        diagonalWinner = diagonalWin();
        horizontalWinner = horizontalWin();
        verticalWinner = verticalWin();
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

    /**
     * this method is used to switch the turns of the players
     *
     */
    public void switchPlayer() {
        if (getCurrentPlayer() == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
    }

    /**
     * This is used to set the message of current state of the game.
     */
    private void setGameStateMessage(String msg) {
        gameStateMessage = msg;
    }

    /**
     * This method displays whose player turn is it to enter the input
     * @return String if player 1 or player 2 should play
     */
    private String nextPlayerMessage() {
        String player = "Player 1";
        if (getCurrentPlayer() == 2) {    //previously currentPlayer == 2
            player = "Player 2";
        }
        return (player + " please indicate where you would like to put your token.");
    }

    /*new addition*/

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
            if (Integer.parseInt(getCell(1,i)) + Integer.parseInt(getCell(2,i))
                    + Integer.parseInt(getCell(3,i)) == 15){
                return getCurrentPlayer();
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
            if (Integer.parseInt(getCell(i,1)) + Integer.parseInt(getCell(i,2))
                    + Integer.parseInt(getCell(i,3)) == 15){
                return getCurrentPlayer();
            }
        }
        return 0;

    }

    /**
     * This method is used to find the winner diagonally in the game.
     * @return int 1 (player 1) or 2 (player 2)
     */
    public int diagonalWin() {
        if (Integer.parseInt(getCell(1,1)) + Integer.parseInt(getCell(2,2))
                + Integer.parseInt(getCell(3,3)) == 15) {
            return getCurrentPlayer();
        } else if (Integer.parseInt(getCell(1,3)) + Integer.parseInt(getCell(2,2))
                + Integer.parseInt(getCell(3,1)) == 15){
            return getCurrentPlayer();
        }
        return 0;

    }
}
