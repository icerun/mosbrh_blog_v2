package com.inkfoxer.mosbrhblog.base.validator.constraint;

import com.inkfoxer.mosbrhblog.utils.StringUtils;
import com.inkfoxer.mosbrhblog.base.validator.annotion.NotBlank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 判断是否为空字符串【校验器】
 *
 * @author 灵雨
 * @date 2019年12月4日13:17:17
 */
public class StringValidator implements ConstraintValidator<NotBlank, String> {
    @Override
    public void initialize(NotBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value) || StringUtils.isEmpty(value.trim())) {
            return false;
        }
        return true;
    }
}
