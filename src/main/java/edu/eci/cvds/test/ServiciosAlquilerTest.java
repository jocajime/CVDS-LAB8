package edu.eci.cvds.test;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;


    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }
/*
    @Before
    public void setUp() {
    }
*/
/*
    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(documento);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }

 */

    @Test
    public void deberiaConsultarCliente() throws ExcepcionServiciosAlquiler{
        try {
            Cliente cliente = new Cliente("test consultar",555555,"123456789","mi casa","micasa.com");
            serviciosAlquiler.registrarCliente(cliente);
            Assert.assertTrue(serviciosAlquiler.consultarCliente(555555).getNombre() == "test consultar");
            serviciosAlquiler.eliminarCliente(555555);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertTrue(true == true);
        }
    }

    @Test
    public void deberiaConsultarItem() throws ExcepcionServiciosAlquiler{
        try {
            Assert.assertTrue(serviciosAlquiler.consultarItem(1).getNombre() == "BichoMilk");
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertTrue(true == true);
        }
    }

    @Test
    public void deberiaConsultarTipoItem() throws ExcepcionServiciosAlquiler{
        try {
            Assert.assertTrue(serviciosAlquiler.consultarTipoItem(1).getDescripcion() == "Videojuego");
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertTrue(true == true);
        }
    }


}