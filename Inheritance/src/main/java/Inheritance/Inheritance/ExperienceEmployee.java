package Inheritance.Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ExperienceEmployee")
public class ExperienceEmployee extends Employee {

	private int experience;
	private int hike;
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getHike() {
		return hike;
	}
	public void setHike(int hike) {
		this.hike = hike;
	}
	@Override
	public String toString() {
		return "ExperienceEmployee [experience=" + experience + ", hike=" + hike + "]";
	}
	
}
