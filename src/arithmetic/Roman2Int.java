package arithmetic;

import java.util.ArrayList;
import java.util.HashMap;

public class Roman2Int {

    /**
     * XX能并列，比较坑，最水的方法
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        char[] chars = s.toCharArray();

//        System.out.println(chars.length);

        char preMax = 'I';
        int result = 0;
        for (int i = chars.length-1; i>=0; i--) {
//            System.out.println(chars[i]);

            switch (chars[i]) {
                case 'I':
                    if(preMax == 'I'){
                        result += 1;
                    }
                    if(preMax == 'V'||preMax == 'X'){
                        result -= 1;
                    }
                    break;
                case 'V':
                    preMax ='V';
                    result += 5;
                    break;
                case 'X':
                    if(preMax == 'I'||preMax=='V'||preMax=='X'){
                        result += 10;
                        preMax = 'X';
                    }
                    if(preMax == 'L'||preMax=='C'){
                        result -= 10;
                    }

                    break;
                case 'L':
                    preMax = 'L';
                    result += 50;
                    break;
                case 'C':
                    if(preMax =='I'||preMax=='V'||preMax=='X'||preMax=='L'||preMax =='C'){
                        result += 100;
                        preMax = 'C';
                    }
                    if(preMax=='D'||preMax=='M'){
                        result -= 100;
                    }
                    break;
                case 'D':
                    if(preMax != 'M'){
                        preMax = 'D';
                    }
                    result += 500;
                    break;
                case 'M':
                    preMax = 'M';
                    result += 1000;
                    break;
            }
        }
        return result;
    }


    public int roman2Int(String s) {
        int result = 0;
        HashMap<String,Integer> chars = new HashMap<>();

        chars.put("A",0);
        chars.put("I",1);
        chars.put("V",5);
        chars.put("X",10);
        chars.put("L",50);
        chars.put("C",100);
        chars.put("D",500);
        chars.put("M",1000);

        char pre= 'A',current;

        for (int i = s.length()-1; i >=0; i--) {
            current = s.charAt(i);
            int valueCur = chars.get(new String(new char[]{current}));
            int valuePre = chars.get(new String(new char[]{pre}));
//            System.out.println(valuePre);

            if (valueCur >= valuePre) {
                result += valueCur;
            }else{
                result -= valueCur;
            }

            pre = current;
        }


        return result;

    }


    public static void main(String[] args) {

       Roman2Int roman2Int =  new Roman2Int();
        System.out.println(roman2Int.roman2Int("III"));
        System.out.println(roman2Int.roman2Int("IV"));
        System.out.println(roman2Int.roman2Int("IX"));
        System.out.println(roman2Int.roman2Int("LVIII"));
        System.out.println(roman2Int.roman2Int("MCMXCIV"));
    }

}
