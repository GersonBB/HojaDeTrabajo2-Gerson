import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostfixCalculator implements Calculator {
    private Vector<Integer> stack;

    public PostfixCalculator() {
        stack = new Vector<>();
    }

    @Override
    public int evaluateExpression(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token, operand1, operand2);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int performOperation(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);
            PostfixCalculator calculator = new PostfixCalculator();

            while (scanner.hasNextLine()) {
                String expression = scanner.nextLine();
                int result = calculator.evaluateExpression(expression);
                System.out.println("Resultado: " + result);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo datos.txt");
        }
    }
}
