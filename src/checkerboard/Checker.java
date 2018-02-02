/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author Xinhui
 */
public class Checker {
    
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private double rectangleWidth; 
    private double rectangleHeight;
    private AnchorPane anchorPane;
    
    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double getBoardWidth() {
        return boardWidth;
    }

    public double getBoardHeight() {
        return boardHeight;
    }

    public Color getLightColor() {
        return lightColor;
    }

    public Color getDarkColor() {
        return darkColor;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    public double getRectangleHeight() {
        return rectangleHeight;
    }

    public AnchorPane getBoard() {
        return anchorPane;
    }

    
  
    public Checker (int numRows, int numCols, double boardWidth,double boardHeight){
        this.numCols = numCols;
        this.numRows = numRows;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;  
        rectangleWidth = boardWidth/numRows;
        rectangleHeight = boardHeight/numCols;
    }
    public Checker (int numRows, int numCols, double boardWidth,double boardHeight,Color lightColor,Color darkColor){
        this(numCols,numRows,boardHeight,boardWidth);
        this.darkColor = darkColor;
        this.lightColor = lightColor;
    }
    
    public AnchorPane build(){
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(boardWidth, boardHeight);
        
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                Rectangle rectangle = new Rectangle(col * rectangleWidth, row * rectangleHeight, rectangleWidth, rectangleHeight);
                Color color = darkColor;
                if(row % 2 == col % 2){
                    color = lightColor;
                }
                rectangle.setFill(color);
                anchorPane.getChildren().add(rectangle);
            }
        }
      return anchorPane;  
    }
    
}


    

