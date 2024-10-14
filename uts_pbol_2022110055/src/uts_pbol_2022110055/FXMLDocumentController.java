/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TableView<SiswaModel> tbvsiswa;
    @FXML
    private Button btnawal;
    @FXML
    private Button btnsebelum;
    @FXML
    private Button btnakhir;
    @FXML
    private Button btnsesudah;
    @FXML
    private Button btntambah;
    @FXML
    private MenuButton btnhapus;
    @FXML
    private Button btnubah;
    @FXML
    private Button btnkeluar;
    
    private DBSiswa dt = new DBSiswa();
    public static DBSiswa dts = new DBSiswa();
    public static DBBuku dtb = new DBBuku();
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
    }    
    
    public void showdata(){
         ObservableList<SiswaModel> data=dt.Load();
        if(data!=null){            
            tbvsiswa.getColumns().clear();
            tbvsiswa.getItems().clear();
            TableColumn col=new TableColumn("NIS");
            col.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("NIS"));
            tbvsiswa.getColumns().addAll(col);
            col=new TableColumn("Nama");
            col.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("Nama"));
            tbvsiswa.getColumns().addAll(col);
            col=new TableColumn("Kelas");
            col.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("Kelas"));
            tbvsiswa.getColumns().addAll(col);
            col=new TableColumn("Jurusan");
            col.setCellValueFactory(new PropertyValueFactory<SiswaModel, String>("Jurusan"));
            tbvsiswa.getColumns().addAll(col);
            tbvsiswa.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvsiswa.getScene().getWindow().hide();;
        }        

    }
    @FXML
    private void awalklik(ActionEvent event) {
    }

    @FXML
    private void sebelumklik(ActionEvent event) {
    }

    @FXML
    private void akhirklik(ActionEvent event) {
    }

    @FXML
    private void sesudahklik(ActionEvent event) {
    }

    @FXML
    private void tambahklik(ActionEvent event) {
    }

    @FXML
    private void hapusklik(ActionEvent event) {
    }

    @FXML
    private void ubahklik(ActionEvent event) {
    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }
    
}
