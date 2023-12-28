package ru.brigada.javaFX.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import ru.brigada.javaFX.Model.Diagram;
import ru.brigada.javaFX.Model.Point;
public class MainController {
    @FXML
    Pane pane;
    private Diagram diagram;
    public void pointPlaceM(double x, double y, double z, double w){
            Point point = new Point(x,y, z,w);
            if (diagram.getxMax() < point.getX() || diagram.getyMax() < point.getY()||
                    diagram.getColorMax()<point.getColor()||diagram.getDiamMax()<point.getDiameter()) {
                diagram.changeMashtab(point);
            }
            point.setCenterX(31 * point.getX() / (diagram.getxMax() / 22) + 100);
            point.setCenterY(-(31 * point.getY() / (diagram.getyMax() / 10)) + 360);
            point.setRadius((point.getDiameter()/(diagram.getDiamMax()/22))/2);
            point.setFill((Paint)point.transDoubleToColor(point.getColor()/(diagram.getColorMax()/1512)));
            diagram.getPointList().add(point);
            diagram.getChildren().add(point);

    }
    public void initialize(){
        this.diagram = new Diagram();
        pane.getChildren().add(diagram);
    }
}
