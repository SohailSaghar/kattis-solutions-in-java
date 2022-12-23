import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i+=2) {
            switch (s.substring(i, i + 2)) {
                case "A1":a++; break;
                case "A2":a += 2; break;
                case "B1":b++;break;
                case "B2":b += 2;break;
            }
            if (a >= 11 && Math.abs(a-b) >= 1) {
                System.out.println("A");
                return;
            } else if (b >= 11 && Math.abs(a-b) >= 1) {
                System.out.println("B");
                return;
            }
        }
    }
}