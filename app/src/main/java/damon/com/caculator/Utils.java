package damon.com.caculator;

import java.util.ArrayDeque;

/**
 * Created by King on 2017/8/29.
 */

public class Utils {
    MyClickListener myClickListener;
    public static double calulate(ArrayDeque<Double> nums,ArrayDeque<Character> characters){

        Double result = new Double(0);
        Double first,second,third;
        Character firstChar,secondChar;
        while(nums.size()>=3&&!MyClickListener.error){
            first = nums.removeFirst();
            second = nums.removeFirst();
            third = nums.removeFirst();
            firstChar = characters.removeFirst();
            secondChar = characters.removeFirst();
            if(isPriority(firstChar,secondChar)){
                if(secondChar.equals('*')){
                    second = second * third ;
                    nums.addFirst(second);
                    nums.addFirst(first);
                    characters.addFirst(firstChar);
                }
                if(secondChar.equals('/')){
                    if(third == 0) {
                        MyClickListener.error = true;
                        return 0;
                    }
                    else second = second / third ;
                    nums.addFirst(second);
                    nums.addFirst(first);
                    characters.addFirst(firstChar);
                }
            }
            else if(firstChar.equals('/')&&second == 0) {
                MyClickListener.error = true;
                return 0;
            }
            else {
                if(firstChar.equals('+')){
                    first = first + second;

                }
                if(firstChar.equals('-')){
                    first = first - second;

                }
                if(firstChar.equals('*')){
                    first = first * second;

                }
                if(firstChar.equals('/')){
                    first = first / second;
                }
                nums.addFirst(third);
                nums.addFirst(first);
                characters.addFirst(secondChar);
            }
        }
        first = nums.removeFirst();
        second = nums.removeFirst();
        firstChar = characters.getFirst();
        if(firstChar.equals('-')) result= first-second;
        if(firstChar.equals('+')) result= first+second;
        if(firstChar.equals('*')) result= first*second;
        if(firstChar.equals('/')) result= first/second;
        return result;
    }

    public static boolean isPriority(Character a,Character b){
        if((a.equals('+')||a.equals('-'))&&(b.equals('*')||b.equals('/'))) return true;
        return false;
    }
}
