package com.freight.ms.system.template;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wyq on 2018/4/17.
 */

@Controller
public class TemplateController {

    @RequestMapping("/template/generate")
    @ResponseBody
    public String generate(@RequestParam(value = "moduleCh") String moduleCh,
                           @RequestParam(value = "moduleEn") String moduleEn,
                           @RequestParam(value = "modelCh") String modelCh,
                           @RequestParam(value = "modelEn") String modelEn){
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setModuleCh(moduleCh);
        templateConfig.setModuleEn(moduleEn);
        templateConfig.setModelCh(modelCh);
        templateConfig.setModelEn(modelEn);

        TemplateGenerator templateGenerator = new TemplateGenerator(templateConfig);
        templateGenerator.initBeetlEngine();
        templateGenerator.generate();

        return "success";
    }
}
