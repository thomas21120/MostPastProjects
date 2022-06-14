/**
 * Thomas Lindley, CMSC 451
 * 15/NOV/2021
 * SortInterface.java - interface for quicksort, requires iterative and recursive with their respective
 *                      necessary arguments. 
 * recursive quick sort algorithm implementation adapted from: https://www.geeksforgeeks.org/quick-sort/
 * iterative quick sort adapted from amit's comment: https://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive 
 */
interface SortInterface{
  void recursiveQuickSort(int[] array, int low, int high);
  void iterativeQuickSort(int[] array);
}
