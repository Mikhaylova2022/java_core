package lesson5.hw5;

public class Main {
    private static final String FILE_NAME = "appData.csv";
    private static final String CSV_SPLIT_BY = ";";


    public static void main(String[] args) {
        String[] testHeader = {"Value 1", "Value 2", "Value 3"};
        int[][] testData = {
                {100, 200, 123},
                {300, 400, 500}
        };
        AppData appData1 = new AppData(testHeader, testData);
        appData1.print();
        appData1.saveDataIntoCSV();
        appData1.getDataFromCSV(FILE_NAME, CSV_SPLIT_BY);
        appData1.print();
    }
}