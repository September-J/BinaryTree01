package Tree;
class Node{
    char val;
    Node left;
    Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
public class BinaryTree {
    private static Node root = null;
    public static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }
    //先序遍历
    public static void prevOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }
    //中序遍历
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    //后序遍历
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }
    //求二叉树结点个数
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    //二叉树叶子结点的个数
    public static int getLeafSize(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return getLeafSize(root.left)+getLeafSize(root.right);
    }
    public static void main(String[] args){
        root = build();
        prevOrder(root);

    }
}
