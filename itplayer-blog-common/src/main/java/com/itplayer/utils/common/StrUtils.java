package com.itplayer.utils.common;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class StrUtils {

    private static final Long CLEAR_TIME = 4362091751236L;

    private StrUtils() {
    }

    /**
     * 判断字符串为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
        return !isNull(str);
    }


}
