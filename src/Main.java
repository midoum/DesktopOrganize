import java.io.IOException;

import com.sun.glass.events.MouseEvent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	Scene s;
	
    @Override public void start(Stage stage) throws IOException {
  	
    Parent p=FXMLLoader.load(getClass().getResource("Main.fxml"));
  
    
     s=new Scene(p); 
   

    stage.setScene(s);
      stage.show();
      
        
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
	
}