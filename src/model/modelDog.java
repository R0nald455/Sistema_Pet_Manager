/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import clases.clsDog;
import clases.clsPet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class modelDog {
    dbData dbData;
    Connection con;

    public modelDog() {
        this.dbData = new dbData();
    }
        
    public boolean createPet(clsDog dog ){
    try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
        if(con != null){
        System.out.println("conectado");
        };
        String sql="Insert  into tb_pet( `petCode`, `petName`, `born_year`, `color`, `health_status`) values(?,?,?,?,?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1,dog.getCode());
        statement.setString(2,dog.getName());
        statement.setInt(3,dog.getBorn_year());
        statement.setString(4,dog.getColor());
        statement.setString(5,dog.getHealthStatus());
        int rowsAffected = statement.executeUpdate();
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editPet(clsDog dog ){
    try{

        return true;
    }catch(Exception e){
        return false;
    }
    }
        
    public clsDog searchPet(int code ){
            clsDog dog =null;
            return dog;
    }
            
    public boolean deletePet( clsDog dog){
    try{

        return true;
    }catch(Exception e){
        return false;
    }
    }
                

}
