package Inheritance.Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fresherEmployee")
public class FresherEmployee extends Employee {
	
	private int ContractPeriod;
	private int increment;
	public int getContractPeriod() {
		return ContractPeriod;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public void setContractPeriod(int contractPeriod) {
		ContractPeriod = contractPeriod;
	}
	@Override
	public String toString() {
		return "FresherEmployee [ContractPeriod=" + ContractPeriod + ", increment=" + increment + "]";
	}
}