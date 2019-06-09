package by.belstu.it.agapkina.basejava;

import static java.lang.Math.*;

import java.sql.Wrapper;
import java.util.Arrays;

/**
 * @author Diana Agapkina
 * @version 1.0
 */
public class JavaTest {
    /**
     * @value 0
     * @see WrapperString
     */
    static int sint;

    //task c
    final int CONST1 = 5;                //видны всем классам в текущем пакете
    public final int CONST2 = 6;         //видны другим классам из текущего пакета и из внешних пакетов
    public static final int CONST3 = 7;  //обращение к ней идет без создания объекта класса

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //task b
        char c1 = 'a';
        char c2 = '\u0061';
        char c3 = 97;
        int i = 15;
        double d = 1.5;
        short s = 10;
        byte by = 1;
        long l = 50;
        boolean bo1 = true;
        boolean bo2 = false;

        System.out.println("String + int" + i);
        System.out.println("String + char" + c1);
        System.out.println("String + double" + d);

        byte t1 = (byte) (by + i);
        int t2 = (int) (d + l);
        long t3 = i + 2147483647L;

        System.out.println(sint);

        boolean t4 = bo1 && bo2;
        boolean t5 = bo1 ^ bo2;
        //boolean t6 = bo1 + bo2;   !!! wrong

        long t6 = 9223372036854775807L;
        long t7 = 0x7ffffffffffL;

        System.out.println("c1 = " + c1 + "; c2 = " + c2 + "; c3 = " + c3);
        System.out.println(c1 + c2 + c3);

        System.out.println((int) (3.45 % 2.4));
        System.out.println((1.0 / 0.0));
        System.out.println((0.0 / 0.0));
        System.out.println((Math.log(-345)));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        System.out.println("__________________________________");

        //task d
        System.out.println(Math.round(Math.PI));
        System.out.println(Math.round(Math.E));
        System.out.println(Math.min(Math.PI, Math.E));
        System.out.println(Math.random() * 1);
        System.out.println("__________________________________");

        //task e
        Boolean bb = true;
        Integer ii = 6;
        Byte byt = 2;
        Short ss = 5;
        Long ll = 80L;
        Double dd = 15.18;

        System.out.println("6 >>> 2 = " + (ii >>> byt) + "; 6 >> 2 = " + (ii >>> byt));
        System.out.println("~5 = " + ~ss + "; 6 & 5 = " + (ii & ss));
        System.out.println("min long: " + Long.MIN_VALUE + "; max long: " + Long.MAX_VALUE);
        System.out.println("min double: " + Double.MIN_VALUE + "; max double: " + Double.MAX_VALUE);

        int t8 = new Integer(6);
        byte t9 = new Byte((byte) 2);

        System.out.println(Integer.parseInt("55"));
        System.out.println(Integer.toHexString(11));
        System.out.println(Integer.compare(5, 2));          //a>b = 1; a==b - 0; a<b = -1
        System.out.println(Integer.toString(ii));
        System.out.println("binary = " + Integer.toBinaryString(12) + "; num of one bits " + Integer.bitCount(12));
        System.out.println("__________________________________");

        //task f
        String t10 = "2345";
        Integer t11 = new Integer(t10);  //конструктор
        Integer t12 = Integer.valueOf(t10);
        Integer t13 = Integer.parseInt(t10);

        byte[] t14 = t10.getBytes();
        System.out.println("string to bit array:" + Arrays.toString(t14));
        String t15 = new String(t14);
        System.out.println("bits to string: " + t15);

        String t16 = "true";
        Boolean t17 = new Boolean(t10);
        Boolean t18 = Boolean.valueOf(t16);

        System.out.println(t10 == t16);
        System.out.println(t10.equals(t16));
        System.out.println(t10.compareTo(t16));

        String t19 = "hello world";

        String[] words = t19.split(" ");
        for (String word : words) System.out.println(word);

        if (t19.contains("hello")) System.out.println("yes");
        else System.out.println("no");

        System.out.println(t19.hashCode());
        System.out.println(t19.indexOf('w'));
        System.out.println(t19.length());
        System.out.println(t19.replace("hello", "bye"));
        System.out.println("__________________________________");

        //task g
        int[] t20 = new int[0];
        //t23[1] = 5;

        char[][] t21 = new char[3][];
        for (int j = 0; j < 3; j++) t21[j] = new char[j + 1];
        System.out.println(t21.length);
        System.out.println("0-str: " + t21[0].length + "; 1-str: " + t21[1].length + "; 2-str: " + t21[2].length);

        char[] t22[] = {{'a', 'b', 'c'}, {'d', 'e', 'f'}};
        char t23[][] = {{'a', 'b', 'c'}, {'d', 'e', 'f'}};

        System.out.println(t22 == t23);
        t22 = t23;
        System.out.println(t22 == t23);

        for (char[] symb : t22) System.out.println(symb);
        System.out.println("__________________________________");

        //task h
        WrapperString t24 = new WrapperString("Hello");
        System.out.println(t24.replace('H', 'h'));

        WrapperString t25 = new WrapperString("String") {
            @Override
            public String replace(char oldchar, char newchar) {
                return super.replace(oldchar, newchar);
            }

            public Character delete(char newchar) { return newchar; }
        };

        System.out.println(t25.replace('S', 's'));
    }
}
