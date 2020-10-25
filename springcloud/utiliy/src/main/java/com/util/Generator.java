package com.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Generator {

    public static void main(String[] args) throws FileNotFoundException {
        Map map = new Yaml().load(new FileInputStream("utiliy/src/main/resources/config/reverse.yml"));
        String author = LnUtils.ymlToObject(map, "author");
        String url = LnUtils.ymlToObject(map, "url");
        String username = LnUtils.ymlToObject(map, "username");
        String password = LnUtils.ymlToObject(map, "password") + "";
        String driverName = LnUtils.ymlToObject(map, "driverName");

        String outputDir = LnUtils.ymlToObject(map, "src");

        String packParent = LnUtils.ymlToObject(map, "pack.parent");
        String packEntity = LnUtils.ymlToObject(map, "pack.entity");
        String packDao = LnUtils.ymlToObject(map, "pack.dao");
        String packServiceImpl = LnUtils.ymlToObject(map, "pack.serviceImpl");
        String packService = LnUtils.ymlToObject(map, "pack.service");
        String packController = LnUtils.ymlToObject(map, "pack.controller");


        String tablePrefix = LnUtils.ymlToObject(map, "table.prefix");

        List<String> list = null;
        list = LnUtils.ymlToObject(map, "table.exclude");
        String[] tableExclude = list != null ? list.toArray(String[]::new) : null;
        list = LnUtils.ymlToObject(map, "table.include");
        String[] tableInclude = list != null ? list.toArray(String[]::new) : null;

        List<String> overWriter = LnUtils.ymlToObject(map, "pack.overwriter");

        AutoGenerator autoGenerator = new AutoGenerator();

        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)  //支持Ar模式
                .setAuthor(author)
                .setOpen(false)
                .setFileOverride(true)
                .setOutputDir(outputDir + "/src/main/java")
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setServiceName("I%sService")
                .setMapperName("%sDao");
        autoGenerator.setGlobalConfig(config);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(driverName)
                .setUsername(username)
                .setPassword(password)
                .setUrl(url);
        autoGenerator.setDataSource(dataSourceConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix(tablePrefix)// 此处可以修改为您的表前缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setExclude(tableExclude)
                .setInclude(tableInclude) //需要生成的表
                .setEntityLombokModel(true) //Lombok
                .setEntityTableFieldAnnotationEnable(true)
                .setRestControllerStyle(true);
        autoGenerator.setStrategy(strategyConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packParent)
                .setEntity(packEntity)
                .setMapper(packDao)
                .setService(packService)
                .setController(packController)// 这里是控制器包名，默认 web
                .setServiceImpl(packServiceImpl)
        //.setXml(xml)
        ;
        autoGenerator.setPackageInfo(packageConfig);

        TemplateConfig templateConfig = new TemplateConfig();
        if (!overWriter.contains("po")) {
            templateConfig.setEntity(null);
        }
        if (!overWriter.contains("dao")) {
            templateConfig.setMapper(null);
        }
        if (!overWriter.contains("service")) {
            templateConfig.setService(null);
        }
        if (!overWriter.contains("serviceImpl")) {
            templateConfig.setServiceImpl(null);
        }
        if (!overWriter.contains("controller")) {
            templateConfig.setController(null);
        }
        //设置不生成xml,这个单独生成
        templateConfig.setXml(null);
        if (overWriter.contains("mapperXml")) {
            // 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            //如果模板引擎是 velocity
            //String templatePath = "/templates/mapper.xml.vm";
            //自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ,如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return outputDir + "/src/main/resources/mapper/"
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            autoGenerator.setCfg(new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            }.setFileOutConfigList(focList));
        }
        //设置freemarker引擎,默认velocity
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.setTemplate(templateConfig);
        autoGenerator.execute();
    }

}
