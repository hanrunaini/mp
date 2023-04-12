package com.srr;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.Collections;

/**
 * ClassName: GeneratorApplicationTest
 * Package: com.srr
 * Description:
 *
 * @Author srr
 * @Create 2023/4/11 22:26
 * @Version 1.0
 */
@SpringBootTest
public class GeneratorApplicationTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.101.142:3306/mp?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false", "root", "abc123")
                .globalConfig(builder -> {
                    builder.author("沈润润") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
//                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
//                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
//                    if (typeCode == Types.SMALLINT) {
//                        // 自定义类型转换
//                        return DbColumnType.INTEGER;
//                    }
//                    return typeRegistry.getColumnType(metaInfo);
//
//                }))
                .packageConfig(builder -> {
                    builder.parent("com.srr") // 设置父包名
                            .moduleName("mp") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("srr_user") // 设置需要生成的表名
                            .addTablePrefix("srr_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
