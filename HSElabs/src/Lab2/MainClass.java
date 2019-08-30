package Lab2;

import java.util.Arrays;
import java.util.Random;

public class MainClass {
    long startTime = System.currentTimeMillis();

    public static int searchMax(int[][] myArray) {
        int max = myArray[0][0];
        for (int j = 0; j < myArray.length; j++)
            for (int i = 0; i < myArray[j].length; i++) {
                if (myArray[j][i] > max) {
                    max = myArray[j][i];
                }
            }
        return max;
    }

    public static int[][] searchMaxIndex(int[][] myArray) {
        int[][] midArray = new int[myArray.length * myArray[0].length][2];
        int pos = 0;
        int max = searchMax(myArray);
        for (int j = 0; j < myArray.length; j++) {
            for (int i = 0; i < myArray[j].length; i++) {
                if (myArray[j][i] == max) {
                    midArray[pos][0] = j;
                    midArray[pos][1] = i;
                    pos++;
                }
            }
        }
        int[][] indexArray = new int[pos][2];
        System.arraycopy(midArray, 0, indexArray, 0, pos);
        return indexArray;
    }

    public static int searchMin(int[][] myArray) {
        int min = myArray[0][0];
        for (int j = 0; j < myArray.length; j++) {
            for (int i = 0; i < myArray[j].length; i++) {
                if (myArray[j][i] < min) {
                    min = myArray[j][i];

                }
            }
        }
        return min;
    }

    public static int[][] searchMinIndex(int[][] myArray) {
        int[][] midArray = new int[myArray.length * myArray[0].length][2];
        int pos = 0;
        for (int j = 0; j < myArray.length; j++) {
            for (int i = 0; i < myArray[j].length; i++) {
                if (myArray[j][i] == searchMin(myArray)) {
                    midArray[pos][0] = j;
                    midArray[pos][1] = i;
                    pos++;
                }
            }
        }
        int[][] indexArray = new int[pos][2];
        System.arraycopy(midArray, 0, indexArray, 0, pos);
        return indexArray;
    }

    public static int searchMax1(int[] myArray1) {
        int max = myArray1[0];
        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1[i] > max) {
                max = myArray1[i];
            }
        }
        return max;
    }

    public static int searchMin1(int[] myArray1) {
        int min = myArray1[0];
        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1[i] < min) {
                min = myArray1[i];

            }
        }
        return min;
    }

    public static int searchMaxIndex1(int[] myArray1) {
        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1[i] == searchMax1(myArray1)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchMinIndex1(int[] myArray1) {
        for (int i = 0; i < myArray1.length; i++) {
            if (myArray1[i] == searchMin1(myArray1)) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] SortAscending(int[][] myArray) {
        int[][] midArray = myArray;
        int[] Sort = new int[myArray.length];
        for (int j = 0; j < myArray[0].length; j++) {
            for (int i = 0; i < myArray.length; i++) {
                Sort[i] = myArray[i][j];
            }
            for (int i = 0; i < myArray.length; i++) {
                midArray[i][j] = searchMin1(Sort);
                Sort[searchMinIndex1(Sort)] = searchMax1(Sort);
            }
        }
        return midArray;
    }

    public static int[][] SortDescending(int[][] myArray) {
        int[][] midArray = myArray;
        int[] Sort = new int[myArray.length];
        for (int j = 0; j < myArray[0].length; j++) {
            for (int i = 0; i < myArray.length; i++) {
                Sort[i] = myArray[i][j];
            }
            for (int i = 0; i < myArray.length; i++) {
                midArray[i][j] = searchMax1(Sort);
                Sort[searchMaxIndex1(Sort)] = searchMin1(Sort);
            }
        }
        return midArray;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int w = Integer.parseInt(args[0]);
        int g = Integer.parseInt(args[1]);
        int[][] myArray = new int[w][g];
        System.out.println("Initial array looks like: ");
        for (int j = 0; j < myArray.length; j++)
            for (int i = 0; i < myArray[j].length; i++) {
                myArray[j][i] = r.nextInt(Integer.parseInt(args[2]));
                System.out.print(myArray[j][i] + " ");
            }
        System.out.println();
        System.out.println("Max element: " + searchMax(myArray));
        System.out.println();
        for (int i = 0; i < searchMaxIndex(myArray).length; i++) {
            System.out.println("Index of max element: " + "[" + searchMaxIndex(myArray)[i][0] + "]" + "["+ searchMaxIndex(myArray)[i][1] + "]");
        }
        System.out.println();
        System.out.println("Min element: " + searchMin(myArray));
        System.out.println();
        for (int i = 0; i < searchMinIndex(myArray).length; i++) {
            System.out.println("Index of min element: " + "[" + searchMinIndex(myArray)[i][0] + "]" + "["+ searchMinIndex(myArray)[i][1] + "]");
        }
        System.out.println();
        int b = 3;
        int a = 1;
        int parameter = Integer.parseInt(args[3]);
        if ((parameter < a) || (parameter > b)) {
            System.out.println("Sort ascending looks like: ");
            for (int j = 0; j < myArray.length; j++) {
                for (int i = 0; i < myArray[j].length; i++) {
                    System.out.print(SortDescending(myArray)[j][i] + " ");
                }
                System.out.println();
            }
        }
        if (parameter == 1) {
            System.out.println("Sort ascending looks like: ");
            for (int j = 0; j < myArray.length; j++) {
                for (int i = 0; i < myArray[j].length; i++) {
                    System.out.print(SortDescending(myArray)[j][i] + " ");
                }
                System.out.println();
            }
        }
        if (parameter == 2) {
            System.out.println("Sort descending looks like: ");
            for (int j = 0; j < myArray.length; j++) {
                for (int i = 0; i < myArray[j].length; i++) {
                    System.out.print(SortAscending(myArray)[j][i] + " ");
                }
                System.out.println();
            }
        }
        if (parameter == 3) {
            System.out.println("Sort ascending looks like: ");
            for (int j = 0; j < myArray.length; j++) {
                for (int i = 0; i < myArray[j].length; i++) {
                    System.out.print(SortDescending(myArray)[j][i] + " ");
                }
                System.out.println();
            }
            System.out.println(" ");
            System.out.println("Sort descending looks like: ");
            for (int j = 0; j < myArray.length; j++) {
                for (int i = 0; i < myArray[j].length; i++) {
                    System.out.print(SortAscending(myArray)[j][i] + " ");
                }
                System.out.println();
            }
        }
        int start = 0;
        long timeSpent = System.currentTimeMillis() - start;
        System.out.println("The programstopped in " + timeSpent + " milliseconds");
    }
}