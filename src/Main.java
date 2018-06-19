
public class Main {

	public static void main(String[] args) {
    LoginFrame lf = new LoginFrame();
DB.intializeDB();
lf.setVisible(true);
DB.getBtcIndex();
		
	}

}
