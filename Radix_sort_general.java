package radix_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

	void radixSort(int[] nums)
	{
		
		final int radix = 10;
		int placeholder = 1;
		int temp=-1;
		boolean is_maximum_digits = false;
		
		ArrayList<Integer> bucket[] = new ArrayList[radix];
		for(int i=0;i<bucket.length;i++)
		{
			bucket[i] = new ArrayList<>();
		}
		
		while(!is_maximum_digits)
		{
			for(Integer input_number:nums)
			{
				is_maximum_digits = true;
				temp = input_number/placeholder;
				bucket[temp % radix].add(input_number);
				if(is_maximum_digits && temp>0)
				{
					is_maximum_digits = false;
				}
					
			}
			int j=0;
			
			for(int k=0; k<radix;k++)
			{
				for(Integer i:bucket[k])
				{
					nums[j] = i;
					j++;
				}
				bucket[k].clear();
			}
			placeholder = placeholder * radix;
		}
		Arrays.stream(nums).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input_array = new int[]{100, 54, 355, 102, 43, 10, 287, 005};
		
		Test1 t1 = new Test1();
		t1.radixSort(input_array);
	}

}
