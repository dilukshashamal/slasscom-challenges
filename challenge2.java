import java.util.*;

public class challenge2 {
//    main method
    public static void main(String[] cha2){

        String inputPare;

//      scan parenthesis
        Scanner sc = new Scanner(System.in);
        inputPare = sc.nextLine();

        System.out.println("Enter parenthesis:");
        inputPare = sc.nextLine();

//      get output
        if(checkParenthesis(inputPare))
            System.out.println("true");
        else
            System.out.println("false");


    }

    public static boolean checkParenthesis(String inPar){

//      create empty stack
        Stack st = new Stack();
//      convert char array
        char[] inputArray = inPar.toCharArray();
//      get parenthesis
        char getPare;

//      check input arrays and check closed parenthesis
        for(int i=0; i < inputArray.length; i++){
//          get current parenthesis
            char currentPare = inputArray[i];

//          check current parenthesis
            if(currentPare == '(' || currentPare == '[' || currentPare == '{'){

//              push current parenthesis
                st.push(currentPare);
//              if it is not parenthesis, need to continue
                continue;
            }

//          check closed parenthesis
            switch (currentPare){
                case ')':
                    getPare = (char)st.pop();
                    if(getPare == '{' || getPare == '[')
                        return false;
                    break;

                case ']':
                    getPare = (char)st.pop();
                    if(getPare == '(' || getPare == '{')
                        return false;
                    break;

                case '}':
                    getPare = (char)st.pop();
                    if(getPare == '[' || getPare == '(')
                        return false;
                    break;

            }
        }

//      whether it is empty parenthesis get true value
        return (st.isEmpty());

    }
}
