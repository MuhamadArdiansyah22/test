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
public class DBBuku {
   private BukuModel dtmk=new BukuModel();    
    public BukuModel getBukuModel(){ return(dtmk);}
    public void setBukuModel(BukuModel m){ dtmk=m;}    

    public ObservableList<BukuModel>  Load() {
        try {   ObservableList<BukuModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
           con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
"Select KodeBk, Penulis, Judul, TotalPg from buku");
            int i = 1;
            while (rs.next()) {
                BukuModel dtm=new BukuModel();
                dtm.setKodeBk(rs.getString("KodeBk")); 
                dtm.setPenulis(rs.getString("Penulis"));
                dtm.setJudul(rs.getString("Judul"));
                dtm.setTotalPg(rs.getInt("TotalPg"));

TableData.add(dtm);
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
            ResultSet rs = con.statement.executeQuery("select count(*) as jml from buku where KodeBk = '" + nomor + "'");
            while (rs.next()) {   val = rs.getInt("jml");            }
            con.tutupKoneksi();
        } catch (SQLException e) {            e.printStackTrace();        }
        return val;
    }        

     public boolean insert() {
        boolean berhasil = false;    Koneksi con = new Koneksi();
        try {         con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into buku (KodeBk, Penulis, Judul, TotalPg) values (?,?,?,?)");
            con.preparedStatement.setString(1, getBukuModel().getKodeBk());
            con.preparedStatement.setString(2, getBukuModel().getPenulis());
            con.preparedStatement.setString(3, getBukuModel().getJudul());
            con.preparedStatement.setInt(4, getBukuModel().getTotalPg());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            e.printStackTrace();            berhasil = false;
        } finally {            con.tutupKoneksi();            return berhasil;        }
    }

      public ObservableList<BukuModel> LookUp(String fld,String dtmk){
   try{
       ObservableList<BukuModel> tableData=FXCollections.observableArrayList();
       Koneksi con=new Koneksi();
       con.bukaKoneksi();
       con.statement = con.dbKoneksi.createStatement();
       ResultSet rs = con.statement.executeQuery("Select KodeBk, Penulis, Judul, TotalPg from buku where "+fld+" like '%"+dtmk+"%'");
       int i=1;
       while (rs.next()){
                BukuModel m=new BukuModel();
                m.setKodeBk(rs.getString("KodeMK"));
                m.setPenulis(rs.getString("Penulis"));
                m.setJudul(rs.getString("Judul"));
                m.setTotalPg(rs.getInt("TotalPg"));
                tableData.add(m);
                i++;
       }
       con.tutupKoneksi();
       return tableData;
   } catch (SQLException ex){       ex.printStackTrace();       return null;      }
}
        public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from buku where KodeBk = ? ");
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
                    "update buku set Penulis = ?, Judul = ?, JumlahPg= ?  where  KodeBk = ? ; ");
            con.preparedStatement.setString(1, getBukuModel().getPenulis());
            con.preparedStatement.setString(2, getBukuModel().getJudul());
            con.preparedStatement.setString(3, getBukuModel().getTotalPg());
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
