package com.inkfoxer.mosbrhblog.picture.vo;

import com.inkfoxer.mosbrhblog.base.vo.BaseVO;
import lombok.Data;

/**
 * CommentVO
 *
 * @author: 灵雨
 * @create: 2020年1月11日16:15:52
 */
@Data
public class StorageVO extends BaseVO<StorageVO> {

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 存储大小
     */
    private long storagesize;
}
