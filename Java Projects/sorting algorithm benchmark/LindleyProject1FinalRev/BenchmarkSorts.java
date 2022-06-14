/**
 * Thomas Lindley, CMSC 451
 * 15/NOV/2021
 * BenchmarkSorts.java - benchmarks quicksort's iterative and recursive implementations by calling appropriate
 *                       methods from QuickSort.java, and starting and stopping a timer before and after 
 *                       return
 * recursive quick sort algorithm implementation adapted from: https://www.geeksforgeeks.org/quick-sort/
 * iterative quick sort adapted from amit's comment: https://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive 
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkSorts {
    // warmup code 
    protected static void warmUp(){
        for (int i = 0; i < 100000; i++) {
            QuickSort qWarmUp = new QuickSort();
            qWarmUp.getCrit();
        }
    }
    // method to create arrays of random values 0 - 9 inclusive of appropriate size
    public static int[] randomArrays(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
    public static void main(String[] args) {
        // warmup quick sort
        System.out.println("Warmup started.");
        warmUp();
        System.out.println("Warmup ended.");
        // Variables for timing 
        long start;
        long end;
        long totalTime;
        // start count at 1, used to control while loop and how many elements in arrays each iteration of loop
        int count = 1;
        // arrays to store benchmarking data of sorting algorithm
        String[] times = new String[50];
        String[] critCounts = new String[50];
        try {
            // get files ready to write
            BufferedWriter bwRe = new BufferedWriter(new FileWriter("recursive.txt"));
            BufferedWriter bwIt = new BufferedWriter(new FileWriter("iterative.txt"));
            // run 10 times since start at 1
            while (count < 11) {
                int critOpCount = 0;
                // Create 50 int arrays to pass to quick sort functions, with appropriate amount of elements for each run.
                int numElements = count * 100;
                //create arrays with correct number of elements
                int[][] arrays = new int[52][numElements];
                
                // populate arrays with random ints
                for (int i = 0; i < 52; i++) {
                    arrays[i] = randomArrays(count * 100);
                }
                
                // print 2 unsorted array 1 for recursive and 1 for itterative 
                System.out.println("\nUnsorted Array 1 with: " + numElements + " elements./n");
                for (int index = 0; index < arrays[50].length; index++) {
                    System.out.print(arrays[50][index]+" ");
                }
                System.out.println(" ");
                System.out.println("\nUnsorted Array 2 with: " + numElements + " elements./n");
                for (int index = 0; index < arrays[51].length; index++) {
                    System.out.print(arrays[51][index]+" ");
                }
                System.out.println(" ");

                // recursive sort sample, use an array that will not be sorted later because it will remain sorted due to scope
                QuickSort sortSample = new QuickSort();
                System.out.println("\nRecursively Sorted Array 1 with: " + numElements + " elements./n");
                sortSample.recursiveQuickSort(arrays[50], 0, numElements -1);
                for (int index = 0; index < arrays[50].length; index++) {
                    System.out.print(arrays[50][index]+" ");
                }
                System.out.println(" ");
                
                // start line in file with count of elements
                bwRe.write(String.valueOf(numElements) + " ");
                bwIt.write(String.valueOf(numElements) + " ");

                // Pass 50 random int arrays to recursive quick sort and keep time
                for (int i = 0; i < 50; i++) {
                    QuickSort sort = new QuickSort();
                    start = System.nanoTime();
                    sort.recursiveQuickSort(arrays[i], 0, numElements -1);
                    end = System.nanoTime();
                    totalTime = end-start;
                    critOpCount = sort.getCrit();
                    critCounts[i] = critOpCount + " ";
                    times[i] = String.valueOf(totalTime) + " ";
                    // check if array is sorted, if not throw exception
                    try {
                        for (int j = 0; j < arrays[i].length - 1; j++) {
                            if(arrays[i][j] > arrays[i][j + 1]){
                                throw new UnsortedException();
                            }
                        }
                    } catch (UnsortedException e) {
                        System.out.println("Array not successfully sorted!");
                    }
                    
                }

                for (int index = 0; index < critCounts.length; index++) {
                    bwRe.write(critCounts[index]);
                }
                for (int index = 0; index < times.length; index++) {
                    bwRe.write(times[index]);
                }

                // iterative sort sample, use an array that will not be sorted later because it will remain sorted due to scope
                QuickSort itSortSample = new QuickSort();
                itSortSample.iterativeQuickSort(arrays[51]);
                System.out.println("\nIteratively Sorted Array 2 with: " + numElements + " elements./n");
                sortSample.recursiveQuickSort(arrays[51], 0, numElements -1);
                for (int index = 0; index < arrays[51].length; index++) {
                    System.out.print(arrays[51][index]+" ");
                }
                System.out.println(" ");

                // Pass 50 random int arrays to iterative quick sort and keep time
                for (int i = 0; i < 50; i++) {
                    QuickSort sort = new QuickSort();
                    start = System.nanoTime();
                    sort.iterativeQuickSort(arrays[i]);
                    end = System.nanoTime();
                    totalTime = end-start;
                    critOpCount = sort.getCrit();
                    critCounts[i] = critOpCount + " ";
                    times[i] = String.valueOf(totalTime) + " ";
                }
                for (int index = 0; index < critCounts.length; index++) {
                    bwIt.write(critCounts[index]);
                }
                for (int index = 0; index < times.length; index++) {
                    bwIt.write(times[index]);
                }

                bwIt.write("\n");
                bwRe.write("\n");
                count++;
            }
            bwRe.close();
            bwIt.close();
        } catch (IOException e) {
            System.out.println("Failed file operations.");
        }
    }
}