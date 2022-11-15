import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        String equation = "something";

        while (!(equation.equals("quit"))) {
            System.out.println("Write your fraction Equation (type \"quit\" to exit)");
            equation = input.nextLine();

            if (!(equation.equals("quit"))) {
                String answer = produceAnswer(equation);
                System.out.println(answer);
            }
        }
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String texts) {
        Scanner inputs = new Scanner(texts);
        // TODO: Implement this function to produce the solution to the input
        inputs.useDelimiter(" ");
        String fTerm = inputs.next();
        String operation = inputs.next();
        String lTerm = inputs.next();

        int fNum;
        int fDen;
        int fWhole;

        int lNum;
        int lDen;
        int lWhole;

        //Numerator
        Scanner deliminate = new Scanner(fTerm);
        //If the term has a fractional part
        if (fTerm.indexOf("/") >= 0){
            //if the term has a whole number part
            if (fTerm.indexOf("_") >= 0){

                deliminate.useDelimiter("_");

                fWhole = deliminate.nextInt();

                String tempString = deliminate.next();

                Scanner fracPart = new Scanner(tempString);

                fracPart.useDelimiter("/");
                fNum = fracPart.nextInt();
                fDen = fracPart.nextInt();

            } else{
                deliminate.useDelimiter("/");
                fWhole = 0;
                fNum = deliminate.nextInt();
                fDen = deliminate.nextInt();
            }

        } else{
            fWhole = Integer.parseInt(fTerm);
            fNum = 0;
            fDen = 1;
        }

        //Denominator
        Scanner deliminater = new Scanner(lTerm);
        //If the term has a fractional part
        if (lTerm.indexOf("/") >= 0){
            //if the term has a whole number part
            if (lTerm.indexOf("_") >= 0){

                deliminater.useDelimiter("_");

                lWhole = deliminater.nextInt();

                String tempString = deliminater.next();
                Scanner fractPart = new Scanner(tempString);

                fractPart.useDelimiter("/");
                lNum = fractPart.nextInt();
                lDen = fractPart.nextInt();

            } else{
                deliminater.useDelimiter("/");
                lWhole = 0;
                lNum = deliminater.nextInt();
                lDen = deliminater.nextInt();
            }

        } else{
            lWhole = Integer.parseInt(lTerm);
            lNum = 0;
            lDen = 1;
        }

        return "whole:" + lWhole + " numerator:" + lNum + " denominator:" + lDen;
    }
}
// TODO: Fill in the space below with any helper methods that you think you will need
