/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package petmanager;

import clases.clsCat;
import clases.clsDog;

public class interfaz {
    public static void main(String[] args) {
        clsDog perro= new clsDog(2,"zeus",2015,"negro","sano","Pastor Aleman",true);
        clsCat gato= new clsCat(1,"Wismichu",2010,"gris","sano","egipcio");
        
        System.out.println("perro =\n"+perro.getAnimalType());
        System.out.println(perro.getNumberOfBones());
        
        
        System.out.println("gato =\n"+ gato.getAnimalType());
        System.out.println(gato.getNumberOfBones());
        
    }
}
