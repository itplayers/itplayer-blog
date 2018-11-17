package com.itplayer.utils.file;

import com.itplayer.common.exception.SystemException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class FileUtils {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

	}
    
    public static boolean deleteFile(String filePath) throws Exception {
    	boolean flag = false;
    	File file = new File(filePath);
    	if(!file.exists()){
    		return flag;
    	}
    	flag = file.delete();
    	return flag;
    }
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            boolean mkdirs = targetFile.mkdirs();
            if(!mkdirs){
                throw new SystemException("文件目录不存在，创建文件目录失败");
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath + File.separator + fileName);
            out.write(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
