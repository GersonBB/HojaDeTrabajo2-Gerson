import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz Calculator para evaluar expresiones en notación postfix.
 */
public class PostfixCalculator implements Calculator {
    private Vector<Integer> stack;

    /**
     * Crea un nuevo objeto PostfixCalculator con una pila vacía.
     */
    public PostfixCalculator() {
        stack = new Vector<>();
    }

    /**
     * Evalúa la expresión matemática dada en notación postfix.
     *
     * @param expression La expresión en notación postfix a evaluar.
     * @return El resultado de la evaluación de la expresión.
     */
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

    /**
     * Verifica si un token es numérico.
     *
     * @param token El token a verificar.
     * @return true si el token es numérico, false en caso contrario.
     */
    private boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Realiza una operación matemática dada por el operador entre dos operandos.
     *
     * @param operator  El operador de la operación.
     * @param operand1  El primer operando.
     * @param operand2  El segundo operando.
     * @return El resultado de la operación.
     * @throws IllegalArgumentException Si el operador es inválido.
     */
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

    /**
     * Método principal para ejecutar el programa.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
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
