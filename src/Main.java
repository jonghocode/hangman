public class Main {
    public static DB db = new DB();
    JoinFrame jf = null;
    MainFrame mf = null;
    Home h = null;
    BoardScore bs = null;
    public static RockPaperScissors rs = new RockPaperScissors();
    public static Member mem = new Member();

    public static void main(String[] args) {
        Main m = new Main();
        m.jf = new JoinFrame(m);
        m.mf = new MainFrame(m);
        m.h = new Home(m);
        m.bs = new BoardScore(m);
    }

}