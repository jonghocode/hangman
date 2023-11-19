import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissors extends JFrame {
    private JTextField userInput;
    private JLabel resultLabel;

    public RockPaperScissors() {
        setTitle("Rock-Paper-Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        userInput = new JTextField();
        userInput.setPreferredSize(new Dimension(200, 30));

        JButton playButton = new JButton("가위, 바위, 보 중 하나를 입력해주세요!");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });

        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(userInput, BorderLayout.NORTH);
        panel.add(playButton, BorderLayout.CENTER);
        panel.add(resultLabel, BorderLayout.SOUTH);

        add(panel);
    }

    private void playGame() {
        String userChoice = userInput.getText().toLowerCase().trim();
        if (!userChoice.equals("가위") && !userChoice.equals("바위") && !userChoice.equals("보")) {
            JOptionPane.showMessageDialog(this, "가위, 바위, 보 중 하나를 입력해주세요!");
            return;
        }

        String[] choices = {"가위", "바위", "보"};
        Random random = new Random();
        int computerIndex = random.nextInt(choices.length);
        String computerChoice = choices[computerIndex];

        String result = determineWinner(userChoice, computerChoice);
        if (result.equals("You win!")) {
            JOptionPane.showConfirmDialog(null, "부활!", "Ooops...",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
            new PlayFrame("1");
        } else {
            JOptionPane.showConfirmDialog(null, "유저는 " + userChoice + ", 컴퓨터는 " + computerChoice + "이므로 부활하지 못했습니다..", "Ooops...",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
    }

    private String determineWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "It's a tie!";
        } else if ((user.equals("바위") && computer.equals("가위")) ||
                (user.equals("가위") && computer.equals("보")) ||
                (user.equals("보") && computer.equals("바위"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RockPaperScissors();
            }
        });
    }
}