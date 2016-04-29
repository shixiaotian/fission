package com.sxt.auth.utils;


import java.util.List;

/**
 *
 * 扩展Listutils
 *
 * Created by xiaotian.shi on 16/4/23.
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

    /**
     * 判断集合是否不为空
     *
     * @param list
     *
     * @return boolean
     */
    public static boolean isNotEmpty(List list) {

        if(ListUtils.isEmpty(list)) {
            return false;
        } else {
            return true;
        }
    }

//    public static void main(String arg[]) {
//
//        List a=new ArrayList();
//
//
//        System.out.println(ListUtils.isEmpty(a));
//    }


}
