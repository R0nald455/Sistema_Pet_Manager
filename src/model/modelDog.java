/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import clases.clsDog;
import clases.clsPet;
import config.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class modelDog {

    conexion  con= new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    public boolean createPet(clsDog dog ){
    try{
        
        return true;
    }catch(Exception e){
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
        try{
            System.out.println(code);
            if(code==1){
            dog=new clsDog(1,"zeus",2010,"Negro","Sano","Pastor Aleman",true);
            }
            return dog;
        }catch(Exception e){
            return dog;
        }
    }
            
    public boolean deletePet( clsDog dog){
    try{
        
        return true;
    }catch(Exception e){
        return false;
    }
    }
                

}
