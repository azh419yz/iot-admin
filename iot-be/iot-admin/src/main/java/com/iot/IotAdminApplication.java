package com.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author init
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IotAdminApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(IotAdminApplication.class, args);
        System.out.println("""
                (♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ \s
                 .-------.       ____     __       \s
                 |  _ _   \\      \\   \\   /  /   \s
                 | ( ' )  |       \\  _. /  '      \s
                 |(_ o _) /        _( )_ .'        \s
                 | (_,_).' __  ___(_ o _)'         \s
                 |  |\\ \\  |  ||   |(_,_)'        \s
                 |  | \\ `'   /|   `-'  /          \s
                 |  |  \\    /  \\      /          \s
                 ''-'   `'-'    `-..-'             \s""");
    }
}
