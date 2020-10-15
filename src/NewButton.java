import java.io.File;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class NewButton {
	String name;
	String exe;
	Button B=new Button();
	String fileExtension ;
	public  NewButton() {
		
	
		FileChooser f1=new FileChooser();
		 File file = f1.showOpenDialog(null); 
			B.setPrefSize(80, 80);
			name=file.getName();
			exe=file.getAbsoluteFile().toString();
			B.setText(name);
			
		
			
			
			B.setOnAction(CreateButton());
		
			

	}
	public EventHandler<ActionEvent> CreateButton() {
		EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    	 try {
		    		 Process p = Runtime
		    				   .getRuntime()
		    				   .exec("rundll32 url.dll,FileProtocolHandler"+" "+exe);
		    				p.waitFor();
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	event.consume();
		    }
		};
		return buttonHandler;
		
	}
	public Button getButton( ) {
		return B;
	}
}
