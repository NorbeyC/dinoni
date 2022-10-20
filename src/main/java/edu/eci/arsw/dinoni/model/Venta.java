package edu.eci.arsw.dinoni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int ventasDia;
    private String fecha;
    private int ventasSemana;
    private int ventasMes;

    public Venta() {
    }

    /**
     * Constructor de la clase Venta
     * @param id
     * @param ventasDia
     * @param fecha
     * @param ventasSemana
     * @param ventasMes
     */

    public Venta(long id, int ventasDia, String fecha, int ventasSemana, int ventasMes) {
        this.id = id;
        this.ventasDia = ventasDia;
        this.fecha = fecha;
        this.ventasSemana = ventasSemana;
        this.ventasMes = ventasMes;
    }

    /**
     * Constructor de la clase Venta sin recibir id
     * @param ventasDia
     * @param fecha
     * @param ventasSemana
     * @param ventasMes
     */

    public Venta(int ventasDia, String fecha, int ventasSemana, int ventasMes) {
        this.ventasDia = ventasDia;
        this.fecha = fecha;
        this.ventasSemana = ventasSemana;
        this.ventasMes = ventasMes;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVentasDia() {
        return this.ventasDia;
    }

    public void setVentasDia(int ventasDia) {
        this.ventasDia = ventasDia;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVentasSemana() {
        return this.ventasSemana;
    }

    public void setVentasSemana(int ventasSemana) {
        this.ventasSemana = ventasSemana;
    }

    public int getVentasMes() {
        return this.ventasMes;
    }

    public void setVentasMes(int ventasMes) {
        this.ventasMes = ventasMes;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", ventasDia='" + getVentasDia() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", ventasSemana='" + getVentasSemana() + "'" +
            ", ventasMes='" + getVentasMes() + "'" +
            "}";
    }
}
