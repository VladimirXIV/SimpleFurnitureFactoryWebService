package noncom.just.fun.util;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import noncom.just.fun.dto.ExpireTimeDto;
import noncom.just.fun.model.Order;

public class AppHelper {
	
	public static ExpireTimeDto getDaysToExpireDate(Order order) {
		
		LocalDate expireLocalDate = order.getFinalDate();	
		LocalDate currentLocalDate = LocalDate.now();
		
		int minutes = DateTime.now().getMinuteOfHour();
		int hours = (minutes == 0) ? (24 - DateTime.now().getHourOfDay()) : (23 - DateTime.now().getHourOfDay());		
		int days = (hours == 0) ? (Days.daysBetween(currentLocalDate, expireLocalDate).getDays())
				                : (Days.daysBetween(currentLocalDate, expireLocalDate).getDays() - 1);
		
		ExpireTimeDto dayswithhours = new ExpireTimeDto(days, hours);
        
        return dayswithhours;	
	}

}
