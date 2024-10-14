/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol_2022110055;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class DBSiswa {
    private SiswaModel dt=new SiswaModel();    
    public SiswaModel getSiswaModel(){ return(dt);}
    public void setSiswaModel(SiswaModel s){ dt=s;}    

    public ObservableList<SiswaModel>  Load() {
        try {   ObservableList<SiswaModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
           con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
"Select NIS, Nama, Kelas, Jurusan from siswa");
            int i = 1;
            while (rs.next()) {
                SiswaModel d=new SiswaModel();
                d.setNIS(rs.getString("NIS")); 
                d.setNama(rs.getString("Nama"));
                d.setKelas(rs.getString("Kelas"));
                d.setJurusan(rs.getString("Jurusan"));

TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
    }
    public int validasi(String nomor) {
        int val = 0;
        try {  Koneksi con = new Koneksi();     con.bukaKoneksi();   con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from siswa where NIS = '" + nomor + "'");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            e.printStackTrace();        }
        return val;
    }        

     public boolean insert() {
        boolean berhasil = false;    Koneksi con = new Koneksi();
        try {         con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into siswa (NIS, Nama, Kelas, Jurusan) values (?,?,?,?)");
            con.preparedStatement.setString(1, getSiswaModel().getNIS());
            con.preparedStatement.setString(2, getSiswaModel().getNama());
            con.preparedStatement.setString(3, getSiswaModel().getKelas());
            con.preparedStatement.setString(4, getSiswaModel().getJurusan());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            e.printStackTrace();            berhasil = false;
        } finally {            con.tutupKoneksi();            return berhasil;        }
        
    }
     public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from siswa where NIS  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update siswa set Nama = ?, Kelas = ?, Jurusan = ?  where  NIS = ? ; ");
            con.preparedStatement.setString(1, getSiswaModel().getNama());
            con.preparedStatement.setString(2, getSiswaModel().getKelas());
            con.preparedStatement.setString(3, getSiswaModel().getJurusan());
            con.preparedStatement.setString(4, getSiswaModel().getNIS());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

public ObservableList<SiswaModel> LookUp(String fld,String dt){
   try{
       ObservableList<SiswaModel> tableData=FXCollections.observableArrayList();
       Koneksi con=new Koneksi();
       con.bukaKoneksi();
       con.statement = con.dbKoneksi.createStatement();
       ResultSet rs = con.statement.executeQuery("Select NIS, Nama, Kelas, Jurusan, from siswa where "+fld+" like '%"+dt+"%'");
       int i=1;
       while (rs.next()){
                SiswaModel d=new SiswaModel();
                d.setNIS(rs.getString("NPM"));
                d.setNama(rs.getString("Nama"));
                d.setKelas(rs.getString("Kelas"));
                d.setJurusan(rs.getString("Jurusan"));
                tableData.add(d);
                i++;
       }
       con.tutupKoneksi();
       return tableData;
   } catch (SQLException ex){       ex.printStackTrace();       return null;      }
}


   

}
