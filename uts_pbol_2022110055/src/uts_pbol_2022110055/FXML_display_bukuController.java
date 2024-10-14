/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2022110055;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXML_display_bukuController implements Initializable {

    @FXML
    private TableView<BukuModel> tbvbuku;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnhapus;
    @FXML
    private Button btnkeluar;
    
    DBBuku dt= new DBBuku();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
       }    
    
    public void showdata(){
         ObservableList<BukuModel> data=dt.Load();
        if(data!=null){            
            tbvbuku.getColumns().clear();
            tbvbuku.getItems().clear();
            TableColumn col=new TableColumn("Kode Buku");
            col.setCellValueFactory(new PropertyValueFactory<BukuModel, String>("KodeBk"));
            tbvbuku.getColumns().addAll(col);
            col=new TableColumn("Penulis");
            col.setCellValueFactory(new PropertyValueFactory<BukuModel, String>("Penulis"));
            tbvbuku.getColumns().addAll(col);
            col=new TableColumn("Judul");
            col.setCellValueFactory(new PropertyValueFactory<BukuModel, String>("Judul"));
            tbvbuku.getColumns().addAll(col);
            col=new TableColumn("Total Halaman");
            col.setCellValueFactory(new PropertyValueFactory<BukuModel, String>("TotalPg"));
            tbvbuku.getColumns().addAll(col);
            tbvbuku.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvbuku.getScene().getWindow().hide();;
        }   
    }  

    @FXML
    private void awalklik(ActionEvent event) {
    }

    @FXML
    private void ubahklik(ActionEvent event) {
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
    }

    @FXML
    private void simpanklik(ActionEvent event) {
    }

    @FXML
    private void sesudahklik(ActionEvent event) {
    }

    @FXML
    private void akhirklik(ActionEvent event) {
    }

    @FXML
    private void hapusklik(ActionEvent event) {
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }
    
}
