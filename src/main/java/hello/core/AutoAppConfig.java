package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan (
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
/**
 * @ComponentScan -
        excludeFilters 로 설정하지 않은 @Component 가 붙은 설정 정보를 자동으로 등록해줌
        @Configuration 인터페이스를 확인하면 @Component 가 붙은것을 확인할 수 있음
        basePackages :  탐색할 패키지의 시작 위치를 지정, 이 패키지를 포함해서 하위 패키지를 모두 탐색
        basePackageClasses : 지정한 클래스의 패키지를 탐색 시작 위치로 지정
        만약 지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

    < 권장 방법 >
    패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것
    - 최근 스프링 부트도 이 방법을 기본으로 제공한다
 */

public class AutoAppConfig {

}
