/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package petmanager;

import clases.clsDoctor;
import clases.clsVeterinary;

public class AbstractClass {
    public static void main(String[] args) {
        clsDoctor doctor1 = new clsDoctor("Jonathan","123456852");
        clsVeterinary vete1 = new clsVeterinary("VetePet","3216548987","Cra 15a-65",doctor1);
    
        vete1.setData(vete1.getName()+" "+vete1.getAddres());
        
        String data= vete1.getHospitalInformation();
        String type= vete1.getPatientType();
        String Surgery  = vete1.Surgery();
        
        
        System.out.println("Data: "+data);
        System.out.println("Type: "+type);
        System.out.println("Surgery: "+Surgery);
    }
}
