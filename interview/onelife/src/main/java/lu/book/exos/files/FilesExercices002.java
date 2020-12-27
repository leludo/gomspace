package lu.book.exos.files;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Log4j2
@Data
public class FilesExercices002 {

    public static final String DOCUMENTS = "C:\\Users\\ludov\\OneDrive\\Documents";
    public static final DirectoryStream.Filter<Path> EXCEL_FILES_FILTER = path -> path.toFile().getName().endsWith(".xlsx");

    public static void main(String[] args) {
        try {

//        // old way - list the files of a given directory and filter them with the suffix
//        final String[] files = new File(DOCUMENTS).list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".xlsx");
//            }
//        });
//        Arrays.stream(files).forEach(System.out::println);

            //Files.newDirectoryStream(Paths.get(DOCUMENTS), path -> path.toString().endsWith(".xlsx")).forEach(System.out::println);

            //Files.newDirectoryStream(Paths.get(DOCUMENTS), EXCEL_FILES_FILTER).forEach(System.out::println);
            //printFiles(Paths.get(DOCUMENTS));

            listFiles(Paths.get(DOCUMENTS)).forEach(System.out::println);




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<File> listFiles(Path path) throws IOException {
        // using flat map to flatten the streams of files into a single stream,  then the stream is transformed into a list
        return Stream.of(path.toFile().listFiles()).flatMap(file -> file.isDirectory()? Stream.of(file.listFiles()):Stream.of(file)).collect(toList());

    }

    static void printFiles(Path path){
        if (path.toFile().isDirectory()){
            try {
                Files.newDirectoryStream(path).forEach(p -> printFiles(p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else  log.info(path.toString());
    }

}