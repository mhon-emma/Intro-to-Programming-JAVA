/*-----------------------------------------------------------------------------
author: <Manyung Hon>

This class encapsulates the logic necessary to perform simple steganography 
cyphering.
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.text.*;

public class SocialNet {
    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// A referential copy (shallow copy of each row) and not an element-wise 
    /// copy (deep copy).  We are sorting elements with respect to the original
    /// data rather than generating a new set of data.
    /// @param posts data containing the rows to reference
    /// @return the shallow copy of rows
    static int[] profile2 = new int[3];
    public static int[][] createView(int[][] posts) {
        // TODO : Implement Here
        int[][]view = new int[posts.length][posts[0].length];
        for(int i = 0; i<posts.length; i++)
        {
            for(int j = 0; j<posts[0].length; j++)
            {
               view[i][j] = posts[i][j];
            }
        }
        return view;
    }
 
    //------------------------------------------------------------------------- 
    /// Compute the differential between "ups" (at index 1) and "downs" 
    /// (at index 2). The differential is not maintained in the data but is a 
    /// virtual field derived by the calculation performed here
    public static int differential(int[] post) {
        // TODO : Implement Here
        int sum= 0;
        sum = post[1] - post[2];
        return sum;
    }

    //------------------------------------------------------------------------- 
    /// Performs a comparison between two posts that is equivalent to a less
    /// than operation so that a sort can use this function to order posts.
    /// The less than criteria is an evaluation between the differentials of
    /// two posts.
    /// @param post1 a post record that is used as the "left" operand for a
    ///        less than comparison 
    /// @param post2 a post record that is used as the "right" operand for a
    ///        less than comparison 
    /// @return returns true if the computed differential for post1 is less than
    ///         the computed differential for post2; otherwise, returns false 
    ///         (false implies that differential for post1 is greater than or
    ///         equal to post2)
    public static boolean lessThan(int[] post1, int[] post2) {
        // TODO : Implement Here
        if(differential(post1)<differential(post2))
        {
            return true;
        }
        return false;
    }
    //------------------------------------------------------------------------- 
    /// Swaps references to posts.  Note that this is a "shallow" swap and not 
    /// a "deep" swap
    /// @param view A shallow copy of a set of posts 
    /// @param i the index of the first reference to swap
    /// @param j the index of the second reference to swap
    public static void swapPosts(int[][] view, int i, int j) {
        
        int[] temp;
        temp = view[j];
        view[j] = view[i];
        view[i] = temp;
        
        // TODO : Implement Here
    }

    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using one of
    /// the iterative sorts we discussed in class, i.e. selection, bubble, or 
    /// insertion sort
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps
    public static int[] iterativeSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        
        int[] profile = new int[3];
        profile[0] = 3;
 
	for(int i = 0; i<view.length-1;i++)
	{
        	for(int j =0;j<view.length-i-1; j++)
        	{
           		 profile[1]++;

           		 if(!lessThan(view[j+1] ,view[j]))
            		{
               			swapPosts(view,j+1,j);
               			profile[2]++;
                       
            		}
        	}
	}	 
       
	// TODO : Implement Here
	
        return profile;
    }

    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using a recursive
    /// approach, i.e. quicksort.
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps
    public static int[] recursiveSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        
        quickSortRecursive(view, 0, view.length-1);
        profile2[0] = 6;
        
        // TODO : Implement Here
        return profile2;
    }
   static void quickSortRecursive(int[][] data, int left, int right)
   {
      if(left<right)
      {
         int partitionPosition = quickSortPartition(data, left, right);
         quickSortRecursive(data, left, partitionPosition-1);
         quickSortRecursive(data, partitionPosition+1, right);
      }
   }
   static int quickSortPartition(int[][] data, int left, int right)
   {
      if(left == right)
      {
         return left;
      }
      int[] partitionElement = data[right];
      int currentSwapPosition = right;
      for(int i=right-1; i>=left; i--)
      {
         if(lessThan(data[i],partitionElement))
         {
            currentSwapPosition--;
            swapPosts(data, currentSwapPosition, i);
            profile2[2]++;
         }
         profile2[1]++;
      }
      swapPosts(data, currentSwapPosition, right);
      return currentSwapPosition;
}

}