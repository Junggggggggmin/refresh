package com.green.refresh.plan;

import com.green.refresh.plan.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    int insPlan(PlanEntity entity);
    List<PlanSelVo> selPlan(PlanSelDto dto);
    int updPlan(PlanUpdDto dto);
    int delPlan(PlanEntity entity);
}
