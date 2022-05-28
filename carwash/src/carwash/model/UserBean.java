package carwash.model;

public class UserBean {
	
	String adminusername;
	String adminpass;
	String cust_name;
	String cust_phone;
	String cust_email;
	String cust_password;
	int cust_id;
	int book_id;
	String book_date;
	String book_time;
	String car_plateno;
	String car_name;
	String cartype;
	String car_package;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_date() {
		return book_date;
	}
	public void setBook_date(String book_date) {
		this.book_date = book_date;
	}
	public String getBook_time() {
		return book_time;
	}
	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}
	public String getCar_plateno() {
		return car_plateno;
	}
	public void setCar_plateno(String car_plateno) {
		this.car_plateno = car_plateno;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getCar_package() {
		return car_package;
	}
	public void setCar_package(String car_package) {
		this.car_package = car_package;
	}
	
		public String getAdminusername() {
			return adminusername;
		}
		public void setAdminusername(String adminusername) {
			this.adminusername = adminusername;
		}
		public String getAdminpass() {
			return adminpass;
		}
		public void setAdminpass(String adminpass) {
			this.adminpass = adminpass;
		}
	
		public int getCust_id() {
			return cust_id;
		}
		public void setCust_id(int cust_id) {
			this.cust_id = cust_id;
		}
		public boolean valid;
		
	
		public String getCust_name() {
			return cust_name;
		}
		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}
		public String getCust_phone() {
			return cust_phone;
		}
		public void setCust_phone(String cust_phone) {
			this.cust_phone = cust_phone;
		}
		public String getCust_email() {
			return cust_email;
		}
		public void setCust_email(String cust_email) {
			this.cust_email = cust_email;
		}
		public String getCust_password() {
			return cust_password;
		}
		public void setCust_password(String cust_password) {
			this.cust_password = cust_password;
		}
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}


	}



