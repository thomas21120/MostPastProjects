// Lindley, Thomas Hw3
// adapted from: https://www.geeksforgeeks.org/binary-heap/

import java.util.ArrayList;
class sortedPriorityQueue <T extends Comparable>{
  private ArrayList<T> queue = new ArrayList();
  public int parent(int i){
    return (i-1)/2;
  }
  public int left(int i){
    return (2*i + 1);
  }
  public int right(int i){
    return (2*i + 2);
  }

  public void add(T element){
    queue.add(element);
    int i = queue.size() - 1;
    while (i != 0 && queue.get(parent(i)).compareTo(queue.get(i)) < 0 ){
      swap(i, parent(i));
      i = parent(i);
    }
  }

  public T remove(){
    if(queue.size() == 1){
      return queue.remove(0);
    }
    T root = queue.get(0);
    queue.set(0, queue.get(queue.size()-1));
    queue.remove(queue.size()-1);
    heapifyMin(0);
    return root;
  }

  void heapifyMin(int x){
    int l = left(x);
    int r = right(x);
    int small = x;
    if (l < queue.size() && queue.get(l).compareTo(queue.get(x)) > 0 ) {
      small = l;
    }
    if (r < queue.size() && queue.get(r).compareTo(queue.get(small)) > 0) {
      small = r;
    }
    if (small != x) {
      swap(x, small);
      heapifyMin(small);
    }
  }

  void swap(int x, int y){
    T temp = queue.get(x);
    queue.set(x, queue.get(y));
    queue.set(y, temp);
  }

  void printStrings(){
    for (T var : queue) {
      System.out.print(var + " ");
    }
    System.out.println();
  }
}