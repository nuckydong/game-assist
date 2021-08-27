package niko.game.assist;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author NiKo
 * @date 2021-08-27
 */
public class SimpleRobot {

    private static void left_mouse_click(Robot robot, double x, double y) {
        long randomNum = System.currentTimeMillis();
        int ran1 = (int) (randomNum % (200 - 100) + 100);// 100-200 随机
        int ran2 = (int) (randomNum % (5 - 1) + 1);// 1-5 的随机
        robot.mouseMove((int) x + ran2, (int) y + ran2);// 点击的point 随机偏移,防止被检测机器人
        robot.delay(ran1);
        robot.mousePress(MouseEvent.BUTTON1_MASK); // 点击鼠标左键
        robot.delay(ran1);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
        robot.delay(1500 + ran1);
    }

    /**
     * 被邀请模式
     *
     * @param times
     * @param time_cost
     * @param x
     * @param y
     * @throws Exception
     */
    private static void fllow(int times, int time_cost, double x, double y) throws Exception {
        Robot robot = new Robot();
        final int total_times = times;
        while (times-- > 0) {
            System.out.println("跟随第" + (total_times - times) + "次挂机开始");
            Thread.sleep(time_cost * 1000);
            left_mouse_click(robot, x, y);
            left_mouse_click(robot, x, y);
            System.out.println("跟随第" + (total_times - times) + "次挂机运行结束");
            System.out.println("-------------------------------------");
        }
    }

    /**
     * 房主模式
     *
     * @param times
     * @param time_cost
     * @param x
     * @param y
     * @throws Exception
     */
    private static void owner(int times, int time_cost, double x, double y) throws Exception {
        Robot robot = new Robot();
        final int total_times = times;
        while (times-- > 0) {
            System.out.println("第" + (total_times - times) + "次挂机开始");
            robot.delay(1500);
            left_mouse_click(robot, x, y);
            Thread.sleep(time_cost * 1000);
            for (int i = 0; i < 3; i++) {
                left_mouse_click(robot, x, y);
            }
            System.out.println("第" + (total_times - times) + "次挂机运行结束");
            System.out.println("---------------------------------------");
        }
    }

    /**
     * @param times     次数
     * @param time_cost 耗时
     * @param x1        房主坐标
     * @param y1
     * @param x2        被邀请人坐标
     * @param y2
     * @throws Exception
     */
    private static void double_mode(int times, int time_cost, double x1, double y1, double x2, double y2) throws Exception {
        Robot robot = new Robot();
        final int total_times = times;
        while (times-- > 0) {
            System.out.println("第" + (total_times - times) + "挂机开始");
            robot.delay(1500);
            left_mouse_click(robot, x1, y1);
            Thread.sleep(time_cost * 1000);
            left_mouse_click(robot, x2, y2);
            left_mouse_click(robot, x1, y1);
            left_mouse_click(robot, x2, y2);
            left_mouse_click(robot, x1, y1);
            System.out.println("第" + (total_times - times) + "次挂机运行结束");
        }
        System.out.println("---------------------------------------------");
    }

    public final static int SELF_JUE_XING = 11;// 独自觉醒
    public final static int SELF_CHI = 70;// 业原火


    public final static int BEN_BEN_BEN_PAO_TIME_COST = 28;// 奔奔奔跑
    public final static int MEI_LUO_FENG_TIME_COST = 40;// 落梅凤
    public final static int YE_YE_TIME_COST = 45;//也也挖土
    public final static int YE_YE_SELF_YU_LIN = 45;
    public final static int HONG_ZHA_ZHE_TIME_COST = 26;// 轰炸者
    public final static int SELF_YU_LIN = 60;


    public static void play(int times, int time_cost) throws Exception {
        int wait_time = 5;
        System.out.println("请移动鼠标到房主需要点击位置, " + wait_time + "秒倒计时");
        for (int i = 0; i < wait_time; i++) {
            Thread.sleep(1000);
            System.out.println(wait_time - i);
        }
        Point point1 = MouseInfo.getPointerInfo().getLocation();
        System.out.println("坐标采集完毕:x=" + point1.getX() + ",y=" + point1.getY());
        System.out.println("-------------------------------------------------");
        System.out.println("请移动鼠标到跟随着需要点击位置, " + wait_time + "秒倒计时");
        while (wait_time-- > 0) {
            Thread.sleep(1000);
            System.out.println(wait_time + 1);
        }
        Point point2 = MouseInfo.getPointerInfo().getLocation();
        System.out.println("坐标采集完毕:x=" + point2.getX() + ",y=" + point2.getY());

//        owner(times, fighting_time_cost, point1.getX(), point1.getY());
//        fllow(times, fighting_time_cost, point1.getX(), point1.getY());
        double_mode(times, time_cost, point1.getX(), point1.getY(), point2.getX(), point2.getY());
    }

    public static void main(String[] args) throws Exception {
        int times = 200;   // 挂机次数
        play(times, YE_YE_TIME_COST);

    }
}
