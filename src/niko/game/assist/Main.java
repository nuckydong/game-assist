package niko.game.assist;

/**
 * @author NiKo
 * @date 2021-08-27
 */
public class Main {

    public static void main(String[] args) {
        try {
            SimpleRobot.play(400, SimpleRobot.YE_YE_TIME_COST);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
