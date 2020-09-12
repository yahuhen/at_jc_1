package main.java.day6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsParser {

    public static void main(String[] args) {

        String toParse =
                "access_log.2020.09.07 212.168.101.5 granted\n" +
                "access_log.2020.09.07 212.168.101.6 granted\n" +
                "access_log.2020.09.07 212.168.101.5 granted\n" +
                "access_log.2020.09.07 212.168.101.6 denied";

        Pattern pattern = Pattern.compile(" (\\d+.){3}\\d.+");
        Matcher matcher = pattern.matcher(toParse);

        String[][] tempArray = new String[toParse.split("\\n").length][2];

        int counter = 0;
        while (matcher.find()) {
            tempArray[counter++] = matcher.group().trim().split(" ");
        }

        Object[][] finalArray = new Object[tempArray.length][3];

        int position = 0;
        boolean next;

        for (String[] strings : tempArray) {
            next = false;
            for (Object[] element : finalArray) {
                if (null != element[0] && ((String) element[0]).equalsIgnoreCase(strings[0])) {
                    if (strings[1].equalsIgnoreCase("granted")) {
                        element[1] = (int) element[1] + 1;
                    } else {
                        element[2] = (int) element[2] + 1;
                    }
                    next = true;
                }
            }

            if (next) {
                continue;
            }

            finalArray[position][0] = strings[0];
            if (strings[1].equalsIgnoreCase("granted")) {
                finalArray[position][1] = 1;
                finalArray[position++][2] = 0;
            } else {
                finalArray[position][1] = 0;
                finalArray[position++][2] = 1;
            }
        }

        for (Object[] el : finalArray) {
            System.out.printf("ip %s: ok - %s, failed - %s%n", el[0], el[1], el[2]);
        }
    }
}
