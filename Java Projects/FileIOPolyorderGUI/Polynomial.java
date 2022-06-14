import java.util.Iterator;
import java.util.Scanner;

public class Polynomial implements Comparable, Iterable {
    Node front;
    public Polynomial(String input) {
        String [] poly = input.split(" ");
        Node lastNode = null;
        for (int i=0; i<poly.length; i++){
            double coefficeint;
            int exponent;
            int xAndExponentLoc = poly[i].indexOf("X^");

            if (xAndExponentLoc != -1){
                coefficeint = Double.parseDouble(poly[i].substring(0, xAndExponentLoc));
                exponent = Integer.parseInt(poly[i].substring(xAndExponentLoc + 2));
            }else if (poly[i].contains("x")){
                coefficeint = Double.parseDouble(poly[i].substring(0, poly[i].length()-1));
                exponent = 1;
            }else{
                coefficeint = Double.parseDouble(poly[i]);
                exponent = 0;
            }
            Node a = new Node(coefficeint,exponent);

            if (front == null){
                front = a;
            }else{
                lastNode.next = a;
            }
            lastNode = a;
        }
    }

    public static class Node{
        double coefficient;
        int exponent;
        Node next;
        Node(double c, int e){
            coefficient = c;
            exponent = e;
            next = null;
        }
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
