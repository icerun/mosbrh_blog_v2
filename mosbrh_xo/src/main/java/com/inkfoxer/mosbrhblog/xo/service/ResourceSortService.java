package com.inkfoxer.mosbrhblog.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.inkfoxer.mosbrhblog.commons.entity.ResourceSort;
import com.inkfoxer.mosbrhblog.xo.vo.ResourceSortVO;
import com.inkfoxer.mosbrhblog.base.service.SuperService;

import java.util.List;

/**
 * 资源分类表 服务类
 *
 * @author 灵雨
 * @date 2018-09-04
 */
public interface ResourceSortService extends SuperService<ResourceSort> {

    /**
     * 获取资源分类列表
     *
     * @param resourceSortVO
     * @return
     */
    public IPage<ResourceSort> getPageList(ResourceSortVO resourceSortVO);

    /**
     * 新增资源分类
     *
     * @param resourceSortVO
     */
    public String addResourceSort(ResourceSortVO resourceSortVO);

    /**
     * 编辑资源分类
     *
     * @param resourceSortVO
     */
    public String editResourceSort(ResourceSortVO resourceSortVO);

    /**
     * 批量删除资源分类
     *
     * @param resourceSortVOList
     */
    public String deleteBatchResourceSort(List<ResourceSortVO> resourceSortVOList);

    /**
     * 置顶资源分类
     *
     * @param resourceSortVO
     */
    public String stickResourceSort(ResourceSortVO resourceSortVO);
}
