package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.annotations.Param;

public interface TipoItemMapper {

    public void insertarTipoItem(@Param("id") int id,
                                 @Param("descripcion") String descripcion);

    public TipoItem consultarTipoItem(@Param("id") int id);

}
