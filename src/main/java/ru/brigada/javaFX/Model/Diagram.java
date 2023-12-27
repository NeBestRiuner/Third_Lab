package ru.brigada.javaFX.Model;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class Diagram extends Pane {
    private List<Point> pointList = new ArrayList<>();
    private List<Text> yList = new ArrayList<>();
    private List<Text> xList = new ArrayList<>();
    private Text text;
    private double xMax = 220;
    private double yMax = 100;
    public Diagram(){
        this.setPrefHeight(415);
        this.setPrefWidth(900);
        text = new Text("Диаграмма");
        text.setLayoutX(450);
        text.setLayoutY(27);
        text.setFont(new Font(14));
        Text zero = new Text("0");
        zero.setFont(new Font(14));
        zero.setLayoutX(75);
        zero.setLayoutY(360);
        Text xLabel = new Text("X");
        xLabel.setLayoutX(440);
        xLabel.setLayoutY(400);
        Text yLabel = new Text("Y");
        yLabel.setLayoutX(60);
        yLabel.setLayoutY(205);
        this.getChildren().addAll(text,zero,xLabel,yLabel);
        Line yLine = new Line(100,50,100,360);
        Line xLine = new Line(100,360,775,360);
        this.getChildren().addAll(xLine,yLine);
        int i = 1;
        while(i<10){
            Line line = new Line(90,360-(i*31),100,360-(i*31));
            Text textN = new Text(i*10+"");
            textN.setLayoutX(76);
            textN.setLayoutY(360-(i*31));
            yList.add(textN);
            this.getChildren().addAll(textN,line);
            i++;
        }
        i = 1;
        while(i<22){
            Line lineX = new Line(100+(i*31),360,100+(i*31),370);
            Text textNX = new Text(i*10+"");
            textNX.setLayoutX(100+(i*31));
            textNX.setLayoutY(380);
            xList.add(textNX);
            this.getChildren().addAll(textNX,lineX);
            i++;
        }
    }
    public void changeMashtab(double xMax, double yMax){
        if(this.xMax<xMax)
        this.xMax=xMax;
        if(this.yMax<yMax)
        this.yMax=yMax;
        ListIterator<Point> iter = pointList.listIterator();
        double cX = this.xMax/22;
        double cY = this.yMax/10;
        while (iter.hasNext()) {
            Point point = iter.next();
            point.setCenterX(31*point.getX()/(cX)+100);
            point.setCenterY(-(31*point.getY()/cY)+360);
        }
        int i = 1;
        while(i<10){
            Text text = yList.get(i-1);
            String result = String.format("%.0f",cY*i);
            text.setText(result);
            i++;
        }
        i = 1;
        while(i<22){
            Text text = xList.get(i-1);
            String result = String.format("%.0f",cX*i);
            text.setText(result);
            i++;
        }
    }
    public double getxMax() {
        return xMax;
    }
    public double getyMax() {
        return yMax;
    }
    public List<Point> getPointList() {
        return pointList;
    }
}
