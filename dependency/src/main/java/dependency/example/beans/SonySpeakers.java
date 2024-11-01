package dependency.example.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speaker{

	public void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("Playing Music Using Sony Speakers");
		
	}

}
