package com.functions;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FunctionController extends AnchorPane {

    
    public FunctionController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Function.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();            
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @FXML private TextField functiontxt; 
    @FXML private LineChart<Number,Number> functionDisplay;
    
    @FXML public void drawGraph()
    {
        //functiontxt.setText("2x"+Function.superscript("2")+"-1x"+Function.superscript("3"));   
        Function func = new Function(functiontxt.getText()+"+0");
        
        XYChart.Series series1 = new XYChart.Series();
        //series1.setName();
        
        functionDisplay.setTitle("Y = " + func.getFunction());

        for(Double i = -5.0; i <= 5; i++)
        {
            Double yVal = func.solve(i);
            series1.getData().add(new XYChart.Data(i, yVal));
            
            System.out.println("x: "+i + " " + "y: " + yVal);
        }    
        
        functionDisplay.getData().clear();
        functionDisplay.getData().addAll(series1);  
        
    }   
    
    Label power = new Label();
    
    @FXML private void printPower()
    {
        if (power.getText().equals("1")) {
            power.setText("0");
        } else {
            power.setText("1");
        }   
        
    }        
    
    @FXML private void printOne()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"¹");            
        } else {
            functiontxt.setText(functiontxt.getText()+"1");
        }
    }
    
    @FXML private void printTwo()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"²");            
        } else {
            functiontxt.setText(functiontxt.getText()+"2");
        }
    }
    
    @FXML private void printThree()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"³");            
        } else {
            functiontxt.setText(functiontxt.getText()+"3");
        }
    }
    
    @FXML private void printFour()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁴");            
        } else {
            functiontxt.setText(functiontxt.getText()+"4");
        }
    }
    
    @FXML private void printFive()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁵");            
        } else {
            functiontxt.setText(functiontxt.getText()+"5");
        }
    }
    
    @FXML private void printSix()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁶");            
        } else {
            functiontxt.setText(functiontxt.getText()+"6");
        }
    }
    
    @FXML private void printSeven()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁷");            
        } else {
            functiontxt.setText(functiontxt.getText()+"7");
        }
    }
    
    @FXML private void printEight()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁸");            
        } else {
            functiontxt.setText(functiontxt.getText()+"8");
        }
    }
    
    @FXML private void printNine()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁹");            
        } else {
            functiontxt.setText(functiontxt.getText()+"9");
        }
    }
    
    @FXML private void printZero()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁰");            
        } else {
            functiontxt.setText(functiontxt.getText()+"0");
        }
    }
    
    @FXML private void printPlus()
    {
        functiontxt.setText(functiontxt.getText()+"+");   
    }
    
    @FXML private void printSub()
    {
        functiontxt.setText(functiontxt.getText()+"-");
       
    }
    
    @FXML private void printMul()
    {
        functiontxt.setText(functiontxt.getText()+"*");
    }
    
    @FXML private void printDiv()
    {
        functiontxt.setText(functiontxt.getText()+"/");
    }
    
    @FXML private void printOpenBrack()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"¹");            
        } else {
            functiontxt.setText(functiontxt.getText()+"(");
        }
    }
    
    @FXML private void printCloseBrack()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"¹");            
        } else {
            functiontxt.setText(functiontxt.getText()+")");
        }
    }
    
    @FXML private void printX()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"¹");            
        } else {
            functiontxt.setText(functiontxt.getText()+"x");
        }
    }
    
    @FXML private void printPoint()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"¹");            
        } else {
            functiontxt.setText(functiontxt.getText()+".");
        }
    }
    
    public void loadFunction()
    {
        //drawGraph();
    }        
    
}    