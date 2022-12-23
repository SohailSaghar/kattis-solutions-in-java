import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == '<') {
                stack.pop();
            } else {
                stack.push(s.substring(i,i+1));
            }
        }
        int b = stack.size();
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < b; i++) {
             c.append(stack.pop());
        }
        System.out.println(c.reverse());
    }
}