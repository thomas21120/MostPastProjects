/**
 * Thomas Lindley, CMSC 451
 * 15/NOV/2021
 * QuickSort.java - used to recursively or iteratively sort an array. Worst case for time complexity is n^2,
 *                  will occur when array is already sorted in either descending or ascending order. 
 *                  Average time complexity is n log n, occurs when array not already sorted.
 * recursive quick sort algorithm implementation adapted from: https://www.geeksforgeeks.org/quick-sort/
 * iterative quick sort adapted from amit's comment: https://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive 
 */

import java.util.Stack;

public class QuickSort implements SortInterface {

  int critOpCount = 0;
  static void swap(int[] array, int i, int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  static int partition(int[] array, int low, int high){
      int pivot = array[high];
      int i = (low - 1);
      for(int j = low; j <= high -1; j++){
          if (array[j] < pivot){
              i++;
              swap(array, i, j);
          }
      }
      swap(array, i + 1, high);
      return (i+1);
  }

  public void recursiveQuickSort(int[] array, int low, int high){
      if (low<high){
          critOpCount += high-low;
          int pi = partition(array, low, high);
          recursiveQuickSort(array, low, pi - 1);
          recursiveQuickSort(array, pi + 1, high);
      }
  }

  public void iterativeQuickSort(int[] array){
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);
    stack.push(array.length);
    while (!stack.isEmpty()){
      int end = stack.pop();
      int start = stack.pop();
      if (end - start < 2){
        continue;
      }
      critOpCount += end - start;
      int pi = partition(array, start, end - 1);
      stack.push(pi + 1);
      stack.push(end);
      stack.push(start);
      stack.push(pi);
    }
  }

  public int getCrit(){
    return critOpCount;
  }
}
