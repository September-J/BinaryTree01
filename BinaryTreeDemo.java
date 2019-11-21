package Tree.BinaryTree01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
public class BinaryTreeDemo {


    //对称二叉树
    //判断一棵树是否对称，可以看看左右子树是否是镜像关系
    public boolean isSymmetry (TreeNode root){
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode t1,TreeNode t2){
        //1.如果t1 t2为空则算镜像
        if(t1 == null && t2 == null){
            return true;
        }
        //2.如果两个树，一个空一个非空则返回false
        if(t1 == null || t2 == null){
            return false;
        }
        //3.两个都非空
        //a）比较根结点是否相同
        //b）递归比较子树，t1.left和t2.right;t1.right和t2.letf
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    //求一个二叉树的镜像:遍历+交换每个结点的左右子树
    public TreeNode makeMirror(TreeNode root){
        if(root == null){
            return null;
        }
        //交换就是此处的“访问”操作
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        makeMirror(root.left);
        makeMirror(root.right);
        return root;
    }
    //给定两个树，找最近公共祖先
    //最关键的点：从最近公共祖先开始去找两个结点，一定都能找到，但一定不在同一个子树中
    private TreeNode lca = null;//保存最终结果
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        //1.借助一个辅助函数，在root中递归查找p和q
        if (root == null) {
            return null;
        }
        findNode(root,p,q);//辅助函数
        return lca;
    }
    private boolean findNode(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;//2.递归在左子树中查找
        int right = findNode(root.right,p,q)?1:0;//3.递归在右子树查找
        int mid = (root == p || root == q)?1:0;//3.对比根结点
        if(left + right + mid >= 2){
            //3.如果这个三个位置，有两个地方找到了，说明这个当前结点就是要找的最近公共祖先
            lca = root;
        }
        return (left + right + mid) > 0;
    }



}
