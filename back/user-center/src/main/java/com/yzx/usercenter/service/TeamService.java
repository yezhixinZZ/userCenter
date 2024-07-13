package com.yzx.usercenter.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yzx.usercenter.model.domain.Team;
import com.yzx.usercenter.model.domain.User;
import com.yzx.usercenter.model.dto.TeamQuery;
import com.yzx.usercenter.model.request.TeamJoinRequest;
import com.yzx.usercenter.model.request.TeamQuitRequest;
import com.yzx.usercenter.model.request.TeamUpdateRequest;
import com.yzx.usercenter.model.vo.TeamUserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
* @author Merer
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-07-01 09:30:48
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除队伍(解散)
     * @param id
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
