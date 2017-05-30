package algo;

/**
 * IP String -> 32 int
 */
public class IpAddress {

    public static void main(String[] args) {
        unitTest();
    }

    /**
     * Calculate (input * (256^time)) by bit shifting
     */
    private static long _pow(int input, int time) {
        long result = input;
        while (time > 0) {
            result <<= 8;
            time--;
        }
        return result;
    }

    private static long calculateIpAddress(String ipAddress) {
        int pow = 0; // 256^_pow
        int tenPow = 0; // 10^tenPow
        int currentNumber = 0;
        long result = 0;

        for (int i=ipAddress.length() - 1; i >= 0; i--) {
            char value = ipAddress.charAt(i);
            if ('0' <= value && value <= '9') {
                currentNumber += (value - '0') * (Math.pow(10, tenPow));
                tenPow++;
            } else if ('.' == value){
                if (currentNumber > 255) {
                    throw new IllegalArgumentException("Each field must be less than 256. Invalid input: " + ipAddress);
                }

                result += _pow(currentNumber, pow);
                pow++;
                tenPow = 0;
                currentNumber = 0;
            } else if (' ' == value && tenPow != 0 && i >= 1) {
                char nextValueMustBeSpaceOrDot = ipAddress.charAt(i - 1);

                if('0' <= nextValueMustBeSpaceOrDot && nextValueMustBeSpaceOrDot <= '9') {
                    throw new IllegalArgumentException("No space is allowed between digit. Invalid input: " + ipAddress);
                }
            }
        }

        return result + _pow(currentNumber, pow);
    }

    private static void unitTest() {
        String[] ipList = {"0.0.0.0", "192.168.50.10", " 192 . 168 . 50 . 10 ", "192.16 8.50.10", "192.168.50.1 0", "192.168.255.10", "192.168.256.10"};
        String[] resultList = {"0", "3232248330", "3232248330", "reportError", "reportError", "3232300810", "reportError"};
        for (int i=0; i<ipList.length; i++) {
            System.out.println("Input: " + ipList[i]);
            try {
                long result = calculateIpAddress(ipList[i]);
                if (!String.valueOf(result).equals(resultList[i])) {
                    throw new RuntimeException("Fail Test " + "\n");
                } else {
                    System.out.println("Pass" + "\n");
                }
            } catch (Exception e) {
                System.out.println(e + "\n");
            }
        }
    }

}
