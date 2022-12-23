import java.util.*;
import java.io.*;
import java.math.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;


public class Main {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio(System.in, System.out);
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.nextLine().split("");
        String[] s2 = sc.nextLine().split("");
        Set<String> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < s2.length && i < s.length) {
            if (s[i].equals(s2[j])) {
                i++;
                j++;
            } else {
                if (s[i - 1].equals(s2[j])) {
                    set.add(s[i-1]);
                    j++;
                }
            }
        }
        if (i == s.length && j!=s2.length) {
            set.add(s2[j]);
        }
        for (String k :
                set) {
            System.out.print(k);
        }


    }
/**
 * Mængden af whitespace er ligegyldt så længde er
 * er mindst 1 og hvis det kommer i slutningen af linjen er det også ligegyldt
 */

    /** Simple yet moderately fast I/O routines.
     *
     * Example usage:
     *
     * Kattio io = new Kattio(System.in, System.out);
     *
     * while (io.hasMoreTokens()) {
     *    int n = io.getInt();
     *    double d = io.getDouble();
     *    double ans = d*n;
     *
     *    io.println("Answer: " + ans);
     * }
     *
     * io.close();
     *
     *
     * Some notes:
     *
     * - When done, you should always do io.close() or io.flush() on the
     *   Kattio-instance, otherwise, you may lose output.
     *
     * - The getInt(), getDouble(), and getLong() methods will throw an
     *   exception if there is no more data in the input, so it is generally
     *   a good idea to use hasMoreTokens() to check for end-of-file.
     *
     * @author: Kattis
     */



    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public boolean hasMoreTokens() {
            return peekToken() != null;
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }



        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) { }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
    // Remove whitespace or whatever character
    public static String removeCharacter(String sentence, String character) {
        return sentence.replaceAll(character,"");
    }
    //digit sum to 1 digit
    public static int digitSumto1(int n)
    {
        int sum = 0;

        // Loop to do sum while
        // sum is not less than
        // or equal to 9
        while (n > 0 || sum > 9)
        {
            if (n == 0) {
                n = sum;
                sum = 0;
            }
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    //Digitsum
    public static int calculateDigitSum(int number) {
        int digitSum = 0;

        while (number > 0) {
            digitSum = digitSum + (number % 10);
            number = number / 10;
        }

        return digitSum;
    }

    // Reverse string
    public static String reverseString(String s) {
        return new StringBuffer(s).reverse().toString();
    }
    // can calculate strings so "2+2" = 4
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}