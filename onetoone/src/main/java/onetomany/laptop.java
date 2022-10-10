package onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class laptop {
	
	@Id
	private int laptopId;
	private String laptopName;
	public int getlaptopId() {
		return laptopId;
	}
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	@Override
	public String toString() {
		return "laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + "]";
	}
	
		
	
}
