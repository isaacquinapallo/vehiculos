import javax.swing.*;
import java.awt.*;

public class VariableVehiculos extends Vehiculos {

    public String placa;
    public String marca;
    public String cilindraje;
    public String combustible;
    public String color;
    public String propietario;

    public VariableVehiculos() {}
    public VariableVehiculos(String placa, String marca, String cilindraje, String combustible, String color, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.combustible = combustible;
        this.color = color;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getColor() {
        return color;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
