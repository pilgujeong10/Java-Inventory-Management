package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.FILELOAD;
import panelchange.Exe;
import panelchange.panellist;

public class mainpnel {

	private JPanel panel;
	
	int i=0;
	
	public mainpnel() {
		
		panel = new JPanel(new BorderLayout());
		///////////////////////////////////////
		//JPanel textpanel = new JPanel(new GridLayout(1,1));
		//textpanel.add(new JLabel("                   기능을 선택하세요"));
		//panel.add(textpanel,BorderLayout.NORTH);
        ///////////////////////////////////////
		
		JPanel bupanel = new JPanel(new GridLayout(1,5));
		
		String[] m = {"재고관리","입출금 관리","매출 관리","저장"};
		String[] m2 = {"mypanel1","mypanel2","mypanel3","mypanel4"};
		
		JButton[] bu = new JButton[4];
		
		bupanel.add(new JLabel("기능을 선택하세요"));
		
		for(int i=0;i<4;i++){
			bu[i] = new JButton(m[i]);
			bupanel.add(bu[i]);
		}
		
		///////////////////////////////////////////////////////////////////////
		bu[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Exe.chagepanel(panellist.loadpanel(m2[0]));
				
			}
		});
		bu[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Exe.chagepanel(panellist.loadpanel(m2[1]));
				
			}
		});
		bu[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Exe.chagepanel(panellist.loadpanel(m2[2]));
				
			}
		});
		bu[3].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FILELOAD d = new FILELOAD();
				d.save();
				
			}
		});
		
		
		panel.add(bupanel , BorderLayout.NORTH);
		///////////////////////////////////////
		
		
	}
	
	public JPanel getpanel()
	{
		return panel;
	}
}
