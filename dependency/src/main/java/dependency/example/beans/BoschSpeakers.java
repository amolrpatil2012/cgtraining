package dependency.example.beans;

import org.springframework.stereotype.Component;

@Component
public class BoschSpeakers implements Speaker{

	public void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("Playing Music Using Bosch Speakers");
		
	}
}
