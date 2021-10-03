// CID - Challenge 1.
// Luis Donaldo García Castro 218294494
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class GD extends Agent{
    // Gradient variables
    protected double solution;
    protected double gradient;
    protected double step_size = 0.1;
    protected int counter = 0;
    // To save the results:
    double result_iteration;
    double result_solution = 999999.99;
    double result_solution_evaluation = 999999.99;
    /**
     * This functions returns teh derivative of x^2
     */
    protected double derivateF( double x ){
        return 2*x;
    }
    protected double objective( double x ){
        return x*x;
    }
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        /* INITIALIZING GD Variables */
        solution = 0 + Math.random() * (5 - 0); // Generate initial point (Could be random)
        solution = Math.ceil(solution);
        System.out.println("Initial point: " + solution  + "." );

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                // calculate gradient
                gradient = derivateF( solution );
                // take a step
                solution = solution - step_size * gradient;
                // evaluate candidate point
                double solution_eval = objective(solution);
	            // report progress
                System.out.println("\t i = "+  counter + ": f("+solution+") = " + solution_eval );
                counter = counter + 1;
                // Selecting the result
                if( solution_eval >= 0 && solution_eval < result_solution_evaluation  ){
                    result_solution_evaluation = solution_eval;
                    result_solution = solution;
                    result_iteration = counter;
                }
                if( counter > 200 ){
                    //Setting a maximum of 30 iterations
                    doDelete();
                }
            }
        });

    }

    protected void takeDown(){
        // Dismissal message
        System.out.println("Agent "+ getAID().getName() + "terminating.");
        System.out.println("Best results:");
        System.out.println("\t i = "+  result_iteration + ": f("+result_solution+") = " + result_solution_evaluation );
    }

}




