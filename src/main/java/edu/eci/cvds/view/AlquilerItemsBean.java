package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.sql.Date;
import java.util.List;

@ManagedBean(name = "AlquilerItemsBean")
@ApplicationScoped
public class AlquilerItemsBean extends BasePageBean {

    @Inject
    private ServiciosAlquiler servicioAlquiler;
    public long costo;
    private Cliente cliente;

    /**
     * consultar todos os clientes
     * @return todos los clientes
     * @throws ExcepcionServiciosAlquiler
     */
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return servicioAlquiler.consultarClientes();
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes");
        }
    }

    /**
     * consultar un cliente por su documento
     * @param documento
     * @return cliente con el documento consultado
     * @throws ExcepcionServiciosAlquiler
     */
    public Cliente consultarCliente(long documento) throws ExcepcionServiciosAlquiler{
        try{
            return servicioAlquiler.consultarCliente(documento);
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes");
        }
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }




    /**
     * Registrar un nuevo cliente en la base de datos
     * @param nombre
     * @param documento
     * @param telefono
     * @param direccion
     * @param email
     * @throws ExcepcionServiciosAlquiler
     */
    public void registrarCliente(String nombre, long documento, String telefono, String direccion, String email) throws ExcepcionServiciosAlquiler {
        try{
            Cliente c = new Cliente( nombre,  documento,  telefono,  direccion,  email);
            servicioAlquiler.registrarCliente(c);
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al registrar cliente");
        }

    }

    /**
     *
     * @param iditem
     * @param numdias
     * @throws ExcepcionServiciosAlquiler
     */

    public void consultarCosto(int iditem , int numdias) throws ExcepcionServiciosAlquiler {
        try {
            this.costo = servicioAlquiler.consultarCostoAlquiler(iditem, numdias);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            throw new ExcepcionServiciosAlquiler("Error al consultar costo alquiler");
        }
    }

    /**
     * retorna el costo del alquiler
     * @return
     */
    public long getCosto(){
        return costo;
    }

    /**
     *
     * @param iditem
     * @return
     * @throws ExcepcionServiciosAlquiler
     */
    public long consultarMulta(int iditem) throws ExcepcionServiciosAlquiler {
        try {
            return servicioAlquiler.consultarMultaAlquiler(iditem, new Date(System.currentTimeMillis()));
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            throw new ExcepcionServiciosAlquiler("Error al consultar multa alquiler");
        }
    }

    /**
     *
     * @param idItem
     * @param numdias
     * @throws ExcepcionServiciosAlquiler
     */
    public void registrarAlquiler(int idItem , int numdias) throws ExcepcionServiciosAlquiler {
        try {
            Item item = servicioAlquiler.consultarItem(idItem);
            servicioAlquiler.registrarAlquilerCliente(new Date(System.currentTimeMillis()),cliente.getDocumento(),item,numdias);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }

    }



}
