package com.green.refresh.utils;

import java.nio.file.Paths;
import java.util.UUID;

public class FileUtils {
    public static String getExt(String fileNm) {
        String ext = fileNm.substring(fileNm.lastIndexOf("."));
        return ext;
    }

    public static String getFileNm(String fileNm) {
        String FileName = fileNm.substring(0,fileNm.lastIndexOf("."));
        return FileName;
    }


    public static String makeRandomFileNm(String fileNm) {
        String uuid = UUID.randomUUID().toString();
        String ext = getExt(fileNm);

        String fullName = uuid+ext;

        return fullName;
    }


    public static String getAbsolutePath(String src) {
        return Paths.get(src).toFile().getAbsolutePath();
    }
}
