package com.yzx.usercenter.model.request;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;


@Data
public class TeamJoinRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 20020804L;

    /**
     * id
     */
    private Long teamId;


    /**
     * 密码
     */
    private String password;
}
