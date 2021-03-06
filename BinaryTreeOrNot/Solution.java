class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	boolean checkBST(Node root) {
        return checkLimit(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    

    boolean checkLimit(Node root, int minValue, int maxValue) {
        if(root == null) {
            return true;
        }else if(root.data < minValue || root.data >maxValue) {
            return false;
        }else {
            return checkLimit(root.left,minValue,root.data-1) && checkLimit(root.right,root.data+1,maxValue);
        }
    }


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data < root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
    }	
}