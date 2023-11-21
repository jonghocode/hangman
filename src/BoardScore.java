import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BoardScore extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public BoardScore(Main m) {
        setTitle("상위 10명의 회원");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        model = new DefaultTableModel();
        table = new JTable(model);

        // 테이블 컬럼 설정
        model.addColumn("아이디");
        model.addColumn("점수");

        Connection connection = null;
        try {
            // Oracle DB 연결
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "insa";
            String password = "insa";
            connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String sqlQuery ="SELECT id, num FROM score ORDER BY TO_NUMBER(num) DESC";

            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // 가져온 데이터를 테이블에 추가
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                int num = resultSet.getInt("num");
                model.addRow(new Object[]{id, num});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);


    }
}
