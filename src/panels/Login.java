package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import panelchange.Exe;
import panelchange.panellist;

public class Login {
	
	private JPanel panel;
	
	
	

	public Login() {
		
		panel = new JPanel(new BorderLayout());
		
		///////////////////////////////////////// centrtpanel
		JLabel label1, label2;
		JTextField text1, text2;
		JPanel cepanel = new JPanel();
		
		label1 = new JLabel();
		label1.setText("아이디");
		text1=new JTextField(30);

		label2=new JLabel();
		label2.setText("비밀번호");
		text2=new JPasswordField(30);

		cepanel= new JPanel(new GridLayout(0, 1));
		cepanel.add(label1);
		cepanel.add(text1);
		cepanel.add(label2);
		cepanel.add(text2);
	
		/////////////////////////////////////////
		
		JPanel bopanel = new JPanel(new GridLayout(1,1));
		JButton loginbutton = new JButton("login");
		bopanel.add(loginbutton);
		loginbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String value1=text1.getText();
				String value2=text2.getText();
				if(value1.equals("1") && value2.equals("2")) {
					System.out.println("로그인 성공");
					Exe.chagepanel(panellist.load_mainpanel());
					//setVisible(false);
				} else {

					System.out.println("로그인 실패");
				}
				
			}
		});
		
		
		/////////////////////////////////////////
		bopanel.setPreferredSize(new Dimension(70,150));
		panel.add(cepanel,BorderLayout.CENTER );
		panel.add(bopanel,BorderLayout.SOUTH);
		
	}
		
	
	
	public JPanel getpanel()
	{
		return panel;
	}
}
