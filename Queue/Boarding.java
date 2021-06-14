/*-----------------------------------------------------------------------------
author: <Manyung Hon>
------------------------------------------------------------------------------*/

public class Boarding {

    // A list of queues also known as a priority queue
    static Queue queues[] = new Queue[3];
  
    public static void main(String[] args) {
        Passenger manifest[] = PassengerManifest.getManifest();
        print(manifest);
        
        //TODO: Add code here
        queues[0] = new Queue(50);
        queues[1] = new Queue(50);
        queues[2] = new Queue(50);
        
	    

        
    }

    public static boolean checkIn(String name) {
        //TODO: Add code here
        if(queues[0].isFull() == true && queues[1].isFull() == true && queues[2].isFull() == true)
        {
            return false;
        }
        else if(queues[0].isFull() != true && queues[1].isFull() == true && queues[2].isFull() == true)
        {
            queues[0].enqueue(name);
            return true;
        }
        else if(queues[0].isFull() != true && queues[1].isFull() != true && queues[2].isFull() == true)
        {
            queues[1].enqueue(name);
            return true;
        }
        else if(queues[0].isFull() != true && queues[1].isFull() != true && queues[2].isFull() != true)
        {
            queues[2].enqueue(name);
            return true;
        }
        return false;
    }
    public static String boardNext() {
        //TODO: Add code here
        if(queues[0].isEmpty() == true && queues[1].isEmpty() == true && queues[2].isEmpty() == true)
        {
            return null; 
        }
        if(queues[0].isEmpty() == false && queues[1].isEmpty() == true && queues[2].isEmpty() == true)
        {
            return queues[0].dequeue(); 
        }
        if(queues[0].isEmpty() == false && queues[1].isEmpty() == false && queues[2].isEmpty() == true)
        {
            return queues[1].dequeue(); 
        }
        if(queues[0].isEmpty() == false && queues[1].isEmpty() == false && queues[2].isEmpty() == false)
        {
            return queues[2].dequeue(); 
        }
        return null;
}  
    // A helper function to print out a passenger manifest
    // @param manifest a passenger manifest to print
    public static void print(Passenger[] manifest) {
        for(int i = 0; i < manifest.length; i++) {
            System.out.println(i + "::" + manifest[i]);
        } 
    }
}
