package tictactoe;

import java.io.FileWriter;
import java.io.IOException;

public class SaveFile {

    /**
     * This method is used to save the contents of the board into a file.
     * @param fileName asked from the user
     * @param object this is the grid/board that is being saved
     */
    public static void save(String fileName, TicTacToe object){
        String savedString = "";

        savedString = object.getStringToSave();

        FileWriter pointerWrite = null;
        try{
            pointerWrite = new FileWriter(fileName);

            pointerWrite.append(savedString);   //writing to file
            pointerWrite.flush(); //forcing the data to file
            pointerWrite.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
