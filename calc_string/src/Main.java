import java.util.Scanner;

public static void main(String[] args) {
    while(true) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input_data:");
        String input = in.nextLine();
        System.out.println("OutPut:" + CalcString(input));
    }
}

private static String CalcString(String Input) {
    try {
        String[] Members = CustomSplitCalc(Input);
        if (Members.length != 3) {
            throw new Exception("не верный формат");
        }

        if (Members[0].length() > 12) {
            throw new Exception("первая строка больше 10");
        }

        if (Members[2].length() > 12) {
            throw new Exception("вторая строка больше 10");
        }

        String FirstMember = Members[0];
        String SecondMember = Members[2];
        int MultsMember;
        String FiMe;
        String var10000;
        switch (Members[1]) {
            case "+":
                if (FirstMember.charAt(0) == '"' && FirstMember.charAt(FirstMember.length() - 1) == '"') {
                    if (SecondMember.charAt(0) == '"' && SecondMember.charAt(SecondMember.length() - 1) == '"') {
                        var10000 = FirstMember.substring(0, FirstMember.length() - 1);
                        return var10000 + SecondMember.substring(1);
                    }

                    throw new Exception("действие \"+\" второй элемент не является строкой");
                }

                throw new Exception("действие \"+\" первый элемент не является строкой");
            case "-":
                if (FirstMember.charAt(0) == '"' && FirstMember.charAt(FirstMember.length() - 1) == '"') {
                    if (SecondMember.charAt(0) == '"' && SecondMember.charAt(SecondMember.length() - 1) == '"') {
                        String FirMe = FirstMember.substring(1, FirstMember.length() - 1);
                        FiMe = SecondMember.substring(1, SecondMember.length() - 1);
                        var10000 = FirMe.replace(FiMe, "");
                        return "\"" + var10000 + "\"";
                    }

                    throw new Exception("действие \"-\" вторя строка строка не строка");
                }

                throw new Exception("действие \"-\" первая строка не строка");
            case "*":
                if (FirstMember.charAt(0) == '"' && FirstMember.charAt(FirstMember.length() - 1) == '"') {
                    MultsMember = -1;

                    try {
                        MultsMember = Integer.parseInt(SecondMember);
                    } catch (Exception var11) {
                        System.out.println(String.valueOf(var11) + "  второй обьекст не чесло");
                        System.exit(1);
                    }

                    if (MultsMember <= 0 && MultsMember >= 11) {
                        throw new Exception("число после знака действия не в диапазоне  [1:10]");
                    }

                    FiMe = FirstMember.substring(1, FirstMember.length() - 1);
                    String Outt = "";

                    for(int i = 0; i < MultsMember; ++i) {
                        Outt = Outt + FiMe;
                    }

                    if (Outt.length() > 40) {
                        Outt = Outt.substring(0, 40) + "...";
                    }

                    return "\"" + Outt + "\"";
                }

                throw new Exception("действие \"*\" первая строка не строка");
            case "/":
                if (FirstMember.charAt(0) == '"' && FirstMember.charAt(FirstMember.length() - 1) == '"') {
                    MultsMember = -1;

                    try {
                        MultsMember = Integer.parseInt(SecondMember);
                    } catch (Exception var10) {
                        System.out.println(String.valueOf(var10) + "  второй объект не число");
                        System.exit(1);
                    }

                    if (MultsMember <= 0 && MultsMember >= 11) {
                        throw new Exception("число после знака действия не в диапазоне  [1:10]");
                    }

                    FiMe = FirstMember.substring(1, FirstMember.length() - 1);
                    var10000 = FiMe.substring(0, FiMe.length() / MultsMember);
                    return "\"" + var10000 + "\"";
                }

                throw new Exception("действие \"/\" первая строка не строка");
        }
    } catch (Exception var12) {
        System.out.println(var12);
        System.exit(1);
    }

    return "GAG";
}

private static String[] CustomSplitCalc(String Input) {
    String[] VoidStr = new String[]{""};

    try {
        String[] Members = new String[]{"", "", ""};
        int i = 0;

        for (int asterix = 0; i < Input.length(); ++i) {
            if ('"' == Input.charAt(i)) {
                ++asterix;
            }

            if (('+' == Input.charAt(i) || '-' == Input.charAt(i) || '*' == Input.charAt(i) || '/' == Input.charAt(i)) && 0 == asterix % 2) {
                break;
            }
        }

        if (i != 0 && i != Input.length() - 1) {
            char var10002;
            if (Input.charAt(i - 1) != ' ') {
                var10002 = Input.charAt(i - 1);
                throw new Exception("тут должен быть пробел,  не " + var10002);
            } else if (Input.charAt(i + 1) != ' ') {
                var10002 = Input.charAt(i + 1);
                throw new Exception("после знака действия должен быть пробел, a не " + var10002);
            } else {
                Members[0] = Input.substring(0, i - 1);
                Members[1] = Input.substring(i, i + 1);
                Members[2] = Input.substring(i + 2);
                return Members;
            }
        } else {
            throw new Exception("цикл дошел до конца и не нашел знак математического действия");
        }
    } catch (Exception var5) {
        System.out.println(var5);
        System.exit(1);
        return VoidStr;
    }
}