public class BigO {
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        int n = 0;

        System.out.println("f(x)= 400n^3 + 3n + 2000. g(n)= 5n^5");

        for(int i =0; i<25; i++){
            a = (400 * (Math.pow(i,3))) + (3*i) + 2000;
            b = (5 * (Math.pow(i,5)));
            System.out.println("n= " + i + "  f(n) = " + a + "  g(n) = " + b);
            if(b < a){
                n++;
            }
        }
        if(b > a){
            System.out.println("g(n) surpassed f(n) at n= " + n);
        }else{
            System.out.println("g(n) did not surpass f(n)");
        }
    }
}
