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
        System.out.println("editar funciona");
    try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
        if(con != null){
        System.out.println("conectado");
        };
        
        String sqlId="SELECT petId,cat_id FROM tb_pet inner join tb_cat on (pet_id=petId) WHERE petCode=?";
        String sqlPet="UPDATE tb_pet SET petCode=?,petName=?,born_year=?,color=?,health_status=? WHERE petId=?";
        String sqlCat="UPDATE tb_cat SET breed=? WHERE cat_id=?";
        
        
        //se prepara el estamento y se envia la orden de retornar las llaves generadas
        PreparedStatement statement = con.prepareStatement(sqlId);
        statement.setInt(1,cat.getCode());
        //se ejecuta la consulta para conocer los id 
        ResultSet rs=statement.executeQuery();
        while(rs.next()){
            int id1=rs.getInt(1);
            int id2=rs.getInt(2);
            PreparedStatement staPet=con.prepareStatement(sqlPet);
            //se envian lso datos a la cconsulta sql
            staPet.setInt(1,cat.getCode());
            staPet.setString(2,cat.getName());
            staPet.setInt(3,cat.getBorn_year());
            staPet.setString(4,cat.getColor());
            staPet.setString(5,cat.getHealthStatus());
            staPet.setInt(6,id1);
            staPet.executeUpdate();
            
            
           
            PreparedStatement staDog=con.prepareStatement(sqlCat);
            staDog.setString(1,cat.getBreed());
            staDog.setInt(2, id2);
            
            staDog.executeUpdate();
            
            
        }
       
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        
    public clsCat searchPet(int code ){
            clsCat cat =null;
            System.out.println("buscar  funciona = "+code);
            try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            if(con != null){
            System.out.println("conectado");
            };
                
            String sql="SELECT petCode,petName,born_year,color,health_status,breed FROM tb_pet inner join tb_cat on (pet_id=petId) WHERE petCode=?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setInt(1,code);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
            cat=new clsCat();
            cat.setCode(rs.getInt(1));
            cat.setName(rs.getString(2));
            cat.setBorn_year(rs.getInt(3));
            cat.setColor(rs.getString(4));
            cat.setHealthStatus(rs.getString(5));
            cat.setBreed(rs.getString(6));
            }
              return cat;  
            }catch(SQLException e){
                e.printStackTrace();
            return cat;
            }
            
    }
            
    public boolean deletePet(int code){
    try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
        if(con != null){
        System.out.println("conectado");
        };
        
        String sqlId="SELECT petId,cat_id FROM tb_pet inner join tb_cat on (pet_id=petId) WHERE petCode=?";
        String sqlPet="DELETE FROM `tb_pet` WHERE petId=?";
        String sqlCat="DELETE FROM `tb_cat` WHERE cat_id=?";
        
        
        //se prepara el estamento y se envia la orden de retornar las llaves generadas
        PreparedStatement statement = con.prepareStatement(sqlId);
        statement.setInt(1,code);
        //se ejecuta la consulta para conocer los id 
        ResultSet rs=statement.executeQuery();
        while(rs.next()){
            int id1=rs.getInt(1);
            int id2=rs.getInt(2);

            
            PreparedStatement staDog=con.prepareStatement(sqlCat);
            staDog.setInt(1, id2);
            
            staDog.executeUpdate();
            
            
            
            PreparedStatement staPet=con.prepareStatement(sqlPet);
            //se envian lso datos a la cconsulta sql
            staPet.setInt(1,id1);
            staPet.executeUpdate();
        }
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
          
    
    
    
}
