package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static void Decrease(String number,List<Integer> weights){
        for(int i =0;i<15;i++){
            if(Integer.parseInt(Character.toString(number.charAt(i)))==1){
                weights.set(i,weights.get(i)-1);
            }
        }
    }
    static void Increase(String number,List<Integer> weights){
        for(int i=0;i<15;i++){
            if(Integer.parseInt(Character.toString(number.charAt(i)))==1){
                weights.set(i,weights.get(i)+1);
            }
        }
    }
    static Boolean Proceed(String number,List<Integer> weights,int bias){
        int net = 0;
        for(int i = 0;i<15;i++){
            net+=Integer.parseInt(Character.toString(number.charAt(i)))*weights.get(i);
        }
        if(net>=bias){
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        int bias=-1;
        int one=0;
        int two=0;
        List<String> numbers= new ArrayList<>();
        numbers.add("111101101101111");
        numbers.add("001001001001001");
        numbers.add("111001111100111");
        numbers.add("111001111001111");
        numbers.add("101101111001001");
        numbers.add("111100111001111");
        numbers.add("111100111101111");
        numbers.add("111001001001001");
        numbers.add("111101111101111");
        numbers.add("111101111001111");

        List<String> imagesOfNumbers = new ArrayList<>();
        imagesOfNumbers.add("110001111001111");
        imagesOfNumbers.add("011001111001111");
        imagesOfNumbers.add("111001100001111");
        imagesOfNumbers.add("111001111000111");
        imagesOfNumbers.add("111001111001100");

        List<Integer> weights=new ArrayList<>();
        for(int i =0;i<15;i++){
            weights.add(0);
        }

        Random random = new Random();
        for(int i =0;i<30000;i++){
            int rand=random.nextInt(10);
            if(rand!=3){
                if(Proceed(numbers.get(rand),weights,bias)){
                    Decrease(numbers.get(rand),weights);
                }
                one++;
            }
            else{
                if(!Proceed(numbers.get(rand),weights,bias)){
                    Increase(numbers.get(rand),weights);
                }
                two++;
            }
        }
        System.out.println(weights);
        System.out.println("0 это 3 ? "+Proceed(numbers.get(0),weights,bias));
        System.out.println("1 это 3 ? "+Proceed(numbers.get(1),weights,bias));
        System.out.println("2 это 3 ? "+Proceed(numbers.get(2),weights,bias));
        System.out.println("3 это 3 ? "+Proceed(numbers.get(3),weights,bias));
        System.out.println("4 это 3 ? "+Proceed(numbers.get(4),weights,bias));
        System.out.println("5 это 3 ? "+Proceed(numbers.get(5),weights,bias));
        System.out.println("6 это 3 ? "+Proceed(numbers.get(6),weights,bias));
        System.out.println("7 это 3 ? "+Proceed(numbers.get(7),weights,bias));
        System.out.println("8 это 3 ? "+Proceed(numbers.get(8),weights,bias));
        System.out.println("9 это 3 ? "+Proceed(numbers.get(9),weights,bias));


        System.out.println("Узнал 3? "+Proceed(numbers.get(3),weights,bias));
        System.out.println("Узнал первый образ 3? "+Proceed(imagesOfNumbers.get(0),weights,bias));
        System.out.println("Узнал второй образ 3? "+Proceed(imagesOfNumbers.get(1),weights,bias));
        System.out.println("Узнал третьий образ 3? "+Proceed(imagesOfNumbers.get(2),weights,bias));
        System.out.println("Узнал четвертый 3? "+Proceed(imagesOfNumbers.get(3),weights,bias));
        System.out.println("Узнал пятый образ 3? "+Proceed(imagesOfNumbers.get(4),weights,bias));
        System.out.println(one);
        System.out.println(two);
    }
}
//[0, 0, 0, -5, 0, 2, 2, 2, 0, -2, 0, 2, 2, 2, 0]
//[1, 1, 0, -4, 0, 2, 1, 1, 0, -4, 0, 3, 1, 1, 0]
//[0, 0, 0, -6, 0, 1, 1, 2, 0, -6, 0, 3, 1, 1, 0]
