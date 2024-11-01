package profiledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import profiledemo.model.LinuxOS;
import profiledemo.model.OS;

@Configuration
@Profile("linux")
public class LinuxConfig {
	
	@Bean
	public OS getLinuxOS()
	{
		return new LinuxOS();
	}

}
