package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)     // excludeFilters 로 설정하지 않은 @Component 가 붙은 설정 정보를 자동으로 등록해줌
      // @Configuration 인터페이스를 확인하면 @Component 가 붙은것을 확인할 수 있음
public class AutoAppConfig {

}
