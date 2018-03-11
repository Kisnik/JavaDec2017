import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;


public class General {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose your browser to export cache:");
        System.out.println("1 - Google Chrome");
        System.out.println("2 - Opera");
        System.out.println("3 - Mozilla FireFox");
        System.out.println("4 - Yandex browser");

        int n = Integer.parseInt(reader.readLine());

        Path toPath = Paths.get("D:\\MusicCache2");
        if (!Files.exists(toPath)) Files.createDirectory(toPath);// creating target path

        Path fromPathChrome = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Google", "Chrome", "User Data", "Default", "Media Cache")
                .toAbsolutePath().toString());
        Path fromPathOpera = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Opera Software", "Opera Stable", "Media Cache")
                .toAbsolutePath().toString());
        Path fromPathMozilla = Paths.get(Paths.get(System.getProperty("user.home"), "Local Settings", "Application Data", "Mozilla", "Firefox",
                "Profiles", "zayl0w0i.default", "cache2", "entries").toAbsolutePath().toString());
        Path fromPathYa = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Yandex", "YandexBrowser", "User Data", "Default", "Media Cache")
                .toAbsolutePath().toString());

        switch (n) {
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
        System.out.println("0 - exit");
        System.out.println("1 - help");
        int comandMenu = Integer.parseInt(reader.readLine());
        while (comandMenu != 0) {
            switch (comandMenu) {
                case 1:
                    System.out.println("1 - Create ZIP archive of mp3 cache");
                    System.out.println("2 - Unzip mp3 cache");
                    int zipComand = Integer.parseInt(reader.readLine());
                    switch (zipComand) {
                        case 1:
                            System.out.println("Enter the path for ZIP archive");
                            System.out.println("For example: D:\\MusicCache\\Music.zip");
                            String pathZip = reader.readLine();
                            ForChromium.zipCreator(toPath, Paths.get(pathZip));
                            System.out.println("ZIP created");
                            break;
                        case 2:
                            System.out.println("Enter the path of ZIP archive");
                            System.out.println("For example: D:\\MusicCache\\Music.zip");
                            pathZip = reader.readLine();
                            System.out.println("Enter the path to unzip archive");
                            System.out.println("For example: D:\\MusicCache");
                            String pathUnZip = reader.readLine();
                            ForChromium.unZip(Paths.get(pathZip), Paths.get(pathUnZip));
                            System.out.println("unzip finished");
                            break;
                        default:
                            System.out.println("Incorrect input");
                            break;
                    }
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;


            }
            System.out.println("0 - exit");
            System.out.println("1 - help");
            comandMenu = Integer.parseInt(reader.readLine());

        /*Path zipPath = Paths.get("D:\\MusicCache1\\Music.zip");
        ForChromium.zipCreator(toPath, zipPath);
        ForChromium.unZip(zipPath, Paths.get("D:\\MusicCache2"));*/


        }
    }
}