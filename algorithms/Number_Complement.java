package algorithms;
import java.io.*;
public class Number_Complement {
	public static void main(String []args)throws IOException
	{
		BufferedReader m=new BufferedReader(new InputStreamReader(System.in));
		int a=Integer.parseInt(m.readLine());
		int []temp={1,2};
		temp[0]=1;
		temp[1]=2;
		//String m=new String();
	//	Integer.parseInt(m);
		/*//int b=(a|0xFFFFFFFF);
		String temp=Integer.toBinaryString(a);
		String t=new String();
		for(int i=0;i<temp.length();i++)
		{
			if(temp.charAt(i)=='1')
				t=t+'0';
			else
				t=t+'1';
		}
		System.out.println(Integer.parseInt(t, 2));*/
		
		System.out.println(~a&((Integer.highestOneBit(a)<<1)-1));
	}
}
