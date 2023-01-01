package com.inkfoxer.mosbrhblog.base.validator.annotion;


import com.inkfoxer.mosbrhblog.base.validator.constraint.IntegerValidator;
import com.inkfoxer.mosbrhblog.base.validator.Messages;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 判断Integer是否为空【注解】
 *
 * @author 灵雨
 * @date 2019年12月4日13:12:52
 */
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IntegerValidator.class})
public @interface IntegerNotNull {

    boolean required() default true;

    String message() default Messages.CK_NUMERIC_DEFAULT;

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
