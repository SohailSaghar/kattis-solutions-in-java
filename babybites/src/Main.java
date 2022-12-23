import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr.add(sc.next());
        }
        int mumble = 0;
        int numbers = 0;
        for (int i = 1; i <= n; i++) {
            if (arr.get(i-1).equals("" + i) || numbers+mumble==i){
                numbers++;
            } else if (arr.get(i-1).equals("mumble") || numbers+mumble==i) {
                mumble++;
            } else {
                System.out.println("something is fishy");
                return;
            }
        }
        System.out.println("makes sense");
    }
}