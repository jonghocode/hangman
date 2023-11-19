import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
    Connection con = null;
    Statement stmt = null;
    String url = "jdbc:oracle:thin:@localhost:1521:xe";	//dbstudy 스키마
    String user = "insa";
    String passwd = "insa";		//본인이 설정한 root 계정의 비밀번호를 입력하면 된다.

    DB() {	//데이터베이스에 연결한다.
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
            System.out.println("Oracle 서버 연동 성공");
        } catch(Exception e) {
            System.out.println("Oracle 서버 연동 실패 > " + e.toString());
        }
    }


    boolean logincheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String checkingStr = "SELECT pw FROM hangman WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);
            if(result.next()) { // 결과가 있다면
                if(pw.equals(result.getString("pw"))) {
                    flag = true;
                } else {
                    System.out.println("비밀번호 불일치");
                }
            } else {
                System.out.println("해당 아이디가 존재하지 않습니다.");
            }
        } catch(Exception e) {
            flag = false;
            System.out.println("로그인 실패 > " + e.toString());
        }

        return flag;
    }

    boolean joinCheck(String _i, String _p) {
        boolean flag = false;

        String id = _i;
        String pw = _p;

        try {
            String insertStr = "INSERT INTO hangman VALUES('" + id + "', '" + pw + "')";
            stmt.executeUpdate(insertStr);

            flag = true;
            System.out.println("회원가입 성공");
        } catch(Exception e) {
            flag = false;
            System.out.println("회원가입 실패 > " + e.toString());
        }

        return flag;
    }

    void updateScore(String id, int cnt) {

        try {
            String checkingStr = "SELECT num FROM score WHERE id='" + id + "'";
            ResultSet result = stmt.executeQuery(checkingStr);
            System.out.println(checkingStr);
            if(result.next()) { // 결과가 있다면
                int t = Integer.parseInt(result.getString("num"));
                if (t < cnt) {
                    String str = "update score set num = " + cnt + " where id = '" + id + "'";
                    stmt.executeUpdate(str);
                }
            } else {
                String str2 = "INSERT INTO score VALUES('" + id + "', " + cnt + ")";
                stmt.executeUpdate(str2);
                System.out.println(str2);
            }
        } catch(Exception e) {
            System.out.println("랭킹 insert 실패" + e.toString());
        }

    }
}
