package niko.game.assist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Vector;

/**
 * @author NiKo
 * @date 2021-08-27
 */
public class Main {

    public static void main(String[] args) {
        new LinkedList();
        new ArrayList();
        new Vector();
        Properties properties = new Properties();
        try {
            try {
                // 优先使用外部配置文件
                String config_addr = System.getProperty("user.dir") + File.separator + "game-assist.properties";
                FileInputStream fileInputStream = new FileInputStream(config_addr);
                properties.load(fileInputStream);
            }catch (FileNotFoundException e){
                System.out.println("没有外部配置文件,使用内部配置文件");
                properties.load(Main.class.getResourceAsStream("/game-assist.properties"));
            }
            String mode = properties.getProperty("mode");
            String times = properties.getProperty("run-times");
            String time_cost = properties.getProperty("time-cost");
            SimpleRobot.auto_play(Integer.valueOf(mode), Integer.valueOf(times), Integer.valueOf(time_cost));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
