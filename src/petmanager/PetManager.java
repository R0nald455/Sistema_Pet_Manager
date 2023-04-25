package petmanager;

import clases.clsPet;
import clases.clsVeterinary;
import java.util.Date;

public class PetManager {
    public static void main(String[] args) {
        
        /*datos de  pet1*/
        clsPet pet1=new clsPet();
        pet1.setCode(1);
        pet1.setName("Kira");
        pet1.setBorn_year(2018);
        pet1.setColor("Blanco");
        pet1.setHealthStatus("sano");
       
       
        /*datos pet2*/
        clsPet pet2=new clsPet(1,"Zeus",2021,"cafe","Malito");
        
        /*extraer el año*/
        Date current_date=new Date();
        int current_year=current_date.getYear();
        
        
        int agePet1=pet1.getBorn_year()-current_year;
        int agePet2=pet2.getBorn_year()-current_year;
        /*condicion para comparar las edades*/
        if(agePet1>agePet2){
            
            System.out.println(pet1.getName()+" es menor que "+pet2.getName());
            
        }else if(agePet1<agePet2){
            
            System.out.println(pet1.getName()+" es mayor que "+pet2.getName());
            
        }else{
            
            System.out.println( " las dos mascotas tienen la misma edad");
            
        }
        
        
        
        pet2.getName();
        pet2.move();
        pet2.eat();
        pet2.sound();
        
        //clsVeterinary vete1=new clsVeterinary("PetHealth","3124568974","Cra 4 13 08","Fabio Gomez","1254251521");
        clsPet pet5=new clsPet(2,"Zeus",2021,"blanco","Sano");
        clsPet pet4=new clsPet(1,"Tobey",2012,"negro","Enfermo");
        clsPet pet3=new clsPet(3,"Motas",2016,"gris","Enfermo");
        
        
        
        /*vete1.AgregarPet(pet4);
        vete1.AgregarPet(pet5);
        vete1.AgregarPet(pet3);
        
        vete1.mostrarPets();
        vete1.petCare();*/
        
        
        
    }
}
