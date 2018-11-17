package com.itplayer.common.serialutils;

import com.itplayer.utils.date.DateUtils;

import java.util.Date;
import java.util.Random;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class SerNumUtils {
	private static int sortNum = 0;

	public synchronized static int getSortNum() {
		sortNum = sortNum % 100;
		synchronized (SerNumUtils.class) {
			return sortNum++;
		}
	}

	/**
	 * 获取随机编号
	 *
	 * @param t
	 * @param <T>
	 * @return
	 *         @
	 */
	public static <T> String getSerNum(T t) {
		Date date = new Date();
		String dateToStr = DateUtils.dateToStr(date, "yyyyMMddHHmmssSSS");
		if (null != t) {
			Class<?> aClass = t.getClass();
			SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
			if (null == annotation) {
				return dateToStr + getSortNum();
			}
			String prefix = annotation.prefix();
			String suffix = annotation.suffix();
			return prefix + dateToStr + getSortNum() + suffix;
		} else {
			return dateToStr + getSortNum();
		}
	}

	public static String getSerNum() {
		Date date = new Date();
		String dateToStr = DateUtils.dateToStr(date, "yyyyMMddHHmmssSSS");
		return dateToStr + getSortNum();
	}

	/**
	 * 获取前缀
	 */
	public static <T> String getPrefix(T t) {
		Class<?> aClass = t.getClass();
		SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
		String prefix = annotation.prefix();
		return prefix;
	}

	/**
	 * 获取后缀缀
	 */
	public static <T> String getSuffix(T t) {
		Class<?> aClass = t.getClass();
		SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
		String suffix = annotation.suffix();
		return suffix;
	}

	public static String getSortNumByDate(Date date) {
		String dateTime = DateUtils.dateToStr(date, "ssSSS");
		int max = 99;
		int min = 0;
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return dateTime + s;
	}


	public static String getRadomNum(){
		Date date = new Date();
		String dateToStr = DateUtils.dateToStr(date, "yyMMddHHmmss");
		return dateToStr + getSortNum();
	}


}
