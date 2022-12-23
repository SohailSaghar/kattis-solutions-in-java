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
        String s = sc.nextLine();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            arr.add(s.substring(i,i+1));
        }
        int a = arr.indexOf(" ");
        if (arr.get(a -1).equals("e")) {
            arr.set(a,"x");
        } else if (arr.get(a -1).equals("a") || arr.get(a -1).equals("i") || arr.get(a -1).equals("o") || arr.get(a -1).equals("u")) {
            arr.set(a-1,"e");
            arr.set(a,"x");
        } else if (arr.get(a -1).equals("x") && arr.get(a -2).equals("e")) {
            arr.remove(a);
        } else {
            arr.add(a,"ex");
            arr.remove(" ");
        }

        for (String i :
                arr) {
            out.print(i);
        }
    }
}