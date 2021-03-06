import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Browser {
    public static void getMusic(Path fromPath, Path toPath) {
    }

    public static void zipCreator(Path fromPath, Path zipPath) throws IOException { //method to create Zip
        // out put file
        Path testPath = zipPath.getParent();
        if(!Files.exists(testPath))
            Files.createDirectory(testPath);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(String.valueOf(zipPath)));
        DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);
        // input file
        for (Path file : stream) {
            if (!String.valueOf(file).equals(String.valueOf(zipPath))) {
                FileInputStream in = new FileInputStream(String.valueOf(file));
                // name the file inside the zip  file
                out.putNextEntry(new ZipEntry(String.valueOf(file.getFileName())));

                // buffer size
                byte[] b = new byte[1024];
                int count;

                while ((count = in.read(b)) > 0) {
                    out.write(b, 0, count);
                }
                in.close();
            }
        }
        out.close();
    }

    public static void unZip(Path fromPath, Path toPath) throws IOException { //the unZip method
        if (!(Files.exists(fromPath))) {
            System.err.println("There is no such zip archive");
            return;
        }
        if (!Files.exists(toPath)) Files.createDirectory(toPath);
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(String.valueOf(fromPath));
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            Path toPathFile = null;
            while (ze != null) {
                String fileName = ze.getName();
                toPathFile = Paths.get(toPath + "\\" + fileName);
                if (!Files.exists(toPathFile))Files.createFile(toPathFile);
                FileOutputStream fos = new FileOutputStream(String.valueOf(toPathFile));
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void delData(Path fromPath, double maxSize) throws IOException { // method for deleting data
        try {
        DirectoryStream<Path> stream = Files.newDirectoryStream(fromPath);
        for (Path file : stream) {
            if (Files.size(file) / (1024 * 1024) < maxSize && !Files.isDirectory(file)) {
                Files.delete(file);
            }
        }

        } catch (IOException e) {
            System.out.println("Incorrect input");
        }
    }
    public static LinkedList<Path> pathToLinkedList(Path fromPath) {
        DirectoryStream<Path> stream = null;
        try {
            stream = Files.newDirectoryStream(fromPath);
            LinkedList<Path> listOfFiles = new LinkedList<Path>();
            for (Path file : stream) {
                listOfFiles.add(file.getFileName());
            }
            return listOfFiles;
        } catch (IOException e) {
            System.out.println("There is no such path");
        }
        return null;
    }

    public static void sortPath(Path fromPath) { //sorting and printing names of files

        LinkedList<Path> listOfFiles = pathToLinkedList(fromPath);
        if (listOfFiles == null) return;
        Collections.sort(listOfFiles, new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(listOfFiles.toString());


    }

    public static int numOfFiles(Path fromPath) { //counting number of files
        LinkedList<Path> listOfFiles = null;

        listOfFiles = pathToLinkedList(fromPath);
        if (listOfFiles != null)
            return listOfFiles.size();
        else return 0;

    }
}
