package tree;

public class morrisTraversal{
    public void inOrder(Node root){
        Node current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data +" ");
                current = current.right;
            }else{
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    current = current.left;
                }else{
                    predecessor.right = null;
                    System.out.print(current.data +" ");
                    current = current.right;
                }
            }
        }
    }
    public void preOrder(Node root){
        Node current = root;
        while(current != null){
            if(current.left == null){
                System.out.print(current.data +" ");
                current = current.right;
            }else{
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null){
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = current;
                    System.out.print(current.data +" ");
                    current = current.left;
                }else{
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }
    public static void main(String args[]) {
        binaryTree bt = new binaryTree();
        Node root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(50, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(7, root);
        root = bt.addNode(9, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(30, root);
        morrisTraversal mt = new morrisTraversal();
        mt.inOrder(root);
        System.out.println();
        mt.preOrder(root);
    }
}
