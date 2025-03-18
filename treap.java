
import java.util.*;

// A Treap Node
class TreapNode
{
	int key, priority;
	TreapNode left, right;
}

class treap
{
	public static TreapNode rightRotate(TreapNode y) 
	{
		System.out.println("rightRotate " + y.key);
		TreapNode x = y.left;
		TreapNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	public static TreapNode leftRotate(TreapNode x) 
	{
		System.out.println("leftRotate " + x.key);

		TreapNode y = x.right;
		TreapNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Return new root
		return y;
	}

	/* Utility function to add a new key */
	public static TreapNode newNode(int key) 
	{
		TreapNode temp = new TreapNode();
		temp.key = key;
		temp.priority = (int)(Math.random() * 100);
		temp.left = temp.right = null;
		return temp;
	}
	
	/* Recursive implementation of insertion in Treap */
	public static TreapNode insertNode(TreapNode root, int key) 
	{
		// If root is null, create a new node and return it
		if (root == null) {
			return newNode(key);
		}

		// If key is smaller than root
		if (key <= root.key) {
			// Insert in left subtree
			root.left = insertNode(root.left, key);

			// Fix Heap property if it is violated
			// It is Max heap. To change to min heap change the condition to less than
			if (root.left.priority > root.priority) {
				root = rightRotate(root);
			}
		} else { // If key is greater
			// Insert in right subtree
			root.right = insertNode(root.right, key);

			// Fix Heap property if it is violated
			// It is Max heap. To change to min heap change the condition to less than
			if (root.right.priority > root.priority) {
				root = leftRotate(root);
			}
		}
		return root;
	}

	/* Recursive implementation of Delete() */
	public static TreapNode deleteNode(TreapNode root, int key) 
	{
		System.out.println("DeleteNode key " + key + " root.key " + root.key);
		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteNode(root.left, key);
		else if (key > root.key)
			root.right = deleteNode(root.right, key);

		// IF KEY IS AT ROOT
		
		// If left is NULL
		else if (root.left == null)
		{
			TreapNode temp = root.right;
			root = temp; // Make right child as root
		}
		// If Right is NULL
		else if (root.right == null)
		{
			TreapNode temp = root.left;
			root = temp; // Make left child as root
		}
		// If key is at root and both left and right are not NULL
		// If priority of right child is greater, perform left rotation at node 
		else if (root.left.priority < root.right.priority)
		{
			root = leftRotate(root);
			root.left = deleteNode(root.left, key);
		}
		else	// If priority of left child is greater, perform right rotation at node
		{
			root = rightRotate(root);
			root.right = deleteNode(root.right, key);
		}
		return root;
	}

	// Search a given key in a given BST
	public static TreapNode search(TreapNode root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// Key is greater than root's key
		if (root.key < key)
			return search(root.right, key);

		// Key is smaller than root's key
		return search(root.left, key);
	}

	static void preorder(TreapNode root)
	{
		if (root != null)
		{
			System.out.println("key: " + root.key + " | priority: " + root.priority);
			preorder(root.left);
			preorder(root.right);
		}
	}

	// 6 
	// 2 4 3 1 7 5
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreapNode root = null;
        for(int a:arr){
            root = insertNode(root,a);
        }
		preorder(root);
		
		/*System.out.println("Enter item to search ");
		int key = sc.nextInt();

		TreapNode result = search(root, key);
		if(result != null)
			System.out.println("Search result "+ result.key + " " + result.priority);
		else
			System.out.println("Key " + key + " not found");
		
		do
		{
			System.out.println("Enter item to delete ");
			key = sc.nextInt();
			root = deleteNode(root, key);
			System.out.println("After delete");
			preorder(root);
		} while(key != -1 && root != null);*/
    }
}


/*

In a treap (a randomized binary search tree with heap properties), 
left rotation and right rotation are performed just like in an 
AVL tree or Red-Black tree to maintain balance while preserving the binary search tree (BST) order. 

These rotations are essential for maintaining heap order based on priorities.

1. Left Rotation 
A left rotation is performed when the right child has a higher priority than the current node.

Steps:
Let y be the right child of x.
Make y the new root, and x its left child.
The left child of y (T2) becomes the right child of x.

Pseudocode:
Node* leftRotate(Node* x) {
    Node* y = x->right;  // Store right child
    x->right = y->left;  // Move y's left subtree to x's right
    y->left = x;         // Move x under y

    return y;  // New root after rotation
}


Before Left Rotation:
     x
      \
       y
      /  
     T2  

After Left Rotation:
       y
      /  
     x
      \
       T2  


2. Right Rotation 
A right rotation is performed when the left child has a higher priority than the current node.

Steps:
Let y be the left child of x.
Make y the new root, and x its right child.
The right child of y (T2) becomes the left child of x.

Pseudocode:
Node* rightRotate(Node* x) {
    Node* y = x->left;  // Store left child
    x->left = y->right; // Move y's right subtree to x's left
    y->right = x;       // Move x under y

    return y;  // New root after rotation
}

Before Right Rotation:
       x
      /
     y
      \
       T2  

After Right Rotation:
     y
      \
       x
      /
     T2  

Where Are Rotations Used in a Treap?
During insertion: If the heap property (max-priority at root) is violated, rotations are applied to restore order.
During deletion: If a node is removed, rotations may be used to balance the tree by promoting the child with higher priority.

what is T1 and T2 here?
In the rotation diagrams and pseudocode, T1 and T2 represent subtrees that get rearranged during the rotation process.