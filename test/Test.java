import org.lingBotTeam.lingBot.utils.string.StringDeDuplicator;
import org.lingBotTeam.lingBot.utils.string.message.SimpleMessage;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        testMessage("你好");
        testMessage("你好呀");
        testMessage("你好呀LoL");
        testMessage("什么？这是压缩毛巾！");
        testMessage("什么？这不是饼干，这是压缩毛巾！");
        testMessage("你好你好你好");
        testMessage("你好你好你好你好你好你好你好");
        testMessage("你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好");
        testMessage("好好好对对对是是是");
        for (int i = 0; i < 20; i++) {
            testMessage(randomString(1000 + new Random().nextInt(1000)));
        }
    }

    static void testMessage(String str) {
        SimpleMessage message = new SimpleMessage(str);
        double time = nano();
        double result = StringDeDuplicator.calculateSingleMessage(message);
        double deltaTime = nano() - time;
        println(message.getMessage());
        println("  length: " + message.getMessage().length());
        println("  result: " + result);
        println("  floor:  " + (int) Math.floor(result));
        println(" used ms: " + deltaTime);
    }

    static void println(String str) {
        System.out.println(str);
    }

    static double nano() {
        return System.nanoTime() / 1e6D;
    }

    static String randomString(int length) {
        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString();
    }
}
