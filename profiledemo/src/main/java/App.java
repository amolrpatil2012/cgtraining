import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import profiledemo.config.LinuxConfig;
import profiledemo.config.WindowsConfig;
import profiledemo.model.OS;

public class App {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext();
		
		OS os = null;
		
		if ( context.getEnvironment().getProperty("os.name").contains("Windows"))
		{
			System.setProperty("spring.profiles.active", "windows");
			context.register(WindowsConfig.class);
			context.refresh();
			os = (OS)context.getBean("getWindows");			
		}
		if ( context.getEnvironment().getProperty("os.name").contains("Linux"))
		{
			System.setProperty("spring.profiles.active", "linux");
			context.register(LinuxConfig.class);
			context.refresh();
			os = (OS)context.getBean("getLinuxOS");			
		}
		  if (os != null ) {

              os.printOSName();

      }

     

      context.close();
	}

}
