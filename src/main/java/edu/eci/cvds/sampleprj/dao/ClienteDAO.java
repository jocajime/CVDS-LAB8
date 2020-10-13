package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

public interface ClienteDAO {

    public void save(int documento, String nombre,String telefono, String direccion,String email, int vetado) throws PersistenceException;

    public Cliente load(int id) throws PersistenceException;

}
