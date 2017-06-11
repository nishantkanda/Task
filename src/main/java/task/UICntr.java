package task;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UICntr {

	static String USER_AGENT = "Mozilla 5.0";

	public void msg() throws Exception {
		int i = 0;
		String msg1 = "Enter Planet ID for Specific information or Enter all for complete records \n";
		String msg2 = "Planet Details";
		ParmResponse id = new ParmResponse();
		CmpResponse all = new CmpResponse();
		String s = frameinppanel(msg1, msg2);

		if (isInteger(s)) {
			i = Integer.parseInt(s);
			id.PrmResponse(i, USER_AGENT);
		} else if ((s != null) && (s.length() > 0 && s.equalsIgnoreCase("all"))) {
			all.cmpResp(USER_AGENT);
		} else {
			int resp = ConDiag("Incorrect Option \n " + "Do you want to re-enter ", "Warning");
			if (resp == 0) {
				this.msg();
			}
		}
	}

	public String frameinppanel(String txt, String dft) {
		JFrame frm = new JFrame("Planets");
		String s = (String) JOptionPane.showInputDialog(frm, txt, dft, JOptionPane.PLAIN_MESSAGE, null, null, null);
		return (s);
	}

	public int ConDiag(String e, String title) {
		JFrame frm = new JFrame("Planets");
		int n = JOptionPane.showConfirmDialog(frm, e, title, JOptionPane.YES_NO_OPTION);
		return (n);
	}

	public void framepanel(String txt) {
		JFrame frm = new JFrame("Planets");
		frm.setSize(300, 200);
		JOptionPane.showMessageDialog(frm, "<html><body><p style='width: 200px;'>" + txt + "</p></body></html>",
				"Result", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

}
