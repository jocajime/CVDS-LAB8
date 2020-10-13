package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

public class MyBatisClienteDAO implements ClienteDAO{

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public void save(int documento, String nombre,String telefono, String direccion,String email, int vetado) throws PersistenceException {
        try{
            clienteMapper.insertarCliente(documento,nombre,telefono,direccion,email,vetado);
        } catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar el CLiente ",e);
        }
    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el CLiente "+id,e);
        }


    }

}