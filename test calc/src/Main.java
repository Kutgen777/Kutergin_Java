//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static String calc(String input) {
        try {
            String[] members = input.split(" ");
            if (members.length != 3) {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                String[] dictionaryList = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "+", "-", "*", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                int firstMember = -1;
                int secondMember = -1;
                int actionMember = -1;

                int maxIndex;
                for(maxIndex = 0; maxIndex < dictionaryList.length; ++maxIndex) {
                    if (dictionaryList[maxIndex].equals(members[0])) {
                        firstMember = maxIndex;
                    }

                    if (dictionaryList[maxIndex].equals(members[2])) {
                        secondMember = maxIndex;
                    }

                    if (dictionaryList[maxIndex].equals(members[1])) {
                        actionMember = maxIndex;
                    }
                }

                maxIndex = Math.max(secondMember, firstMember);
                int minIndex = Math.min(secondMember, firstMember);
                if (firstMember == -1) {
                    throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                } else if (secondMember == -1) {
                    throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                } else if (actionMember == -1) {
                    throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                } else {
                    int ret;
                    if (14 < maxIndex && 14 < minIndex) {
                        int firstElemInt = firstMember - 15;
                        ret = secondMember - 15;
                        String var12;
                        switch (actionMember) {
                            case 11:
                                var12 = Integer.toString(firstElemInt + ret);
                                break;
                            case 12:
                                var12 = Integer.toString(firstElemInt - ret);
                                break;
                            case 13:
                                var12 = Integer.toString(firstElemInt * ret);
                                break;
                            case 14:
                                var12 = Integer.toString(firstElemInt / ret);
                                break;
                            default:
                                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }

                        return var12;
                    } else if (11 > maxIndex && 11 > minIndex) {
                        String[] romanNubers10 = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
                        int var10000;
                        switch (actionMember) {
                            case 11:
                                var10000 = firstMember + secondMember;
                                break;
                            case 12:
                                var10000 = firstMember - secondMember;
                                break;
                            case 13:
                                var10000 = firstMember * secondMember;
                                break;
                            case 14:
                                var10000 = firstMember / secondMember;
                                break;
                            default:
                                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }

                        ret = var10000;
                        if (0 >= ret) {
                            throw new Exception("в римской системе нет отрицательных чисел и 0");
                        } else {
                            return romanNubers10[ret / 10] + dictionaryList[ret % 10];
                        }
                    } else {
                        throw new Exception("используются одновременно разные системы счисления");
                    }
                }
            }
        } catch (Exception var10) {
            System.out.println(var10);
            System.exit(1);
            return "";
        }
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Input:");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String outString = calc(input);
            System.out.println("Output:\n" + outString);
        }
    }
}
