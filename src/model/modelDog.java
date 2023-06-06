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
        System.out.println("editar funciona");
    try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
        if(con != null){
        System.out.println("conectado");
        };
        
        String sqlId="SELECT petId,dog_id FROM tb_pet inner join tb_dog on (pet_id=petId) WHERE petCode=?";
        String sqlPet="UPDATE tb_pet SET petCode=?,petName=?,born_year=?,color=?,health_status=? WHERE petId=?";
        String sqlDog="UPDATE tb_dog SET breed=?,pedigree=? WHERE dog_id=?";
        
        
        //se prepara el estamento y se envia la orden de retornar las llaves generadas
        PreparedStatement statement = con.prepareStatement(sqlId);
        statement.setInt(1,dog.getCode());
        //se ejecuta la consulta para conocer los id 
        ResultSet rs=statement.executeQuery();
        while(rs.next()){
            int id1=rs.getInt(1);
            int id2=rs.getInt(2);
            PreparedStatement staPet=con.prepareStatement(sqlPet);
            //se envian lso datos a la cconsulta sql
            staPet.setInt(1,dog.getCode());
            staPet.setString(2,dog.getName());
            staPet.setInt(3,dog.getBorn_year());
            staPet.setString(4,dog.getColor());
            staPet.setString(5,dog.getHealthStatus());
            staPet.setInt(6,id1);
            staPet.executeUpdate();
            
            
           
            PreparedStatement staDog=con.prepareStatement(sqlDog);
            staDog.setString(1,dog.getBreed());
            staDog.setBoolean(2,dog.isPedigree());
            staDog.setInt(3, id2);
            
            staDog.executeUpdate();
            
            
        }
       
        return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
        
    public clsDog searchPet(int code ){
            clsDog dog =null;
            System.out.println("buscar  funciona = "+code);
            try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            if(con != null){
            System.out.println("conectado");
            };
                
            String sql="SELECT petCode,petName,born_year,color,health_status,breed,pedigree FROM tb_pet inner join tb_dog on (pet_id=petId) WHERE petCode=?";
            PreparedStatement statement=con.prepareStatement(sql);
                
            statement.setInt(1,code);
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
            dog=new clsDog();
            dog.setCode(rs.getInt(1));
            dog.setName(rs.getString(2));
            dog.setBorn_year(rs.getInt(3));
            dog.setColor(rs.getString(4));
            dog.setHealthStatus(rs.getString(5));
            dog.setBreed(rs.getString(6));
            dog.setPedigree(rs.getBoolean(7));
            }
              return dog;  
            }catch(SQLException e){
                e.printStackTrace();
            return dog;
            }
            
    }
            
public boolean deletePet( int code){
 try(Connection con=DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
        if(con != null){
        System.out.println("conectado");
        };
        
        String sqlId="SELECT petId,dog_id FROM tb_pet inner join tb_dog on (pet_id=petId) WHERE petCode=?";
        String sqlPet="DELETE FROM `tb_pet` WHERE petId=?";
        String sqlCat="DELETE FROM `tb_dog` WHERE dog_id=?";
        
        
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
