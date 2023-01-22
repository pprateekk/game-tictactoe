package tictactoe;

import boardgame.ui.PositionAwareButton;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class TicTacToeView extends JPanel {

    private PositionAwareButton[][] buttons;
    private JFrame frame;
    private JButton button;
    private JMenuBar menuBar;
    private JPanel panel1;
    private JPanel newPanel;

    private TicTacToe game;
    private JMenuBar menuBar1;
    private JMenu menu1;

    /**
     * Constructor for this class.
     */
    public TicTacToeView(){
        super();
        game = new TicTacToe(3,3);
        gameInterface();
    }

    /**
     * This method is used to run/create the graphical user interface for the Normal TicTacToe Version.
     * It calls on the main frame and the panels and menu bar present in that frame to
     * create a grid and buttons to facilitate the playing of the TicTacToe X/O game.
     */
    public void gameInterface(){
        frame = new JFrame("TicTacToe Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        createMenuBar();
        frame.setJMenuBar(menuBar1);
        newPanel = makeButtonGrid(3,3);
        frame.add(newPanel, BorderLayout.CENTER);
        JLabel displayMessage = new JLabel("Welcome to the TicTacToe Game.\n Please select what you would like to"
                + " play.");
        frame.add(displayMessage, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.add(anotherPanel(), BorderLayout.EAST);
        frame.pack();
    }


    /* NOTE: This part of code is taken from Professor's exampleguiproject Kakuro (KakuroView.java) */

    private JPanel makeButtonGrid(int tall, int wide){
        int countTie = 1;
        JPanel panel = new JPanel();
        buttons = new PositionAwareButton[tall][wide];
        panel.setLayout(new GridLayout(wide, tall));
        for (int y=0; y<wide; y++){
            for (int x=0; x<tall; x++){
                //Create buttons and link each button back to a coordinate on the grid
                buttons[y][x] = new PositionAwareButton();
                buttons[y][x].setAcross(x+1); //made the choice to be 1-based
                buttons[y][x].setDown(y+1);
                int finalCountTie = countTie;
                buttons[y][x].addActionListener(e->{
                    putPiece(e);
                    int whoWinner = game.getWinner();
                    displayWinner(whoWinner);
                    checkTie(finalCountTie);
                    game.switchPlayer();
                });
                panel.add(buttons[y][x]);
            }
        }
        countTie+=1;
        return panel;
    }


    private JPanel anotherPanel(){
        panel1 = new JPanel();
        panel1.add(playAgain());
        panel1.add(playNormal());
        return panel1;
    }

    private JButton playAgain(){
        button = new JButton("Reset");
        button.addActionListener(e->{
//            newPanel.removeAll();
//            newPanel.repaint();
            newPanel.revalidate();
            gameInterface();
        });

        return button;
    }

    private JButton playNormal(){
        JButton button1 = new JButton("TicTacToe Game \n(Numerical)");
        button1.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"The game has not been implemented yet :(");
        });
        return button1;
    }

    private void createMenuBar(){
        menuBar1 = new JMenuBar();
        menu1 = new JMenu("File");
        JMenuItem item = new JMenuItem("Save");
        JMenuItem item2 = new JMenuItem("Load");
        menu1.add(item);
        menu1.add(item2);
        menuBar1.add(menu1);
        item.addActionListener(e->{
            saveFile();
        });
        item2.addActionListener(e->{
            JOptionPane.showMessageDialog(null,"The Load has not been implemented yet :(");
        });


    }

    private void saveFile(){
        String nameOfFile = JOptionPane.showInputDialog("Please enter the name of the file.");

        SaveFile saveObj = new SaveFile();
        saveObj.save(nameOfFile, game);

    }

    /* NOTE: this part of code is used from Professor's exampleguiproject */
    private void putPiece(ActionEvent e){

        //send input to game and update view
        PositionAwareButton clicked = ((PositionAwareButton)(e.getSource()));
        game.takeTurn(clicked.getAcross(), clicked.getDown(),getToken());
        clicked.setText(game.getCell(clicked.getAcross(),clicked.getDown()));

    }

    private String getToken(){
        String token = "X";
        if(game.getCurrentPlayer() == 2){
            token = "O";
        }
        return token;

    }

    private void displayWinner(int whoWinner){
        if (whoWinner == 1){
            JOptionPane.showMessageDialog(null,"The winner of the game is Player 1\n");
        } else if(whoWinner == 2){
            JOptionPane.showMessageDialog(null,"The winner of the game is Player 2\n");
        }
    }

    private void checkTie(int countNum){
        if (countNum > 8){
            JOptionPane.showMessageDialog(null,"The game has no winner. It's a tie :(\n");
        }
    }

    /**
     * This is the main to run the GUI.
     * @param args argument passed
     */
    public static void main(String[] args){
        TicTacToeView obj = new TicTacToeView();
        obj.gameInterface();
    }

}
