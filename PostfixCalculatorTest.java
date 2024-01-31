import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PostfixCalculatorTest {

    @Test
    public void testEvaluateExpression() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertEquals(15, calculator.evaluateExpression("1 2 + 4 * 3 +"));
        assertEquals(12, calculator.evaluateExpression("6 2 3 + *"));
    }

    @Test
    public void testEvaluateExpressionWithInvalidToken() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.evaluateExpression("1 2 x"));
    }

    @Test
    public void testEvaluateExpressionWithDivideByZero() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(ArithmeticException.class, () -> calculator.evaluateExpression("1 0 /"));
    }

    @Test
    public void testEvaluateExpressionWithInsufficientOperands() {
        PostfixCalculator calculator = new PostfixCalculator();
        assertThrows(IllegalStateException.class, () -> calculator.evaluateExpression("1 +"));
    }

}
