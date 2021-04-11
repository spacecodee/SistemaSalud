package Modelo.Doctor;

public class M_DoctorCombo {

    private int idDoctor;
    private String nombre;

    public int getidDoctor() {
        return idDoctor;
    }

    public void setidDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return this.nombre;
    }

}
