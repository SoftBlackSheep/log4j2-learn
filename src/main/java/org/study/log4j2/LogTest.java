package org.study.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.Date;

/**
 * 例子
 * Created by LiZW on 2016/12/27.
 */
public class LogTest {

    // 日志格式 - 使用占位符号
    @Test
    public void test01() {
        Logger logger = LogManager.getFormatterLogger(LogTest.class);

        String name = "李志伟";
        Date birthday = new Date();

        logger.debug("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.debug("用户名称:[%s], 日期:[%s]", name, birthday);
        logger.debug("用户名称:[%1$s], 日期:[%2$tY-%2$tm-%2$te]", name, birthday);
        logger.debug("Integer.MAX_VALUE = [%,d]", Integer.MAX_VALUE);
        logger.debug("Long.MAX_VALUE = [%,d]", Long.MAX_VALUE);

        LogManager.shutdown();
    }

    // 日志格式 - 使用占位符号(兼用老的占位符格式)
    @Test
    public void test02() {
        Logger logger = LogManager.getLogger(LogTest.class);

        String name = "李志伟";
        Date birthday = new Date();

        logger.debug("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.debug("用户名称:[%s], 日期:[%s]", name, birthday);

        logger.printf(Level.INFO, "用户名称:[%s], 日期:[%s]", name, birthday);
        logger.printf(Level.INFO, "用户名称:[%1$s], 日期:[%2$tY-%2$tm-%2$te]", name, birthday);
        logger.printf(Level.INFO, "Integer.MAX_VALUE = [%,d]", Integer.MAX_VALUE);
        logger.printf(Level.INFO, "Long.MAX_VALUE = [%,d]", Long.MAX_VALUE);

        LogManager.shutdown();
    }

    // 日志高亮和样式
    @Test
    public void test03() {
//        Logger logger = LogManager.getFormatterLogger();
        Logger logger = LogManager.getLogger();

        String name = "李志伟";
        Date birthday = new Date();

        logger.debug("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.info("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.warn("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.error("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.fatal("用户名称:[{}], 日期:[{}]", name, birthday);
        logger.error("异常信息提示", new RuntimeException("异常信息"));

        LogManager.shutdown();
    }

    // 输出大量日志
    @Test
    public void test04() {
        Logger logger = LogManager.getLogger();
        String name = "李志伟";
        Date birthday = new Date();
        for (int i = 0; i < 10000; i++) {
            logger.debug("次数[{}] 用户名称:[{}], 日期:[{}]", i, name, birthday);
            logger.info("次数[{}] 用户名称:[{}], 日期:[{}]", i, name, birthday);
            logger.warn("次数[{}] 用户名称:[{}], 日期:[{}]", i, name, birthday);
            logger.error("次数[{}] 用户名称:[{}], 日期:[{}]", i, name, birthday);
            logger.fatal("次数[{}] 用户名称:[{}], 日期:[{}]", i, name, birthday);
        }
        LogManager.shutdown();
    }

}
