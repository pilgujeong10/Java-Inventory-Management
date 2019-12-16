package database;

public class a_day_amount {

	public int y;//이거 private에서 public으로 바꿈
	public int m;
	public int d;
	
	private int a_in;
	private int a_out;
	
	private int b_in;
	private int b_out;
	
	private int c_in;
	public int c_out;
	
	public a_day_amount(int y, int m, int d,  int a_in,int a_out,int b_in,int b_out,int c_in,int c_out) {
		this.a_in = a_in; this.a_out = a_out;
		this.b_in = b_in; this.b_out = b_out;
		this.c_in = c_in; this.c_out = c_out;
		
		this.y = y;
		this.m = m;
		this.d = d;
				
	}
	
	public int getA_in() {
		return a_in;
	}
	public int getB_in() {
		return b_in;
	}
	public int getC_in() {
		return c_in;
	}
	public int getA_out() {
		return a_out;
	}
	public int getB_out() {
		return b_out;
	}
	public int getC_out() {
		return c_out;
	}
	public int getD() {
		return d;
	}
	public int getM() {
		return m;
	}
	public int getY() {
		return y;
	}
	public String get_fullday(){
	
		return String.format("%d년 %d월 %d일", y,m,d);
					
	}
	public String get_fullinform()
	{
		return String.format("%d년 %5d월 %5d일  입금 %5d 출금 %5d    통장잔고 %5d ", y,m,d,(a_out*20000+b_out*50000+c_out*200000),(a_in*10000+b_in*30000+c_in*150000),(a()+b()+c()));
		
	}
	
	public void setA_in(int a_in) {
		this.a_in = a_in;
	}
	public void setC_out(int c_out) {
		this.c_out = c_out;
	}
	public void setC_in(int c_in) {
		this.c_in = c_in;
	}
	public void setB_out(int b_out) {
		this.b_out = b_out;
	}
	public void setB_in (int d) {
		this.d = d;
	}
	public void setA_out(int a_out) {
		this.a_out = a_out;
	}
	
	
	public int a()
	{
		int m=0;
		for(int i =0;i< data.list_day.size();i++)
		{
			m+= (data.list_day.get(i).a_out*20000) - (data.list_day.get(i).a_in*10000);
					
		}
		return m;
	}
	public int b(){
		int m=0;
		for(int i =0;i< data.list_day.size();i++)
		{
			m+= data.list_day.get(i).b_out*50000 - data.list_day.get(i).b_in*30000;
					
		}
		return m;
	}
	public int c(){
		int m=0;
		for(int i =0;i< data.list_day.size();i++)
		{
			m+= data.list_day.get(i).c_out*200000 - data.list_day.get(i).c_in*150000;
					
		}
		return m;
		
	}
	
	
}
