package com.functions;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.chart.XYChart;
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
    
    public void drawGraph()
    {
        functiontxt.setText("2x"+Function.superscript("2")+"-x"+Function.superscript("3")+"+0");   
        Function func = new Function(functiontxt.getText());
        
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
    
    public void loadFunction()
    {
        drawGraph();
    }        
    
}    