/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

public class clsDog extends clsPet{
     private String breed;
     private String Pedigree;

     
     
     //constructor sin elementos de la superclase
    public clsDog() {
    }
    
    
    
    //constructor con  los elementos de la superclase
    public clsDog(String breed, String Pedigree, int code, String name, int born_year, String color, String healthStatus) {
        super(code, name, born_year, color, healthStatus);
        this.breed = breed;
        this.Pedigree = Pedigree;
    }

    
    
    //metodos 
    public void WalkAround(){
        System.out.println("Caminando");
    }
    
    //metodos getters y setters 

    public String getPedigree() {
        return Pedigree;
    }

    public void setPedigree(String Pedigree) {
        this.Pedigree = Pedigree;
    }
    
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
