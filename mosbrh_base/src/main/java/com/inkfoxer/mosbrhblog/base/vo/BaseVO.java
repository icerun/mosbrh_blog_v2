package com.inkfoxer.mosbrhblog.base.vo;

import com.inkfoxer.mosbrhblog.base.validator.annotion.IdValid;
import com.inkfoxer.mosbrhblog.base.validator.group.Delete;
import com.inkfoxer.mosbrhblog.base.validator.group.Update;
import lombok.Data;

/**
 * BaseVO   view object 表现层 基类对象
 *
 * @author: 灵雨
 * @create: 2019-12-03-22:38
 */
@Data
public class BaseVO<T> extends PageInfo<T> {

    /**
     * 唯一UID
     */
    @IdValid(groups = {Update.class, Delete.class})
    private String uid;

    private Integer status;
}
