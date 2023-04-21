/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package clases;

public class clsDoctor {
    private String Name;
    private String Licencia;

    public clsDoctor(String Name, String Licencia) {
        this.Name = Name;
        this.Licencia = Licencia;
    }

    
    
    //metodos getters and setters 
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }
    
    
    
}
