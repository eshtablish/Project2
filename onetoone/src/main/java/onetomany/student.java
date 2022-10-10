package onetomany;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class student {
     
	@Id
	private int  sid;
	private String sname;
	private String sdomain;
	
	@OneToMany
    @JoinColumn(name="sid")
	private List<laptop> slaptop;


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSdomain() {
		return sdomain;
	}


	public void setSdomain(String sdomain) {
		this.sdomain = sdomain;
	}


	public List<laptop> getSlaptop() {
		return slaptop;
	}


	public void setSlaptop(List<laptop> slaptop) {
		this.slaptop = slaptop;
	}


	@Override
	public String toString() {
		return "student [sid=" + sid + ", sname=" + sname + ", sdomain=" + sdomain + "]";
	}
	
	
}
	