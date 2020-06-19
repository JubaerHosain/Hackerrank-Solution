

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

    void decode(String string, Node root) {
        char s[] = string.toCharArray();
        Node base = root;

        for(int i = 0; i < s.length; i++){
            if(s[i] == '0'){
                base = base.left;
            }
            else{
                base = base.right;
            }

            if(base.left == null && base.right == null){
                System.out.print(base.data);
                base = root;
            }
        }

    }

