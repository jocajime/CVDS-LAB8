package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.*;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO itemDAO;

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private TipoItemDAO tipoItemDAO;

    @Inject
    private ItemRentadoDAO itemRentadoDAO;

    //Cliente
    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.consultarCliente((int) docu);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el cliente con documento  "+docu,ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try{
            return clienteDAO.consultarClientes();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes ",e);
        }

    }

    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        try{
            clienteDAO.insertearCliente((int) c.getDocumento(),c.getNombre(),c.getTelefono(),c.getDireccion(),c.getEmail(),c.getVetado());
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar clientes ",e);
        }
    }

    //Item
    @Override
    public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler{
        try{
            return itemDAO.consultarItemsDisponibles();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar los items disponibles ",e);
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.consultarItem(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        try {
            itemDAO.insertarItem(i.getId(),i.getNombre(),i.getDescripcion(),i.getFechaLanzamiento(),(int) i.getTarifaxDia(),i.getFormatoRenta(),i.getGenero(),i.getTipo().getID());
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al insertar item ",ex);
        }
    }

    //TipoItem

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try{
            return tipoItemDAO.consultarTiposItem();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar tipos item ",e);
        }
    }

    @Override
    public void registrarTiposItem(TipoItem ti) throws ExcepcionServiciosAlquiler {
        try{
            tipoItemDAO.save(ti.getID(),ti.getDescripcion());
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al registrar tipos item ",e);
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try{
            return tipoItemDAO.consultarTipoItem(id);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar tipo item "+id,e);
        }
    }

    //ItemRentado

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        try{
            return itemRentadoDAO.loadItems((int) idcliente);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar item rentado ",e);
        }
    }

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}