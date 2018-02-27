import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class General {
    public static void main(String[] args) throws IOException {
        Path toPath = Paths.get("D:\\MusicCache");
        Files.createDirectory(toPath);
        Path fromPath = Paths.get(Paths.get(System.getProperty("user.home"), "AppData", "Local", "Google", "Chrome", "User Data", "Default", "Media Cache").toString());
        DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);
        for (Path file: stream) {
            String s = String.valueOf(file.getFileName());
            if (s.charAt(0)=='f') {// if file name starts from char "f" it is mp3 file
                //here is the alternative check if the file is mp3: we are looking if the input of the file befins from ID3.
                //if yes - it is mp3, if no - it is not mp3. But we have found the cases when the input of the file is not begins from ID3, but it is mp3 file
                //this is the reason, why this check was commented
                /*BufferedReader br = new BufferedReader((new FileReader(fromPath + "\\" + s)));
                String line = br.readLine();
                if (line.startsWith("ID3")) {*/
                    Path toPathFile = Paths.get("D:\\MusicCache\\" + file.getFileName() + ".mp3");
                    if (!Files.exists(toPathFile)) {
                        Files.createFile(toPathFile);
                    }
                    try {
                        Files.copy(file, toPathFile, REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                /*}*/
            }
        }

    }
}
