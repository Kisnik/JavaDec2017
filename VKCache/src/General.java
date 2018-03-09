import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;


public class General {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose your browser:");
        System.out.println("1 - Google Chrome");
        System.out.println("2 - Opera");
        System.out.println("3 - Mozilla FireFox");
        System.out.println("4 - Yandex browser");

        int n = Integer.parseInt(reader.readLine());

        Path toPath = Paths.get("D:\\MusicCache1");
        if (!Files.exists(toPath)) Files.createDirectory(toPath);// creating target path

        Path fromPathChrome = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Google", "Chrome", "User Data", "Default", "Media Cache")
                .toAbsolutePath().toString());
        Path fromPathOpera = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Opera Software", "Opera Stable", "Media Cache")
                .toAbsolutePath().toString());
        Path fromPathMozilla = Paths.get(Paths.get(System.getProperty("user.home"), "Local Settings", "Application Data", "Mozilla", "Firefox",
                "Profiles", "zayl0w0i.default", "cache2", "entries").toAbsolutePath().toString());
        Path fromPathYa = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Yandex", "YandexBrowser", "User Data", "Default", "Media Cache")
                .toAbsolutePath().toString());

        switch (n){
            case 1:
                ForChromium.getMusic(fromPathChrome, toPath);// Chrome
                break;
            case 2:
                ForChromium.getMusic(fromPathOpera, toPath);//Opera
                break;
            case 3:
                ForMozilla.getMusic(fromPathMozilla, toPath);// Mozilla
                break;
            case 4:
                ForChromium.getMusic(fromPathYa, toPath);//Yandex
                break;
            default:
                System.out.println("Incorrect input");
                break;

        }


    }
}
