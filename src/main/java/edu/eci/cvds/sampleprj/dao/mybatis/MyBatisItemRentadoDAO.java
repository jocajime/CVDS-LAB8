package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;

import java.util.Date;
import java.util.List;

public class MyBatisItemRentadoDAO implements ItemRentadoDAO {
    @Inject
    private ItemRentadoMapper itemRentadoMapper;

    @Override
    public void save(int id, int cliente, int items, Date fechainicio, Date fechafin) throws PersistenceException {
        try {
            itemRentadoMapper.insertarItemRentado( id,  cliente,  items,  fechainicio,  fechafin);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar el item rentado",e);
        }
    }

    @Override
    public ItemRentado loadItem(int id) throws PersistenceException {
        try{
            return itemRentadoMapper.consultarItemRentado(id);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item rentado "+id,e);
        }
    }

    @Override
    public List<ItemRentado> loadItems(int id) throws PersistenceException {
        try{
            return itemRentadoMapper.consultarItemsRentados();
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el item rentado "+id,e);
        }
    }

    @Override
    public List<ItemRentado> loadItemsCliente(int idcliente) throws PersistenceException {
        try{
            return itemRentadoMapper.consultarItemsRentadosCliente(idcliente);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el items del cliente "+idcliente,e);
        }
    }
}
