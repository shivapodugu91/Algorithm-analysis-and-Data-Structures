
class Node 
{
    int key;
    Node left, right;
    int left_height;
    int right_height;
    Node(int d) 
    {
        key = d;
        left_height=0;
        right_height=0;
    }
}

public class AvlTreeInsert
{
	 Node root;
	 int max(int a, int b) 
	 {
	        return (a > b) ? a : b;
	 }
	 void displayNode(Node node)
	 {
		 System.out.println("Node "+node.key+", Left height :"+ node.left_height+", Right height :"+node.right_height+", Balance: "+(node.left_height-node.right_height)); 
	 }
	 
	 Node rightRotate(Node top) 
	 {
	        Node middle = top.left;
	        Node T2 = middle.right;
	        // Perform rotation
	        middle.right = top;
	        top.left = T2;
	        // Update heights
	        if(T2!=null)
	        {
	        	top.left_height=1+ max(T2.left_height,T2.right_height);
	        }
	        else
	        	top.left_height=0;
	        middle.right_height=1+ max(top.left_height,top.right_height);
	        return middle;
	    }
	 
	 Node leftRotate(Node middle) 
	 {
	        Node top = middle.right;
	        Node T2 = top.left;
	        // Perform rotation
	        top.left = middle;
	        middle.right = T2;
	        // Update heights
	        if(T2!=null)
	        {
	        	middle.right_height=1+ max(T2.left_height,T2.right_height);
	        }
	        else
	        	middle.right_height=0;
	        top.left_height=1+ max(middle.left_height,middle.right_height);
	        // Return new root
	        return top;
	    } 
	 
	    Node insert(Node node, int key) 
	    {
	        /* 1.  Perform the normal BST insertion */
	        if (node == null)
	        {
	        	node = new Node(key);
	        	System.out.println("\nNew inserted node: "+node.key);
	        	int balance=node.left_height-node.right_height;
	        	System.out.println("Node "+node.key+", Left height :"+ node.left_height+", Right height :"+node.right_height+", Balance: "+balance);
	            return (node);
	        }
	        if (key < node.key)
	        {
	            node.left = insert(node.left, key);
	            node.left_height++;
	        }
	        else if (key > node.key)
	        {
	            node.right = insert(node.right, key);
	            node.right_height++;
	        }
	        else // Duplicate keys not allowed
	            return node;
	        /* 2. Update height of this ancestor node */
	        if(node.left!=null && node.right!=null)
	        {
	        	node.left_height = 1 + max(node.left.left_height, node.left.right_height);
	        	node.right_height = 1 + max(node.right.left_height, node.right.right_height);
	        }
	        int balance=node.left_height-node.right_height;
	        System.out.println("Node "+node.key+", Left height :"+ node.left_height+", Right height :"+node.right_height+", Balance: "+balance);
	        //balancing tree
	        if(Math.abs(balance)>1)
	        	System.out.println("**** Tree imbalanced at node: "+node.key+" ****");
	        
	        // If this node becomes unbalanced, then there 4 cases Left Left Case
	        if (balance > 1 && key < node.left.key)
	        {
	        	System.out.println("After Left-Left-case operations:");
	        	Node tmp=rightRotate(node);
	        	displayNode(tmp.right);
	            displayNode(tmp);
	        	return tmp;
	        }
	            
	        // Right Right Case
	        if (balance < -1 && key > node.right.key)
	        {
	        	System.out.println("After Right-Right-case operations:");
	        	Node tmp=leftRotate(node);
	        	displayNode(tmp.left);
	            displayNode(tmp);
	        	return tmp;
	        }
	        
	        // Left Right Case
	        if (balance > 1 && key > node.left.key) {
	        	System.out.println("After Left-Right-case operations:");
	            node.left = leftRotate(node.left);
	            Node tmp=rightRotate(node);
	            displayNode(tmp.right);
	            displayNode(tmp);
	            return tmp;
	        }
	 
	        // Right Left Case
	        if (balance < -1 && key < node.right.key) {
	        	System.out.println("After Right-Left-case operations:");
	            node.right = rightRotate(node.right);
	            Node tmp= leftRotate(node);
	            displayNode(tmp.left);
	            displayNode(tmp);
	            return tmp;
	        }
	        return node;
	    }
	    
	    // A utility function to print In-order traversal of the tree.
	    void inOrder(Node node) 
	    {
	        if (node != null) 
	        {    
	            inOrder(node.left);
	            System.out.print(node.key + " ");
	            inOrder(node.right);
	        }
	    }
	    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		AvlTreeInsert tree = new AvlTreeInsert();
	    tree.root = tree.insert(tree.root, 1);
	    tree.root = tree.insert(tree.root, 2);
	    tree.root = tree.insert(tree.root, 3);
	    tree.root = tree.insert(tree.root, 4);
	    tree.root = tree.insert(tree.root, 5);
	    tree.root = tree.insert(tree.root, 6);
	    tree.root = tree.insert(tree.root, 7);
	    tree.root = tree.insert(tree.root, 9);
	    tree.root = tree.insert(tree.root, 8);
	    tree.root = tree.insert(tree.root, 15);
	    tree.root = tree.insert(tree.root, 16);
	    tree.root = tree.insert(tree.root, 12);
	    tree.root = tree.insert(tree.root, 10);
	    tree.root = tree.insert(tree.root, 11);
	    System.out.println("\n\nIn-Order traversal" +" of constructed tree is : ");
	    tree.inOrder(tree.root);
        System.out.println();
	}

}
