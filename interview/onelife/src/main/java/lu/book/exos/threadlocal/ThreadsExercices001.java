package lu.book.exos.threadlocal;

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
public class ThreadsExercices001 {

    public static void main(String[] args) throws InterruptedException {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread t1 = new Thread(() -> {
            threadLocal.set("hello");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie){
                log.error("thread one issue", ie);
            }
            log.info(threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set("what?");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie){
                log.error("thread one issue", ie);
            }
            log.info(threadLocal.get());
        });

        t1.start();t2.start();
        t1.join(); t2.join();




    }


}