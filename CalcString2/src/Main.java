// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.


        // Press Shift+F10 or click the green arrow button in the gutter to run the code.


        while(true) {
            Scanner in = new Scanner(System.in);

            System.out.print("Input_data:");
            String input = in.nextLine();

            //CustomSplitCalc(input);


            System.out.println("OutPut:"+CalcString(input));
        }
    }

    private static String CalcString(String Input){

        try {

            String[]Members=CustomSplitCalc(Input);

            // for (int i=0; i<Members.length;i++)
            // System.out.println(Members[i]);

            if (Members.length !=3)
                throw  new Exception("не верный формат");

            if(Members[0].length()>12)
                throw new Exception("первая строка больше 10");// два символа отнимают ""

            if(Members[2].length()>12)
                throw new Exception("вторая строка больше 10");// два символа отнимают ""

            String FirstMember=Members[0];
            String SecondMember=Members[2];

            switch (Members[1]){
                case "+"://сложение может происходить только тогда когда оба члена евляются строками
                    if(FirstMember.charAt(0) =='\"' && FirstMember.charAt(FirstMember.length()-1) =='\"'){
                        if(SecondMember.charAt(0) =='\"' && SecondMember.charAt(SecondMember.length()-1) =='\"'){
                            return FirstMember.substring(0,FirstMember.length()-1) +SecondMember.substring(1);
                        }else{
                            throw new Exception("действие \"+\" второй элемент не является строкой");
                        }
                    }else{
                        throw new Exception("действие \"+\" первый элемент не является строкой");
                    }

                case "-"://вычитание может происходить только тогда когда оба члена являются строками

                    if (FirstMember.charAt(0) == '\"' && FirstMember.charAt(FirstMember.length() - 1) == '\"') {

                        if (SecondMember.charAt(0) == '\"' && SecondMember.charAt(SecondMember.length() - 1) == '\"') {
                            String FiMe=FirstMember.substring(1, FirstMember.length() - 1);
                            String SeMe=SecondMember.substring(1, SecondMember.length() - 1);

                            return "\""+FiMe.replace(SeMe,"")+"\"";

                        } else {
                            throw new Exception("действие \"-\" вторя строка строка не строка");
                        }
                    } else {
                        throw new Exception("действие \"-\" первая строка не строка");
                    }

                case "*"://умножение может происходить только тогда когдапервый член это строка а второй число
                    if (FirstMember.charAt(0) == '\"' && FirstMember.charAt(FirstMember.length() - 1) == '\"') {

                        int MultsMember=-1;
                        try {
                            MultsMember=Integer.parseInt(SecondMember);
                        }catch (Exception e){
                            System.out.println(e+"  второй обьекст не чесло");
                            System.exit(1);
                        }


                        if (MultsMember>0 || MultsMember <11) {

                            String FiMe=FirstMember.substring(1, FirstMember.length() - 1);

                            String Outt="";
                            for (int i=0;i<MultsMember;i++)
                                Outt+= FiMe;

                            if(Outt.length()>40)
                                Outt = Outt.substring(0,40)+"...";

                            return "\""+Outt+"\"";

                        } else {
                            throw new Exception("число после знака действия не в диапазоне  [1:10]");
                        }
                    } else {
                        throw new Exception("действие \"*\" первая строка не строка");
                    }


                case "/"://деление может происходить только тогда когда первый член это строка а второй число
                    if (FirstMember.charAt(0) == '\"' && FirstMember.charAt(FirstMember.length() - 1) == '\"') {

                        int MultsMember=-1;
                        try {
                            MultsMember=Integer.parseInt(SecondMember);
                        }catch (Exception e){
                            System.out.println(e+"  второй объект не число");
                            System.exit(1);
                        }


                        if (MultsMember>0 ||MultsMember <11) {


                            String Outt=FirstMember.substring(1, FirstMember.length() - 1);
                            return "\""+ Outt.substring(0,Outt.length()/ MultsMember)+"\"";

                        } else {
                            throw new Exception("число после знака действия не в диапазоне  [1:10]");
                        }
                    } else {
                        throw new Exception("действие \"/\" первая строка не строка");
                    }


            };


        }catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }




        return "GAG";
    }

    // разделяет строку на массив из трех строк, первая строка это объект до мат знака
    // второй это сам мат знак
    // третий это объект после мат знака
    //примечание: разделительные пробелы удаленны
    private static String[] CustomSplitCalc(String Input){
        String[] VoidStr = {""};
        try {

            String[] Members = {"", "", ""};

            int i = 0;
            for (; i < Input.length(); i++) {

                if ('+' == Input.charAt(i) || '-' == Input.charAt(i) || '*' == Input.charAt(i) || '/' == Input.charAt(i))
                    break;
            }

            if (i == 0 || i == Input.length() - 1) {
                throw new Exception("цикл дошел до конца и не нашел знак математического действия");
            }

            if (Input.charAt(i - 1) != ' ') {
                throw new Exception("тут должен быть пробел,  не " + Input.charAt(i - 1));
            }

            if (Input.charAt(i + 1) != ' ') {
                throw new Exception("после знака действия должен быть пробел, a не " + Input.charAt(i + 1));
            }


            Members[0] = Input.substring(0, i - 1);
            Members[1] = Input.substring(i, i + 1);
            Members[2] = Input.substring(i + 2);

            //System.out.println(Members[0]);
            //System.out.println(Members[1]);
            //System.out.println(Members[2]);

            return Members;


        }catch (Exception e){
            System.out.println(e);
            System.exit(1);
        }


        return VoidStr;
    }

}