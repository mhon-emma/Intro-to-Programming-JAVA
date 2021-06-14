/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

import java.util.List;
import java.util.ArrayList;

public class BinaryTree {

  private TreeNode root;
  public void insert(String key, int value) {
    //TODO: write this method:
   if(key!= "")
   {
      if(root == null)
      {
         root = new TreeNode(key, value);
         return;
      }    
   }
   
   
   recursiveInsert(root,key, value);
   balanceTree();
  }
  void recursiveInsert(TreeNode node,String key, int value)
  {
      int result = key.compareTo(node.getKey());
      if(key == node.getKey())
      {
         node.setValue(value);
      }
      if(result < 0)
      {
         if(node.getLeftChild() != null)
         {
            recursiveInsert(node.getLeftChild(),key,value);
         }
         else
         {
            TreeNode leftchild = new TreeNode(key,value);
            node.setLeftChild(leftchild);
         }
      }
      else 
      {
         if(node.getRightChild() != null)
         {
            recursiveInsert(node.getRightChild(),key, value);
         }
         else
         {
            TreeNode rightchild = new TreeNode(key,value);
            node.setRightChild(rightchild);
            
         }
      }
   
      
        
   }

  public int search(String key, int[] profile) {
    // TODO: write this method'
    if(root == null)
    {
      return -1;
    }
    TreeNode node = recursiveSearch(root,key,profile);
    
    if(node == null)
    {
      return -1;
    }
    return node.getValue();
  }
  
  public TreeNode recursiveSearch(TreeNode node, String key, int[] profile)
  {
      int result = key.compareTo(node.getKey());
      profile[0]++;
      if(result == 0)
      {
         return node;
      }
      
      if(result<0)
      {
         if(node.getLeftChild() == null)
         {
            return null;
         }
         else
         {
            return recursiveSearch(node.getLeftChild(),key,profile);
         }
      }
      else 
      {
         if(node.getRightChild() == null)
         {
            return null;
         }
         else
         {
            return recursiveSearch(node.getRightChild(),key,profile);
         }
      }
      
  }


  /*This algorithm focuses on correctness
    and is not the most efficient algorithm
    available. Please look up different
    algorithms that solve the balancing problem.
  */
  private void balanceTree() {
    List<TreeNode> nodes = new ArrayList<TreeNode>();
    //Sorts tree from given root
    populateList(root, nodes);
    //Return null if root has no children
    if(nodes.size() == 0) return;

    this.root = balanceTreeHelper(nodes, 0, nodes.size() - 1);
  }

  private TreeNode balanceTreeHelper(List<TreeNode> nodes, int start, int end) {
    int mid = (start + end) / 2;
    TreeNode node = nodes.get(mid);
    if(start == end){
      node.setLeftChild(null);
      node.setRightChild(null);
      return node;
    }
    //Recursively balance tree on left and right children using
    //middle node as root
    if(!(mid - 1 < start)) {
      node.setLeftChild(balanceTreeHelper(nodes, start, mid - 1));
    } else {
      node.setLeftChild(null);
    }

    if(!(mid + 1 > end)) {
      node.setRightChild(balanceTreeHelper(nodes, mid + 1, end));
    } else {
      node.setRightChild(null);
    }

    return node;
  }

  private void populateList(TreeNode node, List<TreeNode> list) {
    if(node == null) return;
    populateList(node.getLeftChild(), list);
    list.add(node);
    populateList(node.getRightChild(), list);
  }
}
