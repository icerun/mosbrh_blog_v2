package com.inkfoxer.mosbrhblog.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inkfoxer.mosbrhblog.commons.entity.SysParams;
import com.inkfoxer.mosbrhblog.xo.vo.SysParamsVO;
import com.inkfoxer.mosbrhblog.base.service.SuperService;

import java.util.List;

/**
 * 参数配置 服务类
 *
 * @author 灵雨
 * @date 2020年7月21日15:54:00
 */
public interface SysParamsService extends SuperService<SysParams> {

    /**
     * 获取参数配置列表
     *
     * @param sysParamsVO
     * @return
     */
    public IPage<SysParams> getPageList(SysParamsVO sysParamsVO);

    /**
     * 通过 参数键名 获取参数配置
     *
     * @param paramsKey
     * @return
     */
    public SysParams getSysParamsByKey(String paramsKey);

    /**
     * 通过 参数键名 获取参数值
     *
     * @param paramsKey
     * @return
     */
    public String getSysParamsValueByKey(String paramsKey);

    /**
     * 新增参数配置
     *
     * @param sysParamsVO
     */
    public String addSysParams(SysParamsVO sysParamsVO);

    /**
     * 编辑参数配置
     *
     * @param sysParamsVO
     */
    public String editSysParams(SysParamsVO sysParamsVO);

    /**
     * 批量删除参数配置
     *
     * @param sysParamsVOList
     */
    public String deleteBatchSysParams(List<SysParamsVO> sysParamsVOList);
}
