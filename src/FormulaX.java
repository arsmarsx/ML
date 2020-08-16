


public class FormulaX {
    static String ActivationFunction;

    public FormulaX(String ActivationFunction) {
        FormulaX.ActivationFunction = ActivationFunction;
    }
    // Trigger
    public static double activationFunction(double y) {
        if (ActivationFunction == "hyper"){
            return hyperbooltan(y);
        }else {
            return sigmoid(y);
        }
    }
    //Trigger for dx
    public static double activationFunctiondx(double y2) {
        if (ActivationFunction == "hyper"){
            return hyperbooltandx(y2);
        }else {
            return sigmoiddx(y2);
        }
    }

    public static double hyperbooltan(double z) {
        System.out.println("hyper used");
        return ((Math.exp(z)- Math.exp(-z))/
                ((Math.exp(z)+ Math.exp(-z))));
    }

    public static double hyperbooltandx(double z2) {
        return (hyperbooltan(z2)*(1-hyperbooltan(z2)));
    }

    public static double sigmoid(double x1) {
        return (1 / (1 + Math.exp(-x1))) ;
    }

    public static double sigmoiddx(double y1) {
        return (sigmoid(y1)*(1-sigmoid(y1)));
    }
}

