package com.green.refresh.plan.model;

import lombok.Data;

@Data
public class PlanEntity {
    private int iplan;
    private int igroup;
    private int iuser;
    private String createdAt;
    private int delYn;
}
