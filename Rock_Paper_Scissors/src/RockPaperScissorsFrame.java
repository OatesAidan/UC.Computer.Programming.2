import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

    JFrame frame;

    JPanel mainPnl;
    JPanel btnPnl;
    JPanel statsPnl;
    JPanel resultsPnl;


    JButton quitBtn;
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

    JLabel playerWinsLbl;
    JLabel computerWinsLbl;
    JLabel tiesLbl;

    JTextField playerWinsField;
    JTextField computerWinsField;
    JTextField tiesField;

    JTextArea resultsArea;

    JScrollPane scrollPane;

    String computerMove= "";

    public int playerWins = 0;
    public int computerWins = 0;
    public int ties = 0;
    public int gamesPlayed = 0;
    public RockPaperScissorsFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("Rock Paper Scissors Game Window");
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createBtnPnl();
        createStatsPnl();
        createResultsPnl();

        mainPnl.add(statsPnl, BorderLayout.NORTH);
        mainPnl.add(resultsPnl, BorderLayout.CENTER);
        mainPnl.add(btnPnl, BorderLayout.SOUTH);
        add(mainPnl);
        setVisible(true);
    }

    private void createStatsPnl()
    {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(2,3, 25, 25));
        statsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Stats Panel"));

        playerWinsLbl = new JLabel("Player Wins", SwingConstants.CENTER);
        playerWinsLbl.setFont(new Font("Arial", Font.PLAIN, 24));
        computerWinsLbl = new JLabel("Computer Wins", SwingConstants.CENTER);
        computerWinsLbl.setFont(new Font("Arial", Font.PLAIN, 24));
        tiesLbl = new JLabel("Number of Ties", SwingConstants.CENTER);
        tiesLbl.setFont(new Font("Arial", Font.PLAIN, 24));
        playerWinsField = new JTextField("0");
        playerWinsField.setHorizontalAlignment(JTextField.CENTER);
        playerWinsField.setFont(new Font("Arial", Font.BOLD, 18));
        computerWinsField = new JTextField("0");
        computerWinsField.setHorizontalAlignment(JTextField.CENTER);
        computerWinsField.setFont(new Font("Arial", Font.BOLD, 18));
        tiesField = new JTextField("0");
        tiesField.setHorizontalAlignment(JTextField.CENTER);
        tiesField.setFont(new Font("Arial", Font.BOLD, 18));

        playerWinsField.setEditable(false);
        computerWinsField.setEditable(false);
        tiesField.setEditable(false);

        statsPnl.add(playerWinsLbl);
        statsPnl.add(computerWinsLbl);
        statsPnl.add(tiesLbl);
        statsPnl.add(playerWinsField);
        statsPnl.add(computerWinsField);
        statsPnl.add(tiesField);
    }

    private void createResultsPnl()
    {
        resultsPnl = new JPanel();
        resultsPnl.setLayout(new GridLayout(1,1));
        resultsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Results Panel"));
        resultsPnl.setSize(600,600);
        resultsArea = new JTextArea();
        scrollPane = new JScrollPane(resultsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(350, 500);
        resultsPnl.add(scrollPane);
    }

    private void createBtnPnl()
    {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout());
        btnPnl.setBorder(new TitledBorder(new EtchedBorder(), "Game Moves"));

        rockIcon = new ImageIcon(new ImageIcon("src/rock.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        paperIcon = new ImageIcon(new ImageIcon("src/paper.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        scissorsIcon = new ImageIcon(new ImageIcon("src/scissors.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent e) -> {System.exit(0);});
        rockBtn = new JButton(rockIcon);
        rockBtn.addActionListener((ActionEvent e) -> {getMove("Rock");});
        paperBtn = new JButton(paperIcon);
        paperBtn.addActionListener((ActionEvent e) -> {getMove("Paper");});
        scissorsBtn = new JButton(scissorsIcon);
        scissorsBtn.addActionListener((ActionEvent e) -> {getMove("Scissors");});

        btnPnl.add(rockBtn);
        btnPnl.add(paperBtn);
        btnPnl.add(scissorsBtn);
        btnPnl.add(quitBtn);
    }

    private void getMove(String pMove)
    {
        Random random = new Random();
        int index = 0;
        ArrayList<String> moves = new ArrayList<>();
        moves.add("Rock");
        moves.add("Paper");
        moves.add("Scissors");

        index = random.nextInt(3);
        computerMove = moves.get(index);
        result(pMove, computerMove);
    }

    private void result(String pMove, String cMove)
    {
        gamesPlayed++;
        int result = 0;
        ArrayList<String> outcome = new ArrayList<>();
        outcome.add("There is a tie!");
        outcome.add("Player Wins!");
        outcome.add("Computer Wins!");

        if (pMove == "Rock" && cMove == "Rock")
        {
            result =  0;
        }
        else if (pMove == "Rock" && cMove == "Paper")
        {
            result =  2;
        }
        else if (pMove == "Rock" && cMove == "Scissors")
        {
            result =  1;
        }
        else if (pMove == "Paper" && cMove == "Paper")
        {
            result =  0;
        }
        else if (pMove == "Paper" && cMove == "Scissors")
        {
            result =  2;
        }
        else if (pMove == "Paper" && cMove == "Rock")
        {
            result =  1;
        }
        else if (pMove == "Scissors" && cMove == "Scissors")
        {
            result =  0;
        }
        else if (pMove == "Scissors" && cMove == "Rock")
        {
            result =  2;
        }
        else if (pMove == "Scissors" && cMove == "Paper")
        {
            result =  1;
        }
        resultsArea.append("Game # " + gamesPlayed +"\t Player Move: " + pMove + "\t Computer Move: " + cMove + "\t Result: " + outcome.get(result) + "\n");
        updateCounters(result);
    }

    private void updateCounters(int r)
    {
        switch(r) {
            case 0:
                ties += 1;
                tiesField.setText(Integer.toString(ties));
                break;
            case 1:
                playerWins += 1;
                playerWinsField.setText(Integer.toString(playerWins));
                break;
            case 2:
                computerWins += 1;
                computerWinsField.setText(Integer.toString(computerWins));
                break;
        }
    }
}