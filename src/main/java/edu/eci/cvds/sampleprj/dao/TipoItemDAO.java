package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;

import java.util.List;

public interface TipoItemDAO {

    public void save(int id, String descripcion) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;

    public List<TipoItem> consultarTiposItem() throws PersistenceException;

    public TipoItem consultarTipoItem(int id) throws PersistenceException;
}
