package algorithms;
import java.util.*;
public class Two_Sum {
	public static void main(String []args)
	{
//		Scanner in=new Scanner(System.in);
		//int a=0;
		int []nums={3,2,4};
		int []temp={0,0};
        for(int i=0;i<nums.length;i++)
            {
                int a=6-nums[i];
                for(int j=i+1;j<nums.length;j++)
                {
                    if(nums[j]==a)
                        {
                            temp[0]=i;
                            temp[1]=j;
                            System.out.println(temp[0]+" "+temp[1]);
                        }
                }
            }
	}
}
