package database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class FILELOAD {

	private Scanner input;
	private Scanner input2;
	
	private Formatter output;
	private Formatter output2;
	
	
	public void read()
	{
		data.list_day = new ArrayList<a_day_amount>();
		data.total_a = 0; data.total_b = 0; data.total_c = 0;
		
		if(new File("data.txt").exists())
		{
			
			
		try
		{
			input = new Scanner(new File("data.txt"));
		}
		catch (Exception e) {
			System.out.println("저장 오류남");
		}
		int i =0;
		try
		{
			System.out.println("불러오기시작");
			while(input.hasNext())
			{
				data.list_day.add(new a_day_amount(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt()));
				
			}
		}
		catch (Exception e) {
			System.out.println("저장 오류남2");
		}
		
		
		
		
		try
		{
			input2 = new Scanner(new File("data2.txt"));
		}
		catch (Exception e) {
			System.out.println("저장 오류남");
		}
		
		try
		{
			while(input.hasNext())
			{
				data.total_a = input2.nextInt();
				data.total_b = input2.nextInt();
				data.total_c = input2.nextInt();
			}
		}
		catch (Exception e) {
			System.out.println("저장 오류남2");
		}
		
		
		input2.close();
		input.close();}
		
	}
	
	public void save()
	{
		
		try {
			
			output = new Formatter("data.txt");
			
			for(int i=0; i<data.list_day.size(); i++){
				output.format("%d %d %d %d %d %d %d %d %d ",
						data.list_day.get(i).getY(), data.list_day.get(i).getM(), data.list_day.get(i).getD(),
						data.list_day.get(i).getA_in(), data.list_day.get(i).getA_out(), data.list_day.get(i).getB_in(),
						data.list_day.get(i).getB_out(), data.list_day.get(i).getC_in(), data.list_day.get(i).getC_out());
			}
			
			
			System.out.println("저장완료");
		} catch (Exception e) {
			
		}	
		output.close();
		
		
		
		
		try {
			output2 = new Formatter("data2.txt");
			
			output2.format("%d %d %d",data.total_a,data.total_b,data.total_c);
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		output2.close();
	}

	
}
