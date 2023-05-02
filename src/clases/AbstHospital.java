

package clases;

public abstract class AbstHospital {

    private String data;
    
    public abstract String getPatientType();
    public abstract String Surgery();
    
    public String getHospitalInformation(){
        return "la informacion es "+ this.data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
