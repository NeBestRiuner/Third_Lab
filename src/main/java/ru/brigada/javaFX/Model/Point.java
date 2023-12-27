package ru.brigada.javaFX.Model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Point extends Circle {
    private double x;
    private double y;
    private double color;
    private double diameter;
    public Point(double x, double y,Color color, double diameter){
        this.x=x;
        this.y=y;
        this.color = (int) (color.getRed() * 0xFF) |
                ((int) (color.getGreen() * 0xFF)) << 010 |
                ((int) (color.getBlue() * 0xFF)) << 020 |
                ((int) (color.getOpacity() * 0xFF)) << 030;
        this.diameter=diameter;
    }

    public Color getColor() {
        Color colorC = Color.rgb(
                (int)this.color & 0xFF,
                ((int)this.color >>> 010) & 0xFF,
                ((int)this.color >>> 020) & 0xFF,
                ((int)this.color >>> 030) / 255d);
        return colorC;
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
}
