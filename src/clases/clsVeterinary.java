/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

import java.util.ArrayList;

public class clsVeterinary {
    
    //atributos
    private String Name;
    private String Phone;
    private String Addres;
    private ArrayList<clsPet> pets;
    private clsDoctor  doctor1;
    
    

    public clsVeterinary(String Name, String Phone, String Addres,String nombreDoc,String licencia) {
        this.Name = Name;
        this.Phone = Phone;
        this.Addres = Addres;
        pets=new ArrayList<>();
        this.doctor1=new clsDoctor(nombreDoc,licencia);
    }
    
    
    public void  AgregarPet(clsPet pet){
        pets.add(pet);
    }
    
    
    public void mostrarPets(){
            for (clsPet pets : pets) {
            System.out.println("- "+pets.getCode()+" "+ pets.getName()+" "+pets.getColor()+" "+pets.getHealthStatus()+" "+pets.getBorn_year());
        }
    }

    //metodos 
    public void petCare(){
        System.out.println("cuidado de mascotas a cargo de "+doctor1.getName());
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
    
    
    
    
    
}
