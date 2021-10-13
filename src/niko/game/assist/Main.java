package niko.game.assist;

/**
 * @author NiKo
 * @date 2021-08-27
 */
public class Main {

    public static void main(String[] args) {
        try {
            SimpleRobot.auto_play(30, SimpleRobot.BEN_BEN_BEN_PAO_TIME_COST, SimpleRobot.Mode.OWNER);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
