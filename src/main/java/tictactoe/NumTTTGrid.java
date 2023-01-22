package tictactoe;
import boardgame.Grid;

public class NumTTTGrid extends GameGrid{

    private Grid gridAdd;

    /**
     * This is the constructor used for this class.
     * @param across the horizontal position in the board
     * @param down the vertical position in the board
     */
    public NumTTTGrid(int across, int down){
        super(across,down);
    }


    public boolean horizontalWin(){
        return false;
    }

    public boolean verticalWin(){
        return false;

    }

    public boolean diagonalWin(){
        return false;

    }

    public void validateInput(String input)throws Exception{
    }

    public void validateLocation(int across, int down)throws Exception{

    }
    public boolean isFull(){
        return false;
    }




}