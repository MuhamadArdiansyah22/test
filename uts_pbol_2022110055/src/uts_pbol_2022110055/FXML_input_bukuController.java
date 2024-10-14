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
public class FXML_input_bukuController implements Initializable {

    @FXML
    private TextField txtkodebuku;
    @FXML
    private TextField txtpenulis;
    @FXML
    private TextField txtjudul;
    @FXML
    private TextField txttotalhalaman;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    boolean editdata=false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simppanklik(ActionEvent event) {
    BukuModel s=new BukuModel();
        s.setKodeBk(txtkodebuku.getText());
        s.setPenulis(txtpenulis.getText());
        s.setJudul(txtjudul.getText());
        s.setTotalPg(Integer.parseInt(txttotalhalaman.getText()));
        FXMLDocumentController.dtb.setBukuModel(s);
        if(editdata){
            if(FXMLDocumentController.dtb.update()){
                          Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   txtkodebuku.setEditable(true);        hapusklik(event);                
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
               a.showAndWait();                    
            }
        }else if(FXMLDocumentController.dtb.validasi(s.getKodeBk())<=0){
            if(FXMLDocumentController.dtb.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            hapusklik(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            txtkodebuku.requestFocus();
        }    
    }


    @FXML
    private void hapusklik(ActionEvent event) {
         txtkodebuku.setText("");
        txtpenulis.setText("");
        txtjudul.setText("");
        txttotalhalaman.setText("");
        txtkodebuku.requestFocus();
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }
    
}
