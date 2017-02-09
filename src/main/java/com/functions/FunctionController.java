package com.functions;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
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
        try{
            
            String tmpFunc = functiontxt.getText();
            Function func = new Function(tmpFunc+"+0");

            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Y = "+tmpFunc);

            for(Double i = -5.0; i <= 5; i++)
            {
                Double yVal = func.solve(i);
                series1.getData().add(new XYChart.Data(i, yVal));

                System.out.println("x: "+i + " " + "y: " + yVal);
            }    

            functionDisplay.getData().clear();
            functionDisplay.getData().addAll(series1); 
            
        } catch (Exception e) {}    
        
    }   
    
    @FXML private Button onebtn = new Button();
    @FXML private Button twobtn = new Button();
    @FXML private Button threebtn = new Button();
    @FXML private Button fourbtn = new Button();
    @FXML private Button fivebtn = new Button();
    @FXML private Button sixbtn = new Button();
    @FXML private Button sevenbtn = new Button();
    @FXML private Button eightbtn = new Button();
    @FXML private Button ninebtn = new Button();
    @FXML private Button zerobtn = new Button();
    @FXML private Button powbtn = new Button();
    
    Label power = new Label();
    
    @FXML private void printPower()
    {
        if (power.getText().equals("1")) {
            
            power.setText("0");
            
            onebtn.setText("1");
            twobtn.setText("2");
            threebtn.setText("3");
            fourbtn.setText("4");
            fivebtn.setText("5");
            sixbtn.setText("6");
            sevenbtn.setText("7");
            eightbtn.setText("8");
            ninebtn.setText("9");
            zerobtn.setText("0");
            
        } else {
            
            power.setText("1");
            
            onebtn.setText("¹");
            twobtn.setText("²");
            threebtn.setText("³");
            fourbtn.setText("⁴");
            fivebtn.setText("⁵");
            sixbtn.setText("⁶");
            sevenbtn.setText("⁷");
            eightbtn.setText("⁸");
            ninebtn.setText("⁹");
            zerobtn.setText("⁰");
            
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
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁺");            
        } else {
            functiontxt.setText(functiontxt.getText()+"+"); 
        }
    }
    
    @FXML private void printSub()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁻");            
        } else {
            functiontxt.setText(functiontxt.getText()+"-");
        }
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
            functiontxt.setText(functiontxt.getText()+"⁽");            
        } else {
            functiontxt.setText(functiontxt.getText()+"(");
        }
    }
    
    @FXML private void printCloseBrack()
    {
        if (power.getText().equals("1")) {
            functiontxt.setText(functiontxt.getText()+"⁾");            
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