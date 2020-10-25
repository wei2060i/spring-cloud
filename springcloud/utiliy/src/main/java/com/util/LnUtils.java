package com.util;

import java.util.Map;

public class LnUtils {
    /**
     * 随机数
     * @return
     */
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * 读取 yml
     * @return
     */
    public static <T> T ymlToObject(Map map, String key) {
        String[] arr = key.split("\\.");
        for (int i = 0; i < arr.length - 1; i++) {
            map = (Map) map.get(arr[i]);
        }
        return (T) map.get(arr[arr.length - 1]);
    }


}
