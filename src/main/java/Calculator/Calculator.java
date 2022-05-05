package Calculator;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;

/*public class Calculator {
    private  final List<String> MATHEMATIK_OPERATIONS;
    public Calculator(){
        AppConfig config = ConfigFactory.create(AppConfig.class);
        MATHEMATIK_OPERATIONS = Arrays.asList(config.supportedOperations().split(","));
    } */
public class Calculator {
    private static final List<String> MATHEMATIK_OPERATIONS = List.of("+", "/","*","-");

    public String calculate(int firstNumber, int secondNumber, String operation){

       if (MATHEMATIK_OPERATIONS.contains(operation)) {
           double result = calculationStep(firstNumber, secondNumber, operation);

            return (new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.ENGLISH))).format(result);
        } else {
            throw new IllegalStateException(String.format(operation));
       }
    }



    public double calculationStep(int firstNumber, int secondNumber, String operation) {
        if (firstNumber < 0 ){ throw new InputMismatchException(" negative number ");
        }
        if (secondNumber < 0){
            throw new InputMismatchException(" negative number ");
        }
        return performOperation(firstNumber, secondNumber, operation);
    }

    private double performOperation(int firstNumber, int secondNumber, String operation) {
        double result;

        switch (operation){
            case "+":
                result = plus(firstNumber, secondNumber);
                break;
            case "/":
                result = divide(firstNumber, secondNumber);
                break;
            case "-":
                result = minus(firstNumber, secondNumber);
                break;
            case "*":
                result = multiply(firstNumber, secondNumber);
                break;

            default:
                result = 0;
                break;
        }

        return result;
    }

    private int plus(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
    private int minus(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }
    private int multiply(int firstNumber,int secondNumber){
        return firstNumber * secondNumber;
    }
    private double divide(int numberOne, double numberTwo){
        if (numberTwo == 0) {
            throw new IllegalArgumentException("You can't divide by zero.");
        }
        return numberOne / numberTwo;
    }

}
