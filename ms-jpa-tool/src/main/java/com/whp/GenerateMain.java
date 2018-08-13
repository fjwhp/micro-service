package com.whp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.whp.jpa.Consts;
import com.whp.jpa.db.AnalysisDB;
import com.whp.jpa.model.TableMeta;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 
 * @描述：生成代码入口
 *
 * @作者：whpO
 * 
 * @时间：2018年5月9日 下午9:14:59
 */
public class GenerateMain {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, TemplateException {
        
        List<TableMeta> tableList ;
        Writer out = null ;
        String targetDir = Consts.TARGET_DIR ;
        
        tableList = AnalysisDB.readDB() ;
        AnalysisDB.readTables(tableList) ;
        // 输出到文件
        File dir = new File(targetDir) ;
        if(!dir.isDirectory()) {
            dir.mkdirs() ;
        }
        
        Configuration cfg = new Configuration() ;
        cfg.setDirectoryForTemplateLoading(new File("src/main/tpl")) ;
        cfg.setObjectWrapper(new DefaultObjectWrapper()); 
        Template tpl = cfg.getTemplate("model.ftl") ;
        if(tableList != null) {
            for(TableMeta tm : tableList) {
                if(StringUtils.isBlank(tm.getClassName()))continue ;
                out = new FileWriter(new File(targetDir + tm.getClassName() + ".java")) ;
                tpl.process(tm, out) ;
                System.out.println("===文件 " + tm.getClassName() + ".java" + " 生成成功===");
            }
        }
        
        out.flush() ;
        out.close() ;       
        
    }
    
}