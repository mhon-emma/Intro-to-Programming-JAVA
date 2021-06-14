/*-----------------------------------------------------------------------------
author: <Manyung Hon>

This program compares an input consisting of a set of letters with a 
dictionary of words and finds the longest word that can be spelled from the set
of input letters.
------------------------------------------------------------------------------*/
public class Countdown {

    // WordGame scans through the set of words and attempts to find words that
    // can be spelled using the set of letters.  Each letter can only be used
    // once.  If a letter repeats, that letter may be used an additional time
    // for each repetition.
    // @param words the set of words to search
    // @param letters the set of letters to unscramble
    // @return the longest word in the set of words that can be spelled using
    //         letters
    public static String WordGame(String[] words, String letters) 
    {
      String word = "";
        
      //TODO: FILL IN YOUR CODE HERE
        
      int length = 0;
      int biggest = 0;
      
      for(int i = 0; i<words.length; i++)
      {
      
         if(contains(words[i], letters) == true)
         {
             length = words[i].length();
         }
          //find matched word and the length of it to find the longest word later
         if(biggest < length)
         {
            biggest = length;
            word = words[i];
         }
         //If the length of the word matched is longer than the length of last word matched, replace the output to the new matched word. 
      }

    	return word;
    }

    /// This method compares a word with an unordered set of alphas and 
    /// determines whether the word can be spelled from a subset of the letters
    /// @input letters a randomly ordered set of characters
    /// @input word to check if can be spelled by characters in letters
    static boolean contains(String letters, String word) 
    { 
        
        //TODO: FILL IN YOUR CODE HERE
        int[][] original = new int[word.length()][2];
        int[][] compare = new int[letters.length()][2];
        
        if(letters.length() > word.length())
        {
            return false;
        }
        //Since the words have to contain all or parts the letter, the length of the word cannot be longer than the letters
        //Excluding the longer words so we don't waste time scanning the words that definitely don't match. 
        for(int i = 0; i<word.length();i++)
        {
            original[i][0] = (int)word.charAt(i);
            original[i][1] = 1;
        }
        //Create an integer array that contains the int of each letters.
        //The top row is all the letters contained in the the letter string.
        //the bottom row of the array all contains 1, which will then be 0 if the letter is used in the word.
        for(int i = 0; i<letters.length();i++)
        {
            compare[i][0] = (int)letters.charAt(i);
            compare[i][1] = 0;
        }
        //Create an integer array that conains the int of each letters in the word from dictionary. 
        //Put 0 in all the colums in the second row. 
        //the bottom row of the array all contains 0, which will then be 1 if the letter is used.
        for(int j = 0; j<word.length();j++)
        {
            for (int i = 0; i<letters.length();i++)
            {
               if(compare[i][1]==0)
               {
                     if(original[j][0] == compare[i][0])
                     {
                      
                      original[j][1]--;
                      compare[i][1]++;
                      break;
                     }  
               }
            }
        }
        //For each of the letters, compare it with the word with random letters using the number form of letters.
        //If the letter match the letter in the word, the column in the second row of original becomes 0
        //Breaks once the letter is used once so it can't scan for a character in the letter more than once
       for (int i = 0; i<letters.length();i++)
       {
          if(compare[i][1]==0)
          {
            return false;
          }
       }
       //if the new word has letters that aren't in the letters, that means it is not a match with the letters. 
       
       return true;

    }

    // ------------------------------------------------------------------------
    // UnitTests
    // ------------------------------------------------------------------------
    // The entry point which carries out the unit testing and the individual
    // tests are better suited to their own class; however, for simplicity
    // sake they are inside Countdown.

    /// Entry Point.  The main program executes a set of UnitTests on the 
    /// Countdown WordGame method.
    public static void main (String[] argv)
    {
        // Get the dictionary.
        String[] words = WordTool.getDictionary ();
      
      
	if( Test1(words) ) {
	    System.out.println("Test 1 succeeded");
	} else {
	    System.out.println("Test 1 failed");
	}

	if( Test2(words) ) {
	    System.out.println("Test 2 succeeded");
	} else {
	    System.out.println("Test 2 failed");
	}

	if( Test3(words) ) {
	    System.out.println("Test 3 succeeded");
	} else {
	    System.out.println("Test 3 failed");
	}
    }

    /// Unit Test 1
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test1(String[] words) {
        String letters = "ionsomsti";
        String word = WordGame(words, letters);

	if(word.compareTo("omission") == 0) {
	  return true;
	}
	return false;
    }

    /// Unit Test 2
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test2(String[] words) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String word = WordGame(words, letters);

	if(word.compareTo("ambidextrous") == 0) {
	  return true;
	}
	return false;
    }

    /// Unit Test 3
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test3(String[] words) 
    {
        //TODO: FILL IN YOUR CODE HERE
          String letters = "sumaoddetdfxourtrxdddaaabbbbetresbbbedibumas";
          String word = WordGame(words, letters);

	      if(word.compareTo("ambidextrous") == 0) 
         {
	          return true;
	      }
	      return false; 
         //same approach just with more repetitive words to test the function I created.        
    }

    // ------------------------------------------------------------------------
    // Utilities
    // ------------------------------------------------------------------------
    /// This method trims out all characters that are not alphas and then
    /// converts the string to lowercase.
    /// @param s the string to clean
    /// @return the cleaned string 
    public static String clean(String s)
    {
        return s.replaceAll("[^a-zA-Z]","").toLowerCase();
    }
}
