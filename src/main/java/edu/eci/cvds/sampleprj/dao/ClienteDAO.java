package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.List;

public interface ClienteDAO {

    public void insertearCliente(int documento, String nombre, String telefono, String direccion, String email, boolean vetado) throws PersistenceException;

    public Cliente consultarCliente(int id) throws PersistenceException;

    public  List<Cliente> consultarClientes() throws PersistenceException;

    public void eliminarCliente(int documento) throws PersistenceException;
}
