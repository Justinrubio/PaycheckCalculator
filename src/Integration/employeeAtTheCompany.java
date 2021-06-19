package Integration;

public class employeeAtTheCompany {
	private double hourlyWage;
	private int totalHours;
	private double weeklySales;

	// constructor with no parameters
	public employeeAtTheCompany() {
		this(20, 40, 400);
	}

	// constructor with 1 parameter
	public employeeAtTheCompany(double wage) {
		this(wage, 40, 400);
	}

	// constructor with 2 parameters
	public employeeAtTheCompany(double wage, int hours) {
		this(wage, hours, 400);
	}

	// constructor with 3 parameters
	public employeeAtTheCompany(double wage, int hours, double sales) {
		setTypicalStats(wage, hours, sales);
	}

	// method for expected statistics of a typical employee of 'The Company'
	public void setTypicalStats(double wage, int hours, double sales) {
		setHourlyWage(wage);
		setTotalHours(hours);
		setWeeklySales(sales);
	}

	// public sets
	public void setHourlyWage(double wage) {
		hourlyWage = ((wage >= 10 && wage <= 20) ? wage : 20);
	}

	public void setTotalHours(int hours) {
		totalHours = ((hours > 0 && hours < 168) ? hours : 40);
	}

	public void setWeeklySales(double sales) {
		weeklySales = ((sales > 0) ? sales : 400);
	}

	// public gets
	public double getHourlyWage() {
		return hourlyWage;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public double getWeeklySales() {
		return weeklySales;
	}
	
	public String averageEmployeeStats() {
		return String.format("Hourly Wage:  $%s \nHours per Week:  %s \nAmount of sales:  $%s \n", 
				getHourlyWage(), getTotalHours(), getWeeklySales());
		
		
		
	}

}
