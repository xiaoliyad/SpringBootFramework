package com.watchdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动程序
 * 
 * @author 
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.watchdata.project.*.*.mapper")
public class SpringBootFrameworkApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootFrameworkApplication.class, args);
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootFrameworkApplication.class);
//        //修改Banner的模式为OFF
//        builder.bannerMode(Banner.Mode.OFF).run(args);
        System.out.println("███████╗████████╗ █████╗ ██████╗ ████████╗    ███████╗██╗   ██╗ ██████╗ ██████╗███████╗███████╗███████╗   \r\n" + 
        		"██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝    ██╔════╝██║   ██║██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝   \r\n" + 
        		"███████╗   ██║   ███████║██████╔╝   ██║       ███████╗██║   ██║██║     ██║     █████╗  ███████╗███████╗   \r\n" + 
        		"╚════██║   ██║   ██╔══██║██╔══██╗   ██║       ╚════██║██║   ██║██║     ██║     ██╔══╝  ╚════██║╚════██║   \r\n" + 
        		"███████║   ██║   ██║  ██║██║  ██║   ██║       ███████║╚██████╔╝╚██████╗╚██████╗███████╗███████║███████║██╗\r\n" + 
        		"╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝       ╚══════╝ ╚═════╝  ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝╚═╝");
    }
}