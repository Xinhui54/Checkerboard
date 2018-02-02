/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Xinhui
 */
public class FXMLCheckerUIController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private AnchorPane anchorPane;
    
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;   
    private Color lightColor;
    private Color darkColor;
    
    private Scene scene;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDefaultRowsCols();
        setDefaultColor();
        numRows = 8;
        numCols = 8;
    } 
    public void ready(Scene scene) {
        
        this.scene = scene;
        
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            renderBoard();
        };
        
        scene.widthProperty().addListener(listener);
        scene.heightProperty().addListener(listener);
        
        renderBoard();
    }
    private void renderBoard(){
        boardWidth = scene.getWidth();
        boardHeight = scene.getHeight() - menuBar.getHeight();
        anchorPane.getChildren().clear();
        Checker reChecher = new Checker(numRows,numCols,boardHeight,boardWidth,lightColor,darkColor);
        anchorPane.getChildren().add(reChecher.build()); 
    }

    @FXML
    public void handleMenuItem(ActionEvent event) {
     
        MenuItem menuItem = (MenuItem)(event.getSource());
        switch(menuItem.getId()) {
            case "Item16":
                numRows = 16;
                numCols = 16;
                break;
            case "Item10":
                numRows = 10;
                numCols = 10;
                break;
            case "Item8":
                numRows = 8;
                numCols = 8;
                break;
            case "Item3":
                numRows = 3;
                numCols = 3;
                break;
            case "ItemDefault":
                lightColor = Color.RED;
                darkColor = Color.BLACK;  
                break;
            case"ItemBlue":
                lightColor = Color.SKYBLUE;
                darkColor = Color.DARKBLUE;  
                break;
            default:
                setDafault();
                break;
        }
        renderBoard();
    }
  
    public void setDefaultRowsCols(){
        boardWidth = 600;
        boardHeight = 360;
    }
    
    public void setDefaultColor(){
        lightColor = Color.RED;
        darkColor = Color.BLACK;
    }
    
    public void setDafault(){
        setDefaultRowsCols();
        setDefaultColor();
        
    }
}


