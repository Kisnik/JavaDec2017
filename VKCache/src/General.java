import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class General {
    public static void main(String[] args) throws IOException {
        Path toPath = Paths.get("D:\\MusicCache");
        Files.createDirectory(toPath);
        Path fromPath = Paths.get("C:\\Users\\Kisnik\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Media Cache");
        DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);
        for (Path file: stream) {
                Path toPathFile = Paths.get("D:\\MusicCache\\" + file.getFileName() + ".mp3");
                if (!Files.exists(toPathFile)) {
                    Files.createFile(toPathFile);
                }
                try {
                    Files.copy(file, toPathFile, REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

    }
}