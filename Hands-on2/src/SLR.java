// CID - Challenge 1.
// Luia Donaldo García Castro 218294494
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.util.HashMap;

public class SLR extends Agent{


    protected HashMap <Integer, Integer> s = new HashMap <Integer, Integer> (); // Sales
    protected HashMap <Integer, Integer> a = new HashMap <Integer, Integer> (); // Advertising

    /**
     * Data taken from:
     * url: https://www.displayr.com/what-is-linear-regression/
     */
    private void fillDataSet(){
        // Filling Sales by year
        s.put(1, 651);
        s.put(2, 762);
        s.put(3, 856);
        s.put(4, 1064);
        s.put(5, 1190);
        s.put(6, 1298);
        s.put(7, 1421);
        s.put(8, 1440);
        s.put(9, 1518);
        // Filling advertising by Year
        a.put(1, 23);
        a.put(2, 26);
        a.put(3, 30);
        a.put(4, 34);
        a.put(5, 43);
        a.put(6, 48);
        a.put(7, 52);
        a.put(8, 57);
        a.put(9, 58);
    }
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        fillDataSet();
        addBehaviour(new CyclicSLRbehaviur());
    }
    protected void takeDown(){
        // Dismissal message
        System.out.println("Agent "+ getAID().getName() + "terminating.");
    }
    //
    private class CyclicSLRbehaviur extends CyclicBehaviour {
        int i = 0;
        int x;
        int y;
        public void action() {
            if( i < 1000 && i < s.size() ){
                // Regression line: y = b0 + (b1)x + e
                x = a.get(i+1); // advertising
                y = s.get(i+1); // sales
                sd// y hat ???
                System.out.println(i + ": " + x + "," + y);
                i++;
            }else{
                doDelete();d
            }
        }
    }

}




