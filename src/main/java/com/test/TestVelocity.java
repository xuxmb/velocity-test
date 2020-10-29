package com.test;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.Properties;

public class TestVelocity {
    public static void main(String[] args) {
        //1.初始化运行时引擎，使用默认的配置
        Properties p = new Properties();
        //加载classpath目录下的vm文件
        p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);

        //2.创建Context对象，然后把数据放进去
        VelocityContext context = new VelocityContext();
        context.put("name", "Hello world");
        context.put("project", "Velocity-test");

        //3.获取模板，合并数据到模板中
        StringWriter sw = new StringWriter();
        Template tpl = Velocity.getTemplate("templates/template_test.vm", "UTF-8");
        tpl.merge(context, sw);
        System.out.println(" result : " + sw );
        //4.文件处理：如添加到zip等
    }
}
