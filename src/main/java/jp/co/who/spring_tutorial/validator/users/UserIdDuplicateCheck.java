package jp.co.who.spring_tutorial.validator.users;

import java.lang.annotation.*;

import javax.validation.Constraint;

@Documented
@Constraint(validatedBy = { UserIdDuplicateCheckValidator.class })
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdDuplicateCheck {

    String message() default "{mrs.app.reservation.UserIdDuplicateCheckValidator.message}";

}
