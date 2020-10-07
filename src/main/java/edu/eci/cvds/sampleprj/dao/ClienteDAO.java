package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

public interface ClienteDAO {

    public void save(Cliente cli) throws PersistenceException;

    public Cliente load(int id) throws PersistenceException;

}
