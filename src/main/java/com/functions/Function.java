/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.functions;

import java.util.ArrayList;
import java.util.HashMap;
import javax.script.*;

/**
 *
 * @author heshan
 */
public class Function
{

    private String iniFunction = "";

    public Function(String function)
    {
        function = function.replaceAll("\\s","");
        this.iniFunction = function;
    }

    public String getFunction()
    {
        return this.iniFunction;
    }


    public Double solve(Double x)
    {
        String function = this.iniFunction;
        function = function.replaceAll("x", "*"+x);
        int length = function.length();
        System.out.println(function);
        for(int i = 0; i < length; i ++)
        {
            System.out.println(function);
            char tmp = function.charAt(i);
            if (tmp == '^')
            {
                //System.out.println(i);

                String tmppow = "";
                String tmpval = "";

                int powLen = 0;
                int valLen = 0;

                for(int j = i+1; j < length;j++)
                {
                    char symbol = function.charAt(j);
                    if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/'||symbol=='%'||symbol=='^'||symbol=='('||symbol==')') {
                        tmppow = function.substring(i+1,j);
                        break;
                    } else {
                        tmppow = function.substring(i+1,j+1);
                    }
                    powLen++;
                }


                for(int j = i-1; j >= 0;j--)
                {
                    char symbol = function.charAt(j);
                    if ( symbol == 'x'){

                        tmpval = "x";
                        break;

                    } else {

                        if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/'||symbol=='%'||symbol=='^'||symbol=='('||symbol==')') {
                            tmpval = function.substring(j+1,i);
                            break;
                        } else {
                            tmpval = function.substring(j,i);
                        }
                    }
                    valLen++;
                }


                //System.out.println("pow len: " + powLen);
                //System.out.println("val len: " + valLen);

                //function = function.substring(0,i+1)+Double.toString(pow)+function.substring(i+powLen);
                //function = function.substring(0,i+1)+Double.toString(val)+function.substring(i+valLen);

                double pow = 0.0,val = 0.0;
                if (tmppow.equals("x")) {
                    pow = x;
                } else {
                    pow = Double.parseDouble(tmppow);
                }

                if (tmpval.equals("x")) {
                     val = x;
                 } else {
                     val = Double.parseDouble(tmpval);
                 }

                 function = function.substring(0,i-valLen)+Double.toString(val)+"^"+Double.toString(pow)+function.substring(i+1+powLen);
                 int tmpValLen = valLen;
                 powLen = Double.toString(pow).length();
                 valLen = Double.toString(val).length();
                 i += valLen-tmpValLen;

                 //System.out.println(function + "####################");


                //powLen = Double.toString(pow).length();
                //valLen = Double.toString(pow).length();

                //System.out.println(powLen);
                //System.out.println(valLen);
                String rslt = Double.toString(Math.pow(val, pow));

                try{

                    char prev = function.charAt(i-2);
                    if (prev == '0'||prev == '1'||prev == '2'||prev == '3'||prev == '4'||prev == '5'||prev == '6'||prev == '7'||prev == '8'||prev == '9')
                    {
                        rslt = "*"+rslt;
                    }

                } catch(Exception e){}

                /*
                System.out.println(function.substring(0,i-valLen));
                System.out.println(rslt);
                System.out.println(function.substring(i+powLen));
                */

                function = function.substring(0,i-valLen)+rslt+function.substring(i+powLen);
                length = function.length();

            }
        }

        Double result = 0.0;

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try{

            result = (Double)engine.eval(function);
            //System.out.println(result);

        }catch(ScriptException e){}

        return result;
    }

    public String superscript(String str)
    {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");
        return str;
    }
    
    public String arrangeExpression(String expression)
    {
        HashMap<Character,Character> sups = new HashMap<>();
        sups.put('⁰','0');
        sups.put('¹','1');
        sups.put('²','2');
        sups.put('³','3');
        sups.put('⁴','4');
        sups.put('⁵','5');
        sups.put('⁶','6');
        sups.put('⁷','7');
        sups.put('⁸','8');
        sups.put('⁹','9');
        
        int size = expression.length();
        for(int i = 0; i < size; i++)
        {
            System.out.println(sups.get(expression.charAt(i)));
        }    
        return expression;
    }        
    
    
    /*
    public static void main(String args[])
    {

        Function func = new Function("3x+5x^2");

        long startTime = System.currentTimeMillis();
        for(Double i = -5.0; i <= -5; i++)
        {
            Double yVal = func.solve(i);
            System.out.println("x: "+i + " " + "y: " + yVal);
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        //System.out.println(result);
        System.out.println("time: " + duration);

    }
    */

}

