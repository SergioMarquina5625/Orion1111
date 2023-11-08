import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNSLookup {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: DNSLookup <IP address or URL>");
            return;
        }

        String input = args[0];

        try {
            InetAddress address;

            // Try to parse the input as an IP address
            try {
                address = InetAddress.getByName(input);
                System.out.println("IP Address: " + address.getHostAddress());
                System.out.println("URL: " + address.getHostName());
            } catch (UnknownHostException e1) {
                try {
                    // Try to parse the input as a URL
                    address = InetAddress.getByName("www." + input);
                    System.out.println("URL: " + address.getHostAddress());
                    System.out.println("IP Address: " + address.getHostName());
                } catch (UnknownHostException e2) {
                    System.out.println("Could not resolve the input to an IP address or URL.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
