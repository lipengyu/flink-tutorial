class BinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
    }

    public static boolean search(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return true;
            } else if (root.val > val) {
                return search(root.left, val);
            } else {
                return search(root.right, val);
            }
        }
        return false;
    }
}