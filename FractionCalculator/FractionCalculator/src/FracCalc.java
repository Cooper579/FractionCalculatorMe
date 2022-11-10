import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        String equation = "something";

        //while (!(equation.equals=="quit")){
        //
        //}
        System.out.println("Write your fraction Equation");
        equation = input.nextLine();

        String answer = produceAnswer(equation);
        System.out.println(answer);
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

        //If the term has a fractional part
        if (fTerm.indexOf("/") >= 0){
            //if the term has a whole number part
            if (fTerm.indexOf("_") >= 0){

            } else{

            }

        } else{
            String fWhole = fTerm;
            String fNum = 0;
            Strnig fDen = 1;
        }




        return lTerm;
    }
}
// TODO: Fill in the space below with any helper methods that you think you will need
