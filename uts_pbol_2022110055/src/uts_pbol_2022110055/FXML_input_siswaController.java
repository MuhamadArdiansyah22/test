/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2022110055;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXML_input_siswaController implements Initializable {

    @FXML
    private TextField txtnis;
    @FXML
    private TextField txtnama;
    @FXML
    private TextField txtkelas;
    @FXML
    private TextField txtjurusan;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    boolean editdata=false;
    @FXML
    private Button btnkeluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanklik(ActionEvent event) {
         SiswaModel s=new SiswaModel();
        s.setNIS(txtnis.getText());
        s.setNama(txtnama.getText());
        s.setKelas(txtkelas.getText());
        s.setJurusan(txtjurusan.getText());
        FXMLDocumentController.dts.setSiswaModel(s);
        if(editdata){
            if(FXMLDocumentController.dts.update()){
                          Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtnis.setEditable(true);        batalklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXMLDocumentController.dts.validasi(s.getNIS())<=0){
            if(FXMLDocumentController.dts.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            batalklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtnis.requestFocus();
        }    
    }

    @FXML
    private void batalklik(ActionEvent event) {
        txtnis.setText("");
        txtnama.setText("");
        txtkelas.setText("");
        txtjurusan.setText("");
        txtnis.requestFocus();
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }
    
}
