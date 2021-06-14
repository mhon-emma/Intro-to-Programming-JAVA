/*
 * This is a data structure to hold passenger data.  It consists of a position
 * indicating when a passenger checked-in and a passenger name  
 * */
public class Passenger {
    public final int position;
    public final String name;

    public Passenger(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public int getNumber()
    {
      return position;
    }
    public String getName()
    {
      return name;
    }
    public String toString() {
        return position + ":" + name;
    }
}
