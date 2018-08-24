package geTest;

import java.util.Scanner;


public class Tree {
	
	public static class Node {

		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	/*
	 * Method to insert a node into tree.
	 * 
	 * */
	private static Node insertNode(Node root, int data){
		/* When first node is inserted. */
		if(root == null){
			Node node = new Node(data);
			node.left = null;
			node.right = null;			
			return node;
		}else{
			Node temp = root;
			Node posNode = null;
			while(temp != null){
				if(data<=temp.data){
					posNode = temp;
					temp = temp.left;
				}else{
					posNode = temp;
					temp = temp.right;
				}
			}
			if(posNode.data >= data){
				Node node = new Node(data);
				node.left = null;
				node.right = null;
				posNode.left = node;
			}else if(posNode.data < data){
				Node node = new Node(data);
				node.left = null;
				node.right = null;
				posNode.right = node;
			}
		return root;
		}
	}

	/* Main Method*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements in tree");
		int size = scan.nextInt();
		int i = 0;
		System.out.println("Enter the elements of tree");
		Node root = null;
		while(i<size){
		int num = scan.nextInt();
		 root = insertNode(root, num);
		 i++;
		}
		System.out.println("Enter element to search");
		int searchElement = 0;
		while(scan.hasNext()){
			if(scan.hasNextInt())
				searchElement = scan.nextInt();
			else
				scan.next();
		System.out.println(searchElement+" : "+search(searchElement, root));
		}
	}
	
	/*
		Method to search an element.
	*/
	private static boolean search(int data, Node root){
		if(root == null){
			return false;
		}
		else if(data == root.data){
			return true;
		}else{
			Node temp = root;
			while(temp != null){
				if(data < temp.data){
					return search(data, temp.left);
				}else{
					return search(data, temp.right);
				}
			}			
			return false;
		}
	}
}
