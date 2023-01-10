package com.jiasu.mdl.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.utils
 * @Description: 时间戳转date
 * @date 2023/1/10 14:36
 */
public class TimeStampToDateUtil {

    public static Date TimeStampToDate(Integer timeStamp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //一般网上的转换是没有中间new Long（timeStamp）,因为他们都是精确到毫秒的时间戳，不用再乘以1000进行转换
        long longTimeStamp = new Long(new Long(timeStamp) * 1000);
        Date date = new Date(longTimeStamp);
        String dareString = simpleDateFormat.format(date);
        return date;
    }
}
