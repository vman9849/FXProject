    	if(stage_idx == 2)
    	{
    		
    		int group_size = 2; //each number is a group
    		int group_num = nums.length/group_size;
    		

    		System.out.println("Before Merge: ");
    		disp(nums);
    		
    		//You need to group these numbers by every two number merging into a group
    		//Do not manually assign it but using a loop with group_num
    		//You can create a temporary array temp[] and after merging save it back to data[]
    		int temp[] = new int[nums.length];
    		for(int g = 0; g < group_num; g += 4)
    		{
    			int g1 = g; //1st group id
    			int g2 = g+2; //2nd group id
    			
    			int i = g1 * group_size;
    			int j = g2 * group_size;
    			
    			int end_i = j - 1;
    			int end_j = (g2 + 2) * group_size - 1;
    			int k; //the index of copy data into temp[]
    			k = g1 * group_size;
    			
    			while(i <= end_i || j <= end_j)
    			{
    				if(i <= end_i && j<= end_j)
    				{
    					if(nums[i] <= nums[j])
    					{
    						temp[k] = nums[i];
    						i++;
    					}
    					else
    					{
    						temp[k] = nums[j];
    						j++;
    					}

    					k++;
    				}
    				else
    				{
    					if(i > end_i)
    					{
    						while(j <= end_j)
    						{
    							temp[k] = nums[j];
    							j++;
    							k++;
    						}
    					}
    					else
    					{
    						while(i <= end_i)
    						{
    							temp[k] = nums[i];
    							i++;
    							k++;
    						}						
    					}
//    					disp(temp);
//    					System.out.println();
    					break;
    				}
    			}
    			
    		}
    		nums = temp;
    		

    		System.out.println("After Merge: ");
    		disp(nums);

    		
    	}
