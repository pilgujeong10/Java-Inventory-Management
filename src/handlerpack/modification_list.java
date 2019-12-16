package handlerpack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import panelchange.Exe;
import panelchange.panellist;

public class modification_list implements ActionListener{

private int y; private int m; private int d;
	
	public modification_list(int y,int m,int d) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.m = m;
		this.d = d;
	}
	
@Override
	public void actionPerformed(ActionEvent e) {
		Exe.chagepanel(panellist.load_mypanel1(y, m,d));
}
}
