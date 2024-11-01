package dependency.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

	@Autowired
	Tyre tyre;
	@Autowired
	Speaker speaker;
	
	public void info()
	{
		tyre.move();
		speaker.playMusic();
	}
}
