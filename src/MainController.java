

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
	@FXML
	public void Enregistrer(Event e1) {
		Save();
		
			
	}
	@FXML
	public void Charger(Event e2) {
		ReadFile();
		
			
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
			addPage(ReadFile(),tabname );
			
			
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
	public void Save() {
		FileChooser f1=new FileChooser();
		String Filename=f1.showSaveDialog(null).toString();
		DocumentBuilder documentBuilder;
		try {
			  DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentFactory.newDocumentBuilder();
			  Document document = documentBuilder.newDocument();
			
			  Element root=document.createElement("user");
			  document.appendChild(root);
			  Element page=document.createElement("page");
			  root.appendChild(page);
			  Element file=document.createElement("fichier");
			  page.appendChild(file);
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(Filename));

	            transformer.transform(domSource, streamResult);
	 
	            System.out.println("Done creating XML File");
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		System.out.println(Filename);
	}
	public Document  ReadFile() {
		Document doc = null;
		FileChooser f1=new FileChooser();
		String Filename=f1.showOpenDialog(null).toString();
		File file = new File(Filename);  
		try {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		doc = db.parse(file);  
		 doc.getDocumentElement().normalize();  
		 NodeList nodeList = doc.getElementsByTagName("page");
		 for (int itr = 0; itr < nodeList.getLength(); itr++)   
		 {  
		 Node node = nodeList.item(itr);  
		 System.out.println("\nNode Name :" + node.getNodeName());  
		
		 }
		}catch(Exception e) {
			
		}
		return doc;
	
		
	}
	public void addPage(Document doc,String pagename) {
	
		
		
	}
	public void addFile(Document doc) {
		
	}
	
}

