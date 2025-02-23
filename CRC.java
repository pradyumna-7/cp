import java.util.Scanner;

public class CRC {
    
    // Function to perform XOR operation
    private static String xor(String dividend, String divisor) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 1; i < divisor.length(); i++) {
            result.append(dividend.charAt(i) == divisor.charAt(i) ? '0' : '1');
        }
        
        return result.toString();
    }
    
    // Function to perform division and get the CRC remainder
    private static String mod2Division(String dividend, String divisor) {
        int pick = divisor.length();
        String tmp = dividend.substring(0, pick);
        
        while (pick < dividend.length()) {
            if (tmp.charAt(0) == '1') {
                tmp = xor(tmp, divisor) + dividend.charAt(pick);
            } else {
                tmp = xor(tmp, "0".repeat(divisor.length())) + dividend.charAt(pick);
            }
            pick++;
        }
        
        if (tmp.charAt(0) == '1') {
            tmp = xor(tmp, divisor);
        } else {
            tmp = xor(tmp, "0".repeat(divisor.length()));
        }
        
        return tmp;
    }
    
    // Function to encode data using CRC
    public static String encodeData(String data, String generator) {
        int dataLen = data.length();
        int generatorLen = generator.length();
        
        String appendedData = data + "0".repeat(generatorLen - 1);
        String remainder = mod2Division(appendedData, generator);
        
        return data + remainder;
    }
    
    // Function to check for errors in received data
    public static boolean checkData(String receivedData, String generator) {
        String remainder = mod2Division(receivedData, generator);
        return remainder.contains("1"); // If remainder has 1, error is present
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter dataword (binary): ");
        String data = scanner.next();
        
        System.out.print("Enter generator polynomial (binary): ");
        String generator = scanner.next();
        
        String codeword = encodeData(data, generator);
        System.out.println("Encoded data (Codeword): " + codeword);
        
        System.out.print("Enter received data (binary) to check for errors: ");
        String receivedData = scanner.next();
        
        if (checkData(receivedData, generator)) {
            System.out.println("Error detected in received data.");
        } else {
            System.out.println("No error detected.");
        }
        
        scanner.close();
    }
}