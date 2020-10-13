package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

import java.util.List;

public class MyBatisTipoItemDAO implements TipoItemDAO {

    @Inject
    private TipoItemMapper tipoItemMapper;


    @Override
    public void save(int id, String descripcion) throws PersistenceException {
        try{
            tipoItemMapper.insertarTipoItem(id,descripcion);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar el tipo item",e);
        }
    }

    @Override
    public TipoItem load(int id) throws PersistenceException {
        try{
            return tipoItemMapper.consultarTipoItem(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar el tipo item",e);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws PersistenceException {
        try{
            return tipoItemMapper.consultarTiposItem();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar tipos item",e);
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws PersistenceException {
        try{
            return tipoItemMapper.consultarTipoItem(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar tipo item" + id,e);
        }
    }
}
