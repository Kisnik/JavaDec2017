import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ForMozilla {
    public static void getMusic(Path fromPath, Path toPath){
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);

            for (Path file : stream) {



                String s = String.valueOf(file.getFileName());
                BufferedReader br = new BufferedReader((new FileReader(fromPath + "\\" + s)));
                String line = br.readLine();

                if (line.startsWith("ID3")) {
                    Path toPathFile = Paths.get(toPath + "\\" + file.getFileName() + ".mp3");
                    if (!Files.exists(toPathFile)) {
                        Files.createFile(toPathFile);// creating target dir
                    }
                    try {
                        Files.copy(file, toPathFile, REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }

            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

