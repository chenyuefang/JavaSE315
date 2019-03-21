package work;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 编写程序，计算任意两个日期之间的天数
 */

public class E370 {

    public static  double getDays(Calendar c1,Calendar c2) {
        Date date1=c1.getTime();
        Date date2=c2.getTime();
        return  getDays(date1,date2);
    }
    public static double getDays(Date date1,Date date2) {
        long time1 =date1.getTime();
        long time2 =date2.getTime();
        double d=Math.abs((time1-time2)/1000d/60/60/24);
        return d;
    }
    public static double getDays(String str1,String str2) throws ParseException {
        DateFormat format=new SimpleDateFormat("YYY-MM-dd");
        Date date1= format.parse(str1);
        Date date2= format.parse(str2);
        return getDays(date1,date2);
    }
}
