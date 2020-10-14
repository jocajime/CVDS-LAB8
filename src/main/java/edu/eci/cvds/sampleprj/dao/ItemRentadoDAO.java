package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.Date;
import java.util.List;

public interface ItemRentadoDAO {

    public void save(int id, int cliente, int items, Date fechainicio, Date fechafin) throws PersistenceException;

    public ItemRentado loadItem(int id) throws PersistenceException;

    public List<ItemRentado> loadItems(int id) throws PersistenceException;

    public List<ItemRentado> loadItemsCliente(int idcliente) throws PersistenceException;

    public void eliminarItemRentado(int id) throws PersistenceException;
}
