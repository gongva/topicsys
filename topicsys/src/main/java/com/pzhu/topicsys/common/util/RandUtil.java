/**
 * 
 */
package com.pzhu.topicsys.common.util;

import java.util.UUID;

/**
 * Desc:各种随机工具方法
 *
 */
public class RandUtil {

    /**
     * Desc:生成uuid(去掉了-)
     * 
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
