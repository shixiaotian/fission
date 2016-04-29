package com.sxt.auth.utils;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 扩展Listutils
 *
 * Created by shixiaotian on 16/4/23.
 *
 */
public class ListUtils extends org.apache.commons.collections.ListUtils{

    /**
     * 判断集合是否为空
     *
     * @param list
     *
     * @return boolean
     *
     */
    public static boolean isEmpty(List list) {

        if(list == null || list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String arg[]) {

        List a=new ArrayList();


        System.out.println(ListUtils.isEmpty(a));
    }


}
