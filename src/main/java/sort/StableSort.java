package sort;


public class StableSort {
    // Exercise from WebLab ADS that asks to stable sort a 'table'
    public static void stableSort(String[][] table, int column) {
        if (table == null) return;
        for (int i = 1; i < table.length; ++i) {
            {
                String[] c = table[i];
                int j = i - 1;

                while (j >= 0 && table[j][column].compareTo(c[column]) > 0) {
                    table[j + 1] = table[j];
                    j--;
                }
                j++;
                table[j] = c;
            }
        }
        return;
    }
}


