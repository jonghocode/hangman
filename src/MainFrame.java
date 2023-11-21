import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MainFrame extends JFrame {
    public static JFormattedTextField userIdInput = new JFormattedTextField("아이디를 입력하세요");
    public static JFormattedTextField userPwInput = new JFormattedTextField("비밀번호를 입력하세요");

    private JPanel panel;
    private JButton btnLogin;
    private JButton btnCreate;

    public MainFrame(Main m) {
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


        userIdInput.setText("아이디를 입력하세요");
        userIdInput.setForeground(Color.LIGHT_GRAY);
        userIdInput.setBackground(Color.DARK_GRAY);
        userIdInput.setHorizontalAlignment(SwingConstants.CENTER);
        userIdInput.setFont(new Font("Press Start K", Font.PLAIN, 17));
        userIdInput.setBounds(550, 50, 200, 40);
        userIdInput.addMouseListener(new MouseAdapter() {   // 입력창을 클릭하면 디폴트로 입력된 글자들을 싹 사라지게 해주는 코드
            @Override
            public void mouseClicked(MouseEvent e) {
                userIdInput.setText("");
            }
        });
        panel.add(userIdInput);

        userPwInput.setText("비밀번호를 입력하세요");
        userPwInput.setForeground(Color.LIGHT_GRAY);
        userPwInput.setBackground(Color.DARK_GRAY);
        userPwInput.setHorizontalAlignment(SwingConstants.CENTER);
        userPwInput.setFont(new Font("Press Start K", Font.PLAIN, 17));
        userPwInput.setBounds(550, 100, 200, 40);
        userPwInput.addMouseListener(new MouseAdapter() {   // 입력창을 클릭하면 디폴트로 입력된 글자들을 싹 사라지게 해주는 코드
            @Override
            public void mouseClicked(MouseEvent e) {
                userPwInput.setText("");
            }
        });
        panel.add(userPwInput);

        JLabel idmsg = new JLabel("로그인에 실패했습니다");
        JLabel msg = new JLabel("아이디와 비밀번호 모두 입력해주세요!");


        idmsg.setFont(new Font("Press Start K", Font.BOLD, 25));


        btnLogin = new JButton("로그인");

        btnLogin.setForeground(Color.YELLOW);
        btnLogin.setBackground(Color.DARK_GRAY);
        btnLogin.setFont(new Font("Press Start K", Font.PLAIN, 10));
        btnLogin.setBounds(550, 150, 80, 30);

        btnLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(userIdInput.getText().equals("") && userPwInput.getText().equals("") ||
                        userIdInput.getText().equals("아이디를 입력하세요") && userPwInput.getText().equals("비밀번호를 입력하세요")){
                    JOptionPane.showMessageDialog(null, msg, "다시 입력해주세요!", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    if (Main.db.logincheck(userIdInput.getText(), userPwInput.getText())) {
                        Main.mem.setUser_id(userIdInput.getText());
                        dispose();
                        m.h.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, idmsg, "다시 입력해주세요!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(btnLogin);

        btnCreate = new JButton("회원가입");

        btnCreate.setForeground(Color.YELLOW);
        btnCreate.setBackground(Color.DARK_GRAY);
        btnCreate.setFont(new Font("Press Start K", Font.PLAIN, 10));
        btnCreate.setBounds(670, 150, 80, 30);
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.jf.setVisible(true);
            }

        });
        panel.add(btnCreate);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setFont(new Font("Press Start K", Font.PLAIN, 13));
        lblNewLabel.setForeground(Color.LIGHT_GRAY);
        lblNewLabel.setBounds(0, 0, 780, 627);
        panel.add(lblNewLabel);
        Image myImg = new ImageIcon("C:\\hangman\\img\\행맨.png").getImage().getScaledInstance(780, 650, 0); // 상대경로 설정하기
        lblNewLabel.setIcon(new ImageIcon(myImg));

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


}