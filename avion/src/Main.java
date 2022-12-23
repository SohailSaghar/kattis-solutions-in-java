import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int j = 0;
        for (int i = 1; i <= 5; i++) {
            String s = sc.next();
            if (s.contains("FBI")) {
                out.print(i + " ");
                j++;
            }
        }
        if (j == 0) {
            out.println("HE GOT AWAY!");
        }
    }
}