package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.demo.utils.Mdk5.convertMD5;
import static com.example.demo.utils.Mdk5.string2MD5;

@SpringBootTest
class DemoApplicationTests {


    /**
     * 判断输入的密码和数据库中保存的MD5密码是否一致
     *
     * @param inputPassword 输入的密码
     * @param md5DB         数据库保存的密码
     * @return
     */
    @Test
     boolean passwordIsTrue(String inputPassword, String md5DB) {

        String md5 = string2MD5(inputPassword);
        return md5DB.equals(md5);
    }



    @Test
    void test2() {
        String s = new String("012345");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("密码是否一致：" + passwordIsTrue("123456", "e10adc3949ba59abbe56e057f20f883e"));
        System.out.println(convertMD5("123456"));
    }


}
