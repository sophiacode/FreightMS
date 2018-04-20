package com.freight.ms.system.template;

/**
 * Created by wyq on 2018/4/18.
 */
public class TemplateConfig {
    private String projectPath = "D:\\project\\FreightMS\\src\\main";
    private String javaPath = projectPath + "\\java\\com\\freight\\ms";
    private String resourcePath = projectPath + "\\resources";

    private String servicePath = javaPath + "\\service";
    private String serviceImplPath = javaPath + "\\serviceImpl";
    private String controllerPath = javaPath + "\\controller";
    private String wrapperPath = javaPath + "\\wrapper";
    private String pagePath = resourcePath + "\\WEB-INF\\views";
    private String jsPath = resourcePath + "\\static\\js";

    private String moduleCh;
    private String moduleEn;
    private String modelCh;
    private String modelEn;
    private String modelBig;

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getJavaPath() {
        return javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }

    public String getServiceImplPath() {
        return serviceImplPath;
    }

    public void setServiceImplPath(String serviceImplPath) {
        this.serviceImplPath = serviceImplPath;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public String getWrapperPath() {
        return wrapperPath;
    }

    public void setWrapperPath(String wrapperPath) {
        this.wrapperPath = wrapperPath;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getJsPath() {
        return jsPath;
    }

    public void setJsPath(String jsPath) {
        this.jsPath = jsPath;
    }

    public String getModuleCh() {
        return moduleCh;
    }

    public void setModuleCh(String moduleCh) {
        this.moduleCh = moduleCh;
    }

    public String getModuleEn() {
        return moduleEn;
    }

    public void setModuleEn(String moduleEn) {
        this.moduleEn = moduleEn;
    }

    public String getModelCh() {
        return modelCh;
    }

    public void setModelCh(String modelCh) {
        this.modelCh = modelCh;
    }

    public String getModelEn() {
        return modelEn;
    }

    public void setModelEn(String modelEn) {
        this.modelEn = modelEn;
    }

    public String getModelBig() {
        return modelBig;
    }

    public void setModelBig(String modelBig) {
        this.modelBig = modelBig;
    }
}
