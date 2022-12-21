package lesson3.HW3;

public class ArrayMethodsGeneric <K> {
    K[] array;

    public ArrayMethodsGeneric(K...array) {
        this.array = array;
    }

    public K[] swapArrayElements(int firstElementIndex, int secondElementIndex) {
        try {
            K temporal = array[firstElementIndex];
            array[firstElementIndex] = array[secondElementIndex];
            array[secondElementIndex] = temporal;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Увы, некоректные значения, Невозможно поменять местами элементы массива");
        }
        return array;
    }

    public void printArray() {
        for (K element: array) {
            System.out.print(element.toString() + " ");
        }
        System.out.println();
    }
}