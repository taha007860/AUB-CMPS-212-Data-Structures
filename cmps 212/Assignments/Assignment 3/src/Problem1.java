import java.util.*;

public class Problem1 {
    public static void main(String[] args) throws Exception {
        String[] digits={0+"",1+"",2+"",3+"",4+"",5+"",6+"",7+"",8+"",9+""};
        ArrayList<String> digitsList=new ArrayList<>();
        for(String x: digits){
            digitsList.add(x);
        }
        String temp="";
        int count=0;
        Scanner forLine=new Scanner(System.in);
        Stack<String> parenthesis=new Stack<>();
        Stack<String> operators=new Stack<>();
        Stack<String> operands=new Stack<>();
        String value="";
        String operator="";
        String operand="";
        String operand1="";
        String operator1="";
        String testOperator="";
        String line=forLine.nextLine();
        Scanner forLinesStrings=new Scanner(line);
        while(forLinesStrings.hasNext()){
            String string=forLinesStrings.next();
            System.out.println("Enter the boolean expression to evaluate now: "+string);
            System.out.print("Your expression is ");
            for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='('){parenthesis.push("("); //System.out.println(parenthesis);
            }
            else if(Character.isDigit(string.charAt(i))&&Character.isDigit(string.charAt(i+1))){
                value=value+string.charAt(i);
                int h=i+1;
                while(Character.isDigit(string.charAt(h))){
                    value=value+string.charAt(h);
                    h++;}
                i=h-1;
               // System.out.println(value);
                operands.push(value); value=""; } //System.out.println(operands);}
            else if(digitsList.contains(string.charAt(i)+"")){
                    value=value+string.charAt(i);
                    operands.push(value);
                    //System.out.println(value);
                    value=""; }//System.out.println(operands);}
            else if(!Character.isDigit(string.charAt(i))&&string.charAt(i)!='('&&string.charAt(i)!=')'&&
            string.charAt(i)!=string.charAt(i+1)&&string.charAt(i)!=string.charAt(i-1)){
                operator=operator+string.charAt(i);
                operators.push(operator); operator="";}// System.out.println(operators);}
            else if(!Character.isDigit(string.charAt(i))&&string.charAt(i)!='('&&string.charAt(i)!=')'&&
            string.charAt(i)==string.charAt(i+1)){
                operator=string.charAt(i)+""+string.charAt(i+1); i++;
                operators.push(operator); operator="";}//System.out.println(operators); System.out.println(operator);}
            else if(string.charAt(i)==')'){String testParenthesis=parenthesis.pop();
                if(!testParenthesis.equals("(")){throw new Exception();}
                else{if(operators.isEmpty()){if(operands.isEmpty()){throw new Exception();}}}
                    while(!operators.isEmpty()){
                    testOperator=operators.pop();
                    if(testOperator.equals("!")){
                        if(operands.isEmpty()){throw new Exception();}
                        else{operand=operands.pop();
                            if((operand.equals("FALSE")||operand.equals("0"))&&operators.isEmpty())
                            {temp=temp+"TRUE "; operands.push("TRUE");}
                            else
                            {temp=temp+"FALSE "; operands.push("FALSE");}}}
                    else if(testOperator.equals("&&")){if(operands.isEmpty()){throw new Exception();}
                            else{operand=operands.pop();
                                //System.out.println(operand);
                                operand1=operands.pop();
                                if((!operand.equals("0")&&!operand1.equals("0"))
                                        ||(operand.equals("TRUE")&&operand1.equals("TRUE")))
                                {operands.push("TRUE");
                                 temp=temp+"TRUE ";}
                                else {operands.push("FALSE");
                                temp=temp+"FALSE ";}}}
                        else if(testOperator.equals("||")){if(operands.isEmpty()){throw new Exception();}
                            else{operand=operands.pop();
                       // System.out.println(operand);
                                operand1=operands.pop();
                       // System.out.println(operand1);
                                if((operand.equals("0")&&operand1.equals("0"))||
                                        (operand.equals("FALSE")&&operand1.equals("FALSE")))
                                {operands.push("FALSE");
                                    temp=temp+"FALSE ";}
                                else{operands.push("TRUE");
                                 temp=temp+"TRUE ";}
                                }}
                        else if(testOperator.equals("<")){if(operands.isEmpty()){throw new Exception();}
                            else{operand=operands.pop();
                                operand1=operands.pop();
                                if((Integer.parseInt(operand1)<Integer.parseInt(operand)))
                                {operands.push("TRUE");
                                   temp=temp+"TRUE ";}
                                else{operands.push("FALSE");
                                temp=temp+"FALSE ";}}}
                        else if(testOperator.equals(">")){if(operands.isEmpty()){throw new Exception();}
                        else{operand=operands.pop();
                           // System.out.println(operand);
                            operand1=operands.pop();
                           // System.out.println(operand1);
                            if(Integer.parseInt(operand1)>Integer.parseInt(operand))
                            {operands.push("TRUE");
                             temp=temp+"TRUE ";}
                            //System.out.println(temp);}
                            else{operands.push("FALSE");
                               temp=temp+"FALSE ";}}}
                            ///System.out.println(temp);}}}
                        else if(testOperator.equals("==")){if(operands.isEmpty()){throw new Exception();}
                            else{//System.out.println(testOperator);
                                operand=operands.pop();
                                //System.out.println(operand);
                                operand1=operands.pop();
                               // System.out.println(operand1);
                               if((operand.equals("0")&&operand1.equals("FALSE"))||
                                       (operand.equals("FALSE")&&operand1.equals("0"))||
                                operand.equals(operand1))
                            {operands.push("TRUE");
                               // System.out.println(operands);
                             temp=temp+"TRUE ";}
                           // System.out.println(temp);}
                                else{operands.push("FALSE");// System.out.println(operands);
                               temp=temp+"FALSE "; //System.out.println(temp);
                                }}}}}}
            if(temp.length()==5||temp.length()==6){System.out.print(temp);}
            else{String[] x;
                x=temp.split(" ");
                System.out.print(x[x.length-1]);}
        System.out.println();
        temp="";}}}

