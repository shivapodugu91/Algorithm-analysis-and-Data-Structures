import java.util.Scanner;

class Node 
{
    int data;
    Node next;
    Node insertElements(Node head,int size)
    {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Enter the numbers: ");
		Node current = new Node();
		Node n;
		for(int i=0;i<size;i++)
		{
			n = new Node();
			if(i==0)
			{
				head.data = sc.nextInt();
				head.next = null;	
			}
			else if(i==1)
			{
				n = new Node();
				head.next=n;
				n.data = sc.nextInt();
				n.next=null;
				current=n;
			}
			else if(i==size-1)
			{
				n = new Node();
				n.data = sc.nextInt();
				n.next=null;
				current.next=n;
			}
			else 
			{
				n = new Node();
				n.data = sc.nextInt();
				current.next=n;
				n.next=null;
				current=n;
			}
		}
		System.out.println("\n\nThe linked list before sorting:");
		return head;
    }
 
    void display(Node h)
    {
    	while(h!=null)
    	{
    		System.out.println(h.data);
    		h = h.next;
    	}
    }
    
    Node sortElements(Node head,int size)
    {
    	Node beforeLarge=null,large = head,t=head;
    	Node tmp_swap= new Node();
    	Node tmp_head_prev = null;
    	Node tmp_head =head;
    	//large is used to get the largest element in the remaining elements
    	//before large is used to track the node before the large node
    	//t node is used to iterate through the linked list and used to compare with large to find largest
    	//tmp_swap is used to copy the large nodes next address
    	//tmp_head is used to compare and swap the ith element in the ith iteration
    	//tmp_head_prev is the node before tmp_head to maintain the connection of nodes
    	for(int i=0;i<size-1;i++)
    	{
    		// finding the largest element and the node before the largest element
    		for(int j=i+1;j<size;j++)
    		{
                if(t.next.data>=large.data)
                    {
    					beforeLarge=t;
	    				large=t.next;
	    			}
    				if(j<size-1)
    					t=t.next;
    		}
    		
    		//swapping links for the 1st or 0th iteration
    		if(i==0)
    		{
    			if(beforeLarge!=null)
    			{
    				tmp_swap.next=large.next;
    				if(head==beforeLarge)
    				{
    					head.next=tmp_swap.next;
    					large.next=head;
    				}
    				else
    				{
    					large.next=tmp_head.next;
    					head.next=tmp_swap.next;
    					beforeLarge.next=head;
    				}
    				head=large;
    			}
    			tmp_head = head.next;
    			tmp_head_prev=head;
    			t=tmp_head;
    			large=tmp_head;
    		}
    		else
    			{
    			  	tmp_swap.next=large.next;
    				if(tmp_head!=large)
    				{
    					if(tmp_head==beforeLarge)
        				{
        					tmp_head.next=tmp_swap.next;
        					large.next=tmp_head;
        					tmp_head_prev.next=large;
        					tmp_head=large;
        				}
        				else
        				{
                            large.next=tmp_head.next;
                            tmp_head.next=tmp_swap.next;
                            beforeLarge.next=tmp_head;
                            tmp_head_prev.next=large;
                            tmp_head=large;
        				}
    				}
    				tmp_head_prev=tmp_head;
    				tmp_head = tmp_head.next;
    				t=tmp_head;
    				large=tmp_head;
    			}
        }
    	return head;
    }
}

public class sortingByRelinking {
	public static void main(String[] args)
	{
		Node newLinkedList = new Node();
		System.out.println("Enter size:");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		newLinkedList.display(newLinkedList.insertElements(newLinkedList,size));
		System.out.println("\n\nThe linked list after sorting using selection sort by re-linking nodes:");
		newLinkedList.display(newLinkedList.sortElements(newLinkedList,size));
	}
}
