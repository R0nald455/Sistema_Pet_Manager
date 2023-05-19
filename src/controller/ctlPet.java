/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import clases.clsCat;
import clases.clsDog;
import clases.clsPet;
import model.modelCat;
import model.modelDog;

public class ctlPet {
    private modelDog modelDog;
    private modelCat modelCat;
    
 

    
    

    public boolean CreatePet(clsPet pet){
    try{
        System.out.println("contolador");
        switch(pet.getAnimalType()){
            case "Perro":
                this.modelDog=new modelDog();
                this.modelDog.createPet((clsDog)pet);
                break;
            case "Gato":
                this.modelCat.createPet((clsCat)pet);
                break;
        }
        return true;
    }catch(Exception e){}
        return false;
    }
    
    public boolean EditPet(clsPet pet){
    try{
        switch(pet.getAnimalType()){
            case "Perro":
                this.modelDog=new modelDog();
                this.modelDog.editPet((clsDog)pet);
                break;
            case "Gato":
                this.modelCat.createPet((clsCat)pet);
                break;
        }
        return true;
    }catch(Exception e){}
        return false;
    }
        
    public clsPet searchPet(int code,String type){
        clsPet pet = null;
    try{
        switch(type){
            case "Perro":
                this.modelDog=new modelDog();
                pet=modelDog.searchPet(code);
                break;
            case "Gato":
                this.modelCat.searchPet(code);
                break;
        }
        return pet;
    }catch(Exception e){}
        return pet;
    }
            
    public boolean DeletePet(clsPet pet){
    try{
        switch(pet.getAnimalType()){
            case "Perro":
                this.modelDog=new modelDog();
                this.modelDog.deletePet((clsDog)pet);
                break;
            case "Gato":
                this.modelCat.deletePet((clsCat)pet);
                break;
        }
        return true;
    }catch(Exception e){}
        return false;
    }
}
