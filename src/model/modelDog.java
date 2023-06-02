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
import java.sql.ResultSet;


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
        String sqlPet="Insert  into tb_pet( `petCode`, `petName`, `born_year`, `color`, `health_status`) values(?,?,?,?,?)";
        String sqlDog="INSERT INTO tb_dog(`breed`, `pedigree`, `pet_id`) VALUES (?,?,?)";
        
        
        //se prepara el estamento y se envia la orden de retornar las llaves generadas
        PreparedStatement statement = con.prepareStatement(sqlPet,PreparedStatement.RETURN_GENERATED_KEYS);
        
        
        //se envian lso datos a la cconsulta sql
        statement.setInt(1,dog.getCode());
        statement.setString(2,dog.getName());
        statement.setInt(3,dog.getBorn_year());
        statement.setString(4,dog.getColor());
        statement.setString(5,dog.getHealthStatus());
        
        //se ejecuta la consulta  
        int rowsAffected = statement.executeUpdate();
        
        //se obtienen las llaves generadas automaticamente Id 
        //se podria evaluar con un if para ver si la consulta si se realizao correctamente if(rowsAffected>0)
        ResultSet rs = statement.getGeneratedKeys();//se obtiene la llave generada Id 
        int id =-1;
        if(rs.next()){//se itinera sobre result set para poder obtener los datos de lo contrario no devolvera el dato
             id = rs.getInt(1);
             System.out.println(id+"  xd  "+rowsAffected);
        }
        
        
        
        PreparedStatement statementDog = con.prepareStatement(sqlDog);
        statementDog.setString(1, dog.getBreed());
        statementDog.setBoolean(2,dog.isPedigree());
        statementDog.setInt(3, id);
        
        statementDog.executeUpdate();
        
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
