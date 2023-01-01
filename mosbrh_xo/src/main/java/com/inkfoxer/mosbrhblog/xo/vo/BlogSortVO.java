package com.inkfoxer.mosbrhblog.xo.vo;

import com.inkfoxer.mosbrhblog.base.validator.annotion.NotBlank;
import com.inkfoxer.mosbrhblog.base.validator.group.Insert;
import com.inkfoxer.mosbrhblog.base.validator.group.Update;
import com.inkfoxer.mosbrhblog.base.vo.BaseVO;
import lombok.Data;

/**
 * BlogSortVO
 *
 * @author: 灵雨
 * @create: 2019年12月6日12:56:08
 */
@Data
public class BlogSortVO extends BaseVO<BlogSortVO> {

    /**
     * 分类名
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String sortName;

    /**
     * 分类介绍
     */
    private String content;

    /**
     * 排序字段
     */
    private Integer sort;


    /**
     * OrderBy排序字段（desc: 降序）
     */
    private String orderByDescColumn;

    /**
     * OrderBy排序字段（asc: 升序）
     */
    private String orderByAscColumn;

    /**
     * 无参构造方法
     */
    BlogSortVO() {

    }

}
