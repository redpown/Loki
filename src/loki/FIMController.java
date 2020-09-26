/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loki;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import loki.FXMLDocumentController;
//import static loki.FXMLDocumentController.log_d;

/**
 * FXML Controller class
 *
 * @author Jarvis
 */
public class FIMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    /*public  String Caminho;
    public FIMController(String Caminho){
     this.Caminho = Caminho;
    };*/
     public File l_dir;
     
     public File set_l_dir(File txt){
            return l_dir = txt;
     }
    
    @FXML
    public Button show_log_file;
   
    public void abir_log() throws IOException{
        Desktop desktop = Desktop.getDesktop();
        //File dirToOpen = null;
        try {
            
            desktop.open(l_dir);
        } catch (IllegalArgumentException iae) {
            //System.out.println("File Not Found");
        }
       
     }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       show_log_file.setText("Abrir Log");
        show_log_file.setOnAction(e -> {
            try {
                abir_log();
            } catch (IOException ex) {
                Logger.getLogger(FIMController.class.getName()).log(Level.SEVERE, null, ex);
            };
            Stage stage = (Stage) show_log_file.getScene().getWindow();
            stage.close();
        }
        );
    }    
    
}
