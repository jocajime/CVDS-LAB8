package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "AlquilerItemsBean")
@ApplicationScoped
public class AlquilerItemsBean extends BasePageBean {

    @Inject
    private ServiciosAlquiler serviciosAlquiler;

    /**
     * consultar todos os clientes
     * @return todos los clientes
     * @throws ExcepcionServiciosAlquiler
     */
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return serviciosAlquiler.consultarClientes();
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
            return serviciosAlquiler.consultarCliente(documento);
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes");
        }
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
            serviciosAlquiler.registrarCliente(c);
        } catch (Exception e) {
            throw new ExcepcionServiciosAlquiler("Error al registrar cliente");
        }
    }



}
