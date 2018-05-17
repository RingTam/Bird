package org.bird.sar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 类名：Sar
 * 作者：Monster
 * 时间：2016/1/11 14:11
 * 说明：
 */
public class Sar {

    /**
     * 解压
     *
     * @param file 文件
     * @throws IOException 输入输出异常
     */
    protected void unpack(File file) throws IOException {
        File parentFile = file.getParentFile();
        unpack(file, parentFile);
    }

    /**
     * 解压
     *
     * @param file    文件
     * @param tartDir 目标文件夹
     * @throws IOException 输入输出异常
     */
    protected void unpack(File file, File tartDir) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        File sarDir = getWarDirFile(tartDir, getWarName(file));
        for (Enumeration<? extends ZipEntry> entries = zipFile.entries();
             entries.hasMoreElements(); ) {
            ZipEntry zipEntry = entries.nextElement();
            if (zipEntry.isDirectory()) {
                mkdirsWar(sarDir, zipEntry);
                continue;
            }
            writeEntry(sarDir, zipFile, zipEntry);
        }
        zipFile.close();
    }

    /**
     * 解压
     *
     * @param filePath 文件路径
     * @throws IOException 输入输出异常
     */
    protected void unpack(String filePath) throws IOException {
        unpack(new File(filePath));
    }


    /**
     * 写 条目
     * 将压缩包里面的每一个条目，写入文件。
     *
     * @param sarDir   sar文件夹
     * @param zipFile  zip文件
     * @param zipEntry zip条目
     * @throws IOException 输入输出异常
     */
    private void writeEntry(File sarDir, ZipFile zipFile, ZipEntry zipEntry)
            throws IOException {
        InputStream is = zipFile.getInputStream(zipEntry);
        Files.copy(is, getWarEntryPath(sarDir, zipEntry),
                StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 创建 sar文件夹
     *
     * @param sarDir   sar文件夹
     * @param zipEntry zip条目
     */
    private void mkdirsWar(File sarDir, ZipEntry zipEntry) {
        File file = getWarEntryFile(sarDir, zipEntry);
        file.mkdirs();
    }

    /**
     * 获取 sar条目文件
     *
     * @param sarDir   sar文件夹
     * @param zipEntry zip条目
     * @return 文件
     */
    private File getWarEntryFile(File sarDir, ZipEntry zipEntry) {
        return new File(sarDir, zipEntry.getName());
    }

    /**
     * 获取 sar条目路径
     *
     * @param sarDir   sar文件夹
     * @param zipEntry zip条目
     * @return 文件
     */
    private Path getWarEntryPath(File sarDir, ZipEntry zipEntry) {
        return Paths.get(sarDir.getPath(), zipEntry.getName());
    }

    /**
     * 获取 sar文件夹
     *
     * @param file    文件
     * @param sarName sar名称
     * @return 文件
     */
    private File getWarDirFile(File file, String sarName) {
        return new File(file, sarName);
    }

    /**
     * 获取 sar文件名
     *
     * @param sarPath sar路径
     * @return sar名称
     */
    protected String getWarName(String sarPath) {
        int lastIndex = sarPath.lastIndexOf(File.separatorChar);
        if (lastIndex == -1) {
            return sarPath.substring(0, sarPath.indexOf('.'));
        }
        return sarPath.substring(lastIndex, sarPath.indexOf('.'));
    }

    /**
     * 获取 sar文件名
     *
     * @param file 文件
     * @return sar名称
     */
    protected String getWarName(File file) {
        return getWarName(file.getPath());
    }
}
