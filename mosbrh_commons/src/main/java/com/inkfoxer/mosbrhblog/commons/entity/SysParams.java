package com.inkfoxer.mosbrhblog.commons.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.inkfoxer.mosbrhblog.base.entity.SuperEntity;
import lombok.Data;


/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author 灵雨
 * @since 2020年7月21日15:47:30
 */
@Data
@TableName("t_sys_params")
public class SysParams extends SuperEntity<SysParams> {

    /**
     * 参数名称
     */
    private String paramsName;

    /**
     * 参数键名
     */
    private String paramsKey;

    /**
     * 参数键值
     */
    private String paramsValue;

    /**
     * 参数类型，是否系统内置（1：是，0：否）
     */
    private Integer paramsType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sort;
}
