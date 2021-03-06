package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;

import java.util.Date;
import java.util.List;

public class MyBatisClienteDAO implements ClienteDAO{

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public void insertearCliente(int documento, String nombre, String telefono, String direccion, String email, boolean vetado) throws PersistenceException {
        try{
            clienteMapper.insertarCliente(documento,nombre,telefono,direccion,email,vetado);
        } catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al insertar el CLiente ",e);
        }
    }

    @Override
    public Cliente consultarCliente(int id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el CLiente "+id,e);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar los clientes ",e);
        }
    }

    @Override
    public void guardarItemRentadoCliente(long idcli, int idit, Date fechainicio, Date fechafin) throws PersistenceException {
        try {
            clienteMapper.agregarItemRentadoACliente( idcli, idit, fechainicio, fechafin);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al añadir el nuevo cliente", e);
        }
    }





    @Override
    public void eliminarCliente(int documento) throws PersistenceException {
        try{
            clienteMapper.eliminarCliente(documento);
        }catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al eliminar cliente "+documento,e);
        }
    }



}