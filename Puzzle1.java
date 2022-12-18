import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Puzzle1 {

    static Stack<NewList> stkLeft = new Stack<NewList>();
    static Stack<NewList> stkRight = new Stack<NewList>();
    static NewList listLeft = new NewList();
    static NewList listRight = new NewList();

    
    static char LorR = 'L';

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Puzzle1\\test.txt");
        Scanner input = new Scanner(file);

        int index = 1;

        

        while (input.hasNextLine()) {

            stkLeft.push(listLeft);
            stkRight.push(listRight);

            LorR = 'L';
            String leftStr = input.nextLine();
            leftStr = leftStr.replace(",", "");
            leftStr = leftStr.substring(1, leftStr.length());
            char[] leftChar = leftStr.toCharArray();
            for(char c: leftChar){
                fillList(c);
            }
            // System.out.println(leftStr);


            LorR = 'R';
            String rightStr = input.nextLine();
            rightStr = rightStr.replace(",", "");
            rightStr = rightStr.substring(1, rightStr.length());
            char[] rightChar = rightStr.toCharArray();
            for(char c: rightChar){
                fillList(c);
            }
            // System.out.println(rightStr);

            // for(Object o : listLeft.getValues()){
            //     System.out.println(o.toString());
            // }

            System.out.println(index);
            boolean tf = NewList.compareTo(listLeft, listRight);
            System.out.println(tf);
            System.out.println(NewList.compareTo(listLeft, listRight));
            System.out.println();

            index++;
            if(input.hasNextLine()){
                
                input.nextLine();
            }

            stkLeft.clear();
            stkRight.clear();
            listLeft.clearList();
            listRight.clearList();

        }

        
    }
    

    public static void fillList(char c){

        if(c == '['){

            NewList nList = new NewList();
            if(LorR == 'L'){
                // System.out.println("NewList Add & Push");
                stkLeft.peek().addList(nList);
                stkLeft.push(nList);
            } else {
                stkRight.peek().addList(nList);
                stkRight.push(nList);
            }

        } else if (c == ']'){

            if(LorR == 'L'){
                // System.out.println("NewList Pop");
                stkLeft.pop();
            } else {
                stkRight.pop();
            }

        } else {
            int num = Character.getNumericValue(c);
            if(LorR == 'L'){
                // System.out.println("Int Add");
                stkLeft.peek().addValue(num);
            } else {
                stkRight.peek().addValue(num);
            }
        }
    }
}