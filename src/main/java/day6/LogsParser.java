package main.java.day6;

public class LogsParser {

    public static void main(String[] args) {

        String toParse = "access_log.2020.09.07 212.168.101.5 granted\n" +
                "access_log.2020.09.07 212.168.101.6 granted\n" +
                "access_log.2020.09.07 212.168.101.5 granted\n" +
                "access_log.2020.09.07 212.168.101.6 denied";

        String[] st = toParse.split("\\n");

        String[][] second = new String[st.length][2];
        for (int i = 0; i < st.length; i++) {
            String[] med = st[i].split(" ");
            second[i][0] = med[1];
            second[i][1] = med[2];
        }

        Object[][] finalk = new Object[second.length][3];

        int position = 0;
        boolean next;

        for (int i = 0; i < st.length; i++) {
            next = false;
            for (Object[] el : finalk) {
                if (null != el[0] && ((String) el[0]).equalsIgnoreCase(second[i][0])) {
                    if (second[i][1].equalsIgnoreCase("granted")) {
                        int x = (int) el[1];
                        x += 1;
                        el[1] = x;
                    } else {
                        int x = (int) el[2];
                        x += 1;
                        el[2] = x;
                    }
                    next = true;
                }
            }

            if (next) {
                continue;
            }

            finalk[position][0] = second[i][0];
            if (second[i][1].equalsIgnoreCase("granted")) {
                finalk[position][1] = 1;
                finalk[position][2] = 0;
            } else {
                finalk[position][1] = 0;
                finalk[position][2] = 1;
            }
            position++;
        }


        for (Object[] el : finalk) {
            System.out.printf("ip %s: ok - %s, failed - %s%n", el[0], el[1], el[2]);
        }

    }
}
