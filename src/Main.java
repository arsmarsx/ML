




import java.util.Random;

/*
Neural Network Berta
v. 0.01
       2020
 @author arsmarsx

 */


public class Main {

    Random rand = new Random();

    // Weights
    double w1 = 1;
    double w2 = 1;
    double w3 = 1;
    double w4 = 1;
    double w5 = 1;
    double w6 = 1;


    public void generateRandomWeights(){
        // Generate Random doubles
        double rand_dub1 = rand.nextDouble();
        //int s = (rand.nextInt(99) + 1)/100;;

        w1 = (double) (rand.nextInt(99) + 1)/100;
        w2 = (double) (rand.nextInt(99) + 1)/100;
        w3 = (double) (rand.nextInt(99) + 1)/100;
        w4 = (double) (rand.nextInt(99) + 1)/100;
        w5 = (double) (rand.nextInt(99) + 1)/100;
        w6 = (double) (rand.nextInt(99) + 1)/100;
        //
//        w1 = 0.77;
//        w2 = 0.3;
//        w3 = 0.75;
//        w4 = 0.69;
//        w5 = 0.92;
//        w6 = 0.68;
    }


    public static void main(String[] args) {

        // Data in input
        double[][] inputs = new double[][]{
                {1, 0, 1}, // 1 input
                {0, 1, 1}, // 1 input
                {0, 0, 0}, // 1 input
                {1, 1, 1}, // 1 input
        };
        // Data in output
        double[] outputs = new double[] { 1 , 0 };

        NeuralNetwork nn = new NeuralNetwork(10000,inputs,outputs);

        nn.launchPad();

    }



}

