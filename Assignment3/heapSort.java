public class heapSort {
	static int[] arr=new int[]{83,86,79,42,55,97,93,90,84,21,73,80,1,20,31,43};
	static int size=arr.length;
    public static void display()
    {
    	String DigitAlignFormat = "|%3d ";
    	String StringAlignFormat = "+%3s";

    	for(int i=0;i<size;i++)
    		System.out.format(StringAlignFormat,"----");
    	System.out.format("%n");
    	
    	for (int i = 0; i < size; i++) 
    	    System.out.format(DigitAlignFormat, i);
    	System.out.format("%n");
    	
    	for(int i=0;i<size;i++)
    		System.out.format(StringAlignFormat,"----");
    	System.out.format("%n");
    	
    	for (int i = 0; i < size; i++) 
    	    System.out.format(DigitAlignFormat, arr[i]);
    	System.out.println();

    	for(int i=0;i<size;i++)
    		System.out.format(StringAlignFormat,"----");
    	
    	System.out.println("\n\n");
    }
	public static void swap(int pos,int child)
	{
		int tmp=arr[child];
		arr[child]=arr[pos];
		arr[pos]=tmp;
	}
	
	public static int max(int c1,int c2)
	{
			if(arr[c1]>arr[c2])
				return c1;
			else
				return c2;
	}
	
    public static void percolateDown(int pos, int siz)
    {
    	int c1,c2;
    	c1=pos*2;
		c2=c1+1;
		if(c1>siz-1 && c2>siz-1)
			return;
		if(c2<=arr[0])
		{
			int max_child=max(c1,c2);
			if(arr[pos]<arr[max_child])
			{
				swap(pos,max_child);
				percolateDown(max_child,siz);
			}
		}
		else
		{
			if(arr[pos]<arr[c1])
				swap(pos,c1);
		}
    }

    
	public static void heapify()
	{
		//pointer set to pos
		int pos=size/2;	
		while(pos>=0)
		{
			percolateDown(pos,size);
			pos--;
		}
		System.out.println("Heapified Array with Index: ");
		display();
	}

	//Heap sort
	public static void heap_sort()
	{
		int tempSize=size-1;
		while(tempSize>0)
		{
			swap(0,tempSize);
			tempSize--;
			percolateDown(0,tempSize);
		}
		System.out.println("Sorted Array with Index: ");
		display();
	}
	public static void main(String[] args) 
	{
		System.out.println("\n\nInitial Unsorted Array with Index: ");
		display();
		heapify();
		heap_sort();
	}

}
