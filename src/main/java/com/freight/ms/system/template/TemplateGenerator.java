package com.freight.ms.system.template;

import com.freight.ms.system.template.config.ContextConfig;
import com.freight.ms.system.template.config.ControllerConfig;
import com.freight.ms.system.template.config.PageConfig;
import com.freight.ms.system.template.config.ServiceConfig;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by wyq on 2018/4/1.
 */
public class TemplateGenerator {
    private ContextConfig contextConfig;
    private ControllerConfig controllerConfig;
    private PageConfig pageConfig;
    private ServiceConfig serviceConfig;

    private GroupTemplate groupTemplate;

    public void initBeetlEngine(){
        Properties properties = new Properties();
        properties.put("RESOURCE.root", "");
        properties.put("DELIMITER_STATEMENT_START", "<%");
        properties.put("DELIMITER_STATEMENT_END", "%>");
        properties.put("HTML_TAG_FLAG", "##");
        Configuration cfg = null;
        try {
            cfg = new Configuration(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        groupTemplate = new GroupTemplate(resourceLoader, cfg);
        //groupTemplate.registerFunctionPackage("tool", new ToolUtil());
    }

    public void generateTemplate(String templatePath, String filePath){
        Template template =groupTemplate.getTemplate(templatePath);

        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            try{
                parentFile.mkdirs();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try{
            template.renderTo(new FileOutputStream(file));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
