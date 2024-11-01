package dependency.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dependency.example.beans")
public class ProjectConfig {

}
