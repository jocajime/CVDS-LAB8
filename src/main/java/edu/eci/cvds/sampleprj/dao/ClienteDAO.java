package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;
import java.util.List;

public interface ClienteDAO {

    public void insertearCliente(int documento, String nombre, String telefono, String direccion, String email, boolean vetado) throws PersistenceException;

    public Cliente consultarCliente(int id) throws PersistenceException;

    public  List<Cliente> consultarClientes() throws PersistenceException;

    void guardarItemRentadoCliente(int idcli, int idit, Date fechainicio, Date fechafin) throws PersistenceException;

    public void eliminarCliente(int documento) throws PersistenceException;


}
