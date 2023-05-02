/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

import java.util.ArrayList;

public class clsVeterinary extends AbstHospital {
    
    //atributos
    private String Name;
    private String Phone;
    private String Addres;
    private clsDoctor  doctor;
    
    
    public clsVeterinary(){};

    public clsVeterinary(String Name, String Phone, String Addres,clsDoctor doctor) {
        this.Name = Name;
        this.Phone = Phone;
        this.Addres = Addres;
        this.doctor=doctor;
    }

    
    //metodos 
    public String petCare(clsPet pet){
        System.out.println("atentiendo a la mascota "+pet.getName());
        return pet.getHealthStatus();
    }

    //metodos getters and setters
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    public String getAddres() {
        return Addres;
    }
    public void setAddres(String Addres) {
        this.Addres = Addres;
    }

    @Override
    public String getPatientType() {
        return "animal";
    }

    @Override
    public String Surgery() {
        return "Surgery animal date";
    }
}
