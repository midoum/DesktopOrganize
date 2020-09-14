import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;

public class NewTabController implements Initializable{
@FXML
Button newtab;
@FXML
FlowPane pane;


@FXML
public void newbutton(Event e) {
pane.getChildren().add(new NewButton().getButton());

		
		
	

}



@Override
public void initialize(URL arg0, ResourceBundle arg1) {


}
}
