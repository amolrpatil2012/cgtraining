package cg.hello.beans;

public class Address {
	private String city , country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}

	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	

}
