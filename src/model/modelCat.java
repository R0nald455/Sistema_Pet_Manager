/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import clases.clsCat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class modelCat {
    
    dbData dbData;
    Connection con;

    public modelCat() {
        this.dbData = new dbData();
    }
        
    public boolean createPet(clsCat cat ){
        try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            if(con != null){
            System.out.println("conectado");
            };
            String sql="Insert  into tb_pet( `petCode`, `petName`, `born_year`, `color`, `health_status`) values(?,?,?,?,?)";
            String sqlCat="INSERT INTO tb_cat( `breed`, `pet_id`) VALUES (?,?)";
            PreparedStatement statement = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,cat.getCode());
            statement.setString(2,cat.getName());
            statement.setInt(3,cat.getBorn_year());
            statement.setString(4,cat.getColor());
            statement.setString(5,cat.getHealthStatus());
            
            
            int rowsAffected = statement.executeUpdate();
            
            ResultSet rs=statement.getGeneratedKeys();
            int id =0;
            if(rs.next()){
            id=rs.getInt(1);
            PreparedStatement statementCat = con.prepareStatement(sqlCat);
            statementCat.setString(1, cat.getBreed());
            statementCat.setInt(2,id);
            
            statementCat.executeUpdate();
            }
            
            
            
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editPet(clsCat cat ){
    try{
        return true;
    }catch(Exception e){
        return false;
    }
    }
        
    public boolean searchPet(int code ){
        
    try{
        return true;
    }catch(Exception e){
        return false;
    }
    }
            
    public boolean deletePet(clsCat cat ){
    try{
        return true;
    }catch(Exception e){
        return false;
    }
    }
          
    
    
    
}
