package com.yzx.usercenter.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class TeamQuitRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 20020804L;

    /**
     * id
     */
    private Long teamId;


}
