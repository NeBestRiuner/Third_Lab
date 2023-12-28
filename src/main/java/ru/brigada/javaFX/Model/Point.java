package ru.brigada.javaFX.Model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Point extends Circle {
    private double x;
    private double y;
    private double color;
    private double diameter;
    public Point(double x, double y,double color, double diameter){
        this.x=x;
        this.y=y;
        this.color = color;
        this.diameter=diameter;
    }

    public double getColor() {
        return color;
    }
    public double getDiameter() {
        return diameter;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setColor(double color) {
        this.color = color;
    }
    public Paint transDoubleToColor(double color){
        Paint paint = Color.RED;
        if(color<252){
            paint = Color.rgb(252,(int)color,0);
        } else if (color<504) {
            paint = Color.rgb(252-((int)color-251),252,0);
        } else if (color<756) {
            paint =  Color.rgb(0,252,(int)color-503);
        } else if (color<1008) {
            paint = Color.rgb(0,252-((int)color-755),255);
        } else if (color<1260) {
            paint = Color.rgb((int) (color-1007),0,255);;
        } else if (color<1512) {
            paint = Color.rgb(252,0,252-((int)color-1259));
        }
        return paint;
    }
}
