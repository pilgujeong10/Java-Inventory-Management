package panelchange;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.Login;




public class Exe {

	static private JFrame frame = new JFrame("Administrator access");
	static private JPanel nowpanel;
	static private GridLayout layout = new GridLayout(1, 1);
	
	public Exe(){
		
		nowpanel = new JPanel(new GridLayout(1,1));
		frame.setLayout(layout);
		
		nowpanel.add(new Login().getpanel());
		
		frame.add(nowpanel);
	}
	public JFrame getjframe()
	{
		return frame;
	}
	
	public static void chagepanel(JPanel p)
	{
		frame.remove(nowpanel);
		nowpanel = p;
		frame.add(nowpanel);
		layout.layoutContainer(frame.getContentPane());
		frame.getContentPane().validate();
		
	}
}
