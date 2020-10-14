package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class MyBatisItemDAO implements ItemDAO{

    @Inject
    private ItemMapper itemMapper;

    @Override
    public void insertarItem(int id, String nombre, String descripcion, Date fechalanzamiento, int tarifaxdia, String formatorenta, String genero, int tipoitem) throws PersistenceException{
        try{
            itemMapper.insertarItem(id,nombre,descripcion,fechalanzamiento,tarifaxdia,formatorenta,genero,tipoitem);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el item ",e);
        }
    }

    @Override
    public Item consultarItem(int id) throws PersistenceException {
        try{
            return itemMapper.consultarItem(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item "+id,e);
        }
    }

    @Override
    public List<Item> consultarItems() throws PersistenceException {
        try{
            return itemMapper.consultarItems();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar items ",e);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() throws PersistenceException {
        try{
            return itemMapper.consultarItemsDisponibles();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar items ",e);
        }


    }


    @Override
    public void eliminarItem(int id) throws PersistenceException {
        try{
            itemMapper.eliminarItem(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al eliminar item "+id,e);
        }


    }

}