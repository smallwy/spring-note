package stone.spring.Ioc.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages ={"stone.spring.Ioc.scan.include","stone.spring.Ioc.scan.exclude"},excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,pattern = "stone.spring.Ioc.scan.exclude.*")},
		includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX,pattern = "stone.spring.Ioc.scan.include.*"),@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {MyAnnotion.class})}
		)
public class AppConfig {

}