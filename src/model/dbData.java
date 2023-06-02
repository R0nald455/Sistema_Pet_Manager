/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;



public class dbData {
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/veterinaria";

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }


}
