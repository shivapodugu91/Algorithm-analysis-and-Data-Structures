import java.util.Scanner;

public class tertiarySearch {
	
	// Returns index of se if it is present in arr, else return -1
    public static int Search(int arr[], int l, int r, int se)
    {
        if (r>=l)
        {
        	int m1=0,m2=0,mid=0;
        	mid=(l+r)/2;
            //m1, m2 divides the array into 3 parts
        	m1=l+(mid-l)/2;
        	m2=r-(r-mid)/2;
        	if(mid==(m1+1) && mid==(m2-1))
        		m1=mid;
        	if(m1<m2)
        	{
        		// If the element is present at the middle itself
        		if (arr[m1] == se)
        			return m1;
        		if (arr[m2] == se)
        			return m2;
                // If element is smaller than mid, then it can only be present in left subarray
        		if (arr[m1] < se)
        			return Search(arr, l, m1, se);
        		// Else the element can only be present in right subarray
        		if(arr[m2] >se)
        		{
        			if(arr.length==r)
        				r=r-1;
        			return Search(arr, m2, r, se);
        		}
        		// Else the element can only be present in mid subarray
            	return Search(arr, m1, m2, se);
        	}
        }
        // We reach here when element is not present in array
        return -1;
    }
 

    public static void main(String args[])
    {
    	Boolean stop=false;
        System.out.print("Enter size:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int arr[] = new int[n];
		System.out.println("\nEnter the elements in decreasing order:");
        for(int i=0;i<n;i++)
        {
        	arr[i]=sc.nextInt();
        }
        do{
        System.out.print("\nEnter the searching element:");
        int se =sc.nextInt();
        int result = tertiarySearch.Search(arr,0,n,se);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
        System.out.print("\nIf you want to search again in the array enter 1 else 0:");
    	int temp=sc.nextInt();
    	if(temp==0)
    	{
    		stop=true;
    		System.out.println("Searching stopped..");
    	}
        }
    	while(stop==false);
    }

}
