
import java.util.HashMap;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));


    }
    public static String calc(String x) throws Exception {
        String input1 = x.replaceAll(" ", "");


        String[] h = input1.split("\\s+|(?=[-+*/:?<>])|(?<=[-+*/:?<>])");

        if (h.length != 3 ){
            throw new Exception();
        }
        HashMap<String, Integer> arab = new HashMap<>();
        arab.put("I", 1);
        arab.put("II", 2);
        arab.put("III", 3);
        arab.put("IV", 4);
        arab.put("V", 5);
        arab.put("VI", 6);
        arab.put("VII", 7);
        arab.put("VIII", 8);
        arab.put("IX", 9);
        arab.put("X", 10);
        String rim =  ("1234567890") ;



        if (((arab.containsKey(h[0])==false) && (arab.containsKey(h[2])==true)) || ((arab.containsKey(h[0])==true) &&(arab.containsKey(h[2])==false))){
            throw new Exception();
        }


        if ((h[1].equals("*")==false) && (h[1].equals("/")==false) && (h[1].equals("+")==false) && (h[1].equals("-")==false)){
            throw new Exception();
        }





        if (arab.containsKey(h[0]) == false) {
            String[] g =h[0].split("");
            String[] e= h[2].split("");
            if ((g.length>2) || (e.length>2) ||(rim.contains(g[0])==false)||(rim.contains(e[0])==false)) {
                throw new Exception();
            }

            int ch1=Integer.valueOf(h[0]);
            int ch2=Integer.valueOf(h[2]);

            String v = "";
            {
                if (ch1> 10 || ch1 < 0 || ch2 > 10 || ch2 < 0) {
                    throw new Exception();
                }
            }



            switch (h[1]) {
                case "+":
                    v = Integer.toString(ch1 + ch2);
                    break;
                case "-":
                    v = Integer.toString(ch1 - ch2);
                    break;
                case "/":
                    v = Integer.toString(ch1 / ch2);
                    break;
                case "*":
                    v = Integer.toString(ch1 * ch2);
                    break;


            }
            return v;



        }


        else {

            if (((arab.containsKey(h[0]))==false) || ((arab.containsKey(h[2]))==false)){
                throw new Exception();
            }

            int c;
            String b;
            String t = "";
            switch (h[1]) {
                case "+":
                    c = arab.get(h[0]) + arab.get(h[2]);
                    t = (obrazovanie(c));

                    break;
                case "-":

                    c = (arab.get(h[0]) - arab.get(h[2]));
                    if (arab.get(h[0]) < arab.get(h[2])) {
                        throw new Exception();
                    }

                    t = (obrazovanie(c));

                    break;
                case "*":
                    c = (arab.get(h[0]) * arab.get(h[2]));

                    t = (obrazovanie(c));


                    break;
                case "/":
                    c = (arab.get(h[0]) / arab.get(h[2]));
                    t = (obrazovanie(c));

                    break;


            }
            chislo ="";
            return t;




        }
    }











    static String chislo= "";
    static String obrazovanie(int k) {
        ;
        if (k == 0) {
            return "0";
        }


        if (k - 100 >= 0) {

            chislo += "C";
            obrazovanie(k - 100);
        } else if (k - 90 >= 0) {
            chislo += "XC";
            obrazovanie(k - 90);
        } else if (k - 50 >= 0) {
            chislo += "L";
            obrazovanie(k - 50);
        } else if (k-40>=0){
            chislo +="XL";
            obrazovanie(k-40);
        }
        else if (k - 10 > 0) {

            chislo += "X";
            obrazovanie(k - 10);

        } else if (10 - k >= 0) {
            switch (k) {

                case 1:
                    chislo += "I";
                    break;

                case 2:
                    chislo += "II";
                    break;

                case 3:
                    chislo += "III";
                    break;

                case 4:
                    chislo += "IV";
                    break;

                case 5:
                    chislo += "V";
                    break;

                case 6:
                    chislo += "VI";
                    break;

                case 7:
                    chislo += "VII";
                    break;

                case 8:
                    chislo += "VIII";
                    break;

                case 9:
                    chislo += "IX";
                    break;

                case 10:
                    chislo += "X";
                    break;


            }

        }


        return chislo;


    }
}