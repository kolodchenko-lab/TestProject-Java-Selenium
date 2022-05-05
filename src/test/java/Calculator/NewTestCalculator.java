package Calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewTestCalculator  {

    private Calculator calculator;


    /*@BeforeAll
    static void initBeforeAll() {
        System.out.println("Before all called");
    }*/

   @BeforeEach
    void init() {
        System.out.println("before each called");
        calculator = new Calculator();
    }

    @Test
    void TestMultiply() {
        //GIVEN
        int firstNumber = 3;
        int secondNumber = 2;
        String operation = "*";
        String expectedResult = "6.00";

        //WHEN
        String ActualResult = calculator.calculate(firstNumber, secondNumber, operation);
        //Then
        Assertions.assertEquals(expectedResult, ActualResult);

    }

    @Test
    void testPlus() {
        //GIVEN
        int first = 4;
        int second = 4;
        String operation = "+";
        String ExpectedResult = "8.00";

        //THEN
        String ActualResult = calculator.calculate(first, second, operation);
        //WHEN
        Assertions.assertEquals(ExpectedResult, ActualResult);
    }

    @Test
    void testDivision() {
        //GIVEN
        int first = 11;
        int second = 10;
        String operation = "/";
        String expectedResult = "1.10";
        //WHEN
        String actualResult = calculator.calculate(first, second, operation);
        //THEN
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testCheckException() {
        //GIVEN
        int first = 9;
        int second = 0;
        String operation = "/";
        String expectedExceptionMessage = "You can't divide by zero.";

        //WHEN

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(first, second, operation), String.format("Not equals '%s'", second));
        //THEN
        assertEquals(expectedExceptionMessage, illegalArgumentException.getMessage());
    }
    
  /* @ParameterizedTest
    @ValueSource(ints = {4, 3, Integer.MAX_VALUE})
    void testMinus(int first) {
        //GIVEN
        int second = 2;
        String operation = "-";
        String expectedResult = prepareExpectedResult(first, second);

        //THEN
        String ActualResult = calculator.calculate(first, second, operation);
        //WHEN
        Assertions.assertEquals(expectedResult, ActualResult);


    }

    private String prepareExpectedResult(int first, int second) {
        double expectedResultDouble = first - second;
        String expectedResult = String.format("%1$,.2f",expectedResultDouble);
        return expectedResult;
    }*/
  @ParameterizedTest
  @CsvSource(value = {"+:12.00", "/:1.00"}, delimiter = ':')
  //@CsvFileSource(resources = "/testData.csv")
  void testSum_paramCsv(String operation, String expectedResult) {
      //GIVEN
      int second = 6;
      int first = 6;

      //WHEN
      String actualResult = calculator.calculate(first, second, operation);
      //THEN
      assertEquals(expectedResult, actualResult);
  }
    @Test
    void  testCheckExceptionIsNegativeFirst(){
        //GIVEN
        int first = -7;
        int second = 6;
        String operation = "+";
        String expectedExceptionMessage = "Negative number";

        //WHEN
        InputMismatchException inputMismatchException = assertThrows(InputMismatchException.class,
                () -> calculator.calculate(first, second, operation));
        //THEN

        assertEquals(expectedExceptionMessage, inputMismatchException.getMessage());

    }



    @TestFactory
    Iterable<DynamicTest> dynamicTestsWithIterable() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Minus test",
                        () -> assertEquals("1.00", calculator.calculate(5, 4, "-"))),
                DynamicTest.dynamicTest("Divide Test",
                        () -> assertEquals("2.50", calculator.calculate(5, 2, "/"))));
    }



}


