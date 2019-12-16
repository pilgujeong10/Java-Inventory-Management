package handlerpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panelchange.Exe;
import panelchange.panellist;

public class day_bu_handler implements ActionListener{

	private int y; private int m;
	
	public day_bu_handler(int y,int m) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.m = m;
	}
	
@Override
	public void actionPerformed(ActionEvent e) {
		Exe.chagepanel(panellist.load_mypanel1(y, m, Integer.parseInt(e.getActionCommand())));
	}	
}
