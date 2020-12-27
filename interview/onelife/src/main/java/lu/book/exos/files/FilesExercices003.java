package lu.book.exos.files;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.util.stream.Collectors.toList;

@Log4j2
@Data
public class FilesExercices003 {

    public static final String DOCUMENTS = "C:\\Users\\ludov\\OneDrive\\Documents";

    public static void main(String[] args) {
        try {

            Path docPath = Paths.get(DOCUMENTS);
            // get the file system from the path and then the watch service
            WatchService watchService = docPath.getFileSystem().newWatchService();
            // we register a watcher for any entry modification over the given path
            docPath.register(watchService, ENTRY_MODIFY);

            // the watcher will be active for the poll definition of active time
            WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
            // after the time out the watchkey object will contains a list of events, if not null something append and
            // we are displaying it
            
            if (watchKey != null) {
                watchKey.pollEvents().stream().forEach(watchEvent -> System.out.println(watchEvent.context()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}