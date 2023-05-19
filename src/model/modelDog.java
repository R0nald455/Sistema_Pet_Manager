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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class modelDog {

    conexion  con= new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    
    public boolean createPet(clsDog dog ){
    try{
        System.out.println("modelo");
        String sql="Insert  into perros(name, bornYear, color, healthStatus, breed)"
                + "values('"+dog.getName()+"',"+dog.getBorn_year()+" ,' "+dog.getColor()+" ', '"+dog.getHealthStatus()+"' ,' "+dog.getBreed()+"')";
        System.out.println(sql);
        cn =(Connection) con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
        return true;
    }catch(Exception e){
        return false;
    }
    }
    
    public boolean editPet(clsDog dog ){
    try{
        String  sql="UPDATE persona SET dni='"+"',nombres='"+"' WHERE id=" ;
        cn =(Connection) con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
        return true;
    }catch(Exception e){
        return false;
    }
    }
        
    public clsDog searchPet(int code ){
            clsDog dog =null;
        try{
            String sql="select * from perros where code="+code;
            cn =(Connection) con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]persona=new Object[3];
            while(rs.next()){
            persona[0]=rs.getInt("id");
            persona[1]=rs.getString("dni");
            persona[2]=rs.getString("nombres");
            modelo.addRow(persona);
            }
            return dog;
        }catch(Exception e){
            return dog;
        }
    }
            
    public boolean deletePet( clsDog dog){
    try{
        String  sql="delete from perros where id=" +dog.getCode();
            cn = (Connection)
            con.getConnection();
            st=cn.createStatement();
            st.executeUpdate(sql);
        return true;
    }catch(Exception e){
        return false;
    }
    }
                

}
