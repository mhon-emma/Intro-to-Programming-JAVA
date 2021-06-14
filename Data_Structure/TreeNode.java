/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class TreeNode {

  private final String key;
  private int value;
  private TreeNode leftChild, rightChild;

  public TreeNode(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(TreeNode leftChild) {
    this.leftChild = leftChild;
  }

  public TreeNode getRightChild() {
    return rightChild;
  }

  public void setRightChild(TreeNode rightChild) {
    this.rightChild = rightChild;
  }
}
