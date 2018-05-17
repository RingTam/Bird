package org.bird.war;

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
 * 类名：War
 * 作者：Monster
 * 时间：2016/1/11 14:11
 * 说明：
 */
public class War {

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
        File warDir = getWarDirFile(tartDir, getWarName(file));
        for (Enumeration<? extends ZipEntry> entries = zipFile.entries();
             entries.hasMoreElements(); ) {
            ZipEntry zipEntry = entries.nextElement();
            if (zipEntry.isDirectory()) {
                mkdirsWar(warDir, zipEntry);
                continue;
            }
            writeEntry(warDir, zipFile, zipEntry);
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
     * @param warDir   war文件夹
     * @param zipFile  zip文件
     * @param zipEntry zip条目
     * @throws IOException 输入输出异常
     */
    private void writeEntry(File warDir, ZipFile zipFile, ZipEntry zipEntry)
            throws IOException {
        InputStream is = zipFile.getInputStream(zipEntry);
        Files.copy(is, getWarEntryPath(warDir, zipEntry),
                StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 创建 war文件夹
     *
     * @param warDir   war文件夹
     * @param zipEntry zip条目
     */
    private void mkdirsWar(File warDir, ZipEntry zipEntry) {
        File file = getWarEntryFile(warDir, zipEntry);
        file.mkdirs();
    }

    /**
     * 获取 war条目文件
     *
     * @param warDir   war文件夹
     * @param zipEntry zip条目
     * @return 文件
     */
    private File getWarEntryFile(File warDir, ZipEntry zipEntry) {
        return new File(warDir, zipEntry.getName());
    }

    /**
     * 获取 war条目路径
     *
     * @param warDir   war文件夹
     * @param zipEntry zip条目
     * @return 文件
     */
    private Path getWarEntryPath(File warDir, ZipEntry zipEntry) {
        return Paths.get(warDir.getPath(), zipEntry.getName());
    }

    /**
     * 获取 war文件夹
     *
     * @param file    文件
     * @param warName war名称
     * @return 文件
     */
    private File getWarDirFile(File file, String warName) {
        return new File(file, warName);
    }

    /**
     * 获取 war文件名
     *
     * @param warPath war路径
     * @return war名称
     */
    protected String getWarName(String warPath) {
        int lastIndex = warPath.lastIndexOf(File.separatorChar);
        if (lastIndex == -1) {
            return warPath.substring(0, warPath.indexOf('.'));
        }
        return warPath.substring(lastIndex, warPath.indexOf('.'));
    }

    /**
     * 获取 war文件名
     *
     * @param file 文件
     * @return war名称
     */
    protected String getWarName(File file) {
        return getWarName(file.getPath());
    }
}
