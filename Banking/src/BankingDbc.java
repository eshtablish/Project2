import java.sql.*;
//in this program we connect database(MYSQL) to program
public class BankingDbc {
	Connection con=null;
	public void connectDB()throws Exception {
		// Entering mysql drivers to class
		Class.forName("com.mysql.cj.jdbc.Driver");
		// connecting data base with database name, user name and password using local host
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","Hiremath@1");
	}
	// here registering customer details to database where checking customer name is there or not
	// if name is there it throws exception other wise inserting to table
    public int registerCustomer(Customer c1)throws Exception 
        {
		 String query2="select * from bank where cname='"+c1.cname+"'";
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery(query2);
		 if(rs.next())
		 {
		 	return -1;
		  }
		 else 
		 {
		  String query="insert into bank (cid,cname,cpassword,cphone,cactbal) values(?,?,?,?,?)";
	 	
		  PreparedStatement pst=con.prepareStatement(query);
		  pst.setInt(1, c1.cid);
		  pst.setString(2, c1.cname);
		  pst.setString(3, c1.cpassword);
		  pst.setString(4, c1.cphone);
		  pst.setInt(5, c1.cactbal);
		
	   	  int count =pst.executeUpdate();
		  return count;
		  }
        }
     //login into the account
  	public int login(String username,String pwd)throws Exception{

  		String query2="select * from bank where cname='"+username+"'";
  		Statement st=con.createStatement();
  		ResultSet rs=st.executeQuery(query2);
  		if(rs.next()) {
  			
  			String password=rs.getString(3);
  			//if password from db equal to entered password then login
  			if(password.equals(pwd)) {
  				int cid= rs.getInt(1);
  				return cid;
  			}
  			else {
  				return 0;
  			}
  		}
  		else {
  			return -1;
  		}
  	}
  	
  	//withdraw amount from user account
  	public  int withdraw(int cid,int amount)throws Exception {
  		//getting details by customerid
  		String query="select * from bank where cid="+cid;
  		
  		Statement st=con.createStatement();
  		ResultSet rs=st.executeQuery(query);
  		rs.next();
  		int accbal=rs.getInt(5);
  		//if available balance is greater than required amount then withdraw
  		if(accbal>amount) {
  			
  			accbal-=amount;
  			//updating remaining amount
  			String quer2="update bank set cactbal="+accbal+" where cid="+cid;
  			PreparedStatement pst=con.prepareStatement(quer2);
  			pst.executeUpdate();
  			return accbal;
  		}
  		else {
  			return -1;
  		}
  	}
  	// Deposing the amount to customer account
  	public int deposit(int cid, int amount)throws Exception {
  		
  		String query="select * from bank where cid="+cid;
  		
  		Statement st=con.createStatement();
  		ResultSet rs=st.executeQuery(query);
  		rs.next();
  		int availamount=rs.getInt(5);
  		// adding amount with balance amount in account
  		availamount+=amount;
  		String query2="update bank set caccbal="+availamount;
  		PreparedStatement pst=con.prepareStatement(query2);
  		
  		pst.executeUpdate();
  		
  		return availamount;
  		
  	}
  	
  	// Checking balance in account
  	public int checkBalance(int cid)throws Exception{
  		
  		String query="select * from bank where cid="+cid;
  		
  		Statement st=con.createStatement();
  		ResultSet rs=st.executeQuery(query);
  		rs.next();
  		int availabaleamount=rs.getInt(5);
  		return availabaleamount;
  	}	
  	// customer can change there pin/password in account 
  	public int pinChange(int cid,String oldpwd,String newpwd)throws Exception{
  		
  		String query="select * from bank where cid="+cid;
  		
  		Statement st=con.createStatement();
  		ResultSet rs=st.executeQuery(query);
  		rs.next();
  		
  		String pwd=rs.getString(3);
  		if(pwd.equals(oldpwd)) {
  			
  			String query2="update banking set cpassword='"+newpwd+"' where cid="+cid;
  			
  			PreparedStatement pst=con.prepareStatement(query2);
  			int res=pst.executeUpdate();
  			return res;
  		}
  		else {
  			return -1;
  		}
  		
  		
  	}
}