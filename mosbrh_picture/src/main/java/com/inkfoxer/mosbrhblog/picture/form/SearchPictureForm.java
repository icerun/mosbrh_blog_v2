package com.inkfoxer.mosbrhblog.picture.form;

import com.inkfoxer.mosbrhblog.base.vo.FileVO;
import lombok.Data;

@Data
public class SearchPictureForm extends FileVO {
    private String searchKey;
    private Integer count;
}
