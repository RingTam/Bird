package org.bird.sar;

import org.bird.FileDefinition;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 类名：测试 Web Sar
 * 作者：Monster
 * 时间：2016/1/11 14:19
 * 说明：
 */
public class TestWebSar {

    /**
     * 测试 解压
     */
    @Test
    public void test01() throws IOException {
        File file = new File(FileDefinition.getAppsFile(), "test.sar");
        WebSar sar = new WebSar(file.getPath());
        sar.unpack();
    }
}
