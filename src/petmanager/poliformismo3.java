/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package petmanager;

import clases.clsCat;
import clases.clsDog;

public class poliformismo3 {
    public static void main(String[] args) {
            clsCat gato1= new clsCat(1,"Wismichu",2010,"gris","sano","egipcio");
    clsDog perro1= new clsDog(2,"zeus",2015,"negro","sano","Pastor Aleman",true);
    
    
    perro1.WalkAround();
    perro1.WalkAround(100);
    perro1.WalkAround(false);
    
    }
}
