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
import static loki.FXMLDocumentController.diretorio;

/**
 * FXML Controller class
 *
 * @author Jarvis
 */
public class ChaveController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Button show_log_file;
   
    public void abir_log() throws IOException{
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            
            desktop.open(new File(diretorio.toString()+"\\CHAVE.txt"));
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
