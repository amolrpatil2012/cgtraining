package qualifierdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"qualifierdemo.controller","qualifierdemo.model"})
public class ProjectConfig {

}
