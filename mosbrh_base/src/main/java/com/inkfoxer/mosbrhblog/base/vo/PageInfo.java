package com.inkfoxer.mosbrhblog.base.vo;

import com.inkfoxer.mosbrhblog.base.validator.Messages;
import com.inkfoxer.mosbrhblog.base.validator.annotion.LongNotNull;
import com.inkfoxer.mosbrhblog.base.validator.group.GetList;
import lombok.Data;

/**
 * PageVO  用于分页
 *
 * @author: 灵雨
 * @create: 2019-12-03-22:38
 */
@Data
public class PageInfo<T> {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 当前页
     */
    @LongNotNull(groups = {GetList.class}, message = Messages.PAGE_NOT_NULL)
    private Long currentPage;

    /**
     * 页大小
     */
    @LongNotNull(groups = {GetList.class}, message = Messages.SIZE_NOT_NULL)
    private Long pageSize;
}
