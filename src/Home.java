import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class Home extends JFrame {

    private JPanel panel;
    private JButton btnStart;


    public Home(Main m) {
        super("Save the Hang Man");
        setBounds(0, 0, 780, 650);
        setLocationRelativeTo(null); // 가운데 정렬
        setResizable(false); // 창 크기조절 못하도록

        // -----------

        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setFont(new Font("Press Start K", Font.PLAIN, 20)); // 폰트 설정
        panel.setBounds(0, 0, 780, 650);
        getContentPane().add(panel);
        panel.setLayout(null);


        btnStart = new JButton("게임 시작");

        btnStart.setForeground(Color.YELLOW);
        btnStart.setBackground(Color.DARK_GRAY);
        btnStart.setFont(new Font("Press Start K", Font.PLAIN, 25));
        btnStart.setBounds(550, 240, 200, 40);

        btnStart.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PlayFrame("1").setLocationRelativeTo(null); // 가운데 정렬 ;

            }
        });

        panel.add(btnStart);

        JButton btnNewButton = new JButton("게임 종료");
        btnNewButton.setForeground(UIManager.getColor("InternalFrame.borderDarkShadow"));
        btnNewButton.setBackground(Color.DARK_GRAY);
        btnNewButton.setFont(new Font("Press Start K", Font.PLAIN, 25));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(550, 300, 200, 40);
        panel.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);

            }

        });

        JButton btnScore = new JButton("랭킹 보기");
        btnScore.setForeground(UIManager.getColor("InternalFrame.borderDarkShadow"));
        btnScore.setBackground(Color.DARK_GRAY);
        btnScore.setFont(new Font("Press Start K", Font.PLAIN, 25));
        btnScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m.bs.setVisible(true);
            }
        });
        btnScore.setBounds(550, 360, 200, 40);
        panel.add(btnScore);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setFont(new Font("Press Start K", Font.PLAIN, 13));
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(0, 0, 780, 627);
        panel.add(lblNewLabel);
        Image myImg = new ImageIcon("C:\\hangman\\img\\행맨.png").getImage().getScaledInstance(780, 650, 0); // 상대경로 설정하기
        lblNewLabel.setIcon(new ImageIcon(myImg));

        add(panel);

    }
}