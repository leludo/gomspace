package lu.book.exos.chapter04;

import lombok.extern.java.Log;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@Log
public class Camera {

    public Camera (){
        setFilters();
    }

    private void setFilters(final Function<Color,Color> ... filters ) {
        filter= Stream.of(filters).reduce((current, next) -> current.compose(next))
                .orElse(Function.identity());
        // reduce optional result may be null, the single element of the list is returned.
        // Function.identity() is roughly equivalent to Color -> Color
    }

    private Function<Color,Color> filter;

    public Color capture(final Color inputColor){
        final Color processedColor = filter.apply(inputColor);
        //do something
        return processedColor;
    }
    public static void main(final String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                log.info(String.format("with %s: %s", filterInfo,
                camera.capture(new Color(200, 100, 200))));

        log.info("//" + "START:NOFILTER_OUTPUT");
        printCaptured.accept("no filter");
        log.info("//" + "END:NOFILTER_OUTPUT");

        log.info("//" + "START:BRIGHT_OUTPUT");
        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");
        log.info("//" + "END:BRIGHT_OUTPUT");

        log.info("//" + "START:DARK_OUTPUT");
        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");
        log.info("//" + "END:DARK_OUTPUT");

        log.info("//" + "START:BOTH_OUTPUT");
        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("brighter & darker filter");
        log.info("//" + "END:BOTH_OUTPUT");
    }
}
