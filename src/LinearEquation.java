public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    private double roundedToHundredth(double toRound) {
        return (Math.round(toRound * 100) / 100.0);
    }
    public double distance() {
        double xDistance = Math.pow(x2-x1,2);
        double yDistance = Math.pow(y2-y1,2);
        double distance = Math.sqrt(xDistance + yDistance);
        return roundedToHundredth(distance);
    }
    public double slope() {
        double differenceOfY = y2-y1;
        double differenceOfX = x2-x1;
        return roundedToHundredth(differenceOfY/differenceOfX);
    }
    public double yIntercept() {
        return roundedToHundredth((y1 - (slope()*x1)));
    }
    public String equation() {
        String returnStatement = "";
        int differenceOfY = y2-y1;
        int differenceOfX = x2-x1;
        int tempMultiple = differenceOfX;
        while (true) {
            if (x1 == x2) { //EC Undefined slope
                returnStatement = "\nThe points are on vertical line: x = " + x1;
                break;
            } else if (differenceOfY == 0) { //EC Slope = 0
                returnStatement = "The points are on a horizontal line: y = " + yIntercept();
                break;
            } else if (differenceOfY / (double) differenceOfX == 1) { //EC Slope = 1
                returnStatement = "The equation of the line between these points is: y = x";
                break;
            } else if (differenceOfY / (double) differenceOfX == -1) { //EC Slope = -1
                returnStatement = "The equation of the line between these points is: y = -x";
                break;
            } else if ((differenceOfY % differenceOfX) == 0) { //Slope is a whole number
                returnStatement = "The equation of the line between these points is: y = " + differenceOfY/differenceOfX + "x";
                break;
            } else if (differenceOfX % (Math.abs(tempMultiple) - 1) == 0 && differenceOfY % (Math.abs(tempMultiple) - 1) == 0) { //Slope written as a simplified fraction
                int newYDifference = differenceOfY / (tempMultiple - 1);
                int newXDifference = differenceOfX / (tempMultiple - 1);
                if (differenceOfX != Math.abs(differenceOfX) && (differenceOfY != Math.abs(differenceOfY))) { //Simplifies negatives
                    returnStatement = "The equation of the line between these points is: y = " + (newYDifference*-1) + "/" + (newXDifference*-1) + "x";
                    break;
                } else {
                    if (differenceOfX != Math.abs(differenceOfX)) { //EC Negative in front instead of below
                        returnStatement = "The equation of the line between these points is: y = -" + newYDifference + "/" + newXDifference*-1 + "x";
                        break;
                    } else {
                        returnStatement = "The equation of the line between these points is: y = " + newYDifference + "/" + newXDifference + "x";
                        break;
                    }
                }
            }
            tempMultiple = Math.abs(tempMultiple) - 1; //Variable used to check for multiples of the fraction to simplify
        }
        if (yIntercept() == 0 | yIntercept() == 0.0 | differenceOfY == 0 | x1==x2) { //EC if there is a y-intercept, add it to the equation
            return returnStatement;
        } else if (yIntercept() != Math.abs(yIntercept())){ //EC prevents adding a negative y-intercept
            returnStatement += " - " + yIntercept()*-1;
            return returnStatement;
        } else {
            returnStatement += " + " + yIntercept();
            return returnStatement;
        }
    }
    public String coordinateForX(double x) {
        double yValue = slope()*x + yIntercept();
        return "(" + x + ", " + roundedToHundredth(yValue) + ")";
    }
    public String lineInfo() {
        if (x1 == x2) {
            return equation();
        } else {
            return "\nThe two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" +
                    "\n" + equation() +
                    "\nThe y-intercept of this line is: " + yIntercept() +
                    "\nThe slope of this line is: " + slope() +
                    "\nThe distance between these points is " + distance();
        }
    }
}
