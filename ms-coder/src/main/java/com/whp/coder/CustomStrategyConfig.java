package com.whp.coder;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * 
 * @描述：自定义代码生成策略器(重写其中的includeSuperEntityColumns方法).
 *
 * @作者：whp
 * 
 * @时间：2018年4月27日 下午8:22:53
 */
public class CustomStrategyConfig extends StrategyConfig {

    @Override
    public boolean includeSuperEntityColumns(String fieldName) {
        if (null != getSuperEntityColumns()) {
            for (String column : getSuperEntityColumns()) {
                if (column.equals(fieldName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
