import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static String calc(String input){
        try {

            String[] members = input.split(" ");
            if (members.length != 3)
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            String[] dictionaryList = {
                    "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "+", "-", "*", "/",
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

            int firstMember = -1;
            int secondMember = -1;
            int actionMember = -1;

            for (int i = 0; i < dictionaryList.length; i++) {

                if (dictionaryList[i].equals(members[0]))
                    firstMember = i;

                if (dictionaryList[i].equals(members[2]))
                    secondMember = i;

                if (dictionaryList[i].equals(members[1]))
                    actionMember = i;
            }

            int maxIndex = Math.max(secondMember, firstMember);
            int minIndex = Math.min(secondMember, firstMember);

            if (firstMember == -1 )
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            if (secondMember == -1)
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            if (actionMember == -1)
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");


            if ((14 < maxIndex && 14 < minIndex)) {

                int firstElemInt = firstMember - 15;
                int secondElemInt = secondMember - 15;

                return switch (actionMember) {
                    case (11) -> Integer.toString(firstElemInt + secondElemInt);
                    case (12) -> Integer.toString(firstElemInt - secondElemInt);
                    case (13) -> Integer.toString(firstElemInt * secondElemInt);
                    case (14) -> Integer.toString(firstElemInt / secondElemInt);
                    default -> throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                };
            }

            if((11 > maxIndex && 11 > minIndex)) {

                String[] romanNubers10 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};

                int ret = switch (actionMember) {
                    case (11) -> ( firstMember + secondMember);
                    case (12) -> ( firstMember - secondMember);
                    case (13) -> ( firstMember * secondMember);
                    case (14) -> ( firstMember / secondMember);
                    default -> throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                };

                if(0>=ret){
                    throw  new Exception("в римской системе нет отрицательных чисел и 0");
                }

                return romanNubers10[ret/10]+dictionaryList[ret%10];
            }
            throw new Exception("используются одновременно разные системы счисления");


        }catch (Exception ex){
            System.out.println(ex);
            System.exit(1);

        }
        return "";
    }

    public static void main(String[] args) {

        while (true){
            System.out.println("Input:");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String outString=calc(input);
            System.out.println("Output:\n"+outString);

        }
    }
}
