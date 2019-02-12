package totp;

import org.jboss.aerogear.security.otp.Totp;
import org.jboss.aerogear.security.otp.api.Base32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String QR_PREFIX =
            "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";

    private static final String APP_NAME = "ISAHD";
    private static final String ISSUER = "kdureidy";

    public static String generateQRUrl(String secret) {

        return QR_PREFIX + String.format(
                "otpauth://totp/%s:%s?secret=%s&issuer=%s",
                APP_NAME, ISSUER, secret, APP_NAME);
    }

    public static void main(String[] args) throws IOException {

        String secret = Base32.random();
        System.out.println(secret);
        Totp totp = new Totp(secret);

        System.out.println(generateQRUrl(secret));

        System.out.println("Enter secret:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println(userInput);

        if(totp.verify(userInput)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
