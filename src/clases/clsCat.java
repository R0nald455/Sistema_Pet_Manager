/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

public class clsCat extends clsPet {
    private String breed;

    
    
    
    //constructores con y sin parametros de la superclase
    public clsCat(){
    }
    
    public clsCat(int code, String name, int born_year, String color, String healthStatus,String breed) {
        super(code, name, born_year, color, healthStatus);
        this.breed=breed;
    }
    
    
    //metodos de la clase gato 
    
    public void SelfCleaning(){
        System.out.println("Limpio");
    }
       
       
    
    //metodos getters ans setters
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
