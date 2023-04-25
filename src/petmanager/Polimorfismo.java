/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package petmanager;

import clases.clsCat;
import clases.clsDoctor;
import clases.clsDog;
import clases.clsVeterinary;

public class Polimorfismo {
    
    
    public static void main(String[] args) {
        
        clsCat gato1= new clsCat(1,"Wismichu",2010,"gris","sano","egipcio");
        clsDog perro1= new clsDog(2,"zeus",2015,"negro","sano","Pastor Aleman",true);
        clsDoctor doctor1 = new clsDoctor("Jonathan","123456852");
        clsVeterinary vete1 = new clsVeterinary("VetePet","3216548987","Cra 15a-65",doctor1);
    
        
        
         
        
        String careDog= vete1.petCare(perro1);
        System.out.println("El estado de Salud de "+perro1.getName()+ " es "+careDog);
        String careCat= vete1.petCare(gato1);
        System.out.println("El estado de Salud de "+gato1.getName()+ " es "+careCat);
    
    
    } 
}
