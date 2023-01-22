package tictactoe;


import boardgame.Grid;

import java.util.Iterator;

public class XOGrid extends GameGrid{

    private static  String[] symbols ={"X","O"};

    private Grid grid;

    /**
     * This is the constructor used for this class.
     * @param across the horizontal position in the board
     * @param down the vertical position in the board
     */
    public XOGrid(int across, int down){
        super(across,down);
    }

//    public String getCell(int across, int down){
//        return grid.getValue(across,down);
//    }
//
//    public boolean horizontalWin(){
//        for (int i = 1; i <= 3; i++){
//            if (getCell(1,i) == getCell(2,i)
//                && getCell(2,i) == getCell(3,i)
//                    && getCell(3,i) == "X"){
//                return true;
//            } else if (getCell(1,i) == getCell(2,i)
//                    && getCell(2,i) == getCell(3,i)
//                    && getCell(3,i) == "O") {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean verticalWin(){
//        for (int i = 1; i <= 3; i++){
//            if (getCell(i,1) == getCell(i,2)
//                    && getCell(i,2) == getCell(i,3)
//                    && getCell(i,3) == "X"){
//                return true;
//            } else if (getCell(i,1) == getCell(i,2)
//                    && getCell(i,2) == getCell(i,3)
//                    && getCell(i,3) == "O"){
//                return true;
//            }
//        }
//
//        return false;
//
//    }
//
//    public boolean diagonalWin(){
//        //check for winner downward diagonal
//        if (getCell(1,1) == getCell(2,2)
//                && getCell(2,2) == getCell(3,3)
//                && getCell(3,3) == "X"){
//            return true;
//        } else if (getCell(1,1) == getCell(2,2)
//                && getCell(2,2) == getCell(3,3)
//                && getCell(3,3) == "O"){
//            return true;
//        }
//
//        //check for winner upward diagonal
//        if (getCell(1,3) == getCell(2,2)
//                && getCell(2,2) == getCell(3,1)
//                && getCell(3,1) == "X"){
//            return true;
//        } else if (getCell(1,3) == getCell(2,2)
//                && getCell(2,2) == getCell(3,1)
//                && getCell(3,1) == "O"){
//            return true;
//        }
//
//        return false;
//
//    }
//
////    @Override
//    public boolean isFull(){
//        /* I should have provided this method in the base class
//        but I didn't think of it.  Fortunately, we can
//         use the iterator to count*/
//        Iterator<String> iter = iterator();
//        int count = 0;
//        while(iter.hasNext()){
//            if(!iter.next().equals(" ")){
//                count++;
//            }
//        }
//        if(count == getWidth()*getHeight()){
//            return true;
//        }
//        return false;
//    }

//    @Override
    public void validateInput(String input) throws Exception{

    }

//    @Override
    public void validateLocation(int across, int down)throws Exception{

    /* method should check to see if positions are out of bounds
    as well as if the position is already full*/

    }

    /* private helper methods*/

    private boolean rowCheck(int row){
        boolean match = false;

        return match;
    }

    private boolean columnCheck(int col){
        return false;

    }

    private boolean diagonalCheck(){
        return false;

    }

}