package edu.eci.arsw.dinoni.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.dinoni.model.Venta;
import edu.eci.arsw.dinoni.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    /**
     * Metodo que retorna todas las ventas
     * @return
     */

    public List<Venta> getAllVentas(){
        return ventaRepository.findAll();
    }

    /**
     * Metodo que retorna una venta por su id
     * @param id
     * @return
     */

    public Optional<Venta> getVentaById(long id){
        return ventaRepository.findById(id);
    }

    /**
     * Metodo que retorna si existe una venta por su id
     * @param id
     * @return
     */

    public boolean existsById(long id){
        return ventaRepository.existsById(id);
    }

    /**
     * Metodo que retorna una venta por su fecha
     * @param fecha
     * @return
     */

    public Optional<Venta> getVentaByFecha(String fecha){
        return ventaRepository.findByFecha(fecha);
    }

    /**
     * Metodo que retorna si existe una venta por su fecha
     * @param fecha
     * @return
     */

    public boolean existsByFecha(String fecha){
        return ventaRepository.existsByFecha(fecha);
    }

    /**
     * Metodo que guarda una venta
     * @param venta
     */
    public void saveVenta(Venta venta){
        ventaRepository.save(venta);
    }

    /**
     * Metodo que elimina una venta por su id
     * @param id
     */
    public void deleteVenta(long id){
        ventaRepository.deleteById(id);
    }

    /**
     * Metodo que elimina todas las ventas
     */
    public void deleteAllVentas(){
        ventaRepository.deleteAll();
    }

    /**
     * Metodo que actualiza una venta
     * @param id id de la venta a actualizar
     * @param venta
     */
    public void updateVenta(long id,Venta venta){
        Venta temp = ventaRepository.findById(id).get();
        temp.setVentasDia(venta.getVentasDia());
        temp.setFecha(venta.getFecha());
        temp.setVentasSemana(venta.getVentasSemana());
        temp.setVentasMes(venta.getVentasMes());
        ventaRepository.save(temp);
    }
    
}
