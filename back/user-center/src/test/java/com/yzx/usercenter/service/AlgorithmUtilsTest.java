package com.yzx.usercenter.service;

import com.yzx.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {

    @Test
    public void test() {
        //字符串1通过几次增删改字符的操作可以变成字符串2
        String str1 = "鱼皮是狗";
        String str2 = "鱼皮不是狗";
        String str3 = "鱼皮是鱼不是狗";
        int i = AlgorithmUtils.minDistance(str1, str2);
        int j = AlgorithmUtils.minDistance(str1, str3);
        int l = AlgorithmUtils.minDistance(str2, str3);
        System.out.println(i);
        System.out.println(j);
        System.out.println(l);
    }

    @Test
    public void testTags() {
        List<String> list1 = Arrays.asList("Java", "大三", "男");
        List<String> list2 = Arrays.asList("Java", "大三", "女");
        List<String> list3 = Arrays.asList("Python", "大四", "女");
        //字符串1通过几次增删改字符的操作可以变成字符串2
        int i = AlgorithmUtils.minDistance(list1, list2);
        int j = AlgorithmUtils.minDistance(list1, list3);
        int l = AlgorithmUtils.minDistance(list2, list3);
        System.out.println(i);
        System.out.println(j);
        System.out.println(l);
    }

}
