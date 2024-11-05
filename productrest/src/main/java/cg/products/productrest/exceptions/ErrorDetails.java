


package cg.products.productrest.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
@NoArgsConstructor
public class ErrorDetails {

	private String message;
	private int statusCode;
	
}
