import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        doOpeation(in.nextLine());
//        tests();
    }

    private static void doOpeation(String str) {

        Matcher m = Pattern.compile("^([0-9]+) ([+\\-*/]) ([0-9]+)$").matcher(str);
        if (m.find()) {
            int first = Integer.parseInt(m.group(1));
            String arithmeticOperation = m.group(2);
            int second = Integer.parseInt(m.group(3));
            if (first > 10 | first < 1 | second > 10 | second < 1) {
                throw new RuntimeException("over 10 or less 1");
            }
            switch (arithmeticOperation) {
                case "+" -> System.out.println(second + first);
                case "*" -> System.out.println(first * second);
                case "-" -> System.out.println(first - second);
                case "/" -> System.out.println(first / second);
            }

        } else {
            throw new RuntimeException("worng");
        }
    }

    private static void tests() {
        doOpeation("1 - 10");
        doOpeation("1 + 2");
        doOpeation("1 * 2");
        try {
            doOpeation("1");
        } catch (RuntimeException runtimeException) {
            System.out.println("'1' не прошло = " + runtimeException.getMessage());
        }
        try {
            doOpeation("1 + 2 + 1");
        } catch (RuntimeException runtimeException) {
            System.out.println("'1 + 2 + 1' не прошло = " + runtimeException.getMessage());
        }
        try {
            doOpeation("1+1");
        } catch (RuntimeException runtimeException) {
            System.out.println("'1+1' не прошло = " + runtimeException.getMessage());
        }
    }
}
