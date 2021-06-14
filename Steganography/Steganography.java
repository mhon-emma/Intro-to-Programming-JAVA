/*-----------------------------------------------------------------------------
author: <Manyung Hon>

This class encapsulates the logic necessary to perform simple steganography 
cyphering.
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class Steganography {

    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// Performs a deep copy of the input pixels and returns the copy
    /// @param px the pixels from an image to copy
    /// @return the deep copy of the pixels that were copied
    public static int[][][] copy(int[][][] px) {
        //TODO: IMPLEMENT
        int[][][] newpx = new int[px.length][px[0].length][px[0][0].length];
        for(int i=0; i<px.length; i++)
        {
         for(int j=0; j<px[0].length; j++)
         {
            for(int k =0; k<px[0][0].length;k++)
            {
               newpx[i][j][k] = px[i][j][k];
            }
         }
        }
        return newpx;
    }
    //------------------------------------------------------------------------- 
    /// Computes the error in the individual color channels (RGB only) between 
    /// a pixel in the key image and a pixel in the cypher image.
    /// @param keyPixel An array containing ARGB values that represents a pixel
    ///        in the key image    
    /// @param cypherPixel An array containing ARGB values that represents a 
    ///        pixel in the cypher image
    /// @return An array containing the error (positive values only) between 
    ///         the RGB channels of the input pixels. 
    public static int[] colorError( int[] keyPixel, int[] cypherPixel ) {
         
        //TODO: IMPLEMENT
        int[] color = new int[cypherPixel.length-1];
        for(int i = 0; i<cypherPixel.length-1; i++)
        {
            int sub = Math.abs(cypherPixel[i]-keyPixel[i]);
            color[i] = sub;
            //System.out.println(sub);
        }
    return color;   
    }

    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is represented using the same value in each
    /// cell of the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError( int chpos ) {
        //TODO: IMPLEMENT
        int[] position = new int[3];
        for(int i = 0; i<3;i++)
        {
            position[i] = chpos+1;
            //System.out.println(position[i]);
        } 
        return position;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error uniform
    /// represented in all cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition( int[] error ) {
        //TODO: IMPLEMENT
        int position=error[1]-1;
        return position;
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input pxKey the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt(String s, int[][][] pxKey) {
        //TODO: IMPLEMENT
//         for(int i = 0; i<s.length(); i++)
//         {
//            if((int) s.charAt(i) < 97 || (int) s.charAt(i) >122 )
//            {
//             return null;
//            }
//         }
        
        int[][][] newcopy = copy(pxKey);
        int[] position = new int[s.length()];
        int counter = 0;
        for(int i = 0;i<newcopy.length; i++)
        {
            for(int j = 0; j<newcopy[i].length;j++)
            {
            
               if(i%10 ==0)
               {
                  if(j%10 ==0)
                  {
		                if(counter<s.length())
                      {
                             position= positionToError((int) s.charAt(counter));
                             //System.out.println(position[0]);

                         for(int k =0; k<3; k++)
                         {
                            newcopy[i][j][k+1] = newcopy[i][j][k+1] - position[k];
                            
                         }

                          
                      }
                      counter ++;  
                  }
               }
            }
        }
        
        
        
        
        
     
        return newcopy;
    }

    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input pxCypher the encrypted image containing the message
    /// @input pxKey the key image that was used for the encryption
    /// @return the decrypted string of characters
    public static String decrypt(int[][][] pxCypher, int[][][] pxKey) {
        //TODO: IMPLEMENT
         String word = "";
        for(int i = 0; i<pxCypher.length ; i++)
        {
             for(int j=0; j<pxCypher[i].length ; j++)
             {
                      if((j%10==0 && i%10==0)|| (i==0||j==0))
                      {
                         int letter = 0;
                         letter = Math.abs(errorToPosition(pxKey[i][j]) - errorToPosition(pxCypher[i][j])-1); 
                         if(letter >=65 && letter<=122)
                         {
                           word = word + Character.toString((char)letter); 
                          // System.out.println(word);
                         }   
                      }  
             }
       }
       
        return word;    
        }
	
    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is spread across each cell in the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError2( int chpos ) {
        //TODO: IMPLEMENT
        int[]copy = new int[3];
        int copychpos = chpos+1;
        
        for(int i = 0; i<3; i++)
        {
            copy [i]= copychpos/3;
        }
        
        if(copychpos%3 ==1)
        {
            copy[0]++;
        }      
        else if(copychpos%3 == 2)
        {
            copy[0]++;
            copy[1]++;
        }
             
      
        return copy;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error spread
    /// across different cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition2( int[] error ) {
        int total = 0;
        int[] copy = new int[3];
        // for(int i = 0; i<error.length; i++)
//         {
//         System.out.print(error[i]);
//         }
//         System.out.println();
        
        
        copy = error;
        for(int i=0; i<3; i++)
        {
          total = total + copy[i];
          
        }
        total = total -1;
        
        //TODO: IMPLEMENT
        
	return total;
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input pxKey the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt2(String s, int[][][] pxKey) {
        //TODO: IMPLEMENT
        int[][][] newcopy = copy(pxKey);
        int[] position = new int[s.length()];
        int counter = 0;
        for(int i = 0;i<newcopy.length; i++)
        {
            for(int j = 0; j<newcopy[i].length;j++)
            {
            
               if(i%10 ==0)
               {
                  if(j%10 ==0)
                  {
		                if(counter<s.length())
                      {
                             position= positionToError2((int) s.charAt(counter));
                             //System.out.println(position[0]);

                         for(int k =0; k<3; k++)
                         {
                         
                            newcopy[i][j][k+1] = newcopy[i][j][k+1] + position[k];
                         }
                         counter++; 
                      }   
                  }
               }
            }
        }
        return newcopy;
    }

    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input pxCypher the encrypted image containing the message
    /// @input pxKey the key image that was used for the encryption
    /// @return the decrypted string of characters
    public static String decrypt2(int[][][] pxCypher, int[][][] pxKey) {
      String word = "";
      int[] pxkey = new int [3];
      int[] pxcypher = new int [3];

        for(int i = 0; i<pxCypher.length ; i++)
        {
             for(int j=0; j<pxCypher[i].length ; j++)
             {
                      if((j%10==0 && i%10==0)|| (i==0||j==0))
                      {
                        for(int k=0; k<3; k++)
                        {
                         pxkey[k] = pxKey [i][j][k+1];
                         pxcypher[k] = pxCypher[i][j][k+1];

                         }   
                                                 
                         int letter = 0;
                         letter = Math.abs(errorToPosition2(pxkey) - errorToPosition2(pxcypher)+1);

                         if(letter >=65 && letter<=122)
                         {
                           word = word + Character.toString((char)letter); 
                         }
                      }  
             }
       }
       
        return word;
        

    }
}
