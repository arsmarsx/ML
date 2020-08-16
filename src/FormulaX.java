





public class FormulaX {

    public static double sigmoid(double x1) {
        return (1 / (1 + Math.exp(-x1))) ;
    }

    public static double sigmoiddx(double y1) {
        return (sigmoid(y1)*(1-sigmoid(y1)));
    }
}

