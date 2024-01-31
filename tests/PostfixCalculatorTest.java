import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PostfixCalculatorTest {

    @Test
    void testEvaluateExpression_Addition() {
        PostfixCalculator calculator = new PostfixCalculator();
        String expression = "2 3 +";
        int result = calculator.evaluateExpression(expression);
        assertEquals(5, result);
    }

    @Test
     void testEvaluateExpression_Subtraction() {
        PostfixCalculator calculator = new PostfixCalculator();
        String expression = "5 3 -";
        int result = calculator.evaluateExpression(expression);
        assertEquals(2, result);
    }

    @Test
    void testEvaluateExpression_Multiplication() {
        PostfixCalculator calculator = new PostfixCalculator();
        String expression = "2 3 *";
        int result = calculator.evaluateExpression(expression);
        assertEquals(6, result);
    }

    @Test
    void testEvaluateExpression_Division() {
        PostfixCalculator calculator = new PostfixCalculator();
        String expression = "6 3 /";
        int result = calculator.evaluateExpression(expression);
        assertEquals(2, result);
    }

    @Test
    void testEvaluateExpression_ComplexExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        String expression = "2 3 + 4 *";
        int result = calculator.evaluateExpression(expression);
        assertEquals(20, result);
    }

}