    void mergeSortIteration(int stage_idx, int[] nums)
    {
    	//Implementation Here...
    	System.out.println("Stage Index: "+ stage_idx);
    	int group_size = 2^stage_idx-1;
    	System.out.println("Group Size: "+ group_size);
    	int array_length = nums.length/group_size;
    	System.out.println("Array Length: "+ array_length+"\n");
    	
    	
    		int temp[][] = new int[group_size][];
    		
    		int temp1[] = new int[array_length];
    		int temp2[] = new int[nums.length];
    		
    		int temp3[] = new int[array_length];
    		int temp4[] = new int[nums.length];
    		int temp5[] = new int[array_length];
    		int temp6[] = new int[nums.length];
    		
    		
    		temp[0] = temp1;
    		temp[1] = temp2;
    		System.out.println();
    		for(int k=0;k<array_length;k++)
    		{
    			temp1[k] = nums[k];
    			System.out.print(temp1[k]+" ");
    		}
    		System.out.println();
    		for(int l=temp1.length;l<temp1.length+array_length;l++)
    		{
    			temp2[l] = nums[l];
    			System.out.print(temp2[l]+" ");
    		}
    		
    		System.out.println();
    	}
