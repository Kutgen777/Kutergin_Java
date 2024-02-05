// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static String calc(String input){

        String[]members=input.split(" ");
        if (members.length !=3)
            return "throws Exception";

        String []dictionaryList={
                "throws Exception","I","II","III","IV","V","VI","VII","VIII","IX","X","+","-","*","/",
                "0","1","2","3","4","5","6","7","8","9","10"};

        int firstMember=-1;
        int secondMember=-1;
        int actionMember=-1;

        for (int i=0;i<dictionaryList.length;i++){

            if(dictionaryList[i].equals(members[0])){
                firstMember=i;}

            if(dictionaryList[i].equals(members[2])){
                secondMember=i;}

            if(dictionaryList[i].equals(members[1])){
                actionMember=i;}
        }

        int maxIndex=Math.max(secondMember,firstMember);
        int minIndex=Math.min(secondMember,firstMember);


        if(firstMember ==-1 || secondMember ==-1 || actionMember==-1 ){
            return "throws Exception";
        }
        if((14 < maxIndex && 14 < minIndex)){

            int firstElemInt= firstMember-15;

            int secondElemInt=secondMember-15;

            return switch (actionMember) {
                case (11) -> Integer.toString(firstElemInt + secondElemInt);
                case (12) -> Integer.toString(firstElemInt - secondElemInt);
                case (13) -> Integer.toString(firstElemInt * secondElemInt);
                case (14) -> Integer.toString(firstElemInt / secondElemInt);
                default -> "throws Exception";
            };
        }

        if((11 > maxIndex && 11 > minIndex)){

            String []romanNubers10={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};

            return switch (actionMember) {
                case (11) -> romanNubers10[(firstMember + secondMember)/10]+dictionaryList[(firstMember + secondMember)%10] ;
                case (12) -> ((firstMember-secondMember)<0) ? "throws Exception": (romanNubers10[(firstMember - secondMember)/10]+dictionaryList[(firstMember - secondMember)%10]);
                case (13) -> romanNubers10[(firstMember * secondMember)/10]+dictionaryList[(firstMember * secondMember)%10] ;
                case (14) -> romanNubers10[(firstMember / secondMember)/10]+dictionaryList[(firstMember / secondMember)%10] ;
                default -> "throws Exception";
            };
        }
        return "throws Exception";
    }

    public static void main(String[] args) {

        //System.out.println(calc("ds"));

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        while (true){
            System.out.println("Input:");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            String outString=calc(input);

            if(outString.equals("throws Exception")){
                System.out.println(outString);
                return;
            }

            System.out.println("Output:\n"+outString);
        }
    }
}