package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class Sorting {

    //This variable defines the size of the GUI, it is usually in the range [0.5, 1.5], you adjust it to fit your display
    double size_scale = 0.8;
    
    /************************************************** Implementation Here: **************************************************/
    
    
    /* This function performs an iteration of merge sort by re-arranging the input array "nums" to a different order according to the stage index "stage_idx" 
     * Attention: this function is NOT an action that completely sorts the "nums" but just represents "one round" of the merge procedure during merge sort
     * this function is called by another function "mergeSort()", which iteratively run "mergeSortBalls(int stage_idx, int[] nums)(int stage_idx, int[] nums)" 
     * by inputing different iteration index and nums[]. 
     * 
     * Input Parameters: 
     *         stage_idx - the round index of merge sort. It starts from 1 and ends at 4 since there are 16 numbers to be sorted: stage_idx = 1, 2, 3, 4
     *                     when stage_idx the output should be sorted nums
     *                     
     *              nums - the input array of 16 numbers to be sorted. Actually, nums[16] is both the input and output. After the processing, the output should 
     *                     saved back to nums[16] again.
     *                     
     * Triggered by:    This function is called by "mergeSort()", which is triggered when you hit the "M" key.      
     * 
     * Variables to use:   You really don't need to use any variables in this class other than the two input parameters.
     * 
     * */
    
    void disp(int data[])
	{

//		System.out.println();
		for(int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + ", ");
		}
		System.out.println();
		System.out.println();
	}
    
    
     
    void mergeSort1(int[] nums)
	{
    	
//    	int nums[] = new int[this.numbers.length];
//    	nums = this.numbers;
    	
		int group_size = 1; //each number is a group
		int group_num = nums.length/group_size;
		

		System.out.println("Before Merge: ");
		disp(nums);
		
		//You need to group these numbers by every two number merging into a group
		//Do not manually assign it but using a loop with group_num
		//You can create a temporary array temp[] and after merging save it back to data[]
		int temp[] = Arrays.copyOf(nums, nums.length);
		for(int g = 0; g < group_num; g += 2)
		{
			int g1 = g; //1st group id
			int g2 = g+1; //2nd group id
			
			int i = g1 * group_size;
			int j = g2 * group_size;
			
			int end_i = j - 1;
			int end_j = (g2 + 1) * group_size - 1;
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
					break;
				}
			}
			
		}
		nums = temp;

		System.out.println("After Merge: ");
		disp(nums);
		System.out.println();
//		this.numbers = nums; 
		
//		showBalls(1, numbers);
//		mergeSort2(nums);
    	
	}
	
	void mergeSort2(int[] nums)
	{
		//group_size=2
		
//    	int nums[] = new int[this.numbers.length];
//    	nums = this.numbers;
		
		mergeSort1(nums);
		
		int group_size = 2; //each number is a group
		int group_num = nums.length/group_size;
		

		System.out.println("Before Merge: ");
		disp(nums);
		
		//You need to group these numbers by every two number merging into a group
		//Do not manually assign it but using a loop with group_num
		//You can create a temporary array temp[] and after merging save it back to data[]
		int temp[] = new int[nums.length];
		for(int g = 0; g < group_num; g += 2)
		{
			int g1 = g; //1st group id
			int g2 = g+1; //2nd group id
			
			int i = g1 * group_size;
			int j = g2 * group_size;
			
			int end_i = j - 1;
			int end_j = (g2 + 1) * group_size - 1;
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
//					disp(temp);
//					System.out.println();
					break;
				}
			}
			
		}
		nums = temp;
		

		System.out.println("After Merge: ");
		disp(nums);

//		this.numbers = nums;
		
//		showBalls(2, numbers);
//		mergeSort3(nums);
		
	}
	
	
	void mergeSort3(int[] nums)
	{
		//group_size = 4
//		int nums[] = new int[this.numbers.length];
//		nums = this.numbers;
		
		mergeSort1(nums);
		mergeSort2(nums);
		
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
//					disp(temp);
//					System.out.println();
					break;
				}
			}
			
		}
		nums = temp;
		

		System.out.println("After Merge: ");
		disp(nums);

//		this.numbers = nums;
		
//		showBalls(3, numbers);
//		mergeSort4(nums);
	}
	
	void mergeSort4(int[] nums)
	{
		//group_size = 8
		
		mergeSort1(nums);
		mergeSort2(nums);
		mergeSort3(nums);
	
//		int nums[] = new int[this.numbers.length];
//		nums = this.numbers;
		
		int group_size = 4; //each number is a group
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
//					disp(temp);
//					System.out.println();
					break;
				}
			}
			
		}
		nums = temp;
		

		System.out.println("After Merge: ");
		disp(nums);

//		this.numbers = nums;
				
//		showBalls(4, numbers);
	}
    
    
    void mergeSortIteration(int stage_idx, int[] nums)
    {
    	//Implementation Here...
    	
//    	this.numbers = nums;
    	
    	if(stage_idx == 1)
    	{
    		mergeSort1(nums);
    	}
    	
//    	if(stage_idx == 2)
//    	{	
////    		mergeSort1(nums);
//    		mergeSort2(nums);
//    	}
//    	
//    	if(stage_idx == 3)
//    	{
////    		mergeSort1();
////    		mergeSort2();
//    		mergeSort3(nums);
//    	}
//    	
//    	if(stage_idx == 4)
//    	{
////    		mergeSort1();
////    		mergeSort2();
////    		mergeSort3();
//    		mergeSort4(nums);
//    	}
    }
    
    
    /* This function is similar to the above mergeSortIteration() function that performs one iteration of Radix Sort
     * Though you can use any container to represent bucket. It is suggested to use the provided "MyQueue" to store the numbers drop to different buckets
     * 
     * 
     * Input Parameters: 
     *         stage_idx - the round index of radix sort. It starts from 1 and ends at 2 since there are 16 numbers to be sorted: stage_idx = 1, 2
     *                     when stage_idx the output should be sorted nums
     *                     
     *              nums - the input array of 16 numbers to be sorted. Actually, nums[16] is both the input and output. After the processing, the output should 
     *                     saved back to nums[16] again.
     *                     
     *                     
     * Triggered by:    This function is called by "radixSort()", which is triggered when you hit the "R" key.
     * 
     * Variables to use:   You really don't need to use any variables in this class other than the two input parameters.
     * 
     * 
     * */
    
    void ones()
	{
		int nums[] = new int[this.numbers.length];
		nums = this.numbers;
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
			//adding numbers to bucket
			for(int input_number:nums)
			{
				is_maximum_digits = true;
				temp = input_number/placeholder;
				bucket[temp % radix].add(input_number);
				if(is_maximum_digits && temp>10)
				{
					is_maximum_digits = false;
				}
					
			}
			int j=0;
			
			//used for arranging and storing back to nums - original array
			for(int k=0; k<radix;k++)
			{
				for(int i:bucket[k])
				{
					nums[j] = i;
					j++;
				}
				bucket[k].clear();
			}
			
		}
		Arrays.stream(nums).forEach(System.out::println);
		System.out.println("---------------------------------------------------------------");
		
		this.numbers = nums;
		showBalls(1, numbers);
	}
	
	void tens()
	{
		int nums[] = new int[this.numbers.length];
		nums = this.numbers;
		final int radix = 10;
		int placeholder = 10;
		int temp=-1;
		boolean is_maximum_digits = false;
		
		ArrayList<Integer> bucket[] = new ArrayList[radix];
		for(int i=0;i<bucket.length;i++)
		{
			bucket[i] = new ArrayList<>();
		}
		
		while(!is_maximum_digits)
		{
			//adding numbers to bucket
			for(Integer input_number:nums)
			{
				is_maximum_digits = true;
				temp = input_number/placeholder;
				bucket[temp % radix].add(input_number);
				if(is_maximum_digits && temp>100)
				{
					is_maximum_digits = false;
				}
					
			}
			int j=0;
			
			//used for arranging and storing back to nums - original array
			for(int k=0; k<radix;k++)
			{
				for(Integer i:bucket[k])
				{
					nums[j] = i;
					j++;
				}
				bucket[k].clear();
			}
			
		}
		Arrays.stream(nums).forEach(System.out::println);
		this.numbers = nums;
		
		showBalls(2, numbers);
	}
    
    void radixSortIteration(int stage_idx, int[] nums)
    {
    	//Implementation Here...
    	
//    	System.out.println("Stage Index: "+stage_idx);
    	this.numbers = nums;
    	
    	if(stage_idx == 1)
    	{
    		ones();
    	}
    	
    	if(stage_idx == 2)
    	{
    		ones();
    		tens();
    	}
    	
    }
    
    
    

    /************************************************** End of Implementation **************************************************/
    
    
    /************************************************* Read Only below ****************************************************************/

    /* The entry point for merge sort*/
    void mergeSort()
    {
        gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
        showBalls(0, numbers);
    	int[] merge_array = new int[16];
    	System.arraycopy( numbers, 0, merge_array, 0, numbers.length );
    	
    	
    	for(int idx = 1; idx < 5; idx++)
    	{
        	
    		mergeSortIteration(idx, merge_array);
    		showBalls(idx, merge_array);    		
        	showFrame(idx);
        	showArrow(idx);
        	showStageLabel("Merge ", idx);
    	}
    	
    }
    
    

    /*The entry point for radix sort*/
    void radixSort()
    {
    	gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
    	showBalls(0, numbers);
    	int[] radix_array = new int[16];
    	System.arraycopy( numbers, 0, radix_array, 0, numbers.length );
    	
    	for(int stage_idx = 1; stage_idx < 3; stage_idx++)
    	{
    		radixSortIteration(stage_idx, radix_array);
        	showBalls(stage_idx, radix_array);
        	showFrame(stage_idx);
        	showArrow(stage_idx);
        	showStageLabel("Radix ", stage_idx);
    	}
    }
    
    
    
    private Point2D pt[] = new Point2D[16];
    // private Canvas canvas;
    private GraphicsContext gc;

    private int radius = (int) (50 * size_scale);
    private int radius_center = (int) (25 * size_scale);
    private int canvas_width = (int) (18 * radius); // canvas width
    private int canvas_height =  (int) (3 * radius); // canvas height
    private Vector<Integer> random_sequence = new Vector<Integer>();
    private Vector<Integer> sorted_sequence = new Vector<Integer>();
    private int numbers[] = new int[16]; // the index of ball
	private SimpleDoubleProperty[] pros = new SimpleDoubleProperty[16];
    int m = 0, n = 0;//use for bubble sort
    double motionTime = 0.2;
    SequentialTransition trans = new SequentialTransition();

    //use map to match index and color
    Paint setColor(int i) {
        Map<Integer, Paint> map = new HashMap<Integer, Paint>();
//        Paint[] colorArray = { Color.RED, Color.BLUE, Color.BLACK, Color.rgb(102, 102, 255),
//                Color.BLUEVIOLET, Color.AQUAMARINE, Color.CHOCOLATE,
//                Color.CADETBLUE, Color.CHARTREUSE, Color.DARKMAGENTA,
//                Color.FIREBRICK, Color.HOTPINK, Color.ROSYBROWN, Color.rgb(255, 153, 51),
//                Color.SLATEGRAY, Color.SEAGREEN };
        
        Paint[] colorArray = { Color.rgb(204, 224, 255), Color.rgb(179, 209, 255), Color.rgb(153, 194, 255), Color.rgb(128, 179, 255),
                Color.rgb(102, 163, 255), Color.rgb(77, 148, 255), Color.rgb(51, 133, 255),
                Color.rgb(26, 117, 255), Color.rgb(0, 102, 255), Color.rgb(0, 92, 230),
                Color.rgb(0, 82, 204), Color.rgb(0, 71, 179), Color.rgb(0, 61, 153), Color.rgb(0, 51, 128),
                Color.rgb(0, 41, 102), Color.rgb(0, 20, 51) };
        Paint colors = colorArray[i];
        map.put(i, colors);
        return colors;
    }

    public Sorting(Canvas canvas, GraphicsContext gc) {
        this.gc = gc;
        for (int i = 0; i < 16; i++) {
            pros[i] = new SimpleDoubleProperty(radius * 1.1 * i + (canvas_width / 2 - 8 * radius) + 10 * size_scale);
            pros[i].addListener(new ChangeListener<Number>() {

                @Override
                public void changed(
                        ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue) {
                    showBalls(0, numbers);
                }

            });
        }
    }

    public Sorting() {
    }

    //Re-shuffle the balls into different order
    void reshuffleBalls() {
        random_sequence.clear();
        sorted_sequence.clear();


        gc.clearRect(0, 0, 20 * radius, 10 * radius);//clear the ball part
        
        
        Random rand = new Random();

        for (int i = 0; i < 16; i++) {
            int rand_num = rand.nextInt(16);
            int pass = 0;

            while (pass == 0) {
                pass = 1;
                for (int j = 0; j < random_sequence.size(); j++) {
                    if ((int) random_sequence.get(j) == rand_num) {
                        pass = 0;
                        break;
                    }
                }

                if (pass == 0) {
                    rand_num = rand.nextInt(16);
                }
            }
            random_sequence.addElement(rand_num);
            sorted_sequence.addElement(i);

        }
        for (int i = 0; i < 16; i++) {
            numbers[i] = random_sequence.get(i); // the index of ball
        }
        showBalls(0, numbers);
        m = 0;
        n = 0;
    }
   
    
    
    //show the arrow under balls
    void showTriangle(int i,int j){
        
        pt[i] = new Point2D(pros[i].get(), radius);
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillPolygon(
            new double[]{pt[i].getX()+radius*0.5, pt[i].getX()+radius*0.4, pt[i].getX()+radius*0.6},
            new double[]{pt[i].getY()+radius,pt[i].getY()+radius*1.4,pt[i].getY()+radius*1.4}, 3);
        pt[j] = new Point2D(pros[j].get(), radius);
        gc.setFill(Color.YELLOWGREEN);
        gc.fillPolygon(
            new double[]{pt[j].getX()+radius*0.5, pt[j].getX()+radius*0.4, pt[j].getX()+radius*0.6},
            new double[]{pt[j].getY()+radius,pt[j].getY()+radius*1.4,pt[j].getY()+radius*1.4}, 3);

    }

    void showBalls(int stage_idx, int[] num_array) {
        for (int i = 0; i < 16; i++) {
            
            pt[i] = new Point2D(pros[i].get(), radius * (1.3 + stage_idx * 2)); // point
                                                        // position
            
            
            
            gc.setFill(setColor(num_array[i])); // set the customed color for specific
                                          // index
            gc.setStroke(Color.BLACK);
            gc.fillOval(pt[i].getX(), pt[i].getY() - radius/2, radius, radius);
            gc.setFill(Color.WHITE); // set the customed color for specific
                                     // index
            gc.fillOval(pt[i].getX() + radius/3.7,
                    pt[i].getY() + radius / 3.7  - radius/2, radius_center, radius_center);
            gc.setFill(Color.BLACK);
            Font font = Font.font("verdana", FontWeight.BOLD, radius / 3);
            gc.setFont(font);

            //make numbers can be shown at the center of balls
            if (num_array[i] <= 9)
                gc.fillText(Integer.toString(num_array[i]),
                        pt[i].getX() + radius / 2.5,
                        pt[i].getY() + radius / 1.6 - radius/2);
            else
                gc.fillText(Integer.toString(num_array[i]),
                        pt[i].getX() + radius / 3.5,
                        pt[i].getY() + radius / 1.6 - radius/2);
        }
    }

    
	void swapBalls(int i, int j) {
		 gc.clearRect(0, 0, canvas_width, canvas_height - radius);//clear the ball part
		
		//(1) Draw all the other balls other than i and j 
		//(2) Generate motion between ball i and ball j
		//(3) Draw all the balls after the swap change between the two balls
		
		
	}
	
	void drawBoundary(int i, int j) //j = i + 1
	{
		
	}

    //handler for bubble sort
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

        public void handle(ActionEvent event) {
            System.out.println(m + " " + n);
            if (m >= 15) {
                return;
            }
            Timeline timeline = new Timeline();
            if (numbers[n] > numbers[n + 1]) {
                int temp = numbers[n];
                numbers[n] = numbers[n + 1];
                numbers[n + 1] = temp;
                gc.clearRect(0, radius*2, canvas_width, radius);//clear arrow part

                SimpleDoubleProperty t = pros[n];
                pros[n] = pros[n + 1];
                pros[n + 1] = t;
                timeline.getKeyFrames()
                        .add(new KeyFrame(Duration.seconds(motionTime), handler,
                                new KeyValue(pros[n], pros[n + 1].get()),
                                new KeyValue(pros[n + 1], pros[n].get())));
                System.out.println(n);
                System.out.println(n + 1);
                System.out.println(Arrays.toString(numbers));
                showTriangle(n,n+1);
            } else {
                timeline.getKeyFrames()
                        .add(new KeyFrame(Duration.seconds(0.01), handler));
            }
            timeline.play();
            n++;
            if (n >= 15 - m) {
                n = 0;
                m++;
            }
        }
    };
    
    
    //a simple power function 
    int pow (int a, int b)
    {
        if(b > 0)
        {
        	b--;
        	return a * pow(a, b); 
        }
        else
        {
        	return 1;
        }

    }
  
   /*Draw the arrow for each stage*/
	void showArrow(int idx) {
		Point2D pos = new Point2D(pros[7].get(), radius);
		gc.setFill(Color.GOLD);
		gc.fillPolygon(
				new double[] { pos.getX() + radius * 0.5, pos.getX() + radius * 0.2, pos.getX() + radius * 0.8 },
				new double[] { pos.getY() + radius * (idx * 2 - 0.3), pos.getY() + radius * (2 * idx - 0.8), pos.getY() + radius * (2 * idx - 0.8)}, 3);
	}
  
	
    /*Draw the frame, text, and arrow according to the index*/
    void showFrame(int idx)
    {
    	
    	//Frame's color 
    	gc.setStroke(Color.rgb(20, 20, 20));
    	
    	//Frame's width
    	gc.setLineWidth(2);
    	
    	//Frame's position
    	Point2D start_pos;
    	start_pos = new Point2D(pros[0].get() - radius/4, radius * (0.8 + idx * 2));
    	gc.strokeRoundRect(start_pos.getX(), start_pos.getY(), canvas_width , radius, 20 * size_scale, 20 * size_scale);
    
    	
    	
    	 
    }
    
    /* Draw the stage label for both merge sort and radix sort uses */
    void showStageLabel(String sort_method, int idx)
    {
    	gc.setFill(Color.BLACK);
    	
    	//Calculate label position
    	Point2D start_pos;
    	start_pos = new Point2D(pros[0].get() - radius/4, radius * (0.8 + idx * 2));
    	
    	//Draw Stage Label
        gc.fillText(sort_method + Integer.toString(idx), start_pos.getX() - radius/2, start_pos.getY() - radius/6);
    }
    
    

    
    public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getRadius_center() {
		return radius_center;
	}

	public void setRadius_center(int radius_center) {
		this.radius_center = radius_center;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

}
