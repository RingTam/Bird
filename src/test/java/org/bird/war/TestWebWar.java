package org.bird.war;

import org.bird.FileDefinition;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 类名：测试 Web War
 * 作者：Monster
 * 时间：2016/1/11 14:19
 * 说明：
 */
public class TestWebWar {

    /**
     * 测试 解压
     */
    @Test
    public void test01() throws IOException {
        File file = new File(FileDefinition.getAppsFile(), "test.war");
        WebWar war = new WebWar(file.getPath());
        war.unpack();
    }
}
