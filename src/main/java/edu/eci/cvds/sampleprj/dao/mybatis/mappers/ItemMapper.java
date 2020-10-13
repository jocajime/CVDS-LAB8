package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {

    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("iditem") int id);

    public List<Item> consultarItemsDisponibles();
    
    public void insertarItem(@Param("id") int id,
                             @Param("nombre") String nombre,
                             @Param("descripcion") String descripcion,
                             @Param("fechalanzamiento") Date fechalanzamiento,
                             @Param("tarifaxdia") int tarifaxdia,
                             @Param("formatorenta") String formatorenta,
                             @Param("genero") String genero,
                             @Param("tipoitem") int tipoitem);

}
