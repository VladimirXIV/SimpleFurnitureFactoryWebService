package noncom.just.fun.dto;

public class ExpireTimeDto {
	
	private int days;
	private int hours;
	
	public ExpireTimeDto(int days, int hours) {
		this.days = days;
		this.hours = hours;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
}
