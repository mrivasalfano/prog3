package classes;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft() { return left; }

    public void setLeft(TreeNode left) { this.left = left; }

    public TreeNode getRight() { return right; }

    public boolean esHoja() {
        if (this.getLeft() == null && this.getRight() == null)
            return true;
        else
            return false;
    }

    public void setRight(TreeNode right) { this.right = right; }

    public void setValue(int value) { this.value = value; }

    public int getValue() { return value; }
}
