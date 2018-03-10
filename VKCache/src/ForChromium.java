import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ForChromium {
    public static void getMusic(Path fromPath, Path toPath) {


        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);

            Path toPathFile = null;
            for (Path file : stream) {
                String s = String.valueOf(file.getFileName());

                if (s.charAt(0) == 'f') {//this apply getting files without closing browser

                    BufferedReader br = new BufferedReader((new FileReader(fromPath + "\\" + s)));
                    String line = br.readLine();


                    if (line.startsWith("ID3") || line.startsWith("TAG")) {
                        toPathFile = Paths.get(toPath + "\\" + file.getFileName() + ".mp3");

                        if (!Files.exists(toPathFile)) {
                            Files.createFile(toPathFile);// creating target dir
                        }
                        try {
                            Files.copy(file, toPathFile, REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    } else {
                        if (toPathFile != null) {
                            FileInputStream fin = new FileInputStream(String.valueOf(file));
                            byte[] data = new byte[fin.available()];
                            fin.read(data, 0, fin.available());
                            Files.write(toPathFile, data, StandardOpenOption.APPEND);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            //System.out.println("There is no such browser on your PC");;
        }

    }
}
