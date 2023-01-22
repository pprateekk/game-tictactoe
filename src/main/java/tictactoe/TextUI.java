package tictactoe;
import java.util.Scanner;

public class TextUI{
    private TicTacToe game = new TicTacToe(3,3);
    private Scanner input = new Scanner(System.in);
    private int acrossVal;      //this is the row
    private int downVal;        //this is the column

    private int countTie = 1;   //used to calculate if the game is a tie

    private int whoWinner = -1; //used to check the winner

    /**
     * The constructor used for this class.
     * @param gameType an integer
     */
    public TextUI(int gameType){
        game = new TicTacToe(3,3);
        System.out.println("Let's start the game\n");
        System.out.println("Player 1 please indicate where you would like to put your token.");
        game.setGrid(TicTacToe.newGrid(1,3,3));
    }

    /**
     * This is the method that helps in the running of the game TicTacToe XO
     * It asks for the user input, validates them by calling other methods, and
     * prints who the winner is.
     */
    public void play() {
        while (!game.isDone() && countTie != 9) {
            getPosition();                                            //ask for user input
            if (acrossVal == 0) {                                     //exit condition
                game.setGameOver(true); break;
            }
            try {
                game.takeTurn(acrossVal,downVal,getToken());        //put the piece onto the board
                System.out.println(game);                           //print the board
                whoWinner = game.getWinner();                       //check for the winner
                if (whoWinner == 1){                                //display winner if found
                    System.out.println("The winner of the game is Player 1\n"); game.setGameOver(true); break;
                } else if(whoWinner == 2){
                    System.out.println("The winner of the game is Player 2\n"); game.setGameOver(true); break;
                }
                game.switchPlayer();                                //change the player
                System.out.println(game.getGameStateMessage());     //print the player turn message
                countTie += 1;
            }catch(RuntimeException e){
                System.out.println(game.getGameStateMessage());
            }
        } displayTie(countTie);
    }


    private void displayTie(int count){
        if (count == 9){
            System.out.println("The game has no winner. It was a tie :( \n");
        }
    }
    private void getPosition() {
        int check = 1;
        while (check == 1) {
            System.out.println("across? (0 to quit)"); acrossVal = input.nextInt();
            while (acrossVal > 3 || acrossVal < 0) {
                System.out.println("Please enter a valid input (1-3)"); System.out.println("across? (0 to quit)");
                acrossVal = input.nextInt();}
            input.nextLine();
            System.out.println("down?"); downVal = input.nextInt(); //to get rid or hard return;
            while (downVal > 3 || downVal < 0) {
                System.out.println("Please enter a valid input (1-3)"); System.out.println("down? (0 to quit)");
                downVal = input.nextInt();}
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (game.getCell(i, i) == game.getCell(acrossVal, downVal)
                            && game.getCell(acrossVal, downVal) == "X") {
                        check = 1;
                    } else if (game.getCell(i, i) == game.getCell(acrossVal, downVal)
                            && game.getCell(acrossVal, downVal) == "O") {
                        check = 1;
                    } else {
                        check = 0;
                    }
                }
                if (check == 1) {
                    System.out.println("A piece is already in place. Please enter a valid input"); break;
                }
            }
        }
    }

    private String getToken(){
        String token = "X";
        if(game.getCurrentPlayer() == 2){
            token = "O";
        }
        return token;

    }

    /**
     * This is the main method to run the TextUI
     * @param args the argument
     */
    public static void main(String[] args){
        TextUI tester = new TextUI(1); //textUI for XO game
        tester.play();
    }
}