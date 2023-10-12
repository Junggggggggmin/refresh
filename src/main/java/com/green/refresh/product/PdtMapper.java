package com.green.refresh.product;

import com.green.refresh.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtMapper {
    int insPdt(PdtInsDto dto);
    //    List<PdtSelVo> selPdt(PdtSelDto dto);
    List<PdtSelVo> selPdt(PdtSelDto dto);
    int updPdt(PdtEntity entity);
    int finishPdt(PdtEntity entity);
    int delPdt(PdtEntity entity);
}
