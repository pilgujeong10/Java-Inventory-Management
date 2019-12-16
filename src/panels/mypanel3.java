package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import database.a_day_amount;
import database.data;
import panelchange.panellist;


public class mypanel3 {

	private JPanel panel;
	
	private int toa = sella();
	private int tob = sellb();
	private int toc = sellc();
	
	public mypanel3() {
		this.panel = new JPanel(new BorderLayout());
		/////////////////////////////////////////////////////////////////////////메인 패널
		JTextField[] t = new JTextField[12];
		String[] m = {"","  입력한 날짜의 총 판매량  "," 입력한 날짜의 총 매출 ",
				"호날두 브로마이드",""+sella(),""+toa*20000,
				"호날두 친필 싸인볼",""+sellb(),""+tob*50000,
				"호날두 축구화",""+sellc(),""+toc*200000
				};
		
			
			JPanel panel=new JPanel();
			panel.setLayout(new GridLayout(4,3));
			for(int i=0; i<12; i++){
				t[i]=new JTextField(m[i]);
				panel.add(t[i]);
				t[i].setEditable(false);
				}
		this.panel.add(panel,BorderLayout.CENTER);
		/////////////////////////////////////////////////////////////////////////////////메뉴 패널
		this.panel.add(panellist.load_mainpanel(),BorderLayout.NORTH);
		/////////////////////////////////////////////////////////////////////////총매출
		int a =data.total_a;  int b =data.total_b ;  int c =data.total_c;
		this.panel.add(new JTextField("총매출 : "+Integer.toString(toa*2+tob*5+toc*20)+"[만 원]"),BorderLayout.SOUTH);
	}
	
	public JPanel getpanel()
	{
		return panel;
	}
	public int sella()
	{
		int m= 0;
		for(int i =0 ;i<data.list_day.size();i++)
		{
			m += data.list_day.get(i).getA_out();
		}
		return m;
	}
	
	public int sellb()
	{
		int m= 0;
		for(int i =0 ;i<data.list_day.size();i++)
		{
			m += data.list_day.get(i).getB_out();
		}
		return m;
	}
	
	public int sellc()
	{
		int m= 0;
		for(int i =0 ;i<data.list_day.size();i++)
		{
			m += data.list_day.get(i).getC_out();
		}
		return m;
	}
}
