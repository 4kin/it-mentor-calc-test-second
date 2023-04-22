import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.management.Query.or;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        doOpeation(in.nextLine());
//        String str = "2+2";
//        doOpeation("1+2");
//        doOpeation("1 +2");
//        doOpeation("1+ 2");
//        doOpeation("1");
//        doOpeation("1 +2 1");
//        doOpeation("1+2+1");


    }

    private static void doOpeation(String str) {
        Matcher m = Pattern.compile("^([0-9]+)\s*([+,-,*,/])\s*([0-9]+)$").matcher(str);
        if (m.find()) {
            int first = Integer.parseInt(m.group(1));
            String arithmeticOperation = m.group(2);
            int second = Integer.parseInt(m.group(3));
            if (first > 10 | first < 1 | second > 10 | second < 1) {
                throw new RuntimeException("over 10 or less 1");
            }
            if (arithmeticOperation.equals("+")) {
                System.out.println((second + first));
            } else if (arithmeticOperation.equals("*")) {
                System.out.println((first * second));
            } else if (arithmeticOperation.equals("-")) {
                System.out.println((first - second));
            } else if (arithmeticOperation.equals("/")) {
                System.out.println((first / second));
            }
        } else {
            throw new RuntimeException("worng");
        }
    }


}
