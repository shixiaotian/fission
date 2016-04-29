package com.sxt.auth.base.constant;

/**
 *
 * 权限数据库结构文件
 *
 * Created by shixiaotian on 16/4/21.
 */
public interface AuthDB {

    /**
     *
     * 代码表
     *
     */
    public interface codeList {

        /**
         * 表名
         */
        public static final String tableName = "codeList";

        /**
         * 代码号
         */
        public static final String code = "code";

        /**
         * 描述
         */
        public static final String describe = "describe";

        /**
         * 创建日期
         */
        public static final String createDate = "createDate";

    }

    /**
     *
     * 用户表
     *
     */
    public interface user {

        /**
         * 表名
         */
        public static final String tableName = "user";

        /**
         * 用户编码
         */
        public static final String userCode = "userCode";

        /**
         * 用户账号
         */
        public static final String username = "username";

        /**
         * 用户密码
         */
        public static final String password = "password";

        /**
         * 用户验签
         */
        public static final String token = "token";

        /**
         * 锁定标识
         */
        public static final String lock = "lock";

        /**
         * 删除标识
         */
        public static final String deleted = "deleted";

    }

    /**
     *
     * 用户操作表
     *
     */
    public interface userOperation {

        /**
         * 表名
         */
        public static final String tableName = "userOperation";

        /**
         * 用户编号
         */
        public static final String userCode = "userCode";

        /**
         * 操作类型
         */
        public static final String operation = "operation";

        /**
         * 操作描述
         */
        public static final String operationDescribe = "operationDescribe";

        /**
         * 日期
         */
        public static final String date = "date";

    }
}
