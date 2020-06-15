import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
    public static class TreeNode{
        TreeNode(int val){
            this.val=val;
        }
        TreeNode left = null;
        TreeNode right = null;
        int val;
    }
    public static void dfs(TreeNode tree){
        if(tree==null)
            return;
        System.out.println(tree.val);
        dfs(tree.left);
        dfs(tree.right);
    }
    public static void bfs(TreeNode tree){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            System.out.println(t.val);
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
    }
    public static void zigzag(TreeNode tree){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(tree);
        boolean flag=true;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(flag == true){
                while(!s1.isEmpty()){
                    TreeNode t = s1.pop();
                    System.out.println(t.val);
                    if(t.left!=null){
                        s2.push(t.left);
                    }
                    if(t.right!=null){
                        s2.push(t.right);
                    }
                }
                flag=false;
            }
            else{
                while(!s2.isEmpty()){
                    TreeNode t = s2.pop();
                    System.out.println(t.val);
                    if(t.right!=null){
                        s1.push(t.right);
                    }
                    if(t.left!=null) {
                        s1.push(t.left);
                    }
                }
                flag=true;
            }
        }
    }
    public static boolean identicaltrees(TreeNode tree, TreeNode tree1){
        return helperidentical(tree, tree1);
    }
    public static boolean helperidentical(TreeNode tree, TreeNode tree1){
        if(tree==null && tree1==null)
            return true;
        if(tree==null || tree1==null)
            return false;
        if(tree.val==tree1.val){
            return helperidentical(tree.left, tree1.left) && helperidentical(tree.right, tree1.right);
        }
        else
            return false;
    }
    public static void reverselevelorder(TreeNode tree){
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(tree);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            s.push(t.val);
            if(t.right!=null){
                q.add(t.right);
            }
            if(t.left!=null){
                q.add(t.left);
            }
        }
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    static int maxlevel = 0;
    public static void leftviewhelper(TreeNode tree, int level){
        if(tree==null)
            return;
        if(maxlevel<level){
            System.out.println(tree.val);
            maxlevel=level;
        }
        leftviewhelper(tree.left, level+1);
        leftviewhelper(tree.right, level+1);
    }
    public static void leftview(TreeNode tree){
      leftviewhelper(tree, 1);
    }
    public static void rightviewhelper(TreeNode tree, int level){
        if(tree==null)
            return;
        if(maxlevel<level){
            System.out.println(tree.val);
            maxlevel=level;
        }
        rightviewhelper(tree.right, level+1);
        rightviewhelper(tree.left, level+1);

    }
    public static void rightview(TreeNode tree){
        rightviewhelper(tree, 1);
    }
    public static void bottomview(TreeNode tree){
        if(tree==null)
            return;
        if(tree.left==null || tree.right==null)
            System.out.println(tree.val);
        bottomview(tree.left);
        bottomview(tree.right);
    }
    public static void main(String args[]){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        tree.left.left.left = new TreeNode(8);
        tree.left.left.right = new TreeNode(9);
        tree.left.right.left = new TreeNode(10);
        tree.left.right.right = new TreeNode(11);
        tree.right.left.left = new TreeNode(12);
        tree.right.left.right = new TreeNode(13);
        tree.right.right.left = new TreeNode(14);
        tree.right.right.right = new TreeNode(15);
//        TreeNode tree1 = new TreeNode(1);
//        tree1.left = new TreeNode(2);
//        tree1.right = new TreeNode(3);
//        tree1.left.left = new TreeNode(4);
//        tree1.left.right = new TreeNode(5);
//        tree1.right.left = new TreeNode(6);
//        tree1.right.right = new TreeNode(7);
//        tree1.left.left.left = new TreeNode(8);
//        tree1.left.left.right = new TreeNode(9);
//        tree1.left.right.left = new TreeNode(10);
//        tree1.left.right.right = new TreeNode(11);
//        tree1.right.left.left = new TreeNode(12);
//        tree1.right.left.right = new TreeNode(13);
//        tree1.right.right.left = new TreeNode(14);
//        tree1.right.right.right = new TreeNode(15);
//        System.out.println(identicaltrees(tree,tree1));
//        dfs(tree);
//        bfs(tree);
//        zigzag(tree);
//        reverselevelorder(tree);
//        leftview(tree);
//        rightview(tree);
        bottomview(tree);
    }
}
