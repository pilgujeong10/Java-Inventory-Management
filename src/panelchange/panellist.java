package panelchange;

import javax.swing.JPanel;

import panels.mainpnel;
import panels.mypanel1;
import panels.mypanel2;
import panels.mypanel3;
import panels.year;

public class panellist {
	
	
	public static JPanel loadpanel(String s) {
		// TODO Auto-generated constructor stub
		JPanel p = new JPanel();
		
		if(s.equals("mypanel1")){
			p = load_mypanel1(2017, 6 , 1);
		}
		else if(s.equals("mypanel2")){
			p =load_mypanel2();
		}
		else if (s.equals("mypanel3")){
			p =load_mypanel3();
		}
		
		return p;
			
	}
	
	/*public static JPanel load_panelname()
	{
		panelname pa = new panelname();
		return pa.getpanel();
	}*/
	
	
	///////////////////////////////////////////
	public static JPanel load_mainpanel()
	{
		mainpnel pa = new mainpnel();
		return pa.getpanel();
	}
	
	
	///////////////////////////////////////////////
	public static JPanel load_mypanel1(int y,int m,int d)
	{
		mypanel1 pa = new mypanel1(y,m,d);
		return pa.getpanel();
	}
	public static JPanel load_mypanel2()
	{
		mypanel2 pa = new mypanel2();
		return pa.getpanel();
	}
	public static JPanel load_mypanel3()
	{
		mypanel3 pa = new mypanel3();
		return pa.getpanel();
	}
	public static JPanel load_year(int y,int m)
	{
		year pa = new year(y, m);
		return pa.getpanel();
	}
	
	
}
