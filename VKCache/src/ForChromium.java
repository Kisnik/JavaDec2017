import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ForChromium {
    public static void getMusic(Path fromPath, Path toPath){
        List<Path> list = new ArrayList<>();

        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);

            for (Path file : stream) {

                list.add(file);



                String s = String.valueOf(file.getFileName());
                if (s.charAt(0)=='f') {//this apply getting files without closing browser

                    /*String s = String.valueOf(file.getFileName());
                    BufferedReader br = new BufferedReader((new FileReader(fromPath + "\\" + s)));
                    String line = br.readLine();

                    if (line.startsWith("ID3")) {*/
                    Path toPathFile = Paths.get(toPath + "\\" + file.getFileName() + ".mp3");
                    if (!Files.exists(toPathFile)) {
                        Files.createFile(toPathFile);// creating target dir
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
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
