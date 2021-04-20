package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}

/**
  - 애노테이션에는 상속이라는 개념이 없음
  - @Qulifier 뿐만 아니라 다른 애노테이션들도 함께 조합해서 사용할 수 있음
  - 스프링이 제공하는 기능을 뚜렷한 목적 없이 무분별하게 재정의하는 것은
    유지보수에 더 혼란만 가중할 수 있음
 */