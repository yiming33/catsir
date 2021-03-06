package cn.catsir.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 月份操作工具类
 *
 * @author JD 2015年9月15日
 *
 */
public class GetAllDaysForMonthUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String args[]) {
	
	Calendar a = Calendar.getInstance();  
        a.set(Calendar.YEAR, 2015);  
        a.set(Calendar.MONTH,2-1);
        
        Date d = a.getTime();
        // 月初
        System.out.println("月初" + sdf.format(getMonthStart(d)));
        // 月末
        System.out.println("月末" + sdf.format(getMonthEnd(d)));
 
        Date date = getMonthStart(d);
        Date monthEnd = getMonthEnd(d);
        while (!date.after(monthEnd)) {
            System.out.println(sdf.format(date));
            date = getNext(date);
        }
 
    }
 
    public static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        return calendar.getTime();
    }
 
    public static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        return calendar.getTime();
    }
 
    public static Date getNext(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
}
