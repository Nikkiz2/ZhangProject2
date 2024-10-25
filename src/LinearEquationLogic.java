import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scan;
    private String coord1;
    private String coord2;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private LinearEquation linearEquation;


    public LinearEquationLogic() { //constructor
        linearEquation = null;
        scan = new Scanner(System.in);
    }


    public void start() { //call methods to start
        String option = "Yes";
        mainMenu(); //works
        while (option.equals("Yes")) {
            askForCoords(); //works
            convertToInt(); //works
            linearEquation = new LinearEquation(x1,y1,x2,y2);
            System.out.println(linearEquation.lineInfo());
            askForXValue();
            System.out.println("\nWould you like to continue with another coordinate pair?");
            System.out.print("Enter 'Yes' if so, and 'No' to stop: ");
            option = scan.nextLine();
        }
        System.out.println("\nThank you for using the Linear Equation Calculator, goodbye!");
    }


    private void mainMenu() {
        System.out.println("Welcome to the Linear Equation Calculator!");
        System.out.println("Enter two coordinates and we'll help you find everything" +
                " you need to know about your coordinates (like slope, etc.)!");
    }


    private void askForCoords() {
        System.out.print("\nPlease enter your first coordinate: ");
        coord1 = scan.nextLine();
        System.out.print("Please enter your second coordinate: ");
        coord2 = scan.nextLine();
    }


    private void convertToInt() {
        x1 = Integer.parseInt(coord1.substring(1,coord1.indexOf(", ")));
        y1 = Integer.parseInt(coord1.substring(coord1.indexOf(", ") + 2, coord1.length()-1));
        x2 = Integer.parseInt(coord2.substring(1,coord2.indexOf(", ")));
        y2 = Integer.parseInt(coord2.substring(coord2.indexOf(", ") + 2, coord2.length()-1));
    }


    private void askForXValue() {
        if (x1 != x2) {
            System.out.print("\nEnter an X value to input in the equation: ");
            double xValue = scan.nextDouble();
            scan.nextLine();
            System.out.println("\nYour point is: " + linearEquation.coordinateForX(xValue));
        }
    }
}


