package com.inkfoxer.mosbrhblog.xo.vo;

import com.inkfoxer.mosbrhblog.base.validator.group.GetList;
import com.inkfoxer.mosbrhblog.base.validator.group.Insert;
import com.inkfoxer.mosbrhblog.base.validator.group.Update;
import com.inkfoxer.mosbrhblog.base.vo.BaseVO;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * 图片实体类
 *
 * @author 灵雨
 * @date 2018年9月17日16:08:58
 */
@ToString
@Data
public class PictureVO extends BaseVO<PictureVO> {

    /**
     * 图片UID
     */
    private String fileUid;

    /**
     * 图片UIDs
     */
    @NotBlank(groups = {Insert.class})
    private String fileUids;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 所属相册分类UID
     */
    @NotBlank(groups = {Insert.class, Update.class, GetList.class})
    private String pictureSortUid;
}
