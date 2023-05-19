/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package petmanager;

import clases.clsDog;
import config.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class prueba2 {

    conexion  con= new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    public boolean createPet(){
    try{
        String sql="insert into datos(code,name)"+"values("+2+",'gato')";
        System.out.println(sql);
        cn =(Connection) con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
        return true;
    }catch(Exception e){
        return false;
    }
    }
    
    
    
    public static void main(String[] args) {
        prueba2 prueba = new prueba2();
        
        prueba.createPet();
    }
}
