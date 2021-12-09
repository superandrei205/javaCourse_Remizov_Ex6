import java.util.Scanner;

import java.util.Arrays;

public class Main {
    public static int count = 0;
    public static int lastCalcNumber;

    public static void main(String[] args) {
        startCalc();
    }

    public static void startCalc() {
        count++;
        System.out.println("1. Ввести пример \n" +
                "2. Продолжить работать с предыдущим ответом \n" +
                "3. Выход\n");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (toInt(input) == 1) {

            System.out.println("Введите пример");
            Scanner scanCalc = new Scanner(System.in);
            String inputCalc = scanCalc.nextLine();
            String[] arrayInput = inputCalc.trim().split("");
            String[] removedNull = Arrays.stream(arrayInput)
                    .filter(value ->
                            " ".equals(value) == false
                    )
                    .toArray(size -> new String[size]);

            if (removedNull.length == 2 && removedNull[1].equals('!')) {
                lastCalcNumber = getFactorial(toInt(removedNull[0]));
                System.out.println(removedNull[0] + " ! " + " = " + lastCalcNumber);
                startCalc();
            } else if (removedNull.length == 3) {
                switch (removedNull[1].charAt(0)) {
                    case '+':
                        lastCalcNumber = addition(toInt(removedNull[0]), toInt(removedNull[2]));
                        System.out.println(removedNull[0] + " + " + removedNull[2] + " = " + lastCalcNumber);
                        startCalc();
                        break;
                    case '-':
                        lastCalcNumber = subtraction(toInt(removedNull[0]), toInt(removedNull[2]));
                        System.out.println(removedNull[0] + " - " + removedNull[2] + " = " + lastCalcNumber);
                        startCalc();
                        break;
                    case '*':
                        lastCalcNumber = multiplication(toInt(removedNull[0]), toInt(removedNull[2]));
                        System.out.println(removedNull[0] + " * " + removedNull[2] + " = " + lastCalcNumber);
                        startCalc();
                        break;
                    case '/':
                        lastCalcNumber = division(toInt(removedNull[0]), toInt(removedNull[2]));
                        System.out.println(removedNull[0] + " / " + removedNull[2] + " = " + lastCalcNumber);
                        startCalc();
                        break;
                    case '^':
                        lastCalcNumber = pow(toInt(removedNull[0]), toInt(removedNull[2]));
                        System.out.println(removedNull[0] + " ^ " + removedNull[2] + " = " + lastCalcNumber);
                        startCalc();
                        break;
                    case '?':
                        System.out.println(removedNull[0] + " ? " + removedNull[2] + " = " + getComparison(toInt(removedNull[0]), toInt(removedNull[2])));
                        startCalc();
                        break;
                    default:
                        System.out.println("Операция не распознана. Повторите ввод.");
                }
            }
        }
        if (toInt(input) == 2) {
            if (count == 0) {
                System.out.println("Недоступно");
            } else {
                System.out.println("1. Сложение \n" +
                        "2. Вычитание \n" +
                        "3. Умножение\n" +
                        "4. Деление \n" +
                        "5. Факториал\n" +
                        "6. Возведение в степень \n" +
                        "7. Сравнение\n" +
                        "0. Назад\n");
                Scanner scanCalc = new Scanner(System.in);
                String inputOperation = scanCalc.nextLine();
                int prevVal = lastCalcNumber;
                if (toInt(inputOperation) == 5) {
                    lastCalcNumber = getFactorial(prevVal);
                    System.out.println(lastCalcNumber);
                    startCalc();
                } else if (
                        toInt(inputOperation) == 1 ||
                                toInt(inputOperation) == 2 ||
                                toInt(inputOperation) == 3 ||
                                toInt(inputOperation) == 4 ||
                                toInt(inputOperation) == 6 ||
                                toInt(inputOperation) == 7
                ) {
                    System.out.println("Введите второе число");
                    Scanner scanForNextOperation = new Scanner(System.in);
                    String operationNum = scanForNextOperation.nextLine();
                    switch (toInt(inputOperation)) {
                        case 1:
                            lastCalcNumber = addition(prevVal, toInt(operationNum));
                            System.out.println("\"+\" - " + prevVal + " + " + operationNum + " = " + lastCalcNumber);
                            startCalc();
                            break;
                        case 2:
                            lastCalcNumber = subtraction(prevVal, toInt(operationNum));
                            System.out.println("\"-\" - " + prevVal + " - " + operationNum + " = " + lastCalcNumber);
                            startCalc();
                            break;
                        case 3:
                            lastCalcNumber = multiplication(prevVal, toInt(operationNum));
                            System.out.println("\"*\" - " + prevVal + " * " + operationNum + " = " + lastCalcNumber);
                            startCalc();
                            break;
                        case 4:
                            lastCalcNumber = division(prevVal, toInt(operationNum));
                            System.out.println("\"/\" - " + prevVal + " / " + operationNum + " = " + lastCalcNumber);
                            startCalc();
                            break;
                        case 6:
                            lastCalcNumber = pow(prevVal, toInt(operationNum));
                            System.out.println("\"^\" - " + prevVal + " ^ " + operationNum + " = " + lastCalcNumber);
                            startCalc();
                            break;
                        case 7:
                            System.out.println("\"?\" - " + prevVal + " ? " + operationNum + " = " + getComparison(prevVal, toInt(operationNum)));
                            startCalc();
                            break;
                        default:
                            System.out.println("Операция не распознана. Повторите ввод.");
                    }
                }

            }

        }
        if (toInt(input) == 3) {
            System.out.println("Good bye!");
            return;
        }

    }

    public static int toInt(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            return i;

        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
            return 0;
        }
    }

    public static String createTextAnswer(String num1, String operator, String num2, String equal) {
        return "\" " + operator + "\" " + "- " + num1 + " " + operator + " " + num2 + " = " + equal;
    }

    public static int addition(int x, int y) {
        return x + y;
    }

    public static int subtraction(int x, int y) {
        return x - y;
    }

    public static int multiplication(int x, int y) {
        return x * y;
    }

    public static int division(int x, int y) {
        return x / y;
    }

    public static int pow(int value, int powValue) {
        return (int) Math.pow(value, powValue);
    }

    public static int getFactorial(int f) {
        if (f <= 1) {
            return 1;
        } else {
            return f * getFactorial(f - 1);
        }
    }

    public static String getComparison(int num1, int num2) {
        if (num1 > num2) {
            return Integer.toString(num1) + " > " + Integer.toString(num2);
        } else if (num2 > num1) {
            return Integer.toString(num1) + " < " + Integer.toString(num2);
        } else {
            return Integer.toString(num1) + " = " + Integer.toString(num2);
        }
    }

}


