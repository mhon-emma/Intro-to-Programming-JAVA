/*
 * Derived from WordTool with some minor changes so that it can accommodate 
 * spaces.  Generates a set of passengers given a properly structured data file
 * */

import java.io.*;
import java.util.*;

public class PassengerManifest {

    // Gets a manifest (list) consisting of Passengers given a filename
    // @return an array of Passengers in the order that they were read
    public static Passenger[] getManifest ()
    {
         
	      return getManifest ("manifest");
    }

    // Gets a manifest (list) consisting of Passengers given a filename
    // @param fileName the file to read
    // @return an array of Passengers in the order that they were read
    public static Passenger[] getManifest (String fileName)
    {
	      return readManifest (fileName);
    }

    // Reads a manifest file consisting of checkin position and name pairs into
    // a list of Passengers given a filename
    // @param fileName the file to read
    // @return an array of Passengers in the order that they were read
    static Passenger[] readManifest (String fileName)
    {
	      Passenger[] data = null;
	      try {
	         LinkedList<String> stringList = new LinkedList<String>();

	         Scanner scanner = new Scanner (new FileReader (fileName));
	         scanner.useDelimiter("\n");
	         while (scanner.hasNext()) {
		      String s = scanner.next();
		      stringList.addLast (s);
	    }

	         data = new Passenger[stringList.size()];
	         Iterator<String> iter = stringList.iterator();
	         int i = 0;
	    while (iter.hasNext()) {
            String record[] = iter.next().split(":");
            data[i++] = new Passenger(record[1],Integer.parseInt(record[0]));
	    }

	    return data;
	}
	catch (IOException e) {
	    System.out.println (e);
	    System.exit (0);
	    return null;
	}
    }
}
