package com.able.model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.able.consts.Consts;

/**
 * 表结构信息
 * 
 * @author zhanglikun
 * @mail likun_zhang@yeah.net
 * @date 2013-6-6
 */
public class TableMeta {
    private String schemaName;
    private String tableName;
    private String comment;
    private List<ColumnMeta> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ColumnMeta> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnMeta> columns) {
        this.columns = columns;
    }

    public String getClassName() {
        if (tableName == null)
            return "";
        StringBuffer className = new StringBuffer();

        // 根据表明，把下划线去掉，替换成驼峰命名规范
        if (StringUtils.startsWith(tableName, Consts.DB_TABLE_PREFIX)) {
            className.append(firstCharacterToUpper(lineToHump(tableName)));
        } else {
            System.out.println("==不支持的表前缀=="+tableName);
        }

        // 根据表前缀
        /* if(StringUtils.startsWith(tableName, Consts.DB_TABLE_PREFIX)) {
            String newName = StringUtils.substring(tableName, Consts.DB_TABLE_PREFIX.length()) ;
            String [] names = StringUtils.split(newName.toLowerCase(), "_") ;
            for(int i = 0 ,len = names.length ; i < len ; i ++) {
                className.append(names[i].substring(0, 1).toUpperCase() + names[i].substring(1)) ;
            }
        } else {
            System.out.println("==不支持的表前缀==");
        }*/
        return className.toString();
    }

    /**
     * 
     * @描述：首字母大写
     *
     * @返回：String
     *
     * @作者：wuhp
     *
     * @时间：2018年5月9日 上午10:40:54
     */
    public static String firstCharacterToUpper(String srcStr) {
        return srcStr.substring(0, 1).toUpperCase() + srcStr.substring(1);
    }

    /** 下划线转驼峰 */
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

}