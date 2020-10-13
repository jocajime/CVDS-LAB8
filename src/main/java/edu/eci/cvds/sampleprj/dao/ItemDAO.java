package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

import java.util.Date;
import java.util.List;

public interface ItemDAO {

    public void insertarItem(int id, String nombre, String descripcion, Date fechalanzamiento,int tarifaxdia,String formatorenta,String genero,int tipoitem)
            throws PersistenceException;

    public Item consultarItem(int id) throws PersistenceException;

    public List<Item> consultarItems() throws PersistenceException;

    public List<Item> consultarItemsDisponibles() throws PersistenceException;

}
