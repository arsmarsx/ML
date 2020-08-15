import java.util.Arrays;
import java.util.Random;

/*
Neural Network Berta
v. 0.01
       2020
 @author arsmarsx

 */


public class Main {
    //Main mn = new Main();
    //double x = 0;
    Random rand = new Random();
    //input
    double n1 = 1;
    double n2 = 1;
    double target = 1;

    // Weights
    double w1 = 1;
    double w2 = 1;
    double w3 = 1;
    double w4 = 1;
    double w5 = 1;
    double w6 = 1;
    int range = 100 - 1;

    //before Sigmoid
    double F1 = 1;
    double F2 = 1;
    //Sigmoid
    double S1 = 0;
    double S2 = 0;
    double Ff = 0;
    double calc =0;

    double error = 0;
    double deltaOutputSum = 0;
    double deltaWeights1 = 0;
    //double
    double[] HiddenSum;

    public void generateRandomWeights(){
        // Generate Random doubles
        double rand_dub1 = rand.nextDouble();
        //int s = (rand.nextInt(99) + 1)/100;;

//        w1 = (double) (rand.nextInt(99) + 1)/100;
//        w2 = (double) (rand.nextInt(99) + 1)/100;
//        w3 = (double) (rand.nextInt(99) + 1)/100;
//        w4 = (double) (rand.nextInt(99) + 1)/100;
//        w5 = (double) (rand.nextInt(99) + 1)/100;
//        w6 = (double) (rand.nextInt(99) + 1)/100;
        //
        w1 = 0.77;
        w2 = 0.3;
        w3 = 0.75;
        w4 = 0.69;
        w5 = 0.92;
        w6 = 0.68;

        display();
    }


    public static void main(String[] args) {

        double [] inputData = { 1 ,1 };
        double outputData = 1;

        double x = FormulaX.sigmoiddx(1);
        //new Main().display();
        new Main().launchPad();
    }

    public void launchPad(){
        /////////////////////////////////////////////////////////////
        //                          LAUNCH PAD                     //
        /////////////////////////////////////////////////////////////
        System.out.println("- Welcome to Berta - Neural Network - ");
        generateRandomWeights();
        System.out.println("Starting NN Berta");
        workInHiddenLayer();
        errorCheck();
        //<<Back Propagation
        workInW5_W6();
        workInW1_W4();
    }

    private void workInW1_W4() {
        double[] newWeightsW1_W4 = new double[4];
        newWeightsW1_W4 [0] = HiddenSum[0] / n1;
        newWeightsW1_W4 [1] = HiddenSum[1] / n1;
        newWeightsW1_W4 [2] = HiddenSum[0] / n2;
        newWeightsW1_W4 [3] = HiddenSum[1] / n2;
        System.out.println(Arrays.toString(newWeightsW1_W4));

        //newWeightsW1_W4
        //newWeightsW1_W4 = newWeightsW1_W4 + deltaOutputSum;
    }

    private void workInW5_W6() {
        deltaOutputSum = FormulaX.sigmoiddx(Ff)*error;
        double[] newWeights5_6 = {(deltaOutputSum/S1)+w5,(deltaOutputSum/S2)+w6};
//        int a = 2;
//        for (var i=0; i<array.length; i++) {
//            a = a * array[i];
//        }
        System.out.println(Arrays.toString(newWeights5_6));
        HiddenSum = new double[]{(deltaOutputSum / w5) + FormulaX.sigmoiddx(F1), (deltaOutputSum / w6) + FormulaX.sigmoiddx(F2)};
    }




    public void workInHiddenLayer(){
        F1 = n1 * w1 + n2 * w2;
        F2 = n1 * w3 + n2 * w4;
        S1 = FormulaX.sigmoid(F1);
        S2 = FormulaX.sigmoid(F2);
        System.out.println(""+" Weights { w1= "+w1 +" w2= "+w2+" w3= "+w3+" w4= "+w4+" w5= "+w5+" w6= "+w6+" } F "+F1);
    }
    public void errorCheck(){
        Ff = S1*w5+S2*w6;
        calc = FormulaX.sigmoid(Ff);
        error = (calc -target ); // multiply for 2 is need for rid negative numbers
        if (error > 1) { System.out.println("ATTENTION error > 1"); } // Checker

        System.out.println(" Error= ["+ error+"] calc = ["+calc + "] target = ["+ target+"]");
    }



    public void display(){
        System.out.println("input:||  output :");
        System.out.println( n1 + "   ||  " + target);
        System.out.println( n2 + "   || "+ w1);
    }


}
