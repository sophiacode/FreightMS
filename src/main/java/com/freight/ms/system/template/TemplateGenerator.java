package com.freight.ms.system.template;

import com.freight.ms.system.shiro.ShiroExt;
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
    private GroupTemplate groupTemplate;
    private TemplateConfig templateConfig;

    public TemplateGenerator(TemplateConfig templateConfig){
        this.templateConfig = templateConfig;
    }

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
        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
    }

    public void generate(){
        generateService();
        generateServiceImpl();
        generateController();
        generatePage();
        generateJs();
    }

    public void generateTemplate(String templatePath, String filePath){
        Template template =groupTemplate.getTemplate(templatePath);

        template.binding("config", templateConfig);

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

        System.out.print("success:" + filePath);
    }

    public void generateService(){
        String templatePath = "templates/service.java.btl";
        String fileName = templateConfig.getModuleEn() + "Service.java";
        String filePath = templateConfig.getServicePath() + "/" + fileName;
        generateTemplate(templatePath, filePath);
    }

    public void generateServiceImpl() {
        String templatePath = "templates/serviceImpl.java.btl";
        String fileName = templateConfig.getModuleEn() + "ServiceImpl.java";
        String filePath = templateConfig.getServiceImplPath() + "/" + fileName;
        generateTemplate(templatePath, filePath);
    }

    public void generateController() {
        String templatePath = "templates/controller.java.btl";
        String fileName = templateConfig.getModuleEn() + "Controller.java";
        String filePath = templateConfig.getControllerPath() + "/" + fileName;
        generateTemplate(templatePath, filePath);
    }

    public void generatePage() {
        String path = templateConfig.getPagePath() + "/" + templateConfig.getModelEn() + "/";
        String infoTemplate = "templates/page.html.btl";
        String addTemplate = "templates/page_add.html.btl";
        String editTemplate = "templates/page_edit.html.btl";

        String infoFile = templateConfig.getModelEn() + ".html";
        String addFile = templateConfig.getModelEn() + "_add.html";
        String editFile = templateConfig.getModelEn() + "_edit.html";

        generateTemplate(infoTemplate, path + infoFile);
        generateTemplate(addTemplate, path + addFile);
        generateTemplate(editTemplate, path + editFile);
    }

    public void generateJs() {
        String path = templateConfig.getJsPath() + "/" + templateConfig.getModelEn() + "/";
        String moduleTemplate = "templates/js.js.btl";
        String infoTemplate = "templates/js_info.js.btl";

        String moduleFile = templateConfig.getModelEn() + ".js";
        String infoFile = templateConfig.getModelEn() + "_info.js";

        generateTemplate(moduleTemplate, path + moduleFile);
        generateTemplate(infoTemplate, path + infoFile);
    }
}
