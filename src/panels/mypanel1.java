package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.a_day_amount;
import database.data;
import panelchange.Exe;
import panelchange.panellist;

public class mypanel1 {

	private JPanel panel;
	private a_day_amount ad;
	
	
	public mypanel1(int y,int m,int d) {
		
		
		////////////////////////////////////a dayŬ�� ã��	
		
		System.out.println("ó�� �Է� ��"+y+" "+m+" "+d);
		
		this.ad = findaday(y, m, d);
		////////////////////////////////////////////////////////////////
		this.panel = new JPanel(new BorderLayout());
		/////////////////////////////////////////////////////////////////////////�� ����
		
		JButton dbu = new JButton(String.format("%d/%d/%d\n ��¥����", y,m,d));
		dbu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Exe.chagepanel(panellist.load_year(2017, 6));
			}
		});
		
		
		////////////////////////////////////////////////////////////////////���� �г�
		JTextField[] t = new JTextField[16];
		String[] m2 = {"","  �԰�   ","  ���   ","  ���     ",
				"ȣ���� ��θ��̵�(2�� ��)",""+ad.getA_in(),""+ad.getA_out(),""+data.total_a,
				"ȣ���� ģ�� ���κ�(5�� ��)",""+ad.getB_in(),""+ad.getB_out(),""+data.total_b,
				"ȣ���� �౸ȭ(20�� ��)",""+ad.getC_in(),""+ad.getC_out(),""+data.total_c};
		
			
			JPanel panel=new JPanel();
			panel.setLayout(new GridLayout(0,4));
			panel.add(dbu);
			for(int i=1; i<16; i++){
				t[i]=new JTextField(m2[i]);
				panel.add(t[i]);
				t[i].setEditable(false);
				if(i>4&&(i%4==1||i%4==2)){
					t[i].setEditable(true);
				}}
		this.panel.add(panel,BorderLayout.CENTER);
		/////////////////////////////////////////////////////////////////////////////////�޴� �г�
		this.panel.add(panellist.load_mainpanel(),BorderLayout.NORTH);
		//////////////////////////////////////////////////////////////////////���ΰ�ħ
		JButton restbu = new JButton("���ΰ�ħ");
		restbu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				set_total(ad, t);
				int s;
				int i ;
				if(data.list_day.contains(ad))
				{
					
					for(i=0;i<data.list_day.size();i++)
						if(data.list_day.get(i).getD()==d&&data.list_day.get(i).getM()==m&&data.list_day.get(i).getY()==y)
						{
							
							data.list_day.remove(i);
							data.list_day.add(i,new a_day_amount(y, m, d,Integer.parseInt(t[5].getText())
									  ,Integer.parseInt(t[6].getText())
									  ,Integer.parseInt(t[9].getText())
									  ,Integer.parseInt(t[10].getText())
									  ,Integer.parseInt(t[13].getText())
									  ,Integer.parseInt(t[14].getText())));
							
							
				}
					System.out.println(""+y+" "+m+" "+d);	
				
					
					Exe.chagepanel(panellist.load_mypanel1(y,m,d));
					
				}
				else{
					System.out.println("else �ߵ�");
					data.list_day.add(new a_day_amount(y, m, d,Integer.parseInt(t[5].getText())
															  ,Integer.parseInt(t[6].getText())
															  ,Integer.parseInt(t[9].getText())
															  ,Integer.parseInt(t[10].getText())
															  ,Integer.parseInt(t[13].getText())
															  ,Integer.parseInt(t[14].getText())));
					Exe.chagepanel(panellist.load_mypanel1(y, m, d));
				}
				
			}
		});
		this.panel.add(restbu,BorderLayout.SOUTH);
		
	}
	
	
	public JPanel getpanel()
	{
		return panel;
	}
	
	
	public a_day_amount findaday(int y,int m,int d)
	{
		
		a_day_amount ad = new a_day_amount(2016, 6, 1, 0, 0, 0, 0, 0,0);
		
		int i;
		
	
		for(i=0;i<data.list_day.size();i++)
	
		{
			System.out.println(data.list_day.get(i).getY());
			System.out.println(data.list_day.get(i).getM());
			System.out.println(data.list_day.get(i).getD());
			if((data.list_day.get(i).getD()==d)&&(data.list_day.get(i).getM()==m)&&(data.list_day.get(i).getY()==y))
		{
			
			ad = data.list_day.get(i);
			System.out.println("�ߺ� �ν���");
		}
		else
			System.out.println("�ߺ� �νĸ���");
		}
		
		
		return ad;
	}
	
	public void set_total(a_day_amount ad,JTextField[] t)
	{
		data.total_a += -ad.getA_in() + ad.getA_out()+ Integer.parseInt(t[5].getText())-Integer.parseInt(t[6].getText());
		data.total_b += -ad.getB_in() + ad.getB_out()+ Integer.parseInt(t[9].getText())-Integer.parseInt(t[10].getText());
		data.total_c += -ad.getC_in() + ad.getC_out()+ Integer.parseInt(t[13].getText())-Integer.parseInt(t[14].getText());
		
	}
	
	
}
