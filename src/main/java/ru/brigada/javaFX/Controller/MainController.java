package ru.brigada.javaFX.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import ru.brigada.javaFX.Model.Diagram;
import ru.brigada.javaFX.Model.Point;
import java.util.regex.Pattern;
public class MainController {
    @FXML
    VBox vBox;
    @FXML
    ColorPicker colorChoser;
    @FXML
    TextField textFieldX,textFieldY,textFieldDiam;
    private Diagram diagram;
    public void pointPlaceM(){
        if(!textFieldY.getText().equals("")&&!textFieldX.getText().equals("")&&!textFieldDiam.getText().equals("")) {
            Point point = new Point(Double.parseDouble(textFieldX.getText()), Double.parseDouble(textFieldY.getText()),
                    colorChoser.getValue(), Double.parseDouble(textFieldDiam.getText()));
            if (diagram.getxMax() < point.getX() || diagram.getyMax() < point.getY()) {
                diagram.changeMashtab(point.getX(), point.getY());
            }
            point.setCenterX(31 * point.getX() / (diagram.getxMax() / 22) + 100);
            point.setCenterY(-(31 * point.getY() / (diagram.getyMax() / 10)) + 360);
            point.setRadius(point.getDiameter() / 2);
            Paint paint = point.getColor();
            point.setFill(paint);
            diagram.getPointList().add(point);
            diagram.getChildren().add(point);
        }
    }
    public void initialize(){
        this.diagram = new Diagram();
        vBox.getChildren().add(diagram);
        Pattern pattern = Pattern.compile("(\\d*)?");
        textFieldX.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!pattern.matcher(newValue).matches()||(newValue.length()>5)) textFieldX.setText(oldValue);
        }));
        textFieldY.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!pattern.matcher(newValue).matches()||(newValue.length()>5)) textFieldY.setText(oldValue);
        }));
        textFieldDiam.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!pattern.matcher(newValue).matches()||(newValue.length()>3)) textFieldDiam.setText(oldValue);
        }));
    }
}
