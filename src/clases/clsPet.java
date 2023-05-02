package clases;

import interfaces.IAnimal;
import interfaces.IVertebrate;

 public class clsPet implements IAnimal,IVertebrate {
    private int code;
    private String name;
    private int born_year;
    private String color;
    private String  healthStatus;   
    
    

    
    
    /*constuctor vacio*/
    public clsPet(){
    }

    /*constructor con parametros*/
    public clsPet(int code, String name, int born_year, String color, String healthStatus) {
        this.code = code;
        this.name = name;
        this.born_year = born_year;
        this.color = color;
        this.healthStatus = healthStatus;
    }

       
    

    
    
    
        /*metodos */
    public void eat(){
        System.out.println(this.getName()+" esta comiendo");
    }
    
    public void move(){
        System.out.println(this.getName()+" se esta moviendo");
    }
    
    public void sound(){
        System.out.println(this.getName()+" esta ladrando");
    }
    
    
    @Override
    public String getAnimalType() {
        return "domestico";
    }

    @Override
    public int getNumberOfBones() {
        return 0;
    }
    
 
    
    /*getters and setters*/
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBorn_year() {
        return born_year;
    }
    public void setBorn_year(int born_year) {
        this.born_year = born_year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }


    
}
