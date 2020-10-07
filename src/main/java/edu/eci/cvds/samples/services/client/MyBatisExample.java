/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;


import edu.eci.cvds.sampleprj.dao.mybatis.mappers.*;
import edu.eci.cvds.samples.entities.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();


        // ClienteMapper
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        // CONSULTAR EL CLIENTE CON EL ID
        System.out.println("*******consultarCliente*******");
        System.out.println(cm.consultarCliente(703));
        // CONSULTAR TODOS LOS CLIENTES
        System.out.println("*******consultarClientes******");
        System.out.println(cm.consultarClientes());
        // AGREGAR ITEM RENTADO A CLIENTE
        System.out.println("*agregarItemRentadoACliente***");
        //cm.agregarItemRentadoACliente(703, 5, new Date(2020,9,30), new Date(2020,10,3));

        //ItemMapper
        ItemMapper it = sqlss.getMapper(ItemMapper.class);
        //CONSULTAR ITEM POR SU ID
        System.out.println("*******consultarItem***********");
        System.out.println(it.consultarItem(5));
        //CONSULTAR TODOS LOS ITEMS
        System.out.println("*******consultarItems**********");
        System.out.println(it.consultarItems());
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
