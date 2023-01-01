package com.inkfoxer.mosbrhblog.xo.mapper;

import com.inkfoxer.mosbrhblog.commons.entity.Admin;
import com.inkfoxer.mosbrhblog.base.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员表 Mapper 接口
 *
 * @author 灵雨
 * @since 2018-09-04
 */
public interface AdminMapper extends SuperMapper<Admin> {

    /**
     * 通过uid获取管理员
     *
     * @return
     */
    public Admin getAdminByUid(@Param("uid") String uid);
}
