package jp.co.who.spring_tutorial.api.validator.users.domain;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { UserIdDuplicateCheckValidator.class })
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdDuplicateCheck {

    // これは設定値からとる場合
    String message() default "{mrs.app.reservation.UserIdDuplicateCheckValidator.message}";

    // groups, payload は必須
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
            ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        UserIdDuplicateCheck[] value();
    }
}
