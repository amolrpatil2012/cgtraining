package dependency.example.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CEARTTyres implements Tyre{
	public void move() {
		System.out.println("Moving Using CEAT Tyres");
		
	}

}
