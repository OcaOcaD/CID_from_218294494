// CID - Challenge 1.
// Luia Donaldo García Castro 218294494
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

import java.util.HashMap;

public class SLR extends Agent{

    protected double s[] = new double [9]; // sales
    protected double a[] = new double [9]; // advertising
    /**
     * Data taken from:
     * url: https://www.displayr.com/what-is-linear-regression/
     */
    private void fillDataSet(){
        // Filling Sales by year
        s[0] = 651;
        s[1] = 762;
        s[2] = 856;
        s[3] = 1064;
        s[4] = 1190;
        s[5] = 1298;
        s[6] = 1421;
        s[7] = 1440;
        s[8] = 1518;
        // Filling advertising by Year
        a[0] = 23;
        a[1] = 26;
        a[2] = 30;
        a[3] = 34;
        a[4] = 43;
        a[5] = 48;
        a[6] = 52;
        a[7] = 57;
        a[8] = 58;
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
        int runs;
        double beta0 = 0;
        double beta1 = 0;
        double alpha = 0.003;
        double xi;
        double yi;
        // Error por iteracion
        double error_sum = 0;   //  -2/9 SUM Error
        public void action() {
            // STEP 2: Error cuadratico medio
            // 2.1 Para calcularlo hay que iterar por nuestros datos y obtenerlo
            double ei = 0;
            for (int i = 0; i < s.length; i++){
                yi = s[i];
                xi = a[i];
                // System.out.println(yi + xi);
                ei = (xi)*(yi*(-1*beta0)*(-1*(beta1*(xi))));
                // Pos ya calculalo
                error_sum += ei;
            }
            error_sum = error_sum*-2;
            error_sum = error_sum / s.length;

            if( isSmallEnough( error_sum ) ){
                System.out.println("Found the small error:" + error_sum);
                  doDelete();
            }else{
                // Error not so small. Step forward
                System.out.println(runs + ":\t" +"b0: " + beta0 + "\tb1: " + beta1 +  " \n\tError:  "+ error_sum + " ...");
                beta0 = beta0 + ( alpha * error_sum ) + alpha;
                beta1 = beta1 + ( alpha * error_sum ) + alpha;
                runs++;
            }
            if (runs >= 200){
                doDelete();
            }
        }
    }
    private boolean isSmallEnough( double error ){
        //System.out.println("\tError:  "+ error + " ...");
        return false;
    }

}
