
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        int A = arr.get(0);
        int B = arr.get(1);
        int C = arr.get(2);
        String s = sc.next();
        for (int i = 0; i < 3; i++) {
            if (s.charAt(i) == 'A') {
                System.out.println(A);
            } else if (s.charAt(i) == 'B') {
                System.out.println(B);
            } else {
                System.out.println(C);
            }
        }
    }
}

