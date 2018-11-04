package desire.morse;

/**The external Tree Node for Linked Trees
 * @author desir
 * @param <T> type parameter
 *
 */
public class TreeNode<T> {

    private TreeNode left;
    private TreeNode right;
    private T data;//key value

    /** Create a new TreeNode with left and right child set to null and data set to the dataNode
     * @param data
     */
    public TreeNode(T dataNode) {
        super();
        this.data = dataNode;
    }

    /**  used for making deep copies
     * @param data
     */
    public TreeNode(TreeNode<T> node) {
        super();
        data = node.data;
        left = node.left;
        right = node.right;
    }

    /** return the right child reference	 *
     * @return the reference of the right child
     */
    public TreeNode getLeft() {
        return this.left;
    }

    /** Set the left child reference
     * @param left the left child reference
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /** return the right child reference	 *
     * @return the reference of the right child
     */
    public TreeNode getRight() {
        return right;
    }

    /** Set the right child reference
     * @param right the right child reference
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /** Return the data within this TreeNode
     * @return the data within the treenode
     */
    public T getData()
    {
        return this.data;
    }

    /**
     * Set the node data to the value
     * @return
     */
    public void setData(T data)
    {
        this.data = data;
    }

}
