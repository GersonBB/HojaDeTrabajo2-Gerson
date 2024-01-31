public class Vector<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public Vector() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return array[--size];
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
