package algo;

public class BinaryTree {

	private Node<Integer> root;
	private static int count=0;
	// first we need to find right place where we want to add a new Node
	// starting from root node
	private Node<Integer> addRecursive(Node<Integer> current, int value) {
		if (current == null) {
			return new Node<Integer>(value);

		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);

		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);

		} else
			return current; // value exist
		return current;
	}

	// this will add all nodes starting from root node

	public void add(int value) {
		addRecursive(root, value);
		// System.out.print("root" + String.valueOf(root.value));
	}

	public static void traverseInOrder(Node<Integer> node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print("" + node.value);
			traverseInOrder(node.right);
		}

	}
	
	//using a queue data structure is same as recursive function likte this
		public static void printGivenLevel(Node<Integer> root, int level)
		{
		    if (root == null)
		        return;
		    if (level == 1)
		        System.out.print(root.value + ",");
		    else if (level > 1)
		    {
		        printGivenLevel(root.left, level-1);
		        printGivenLevel(root.right, level-1);
		    }
		}
		
	

	/*public static void getLevel(BinaryTree tree, int level) {
		
		
		
		if( tree.root!=null) {
			
			tree.root = tree.root.left;
			
			count++;
			if(count==level) {
				//now we need to print out this node and this node's parents right child
			printAtGivenLevel(tree.root);
				return;
			}
			if(tree.root==null) {
				System.out.println("no such level");
				return;
				
			}
			getLevel(tree,level);
			
		}*/
		
		
	
			
		

	

	public void traverseLevel(Node<Integer> node) {
		count++;
		if (node == root) {
			System.out.println("" + node.value);
			count=0;
			
		}
		if (node.left != null ) {
			System.out.print("" + node.left.value);
			
		}
		if (node.right != null) {
			System.out.print("" + node.right.value);

		}

		if (node.left != null) {
			traverseLevel(node.left);
		}
		if (node.right != null) {
			traverseLevel(node.right);
		}
		System.out.println("level"+String.valueOf(count));
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node<Integer>(6);

		bt.add(4);
		bt.add(8);
		bt.add(3);
		bt.add(5);
		bt.add(7);
		bt.add(9);
		bt.add(1);
		bt.add(5);
		bt.add(10);

		// bt.traverseInOrder(bt.root);
		printGivenLevel(bt.root,4);
		//bt.traverseLevel(bt.root);
		
		//getLevel(bt,3);
	}

}
