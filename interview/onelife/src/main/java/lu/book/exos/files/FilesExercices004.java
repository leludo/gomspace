package lu.book.exos.files;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

@Log4j2
@Data
public class FilesExercices004 {

    // todo : change this to use resources instead and move the class to junit test instead
    public static final String DOCUMENTS_EMACS_TXT = "C:\\Users\\ludov\\OneDrive\\Documents\\emacs.txt";

    public static void main(String[] args) {
        try {

            Stream<String> lines = Files.lines(Paths.get(DOCUMENTS_EMACS_TXT));

            lines.sorted().filter(l-> l.startsWith("Ctrl")).forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}