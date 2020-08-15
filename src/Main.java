import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/*
Neural Network Berta
v. 0.01
       2020
 @author arsmarsx

 */


public class Main {

    Random rand = new Random();
    //input
    double n1 = 1;
    double n2 = 1;
    double target = 0;

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
        System.out.println("Starting NN Berta");
        generateRandomWeights();
        double acc = 50000;
        for (var epoch =0; epoch<1*acc; epoch++) {
            System.out.println("█︎█︎█︎█︎ New Epoch # "+epoch+ " "+ acc*0.25+" █︎█︎█︎█︎█︎");

            if (epoch <0.25*acc){
                n1 = 1;
                n2 = 0.1;
                target = 0.1;
                System.out.println("zzz");
            }
            if (0.25*acc < epoch&& epoch<0.50*acc){
                n1 = 0.1;
                n2 = 1;
                target = 0.1;
            }
            if (0.50*acc <epoch && epoch <0.75*acc){
                n1 = 0.1;
                n2 = 1;
                target = 0.1;
            }
            if (0.75*acc <epoch){
                n1 = 1;
                n2 = 1;
                target = 1;
            }
            workInHiddenLayer();
            errorCheck();
            //<<Back Propagation
            workInW5_W6();
            workInW1_W4();
            System.out.println("█︎█︎█︎█︎ End Epoch # "+epoch+" █︎█︎█︎█︎█︎");
        }

        testingNewModel();

    }

    private void testingNewModel() {
        Scanner in = new Scanner(System.in);
        //System.out.println("Do you want try new Model? y/n");
        try {
            System.out.println("launch model");
            //String s = in.nextLine();

            System.out.println("Input nums =");
            n1 = Double.parseDouble(in.nextLine());
            n2 = Double.parseDouble(in.nextLine());

            runModel();
        }catch (Exception e){
            testingNewModel();
        }

//        if (Objects.equals(s, "y")){
//
//        }
//        if (Objects.equals(s, "n")){ System.out.println("end");
//        }else { System.out.println("end"); }
    }
    public void runModel(){
        workInHiddenLayer();
        errorCheck();
        testingNewModel();
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

        System.out.println(" Error= ["+ error+"] PREDICT = ["+calc + "] target = ["+ target+"]");
    }

    //START TRAINING
    private void workInW5_W6() {
        // get new weights w5~w6
        deltaOutputSum = FormulaX.sigmoiddx(Ff)*error;
        double[] newWeights5_6 = {(deltaOutputSum/S1)+w5,(deltaOutputSum/S2)+w6};
        w5 = newWeights5_6[0];
        w6 = newWeights5_6[1];
//        int a = 2;
//        for (var i=0; i<array.length; i++) {
//            a = a * array[i];
//        }
        System.out.println(Arrays.toString(newWeights5_6));
        HiddenSum = new double[]{(deltaOutputSum / w5) + FormulaX.sigmoiddx(F1), (deltaOutputSum / w6) + FormulaX.sigmoiddx(F2)};
    }

    private void workInW1_W4() {
        // get new weights w1~w4
        double[] newWeightsW1_W4 = new double[4];
        newWeightsW1_W4 [0] = HiddenSum[0] / n1;
        newWeightsW1_W4 [1] = HiddenSum[1] / n1;
        newWeightsW1_W4 [2] = HiddenSum[0] / n2;
        newWeightsW1_W4 [3] = HiddenSum[1] / n2;
        System.out.println(Arrays.toString(newWeightsW1_W4));
        w1 = newWeightsW1_W4 [0];
        w2 = newWeightsW1_W4 [1];
        w3 = newWeightsW1_W4 [2];
        w4 = newWeightsW1_W4 [3];

        //newWeightsW1_W4
        //newWeightsW1_W4 = newWeightsW1_W4 + deltaOutputSum;
    }

    public void display(){
        System.out.println("input:||  output :");
       // System.out.println( n1 + "   ||  " + target);
        System.out.println( n2 + "   || "+ w1);
    }


}
