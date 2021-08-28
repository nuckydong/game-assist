package niko.game.assist;

/**
 * @author NiKo
 * @date 2021-08-27
 */
public class Main {

    public static void main(String[] args) {
        try {
            SimpleRobot.auto_play(100, SimpleRobot.YE_YE_TIME_COST, SimpleRobot.Mode.DOUBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
