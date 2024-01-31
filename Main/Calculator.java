/**
 * Interfaz para una calculadora que evalúa expresiones matemáticas.
 */
public interface Calculator {

    /**
     * Evalúa la expresión matemática dada.
     *
     * @param expression La expresión a evaluar.
     * @return El resultado de la evaluación de la expresión.
     * @throws IllegalArgumentException Si la expresión es inválida.
     */
    int evaluateExpression(String expression) throws IllegalArgumentException;
}
