package dependency.example.beans;

import org.springframework.stereotype.Component;

@Component
public class MRFTyres implements Tyre{

	public void move() {
		System.out.println("Moving Using MRF Tyres");
		
	}

}
