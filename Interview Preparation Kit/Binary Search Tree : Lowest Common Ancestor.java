

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.

        while(root != null){
            if(root.data > Math.max(v1, v2)){
                root = root.left;
            }
            else if(root.data < Math.min(v1, v2)){
                root = root.right;
            }
            else{
                break;
            }
        }
        
        return root;
    }

