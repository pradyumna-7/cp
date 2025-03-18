import java.util.*;
import java.math.*;
class Solution{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger fact = BigInteger.ONE;
        int i=2;
        while(i<=n){
            fact = fact.multiply(BigInteger.valueOf(i));
            i++;
        }
        System.out.println(fact);
    }
}