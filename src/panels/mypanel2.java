package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import database.data;
import database.a_day_amount;
import handlerpack.modification_list;
import panelchange.panellist;

public class mypanel2 {

	private JPanel panel;
	
	private ArrayList<a_day_amount> list;
	
	public mypanel2() {
		panel = new JPanel(new BorderLayout());
		
		list = data.list_day;
		/////////////////////////////////////메인패널
		JPanel mainpanel = new JPanel(new BorderLayout());
		mainpanel.add(mainpanel(),BorderLayout.NORTH);
		
		JScrollPane  s = new JScrollPane();
		s.setViewportView(mainpanel);
		s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(s,BorderLayout.CENTER);
		
		/////////////////////////////////////////////////메뉴 패널
		panel.add(panellist.load_mainpanel(),BorderLayout.NORTH);
		
		
	}
	
	
	public JPanel mainpanel()
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(list.size(), 1));
		
		int size = list.size();
		
		JPanel[] barpanel = new JPanel[size];
		
		for(int i =0;i<size;i++)
		{
			JTextField j = new JTextField(list.get(i).get_fullinform());
			
			JButton b = new JButton("수정");
			b.addActionListener(new modification_list(list.get(i).getY(),list.get(i).getM(),list.get(i).getD()));
			
			barpanel[i] = new JPanel(new BorderLayout());
			
			barpanel[i].add(j, BorderLayout.CENTER);
			barpanel[i].add(b, BorderLayout.EAST);
			
			panel.add(barpanel[i]);
			
		}
		
		return panel;
		
		
		
	}
	
	
	public JPanel getpanel()
	{
		return panel;
	}
}
