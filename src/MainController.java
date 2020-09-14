

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {
	@FXML
	Button NewTab;
	@FXML
	TabPane tabpane;
	@FXML
	public void newtab(Event e) {
		
		 CreateTab();
			
	}
	
	public void CreateTab() {
		TextInputDialog ti=new TextInputDialog();
		ti.setHeaderText("Enter your tab name");
		ti.showAndWait();
		String tabname=ti.getEditor().getText();
		
		 FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("NewTab.fxml"));
	   
		try {
			Parent parent = loader.load();
			Tab x=new Tab(tabname);
			x.setClosable(true);
			x.setContent(parent);
			tabpane.getTabs().add(x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	
	}
	public void CreateFile() {
		FileChooser f=new FileChooser();
		String Filename=f.showOpenDialog(null).toString();
		System.out.println(Filename);
	}
	
}

