package panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import handlerpack.day_bu_handler;
import panelchange.Exe;
import panelchange.panellist;

public class year {

	private JPanel panel;
	
	private int y;
	private int m;
	
	
	
	
	
	public year(int y, int m) {
		
		
		panel = new JPanel();
		setY(y); setM(m);
		
		//////////////////////////////
		JPanel weekpanel = new JPanel(new GridLayout(1, 7));
		JTextField[] t = new JTextField[7];
		String[] s ={"mon","tue","wed","thu","fri","sat","sun"};
		for(int i =0 ; i<7 ; i++)
		{
		t[i] = new JTextField(s[i]); t[i].setEditable(false); weekpanel.add(t[i]);
		}
		////////////////////////////////////////////
		JPanel n_panel = new JPanel(new GridLayout(3, 1));
		JTextField tt = new JTextField(String.format("%d³â  %d¿ù",this.y,this.m));
		tt.setEnabled(false);
		
		
		n_panel.add(move());
		n_panel.add(tt);
		n_panel.add(weekpanel); 
		///////////////////////////////////////////
		panel.setLayout(new BorderLayout());
		panel.add(n_panel, BorderLayout.NORTH);
		
		panel.add(day(), BorderLayout.CENTER);
		
	}
	
	
	public JPanel move(){
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		JButton[] bu = new JButton[2];
		bu[0]= new JButton(">>>");
		bu[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Exe.chagepanel(panellist.load_year(y, m+1));
				
			}
		});
		bu[1]= new JButton("<<<");
		bu[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Exe.chagepanel(panellist.load_year(y, m-1));
				
			}
		});
		panel.add(bu[1]);panel.add(bu[0]);
		
		return panel;
	}
	
	public JPanel day(){
		

		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(6,7));
		
		
		JButton[] dbu = new JButton[42];
		
		int i = m; int j; int jj;
		int k=0;
		int h;
		h=yoonth(y)%7;
		
		///////////////////////////////////////////
		for(jj=1;jj<=m;jj++)
		{
			
			
			if((i==2)&&(yoon(y)))
				for(j=1;j<=29;j++)
			{
				
				
				h++;
				
			}

			else if(i==2)
				for(j=1;j<=28;j++)
			{
				
				
				h++;
				
			}
			
			else if(i%2==1)
			for(j=1;j<=31;j++)
			{
				
				
				h++;
				
			}

			else if(i%2==0)
			for(j=1;j<=30;j++)
			{
				
			
				h++;
				
			}
		}
		////////////////////////////////////////////
		
		h=h&7;
		for(j=0;j<h;j++)
			{
			dbu[k] = new JButton();
			k++;
			}
		
		if((i==2)&&(yoon(y)))
		{
			for(j=1;j<=29;j++)
		{
			dbu[k] = new JButton(""+j);
			k++;
		}
		}

		else if(i==2)
		{
			for(j=1;j<=28;j++)
		{
			
				dbu[k] = new JButton(""+j);
				k++;
		}
		}
		
		else if(i%2==1)
		{
		for(j=1;j<=31;j++)
		{
			
			dbu[k] = new JButton(""+j);
			k++;
		}
		}

		else if(i%2==0)
		{
		for(j=1;j<=30;j++)
		{
			
			dbu[k] = new JButton(""+j);
			k++;
		}
		}
		for(j=k;j<42;j++)
			{dbu[k] = new JButton();
			k++;
			}
		
		for(j=0;j<42;j++)
			panel.add(dbu[j]);
		
		day_bu_handler handler = new day_bu_handler(y, m);
		
		for(j=0;j<42;j++)
		{
			dbu[j].addActionListener(handler);
		}
		
		return panel;
	}
	
	
	
	
	public boolean yoon(int a)//À±³â ÆÇº°
	{
		if(a%400==0)
			return true;
		else if(a%100==0)
			return false;
		else if(a%4==0)
			return true;
		else
			return false;
	}


	public int mouyoon(int a)//À±³â°¹¼ö
	{
		int i,sum=0;
		
		for(i=1;i<a;i++)
			if(yoon(i))
				sum+=1;

		return sum;
	}


	public int yoonth(int a)//ÃÑÀÏ¼ö
	{
		int i,sum=0;
		int th=0;
		
		if(m%2==1)
		
		th=365*(a-1)+mouyoon(a);

		return th;

	}
	
	public JPanel getpanel()
	{
		return panel;
	}
	
	public void setY(int y) {
		
		
		this.y = y;
			
		
	}
	public void setM(int m) {
		if(m==13)
		{
			this.m = 1;
			setY(y+1);
		}
		else if(m==0)
		{
			this.m = 12;
			setY(y-1);
		}
		else
		{
			this.m = m;
		}
		
	}
	
	
	
	
	
	
	
}
