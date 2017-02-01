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
        function = arrangeExpression(function);
        function = function.replaceAll("x", Double.toString(x));
        
        System.out.println(function);
        
        Double result = 0.0;

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try{

            result = (Double)engine.eval(function);
            //System.out.println(result);

        }catch(ScriptException e){}

        return result;
    }

    public static String superscript(String str)
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
        
        int size = expression.length();
        for(int i = 0; i < size; i++)
        {
            try{
                char tmpChar = expression.charAt(i);
                if (tmpChar == 'x')
                {
                    char tmpchar2 = expression.charAt(i-1);
                    if ( tmpchar2 == '0'||tmpchar2 == '1'||tmpchar2 == '2'||tmpchar2 == '3'||tmpchar2 == '4'||tmpchar2 == '5'||tmpchar2 == '6'||tmpchar2 == '7'||tmpchar2 == '8'||tmpchar2 == '9' ) {
                        expression = expression.substring(0,i)+"*"+expression.substring(i);
                        i++;
                        size++;
                    } else if ( tmpchar2 == '+'||tmpchar2 == '-'||tmpchar2 == '*'||tmpchar2 == '/' ) {
                        expression = expression.substring(0,i)+"1*"+expression.substring(i);
                        i+=2;
                        size+=2;
                    }    
                }
            } catch (Exception e){}    
        }    
        
        
        
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
        
        size = expression.length();
        int prevSymbol = -1;
        int startpow = -1;
        String power ="";
        for(int i = 0; i < size; i++)
        {
           
           try{
               
                if ( startpow == -1 ) startpow = i; 
                char pow = sups.get(expression.charAt(i));
                power += pow;
            
           }catch(Exception e){ 
               
               //String value = expression.substring(prevSymbol+1,startpow+1);
               
               if (!power.equals(""))
               {
                    //System.out.println(power);
                    if ( expression.charAt(startpow-1) == 'x') {
                        
                        String mathPow = "Math.pow(x,"+power+")";
                        System.out.println(mathPow);
                        expression = expression.substring(0,(startpow-1)) + mathPow + expression.substring(i);
                        System.out.println(expression);
                        size = expression.length();

                        int valLen = 1;
                        int powLen = power.length();

                        int sizeLen = valLen + powLen;
                        int tmpLen = mathPow.length();

                        i +=  (tmpLen-sizeLen);
                        startpow = -1;
                        
                            
                        
                    } else {    
                   
                        //System.out.println((prevSymbol+1)+" "+(prevSymbol+startpow+2));
                        String value = expression.substring((prevSymbol+1),(prevSymbol+startpow+2));
                        //System.out.println(value);
                        //System.out.println(power);

                        String mathPow = "Math.pow("+value+","+power+")";
                        expression = expression.substring(0,(prevSymbol+1)) + mathPow + expression.substring(i);
                        System.out.println(expression);
                        size = expression.length();

                        int valLen = value.length();
                        int powLen = power.length();

                        int sizeLen = valLen + powLen;
                        int tmpLen = mathPow.length();

                        i +=  (tmpLen-sizeLen);
                        startpow = -1;
                    }    
         
               } else {
                   startpow = -1;
               }    
               power = "";
           
           }
           
           char symbol = expression.charAt(i);
           if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/'||symbol=='%'||symbol=='^'||symbol=='('||symbol==')')
           {
               prevSymbol = i;
           }
           
        }    
        
        System.out.println(expression);
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
    
        
        //Double result2 = (Double)engine.eval("2+Math.pow(3, 2)");
        //System.out.println(result2 + " *****************######");

    

    }
    */

}

