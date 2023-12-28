package ru.brigada.javaFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.brigada.javaFX.Controller.MainController;

public class App extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            System.out.println(getClass().getResource("/MainApp.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainApp.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            primaryStage.setTitle("My First JavaFX App");
            primaryStage.setScene(scene);
            primaryStage.show();
            MainController mc = fxmlLoader.getController();
            // test
            //test1
            /*
            int i = 10;
            while(i<600){
                mc.pointPlaceM(i,50,0,100);
                i+=10;
            }*/
            //test2
            /*
            int i = 10;
            while(i<600){
                mc.pointPlaceM(i,50,0,i);
                i+=10;
            }*/
            //test3
            /*
            int i = 10;
            while(i<300){
                mc.pointPlaceM(100,i,i*10,100);
                i+=10;
            }*/
            /*
            int i = 10;
            while(i<300){
                mc.pointPlaceM(100,i,i*10,i*10);
                i+=10;
            }*/

            //test5
            int i = 10;
            while(i<500){
                mc.pointPlaceM(i,i,i*10,i);
                i+=10;
            }
        }
        public static void main(String[] args) {
            Application.launch(args);
        }
    }

