// Lindley, Thomas Hw3
// adapted from: https://www.geeksforgeeks.org/binary-heap/

import java.util.ArrayList;

public class run {
  public static void main(String[] args) {
    sortedPriorityQueue pQ = new sortedPriorityQueue();
    pQ.add(12);
    pQ.printStrings();
    pQ.add(1);
    pQ.printStrings();
    pQ.add(2);
    pQ.printStrings();
    pQ.add(13);
    pQ.printStrings();
    pQ.add(3);
    pQ.printStrings();
    pQ.add(4);
    pQ.printStrings();
    pQ.add(5);
    pQ.printStrings();
    System.out.println(pQ.remove());
    pQ.printStrings();
    System.out.println(pQ.remove());
    pQ.printStrings();
    System.out.println(pQ.remove());
    pQ.printStrings();
  }
}
