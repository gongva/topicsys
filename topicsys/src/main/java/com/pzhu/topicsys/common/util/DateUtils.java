package com.pzhu.topicsys.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 
 * @ClassName: DateUtils
 * @date 2013-6-24 上午8:57:16
 * @Description: 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @param months
	 *            月数
	 * @param days
	 *            天数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数，月数，天数之后的日期
	 */
	public static Date afterDate(Date date, int years, int months, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		cal.add(Calendar.MONTH, months);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @param months
	 *            月数
	 * @param days
	 *            天数
	 * @param hours
	 *            小时数
	 * @param minutes
	 *            分钟数
	 * @param seconds
	 *            秒数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数，月数，天数，小时数，分钟数，秒数之后的日期
	 */
	public static Date afterDate(Date date, int years, int months, int days, int hours, int minutes, int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		cal.add(Calendar.MONTH, months);
		cal.add(Calendar.DAY_OF_MONTH, days);
		cal.add(Calendar.HOUR_OF_DAY, hours);
		cal.add(Calendar.MINUTE, minutes);
		cal.add(Calendar.SECOND, seconds);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param days
	 *            天数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定天数之后的日期
	 */
	public static Date afterDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days);
		return cal.getTime();
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         返回指定周数之后的日期
	 *
	 * @param date
	 * @param weeks
	 * @return
	 */
	public static Date afterWeeks(Date date, int weeks) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, weeks);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param months
	 *            月数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定月数之后的日期
	 */
	public static Date afterMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数之后的日期
	 */
	public static Date afterYears(Date date, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @param months
	 *            月数
	 * @param days
	 *            天数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数，月数，天数之前的日期
	 */
	public static Date beforeDate(Date date, int years, int months, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -years);
		cal.add(Calendar.MONTH, -months);
		cal.add(Calendar.DAY_OF_MONTH, -days);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @param months
	 *            月数
	 * @param days
	 *            天数
	 * @param hours
	 *            小时数
	 * @param minutes
	 *            分钟数
	 * @param seconds
	 *            秒数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数，月数，天数，小时数，分钟数，秒数之前的日期
	 */
	public static Date beforeDate(Date date, int years, int months, int days, int hours, int minutes, int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -years);
		cal.add(Calendar.MONTH, -months);
		cal.add(Calendar.DAY_OF_MONTH, -days);
		cal.add(Calendar.HOUR_OF_DAY, -hours);
		cal.add(Calendar.MINUTE, -minutes);
		cal.add(Calendar.SECOND, -seconds);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param days
	 *            天数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定天数之前的日期
	 */
	public static Date beforeDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -days);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param months
	 *            月数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定月数之前的日期
	 */
	public static Date beforeMonths(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -months);
		return cal.getTime();
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         返回指定周数之前的日期
	 *
	 * @param date
	 * @param weeks
	 * @return
	 */
	public static Date beforeWeeks(Date date, int weeks) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, -weeks);
		return cal.getTime();
	}

	/**
	 * @param date
	 *            日期
	 * @param years
	 *            年数
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回指定年数之前的日期
	 */
	public static Date beforeYears(Date date, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -years);
		return cal.getTime();
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (pattern != null) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 把字符串转换成指定格式的日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse(dateStr);
		return date;
	}

	/**
	 * 取当前时间字符串
	 * 
	 * 时间字符串格式为：年(4位)-月份(2位)-日期(2位) 小时(2位):分钟(2位):秒(2位)
	 * 
	 * @return 时间字符串
	 */
	public static String getCurrentDateString() {
		return getCurrentDateString("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 按格式取当前时间字符串
	 * 
	 * @param formatString
	 *            格式字符串
	 * @return
	 */
	public static String getCurrentDateString(String formatString) {
		Date currentDate = new Date();
		return formatDate(currentDate, formatString);
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 取得指定日期的23点59分59秒
	 * 
	 * @param dateStr
	 *            日期 年月
	 * @return : 格式化为当天的最后一秒
	 * @author : chenlong
	 * @version : 1.00
	 * @throws ParseException
	 * @create time : 2013-3-18
	 * @description : 取得指定日期的最后一秒
	 */
	public static Date getDayLastSecond(String dateStr) throws ParseException {
		// 当日期字符串不为空或者""时，转换为Date类型
		if (dateStr != null || !"".equals(dateStr)) {
			Date date = parseDate("yyyy-MM-dd", dateStr);
			// 实例化Calendar类型
			Calendar cal = Calendar.getInstance();
			// 设置年月
			cal.setTime(date);
			// 设置时间为23时
			cal.set(Calendar.HOUR_OF_DAY, 23);
			// 设置时间为59分
			cal.set(Calendar.MINUTE, 59);
			// 设置时间为59秒
			cal.set(Calendar.SECOND, 59);
			// 设置时间为999毫秒
			cal.set(Calendar.MILLISECOND, 999);
			return cal.getTime();
		} else {
			return null;
		}
	}

	/**
	 * 获取传入日期一天的结束时间 yyyy-MM-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayLastSecond(Date date) {
		// 实例化Calendar类型
		Calendar cal = Calendar.getInstance();
		// 设置年月
		cal.setTime(date);
		// 设置时间为23时
		cal.set(Calendar.HOUR_OF_DAY, 23);
		// 设置时间为59分
		cal.set(Calendar.MINUTE, 59);
		// 设置时间为59秒
		cal.set(Calendar.SECOND, 59);
		// 设置时间为999毫秒
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 取得指定年月的第一天
	 * 
	 * @param yearMonthStr
	 *            年月
	 * @return : firstDay 第一天
	 * @author : youyd
	 * @version : 1.00
	 * @throws ParseException
	 * @create time : 2013-2-25 下午12:43:16
	 * @description : 取得指定年月的第一天
	 */
	public static Date getFirstDay(String yearMonthStr) throws ParseException {
		// 当日期字符串不为空或者""时，转换为Date类型
		if (yearMonthStr != null || !"".equals(yearMonthStr)) {
			Date yearMonth = parseDate(yearMonthStr, "yyyy-MM");
			// 实例化Calendar类型
			Calendar cal = Calendar.getInstance();
			// 设置年月
			cal.setTime(yearMonth);
			// 设置日期为该月第一天
			cal.set(Calendar.DATE, 1);
			// 返回指定年月的第一天
			return cal.getTime();
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         取得指定年月的第一天
	 *
	 * @param yearMonthStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstDay(Date yearMonthStr) throws ParseException {
		// 当日期字符串不为空或者""时，转换为Date类型
		if (yearMonthStr != null) {
			Date yearMonth = parseDate(formatDate(yearMonthStr, "yyyy-MM"), "yyyy-MM");
			// 实例化Calendar类型
			Calendar cal = Calendar.getInstance();
			// 设置年月
			cal.setTime(yearMonth);
			// 设置日期为该月第一天
			cal.set(Calendar.DATE, 1);
			// 返回指定年月的第一天
			return cal.getTime();
		} else {
			return null;
		}

	}

	/**
	 * 取得指定年月的最后一天
	 * 
	 * @param yearMonthStr
	 *            年月
	 * @return : lastDay 最后一天
	 * @author : youyd
	 * @version : 1.00
	 * @throws ParseException
	 * @create time : 2013-2-25 下午12:43:16
	 * @description : 取得指定年月的最后一天
	 */
	public static Date getLastDay(String yearMonthStr) throws ParseException {
		// 当日期字符串不为空或者""时，转换为Date类型
		if (yearMonthStr != null || !"".equals(yearMonthStr)) {
			Date yearMonth = parseDate(yearMonthStr, "yyyy-MM");
			// 实例化Calendar类型
			Calendar cal = Calendar.getInstance();
			// 设置年月
			cal.setTime(yearMonth);
			// 设置月份为下一月份
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			// 设置日期为下一月份第一天
			cal.set(Calendar.DATE, 1);
			// 设置时间为23时
			cal.set(Calendar.HOUR_OF_DAY, 23);
			// 设置时间为59分
			cal.set(Calendar.MINUTE, 59);
			// 设置时间为59秒
			cal.set(Calendar.SECOND, 59);
			// 设置时间为999毫秒
			cal.set(Calendar.MILLISECOND, 999);
			// 回滚一天 即上月份的最后一天
			cal.roll(Calendar.DATE, -1);
			// 返回指定年月的最后一天
			return cal.getTime();
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         取得指定年月的最后一天
	 *
	 * @param yearMonthStr
	 * @return
	 * @throws ParseException
	 */
	public static Date getLastDay(Date yearMonthStr) throws ParseException {
		// 当日期字符串不为空或者""时，转换为Date类型
		if (yearMonthStr != null || !"".equals(yearMonthStr)) {
			Date yearMonth = parseDate(formatDate(yearMonthStr, "yyyy-MM"), "yyyy-MM");
			// 实例化Calendar类型
			Calendar cal = Calendar.getInstance();
			// 设置年月
			cal.setTime(yearMonth);
			// 设置月份为下一月份
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			// 设置日期为下一月份第一天
			cal.set(Calendar.DATE, 1);
			// 设置时间为23时
			cal.set(Calendar.HOUR_OF_DAY, 23);
			// 设置时间为59分
			cal.set(Calendar.MINUTE, 59);
			// 设置时间为59秒
			cal.set(Calendar.SECOND, 59);
			// 设置时间为999毫秒
			cal.set(Calendar.MILLISECOND, 999);
			// 回滚一天 即上月份的最后一天
			cal.roll(Calendar.DATE, -1);
			// 返回指定年月的最后一天
			return cal.getTime();
		} else {
			return null;
		}

	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * @param date1
	 * @param date2
	 * @return 返回两个日期间的月数
	 */
	public static Integer getMonths(Date date1, Date date2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	public static Integer getYears(Date date1, Date date2) {
		Calendar calBegin = Calendar.getInstance();
		calBegin.setTime(date1);

		Calendar calEnd = Calendar.getInstance();
		calEnd.setTime(date2);

		return calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);
	}

	/**
	 * 获取传入日期的开始时间 yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDayStartSecond(Date date) {
		// 实例化Calendar类型
		Calendar cal = Calendar.getInstance();
		// 设置年月
		cal.setTime(date);
		// 设置时间为0时
		cal.set(Calendar.HOUR_OF_DAY, 0);
		// 设置时间为0分
		cal.set(Calendar.MINUTE, 0);
		// 设置时间为0秒
		cal.set(Calendar.SECOND, 0);
		// 设置时间为0毫秒
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return
	 * @about version ：1.00
	 * @auther : lifajun
	 * @Description ：返回两个日期相差天数的绝对值
	 */
	public static Integer intervalDay(Date date1, Date date2) {
		return Math.abs((int) ((date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24)));
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         返回两个日期相差周数的绝对值
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Integer intervalWeek(Date date1, Date date2) {
		return (int) Math.ceil(Math.abs((int) ((date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24))) / 7);
	}

	/**
	 * @description 计算量日期中的月数差
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Integer intervalMonth(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(date1);
		calendar2.setTime(date2);
		int year1 = calendar1.get(Calendar.YEAR);
		int year2 = calendar2.get(Calendar.YEAR);
		int month1 = calendar1.get(Calendar.MONTH);
		int month2 = calendar2.get(Calendar.MONTH);
		int month12 = Math.abs(year1 - year2) * 12;
		if (year1 - year2 > 0) {
			month1 += month12;
		} else if (year2 - year1 > 0) {
			month2 += month12;
		}
		return Math.abs(month2 - month1);
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 * 
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 * 
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * 
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}

	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取当前时间所在年的周数
	 *
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取当前时间所在年的最大周数
	 *
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取某年的第几周的开始日期
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取某年的第几周的结束日期
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取当前时间所在周的开始日期
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 
	 * @author Lipx
	 *
	 *         Description:<br>
	 *         获取当前时间所在周的结束日期
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

}
