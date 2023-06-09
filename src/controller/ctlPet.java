/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import clases.clsCat;
import clases.clsDog;
import clases.clsPet;
import java.util.LinkedList;
import model.modelCat;
import model.modelDog;

public class ctlPet {
    private modelDog modelDog;
    private modelCat modelCat;

    public ctlPet() {
        this.modelDog=new modelDog();
        this.modelCat=new modelCat();
    }
    

    public boolean CreatePet(clsPet pet){
    try{
        switch(pet.getAnimalType()){
            case "Perro":                
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
                this.modelDog.editPet((clsDog)pet);
                break;
            case "Gato":
                this.modelCat.editPet((clsCat)pet);
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
                pet=modelDog.searchPet(code);
                break;
            case "Gato":
                pet=modelCat.searchPet(code);
                break;
        }
        return pet;
    }catch(Exception e){}
        return pet;
    }
            
    public boolean DeletePet(int code, String type){
    try{
        switch(type){
            case "Perro":
                this.modelDog.deletePet(code);
                break;
            case "Gato":
                this.modelCat.deletePet(code);
                break;
        }
        return true;
    }catch(Exception e){}
        return false;
    }
    
    
    public LinkedList  fillList(String type){
        LinkedList<clsPet> petObjectList=null;
    try{
        switch(type){
            case "Perro":
                return modelDog.fillList();
            case "Gato":
                return modelCat.fillList();
        }
    }catch(Exception e){
        return petObjectList;
    }
        return null;
    }
}
