package main;

import javax.swing.JFrame;

import database.FILELOAD;
import panelchange.Exe;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		FILELOAD f = new FILELOAD();
		f.read();
		
		JFrame a = new Exe().getjframe();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(800, 400);
		a.setVisible(true);
		
	}

}
