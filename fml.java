import java.util.*;

public class fml {
    public static double calc (double a, char o, double b) {
        double result=0;
        switch (o) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }

    public static String removeParenthesis(String str){

        String newExp = "";
        double res;
        int start = str.indexOf("(");
        int end = str.length();
        newExp = str.substring(0, start);
        int lvl = 1;
        for (int i=start+1; i<str.length(); i++){
            if (str.charAt(i)== '('){
                lvl += 1;
            }
            else if (str.charAt(i)==')'){
                lvl -=1;
                if (lvl == 0){
                    end = i;
                    res = solve(str.substring(start+1, end));
                    newExp = newExp + res + "";
                }
            }
        }
        if(end != str.length()-1){
            newExp = newExp + str.substring(end+1, str.length());
        }
        return newExp;
    }

    public static double solve (String exp) {
        String left;
        String right;
        char op;
        double lres;
        double rres;
        double res = 0;
        if (exp ==""){
            return 0;
        }
        if (exp.contains(" ")){
            exp = exp.replaceAll(" ","");
        }
        if (exp.contains("(")){
            exp = removeParenthesis(exp);
        }
        if(!(exp.contains("+") || exp.contains("*") || exp.contains("/") || exp.contains(")") || exp.contains("("))) {
            res = Double.parseDouble(exp);
            return res;
        }
        if (exp.contains("+")){
            left = exp.substring(0,exp.indexOf("+"));
            right = exp.substring(exp.indexOf("+")+1,exp.length());
            op = '+';
            lres=solve(left);
            rres = solve(right);
            res = calc(lres, op, rres);
            return res;
        }
        if (exp.contains("-")){
            left = exp.substring(0,exp.indexOf("-"));
            right = exp.substring(exp.indexOf("-")+1,exp.length());
            op = '-';
            lres=solve(left);
            rres = solve(right);
            res = calc(lres, op, rres);
            return res;
        }
        if (exp.contains("*")){
            left = exp.substring(0,exp.indexOf("*"));
            right = exp.substring(exp.indexOf("*")+1,exp.length());
            op = '*';
            lres=solve(left);
            rres = solve(right);
            res = calc(lres, op, rres);
            return res;
        }
        if (exp.contains("/")){
            left = exp.substring(0,exp.indexOf("/"));
            right = exp.substring(exp.indexOf("/")+1,exp.length());
            op = '/';
            lres=solve(left);
            rres = solve(right);
            res = calc(lres, op, rres);
            return res;
        }
        /*for(int i=0; i<exp.length(); i++) {
            if (exp.charAt(i)=='+' || (exp.charAt(i)=='-')) {
                left = exp.substring(0,i);
                right = exp.substring(i+1,exp.length());
                op=exp.charAt(i);
                lres=solve(left);
                rres = solve(right);
                res = calc(lres, op, rres);
                return res;
            }
            else if (exp.charAt(i)=='*' || exp.charAt(i)=='/') {
                op=exp.charAt(i);
                left = exp.substring(0,i);
                right = exp.substring(i+1,exp.length());

                lres = solve(left);
                rres = solve(right);
                res = calc(lres, op, rres);
                return res;
            }

        }*/

        return res;
    }

    public static void main(String args[]){
        String tmp = "(10.22-8.22*16/8+-111.11)";
        double tmp2 = solve(tmp);
        System.out.println("tmp is :" + String.format("%.6f",tmp2));

    }



}
