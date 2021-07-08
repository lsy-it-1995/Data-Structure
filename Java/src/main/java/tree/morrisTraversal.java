package tree;

import java.util.ArrayList;
import java.util.List;

public class morrisTraversal{
    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public void inOrderToPrint(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != current && predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }
    private List<Integer> inOrderToList(TreeNode root){
        List<Integer> list = new ArrayList();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode pre = cur.left;
                //keep going right on the left subtree
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                //connect the right most node on leftsubtree to the cur node
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }else{
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
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
        mt.inOrderToPrint(root);
        System.out.println();
        mt.preOrder(root);
    }
}
