package profiledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import profiledemo.model.OS;
import profiledemo.model.WindowsOS;

@Configuration
@Profile("windows")
public class WindowsConfig {
	
	@Bean
	public OS getWindows()
	{
		return new WindowsOS();
	}

}
