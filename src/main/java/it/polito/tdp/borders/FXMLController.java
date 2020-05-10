
package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtTrovaVicini"
    private TextField txtTrovaVicini; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	
    	this.txtResult.clear();
    	int data;
    	try {
    		data = Integer.parseInt(this.txtAnno.getText());
    		if(data<1816 || data>2016) {
    			this.txtResult.appendText("La data deve essere compresa tra 1816 e 2016!");
        		return;
    		}
    	}catch(NumberFormatException nfe){
    		this.txtResult.appendText("Inserire una data in formato numerico, compresa tra 1816 e 2016!");
    		return;
    	}
    	this.model.generateGraph(data);
    	this.txtResult.appendText("Grafo creato!\nNumero vertici: "+this.model.nVertex()+"\nNumero archi: "+this.model.nEdges()+
    			"\nNumero di componenti connesse: "+this.model.numeroComponentiGrafo()+"\n");
    	this.txtResult.appendText(this.model.trovaStatiConfinanti());
		
    }
    
    @FXML
    void doCalcolaVicini(ActionEvent event) {

    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTrovaVicini != null : "fx:id=\"txtTrovaVicini\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
