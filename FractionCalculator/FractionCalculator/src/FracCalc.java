import java.util.Scanner;

/**
 * The FracCalc program is a fraction caclulator. It takes input from the user
 * and can simplify and calculate fractional expressions.
 *
 * @author Cooper Dalton
 * @Version 1.0
 */
public class FracCalc {

    /**
     * The main method of the program repeatedly asks for user input unless
     * they input "quit" otherwise it will calculate the users fractional
     * expressions they input and return the answer printed to the screen
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
        Scanner input = new Scanner(System.in);
        String equation = "something";

        //repeats until the user inputs "quit"
        while (!(equation.equals("quit"))) {
            System.out.println("Write your fraction Equation (type \"quit\" to exit)");
            equation = input.nextLine();

            //repeats until the user inputs "quit"
            if (!(equation.equals("quit"))) {
                String answer = produceAnswer(equation);
                System.out.println(answer);
            }
        }
    }

    /**
     * Produce answer is where the equation is processed and the method
     * which calls all the other appropriate methods for the expression to be calculated
     *
     * @param texts the equation that the user inputted
     * @return String finalAnswer returns the final computed answer
     */
    public static String produceAnswer(String texts) {

        String finalAnswer = "";

        int count = 0;
        //Counts the number of expressiosn there are by counting the number of spaces
        for(int i = 0; i < texts.length(); i++){
            String letter = texts.substring(i, i+1);
            if (letter.equals(" ")){
                count = count + 1;
            }
        }

        String updateString = texts;

        int numTerms = count/2;
        //Repeats multiple times until every term is calculated
        for(int i = 0; i < numTerms; i ++){
            Scanner inputs = new Scanner(updateString);
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

            Scanner deliminate = new Scanner(fTerm);

            //Numerator
            //If the term has a fractional part delimiter it as such
            if (fTerm.indexOf("/") >= 0){
                //if the term has a whole number part delimiter it as such
                if (fTerm.indexOf("_") >= 0){

                    deliminate.useDelimiter("_");

                    fWhole = deliminate.nextInt();

                    String tempString = deliminate.next();

                    Scanner fracPart = new Scanner(tempString);

                    fracPart.useDelimiter("/");
                    fNum = fracPart.nextInt();
                    fDen = fracPart.nextInt();

                    // if no whole number just fraction delimiter it as such
                } else{
                    deliminate.useDelimiter("/");
                    fWhole = 0;
                    fNum = deliminate.nextInt();
                    fDen = deliminate.nextInt();
                }
                //if whole number delimiter it as such
            } else{
                fWhole = Integer.parseInt(fTerm);
                fNum = 0;
                fDen = 1;
            }

            //Denominator
            Scanner deliminater = new Scanner(lTerm);
            //If the term has a fractional part delimiter it as such
            if (lTerm.indexOf("/") >= 0){
                //if the term has a whole number part delimiter it as such
                if (lTerm.indexOf("_") >= 0){

                    deliminater.useDelimiter("_");

                    lWhole = deliminater.nextInt();

                    String tempString = deliminater.next();
                    Scanner fractPart = new Scanner(tempString);

                    fractPart.useDelimiter("/");
                    lNum = fractPart.nextInt();
                    lDen = fractPart.nextInt();

                } else{
                    //if no whole number just fraction delimiter it as such
                    deliminater.useDelimiter("/");
                    lWhole = 0;
                    lNum = deliminater.nextInt();
                    lDen = deliminater.nextInt();
                }
                //If whole number
            } else{
                lWhole = Integer.parseInt(lTerm);
                lNum = 0;
                lDen = 1;
            }

            //Converting to mixed fractions
            int fMixedNum;
            int lMixedNum;

            //if whole number is negative convert to mixed fraction accordingly Numerator
            if (fWhole < 0){
                fMixedNum = fDen * fWhole - fNum;
            }
            //if whole number is positive convert to mixed fraction accordingly Numerator
            else{
                fMixedNum = fDen * fWhole + fNum;
            }
            //if whole number is negative convert to mixed fraction accordingly Denominator
            if (lWhole < 0){
                lMixedNum = lDen * lWhole - lNum;
            }
            //if whole number is positive convert to mixed fraction accordingly Denominator
            else{
                lMixedNum = lDen * lWhole + lNum;
            }

            //Checks which operation to do
            if (operation.equals("+")){
                //Addition
                finalAnswer = addition(fMixedNum, fDen, lMixedNum, lDen);
            }
            else if(operation.equals("-")){
                //Subtraction
                finalAnswer = subtraction(fMixedNum, fDen, lMixedNum, lDen);
            }
            else if(operation.equals("/")){
                //division
                finalAnswer = division(fMixedNum, fDen, lMixedNum, lDen);
            }
            else{
                //Multiplication
                finalAnswer = multiplication(fMixedNum, fDen, lMixedNum, lDen);
            }

            //If multiple terms left to calculate update updateStrign to the most recent final answer plus the next term
            if (i < numTerms - 1) {
                String tempStr = updateString.substring(updateString.indexOf(" ") + 1);
                String dumbStr = tempStr.substring(tempStr.indexOf(" ") + 1);

                updateString = finalAnswer + dumbStr.substring(dumbStr.indexOf(" "));
            }
        }
        return finalAnswer;
    }

    /**
     *This method calculates the expression if it involved multiplication
     * It calculates the final numerator and denominator then calls another method to simplify it
     *
     * @param fNum the numerator of the first term
     * @param fDen the denominator of the first term
     * @param lNum the numerator of the second term
     * @param lDen the denominator of the second term
     * @return String returns by calling the simplify function which will return the simplified version of the fraction
     */
    public static String multiplication(int fNum, int fDen, int lNum, int lDen){

        int finalNum = fNum * lNum;
        int finalDen = lDen * fDen;


        return simplify(finalNum, finalDen);
    }

    /**
     *This method calculates the expression if it involved division
     * It calculates the final numerator and denominator then calls another method to simplify it
     *
     * @param fNum the numerator of the first term
     * @param fDen the denominator of the first term
     * @param lNum the numerator of the second term
     * @param lDen the denominator of the second term
     * @return String returns by calling the simplify function which will return the simplified version of the fraction
     */
    public static String division(int fNum, int fDen, int lNum, int lDen){
        int finalNum = fNum * lDen;
        int finalDen = fDen * lNum;

        //if the final denominator is negative make the numerator negative and denominator positive
        if (finalDen < 0){
            finalDen *=-1;
            finalNum *=-1;
        }

        return simplify(finalNum, finalDen);
    }

    /**
     *This method calculates the expression if it involved addition
     * It calculates the final numerator and denominator then calls another method to simplify it
     *
     * @param fNum the numerator of the first term
     * @param fDen the denominator of the first term
     * @param lNum the numerator of the second term
     * @param lDen the denominator of the second term
     * @return String returns by calling the simplify function which will return the simplified version of the fraction
     */
    public static String addition(int fNum, int fDen, int lNum, int lDen){
        int finalNum = (fNum * lDen) + (lNum * fDen);
        int finalDen = fDen * lDen;


        return simplify(finalNum, finalDen);
    }

    /**
     *This method calculates the expression if it involved subtraction
     * It calculates the final numerator and denominator then calls another method to simplify it
     *
     * @param fNum the numerator of the first term
     * @param fDen the denominator of the first term
     * @param lNum the numerator of the second term
     * @param lDen the denominator of the second term
     * @return String returns by calling the simplify function which will return the simplified version of the fraction
     */
    public static String subtraction(int fNum, int fDen, int lNum, int lDen){
        int finalNum = (fNum * lDen) - (lNum * fDen);
        int finalDen = fDen * lDen;


        return simplify(finalNum, finalDen);
    }

    /**
     *
     * @param num the calculated numerator from the operation method
     * @param den the calculated denominator from the operation method
     * @return String returns the final simplified number in the correct string form
     */
    public static String simplify(int num, int den){
        int finalNum;
        int finalDen;

        //if numerator is positive proceed with simplifying
        if (num >=0) {
            int counter = 2;
            //creates a counter variable which increases and checks whether the counter variable is divisble by both numbers
            while (counter <= num){
                //if numerator is evenly divisble by counter
                if (num % counter == 0){
                    //if denominator is evenly divisble by counter divide both by counter and reset counter
                    if ((den % counter) == 0){
                        den = den / counter;
                        num = num / counter;

                        counter = 1;
                    }
                }
                counter++;
            }

            finalNum = num;
            finalDen = den;
        //if Numerator is negative
        } else{
            int counter = 2;
            num = num*-1;
            //creates a counter variable which increases and checks whether the counter variable is divisble by both numbers
            while (counter <= num){
                //if numerator is evenly divisble by counter
                if (num % counter == 0){
                    //if denominator is evenly divisble by counter divide both by counter and reset counter
                    if ((den % counter) == 0){
                        den = den / counter;
                        num = num / counter;

                        counter = 1;
                    }
                }
                counter++;
            }
            
            finalNum = num*-1;
            finalDen = den;
        }

        int wholeNum = 0;
        boolean negative = finalNum < 0;

        //If the numerator is positive convert to mixed fraction again
        if (finalNum >= 0) {
            //If the numerator is greater than the denominator then increase whole number by one until it's not
            while (finalNum > finalDen - 1) {
                wholeNum++;
                finalNum = finalNum - finalDen;
            }
        }
        //If the numerator is negative convert to mixed fraction again
        else{
            //If the numerator is greater than the denominator then use integer division to find out how many whole numbers there should be
            if (finalNum < finalDen - 1){
                wholeNum = finalNum/finalDen;
                finalNum = finalNum - wholeNum*finalDen;
            }

        }

        //If the numerator is 0 just return the whole number
        if(finalNum == 0){
            return wholeNum + "";
        }
        //if no whole numbers return answer in fraction format
        if(wholeNum == 0){
            return finalNum + "/" + finalDen;
        }
        //if number is negative get rid of the negative in the numerator
        if (negative){
            return wholeNum + "_" + (-1*finalNum) + "/" + finalDen;
        }
        return wholeNum + "_" + finalNum + "/" + finalDen;
    }


}
