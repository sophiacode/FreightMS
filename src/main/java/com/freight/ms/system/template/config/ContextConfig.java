package com.freight.ms.system.template.config;

/**
 * Created by wyq on 2018/4/1.
 */
public class ContextConfig {
    private String projectPath;
    private String moduleName;

    private boolean controllerFlag;
    private boolean serviceFlag;
    private boolean indexPageFlag;
    private boolean addPageFlag;
    private boolean editPageFlag;
    private boolean infoPageFlag;
    private boolean jsFlag;

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public boolean isControllerFlag() {
        return controllerFlag;
    }

    public void setControllerFlag(boolean controllerFlag) {
        this.controllerFlag = controllerFlag;
    }

    public boolean isServiceFlag() {
        return serviceFlag;
    }

    public void setServiceFlag(boolean serviceFlag) {
        this.serviceFlag = serviceFlag;
    }

    public boolean isIndexPageFlag() {
        return indexPageFlag;
    }

    public void setIndexPageFlag(boolean indexPageFlag) {
        this.indexPageFlag = indexPageFlag;
    }

    public boolean isAddPageFlag() {
        return addPageFlag;
    }

    public void setAddPageFlag(boolean addPageFlag) {
        this.addPageFlag = addPageFlag;
    }

    public boolean isEditPageFlag() {
        return editPageFlag;
    }

    public void setEditPageFlag(boolean editPageFlag) {
        this.editPageFlag = editPageFlag;
    }

    public boolean isInfoPageFlag() {
        return infoPageFlag;
    }

    public void setInfoPageFlag(boolean infoPageFlag) {
        this.infoPageFlag = infoPageFlag;
    }

    public boolean isJsFlag() {
        return jsFlag;
    }

    public void setJsFlag(boolean jsFlag) {
        this.jsFlag = jsFlag;
    }
}
