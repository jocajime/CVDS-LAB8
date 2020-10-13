package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ItemRentadoMapper {

    public void insertarItemRentado(@Param("id") int id,
                                    @Param("cliente") int  cliente,
                                    @Param("items") int  items,
                                    @Param("fechainicio") Date fechainicio,
                                    @Param("fechafin") Date  fechafin);

    public ItemRentado consultarItemRentado(@Param("id") int id);

    public List<ItemRentado> consultarItemsRentados();
}
