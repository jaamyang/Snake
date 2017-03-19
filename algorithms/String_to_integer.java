package algorithms;
import java.util.*;
public class String_to_integer {
	public static void main(String[]args)
	{
		 	String temp=new String();
	        Scanner in=new Scanner(System.in);
	        String str=in.nextLine();
	        int flag=0;
	        int sign=0;
		 	for(int i=0;i<str.length();i++)
	        {
		 		if(str.charAt(i)=='-')
		 		{
		 			sign=1;
		 					
		 		}
		 		else if(Character.isDigit(str.charAt(i)))
	                {
		 			if(sign==1)
		 			 temp+='-';
		 			 temp+=Character.toString(str.charAt(i));
	                 sign=0;
		 			 flag=1;
	                }
	          
	        }
		 	try{
		 	if(flag==0)
		 		System.out.println(flag);
		 	else 
		 		System.out.println(Integer.parseInt(temp));
		 	}
		 	catch(NumberFormatException e)
		 	{
		 		System.out.println(0);
		 	}
	}
}
