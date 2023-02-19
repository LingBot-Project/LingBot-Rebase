package org.lingBotTeam.lingBot.utils.string;

public final class StringDeDuplicator {
    /**
     * Calculate similar texts
     * @author siuank
     * @param message the message
     * @return gone for the message
     */
    public static double calculateSingleMessage(WrappedMessage message) {
        String str = message.getMessage().replaceAll("\n", "");
        int length = str.length();
        char[] chars = str.toCharArray();
        char[][] charsA = new char[chars.length][chars.length];
        for (int i = 0; i < charsA.length; i++) {
            charsA[i] = chars.clone();
        }
        double perChar = 1.0 / length;
        double perCharSq = 1.0 / (length * length);
        double[][] ddAA = new double[chars.length + 1][chars.length + 1];
        ddAA[0][0] = 1.0;
        double sim = 0;
        for (int x = 0; x < charsA.length; x++) {
            for (int y = 0; y < charsA.length; y++) {
                char[] cs = charsA[x];
                char c = cs[y];
                int count = 0;
                for (char aChar : chars) {
                    if (aChar == c) ++count;
                }
                sim += count;
                ddAA[x + 1][y + 1] = count;
                ddAA[x + 1][0] = perChar * count;
            }
        }
        for (int x = 0; x < ddAA.length; x++) {
            double[] ds = ddAA[x];
            double total = 0;
            for (double d : ds) {
                total += d;
            }
            double average = total / ds.length;
            sim += average;
        }
        return sim * perCharSq;
    }
}
