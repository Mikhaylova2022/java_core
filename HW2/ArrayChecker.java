package lesson2.HW2;

public class ArrayChecker {
    public static final int EXPECTED_ARRAY_SIZE = 4;
    private String[][] stringArray;

    public ArrayChecker(String[][] stringArray) {
        this.stringArray = stringArray;
    }

    /* Проверяем соответствие размера   массива    */
    public void checkArraySize() {
        if (stringArray == null || stringArray.length != EXPECTED_ARRAY_SIZE || !isArrayRowSizeCorrect()) {
            throw new MyArraySizeException("Incorrect array size!");
        }
    }

    /*Проверка на соответствие размеру строк */
    private boolean isArrayRowSizeCorrect() {
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != EXPECTED_ARRAY_SIZE) {
                return false;
            }
        }
        return true;
    }

    /* Конвертируем в Int и суммируем элементы */
    public int sumArrayElements() {
        int sum = 0;
        if (stringArray != null) {
            for (int i = 0; i < stringArray.length; i++) {
                for (int j = 0; j < stringArray[i].length; j++) {
                    try {
                        sum += Integer.parseInt(stringArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(" Упс, Сумма не может быть сложена, введен некорректно элемент массива! '" +
                                stringArray[i][j] + "'в  ячейке  [" + i + "][" + j + "]");
                    }
                }
            }
        }
        return sum;
    }
}
