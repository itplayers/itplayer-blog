package com.itplayer.utils.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class ObjUtils {
    /**
     * 对象复制
     *
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T cloneObject(T obj) throws Exception {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(obj);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return (T) in.readObject();
    }
}
