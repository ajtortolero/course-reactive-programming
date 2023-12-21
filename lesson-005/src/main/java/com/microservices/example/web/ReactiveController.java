package com.microservices.example.web;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

@RestController
public class ReactiveController {

    @GetMapping("/hello")
    public String handle() {
        return "Hola WebFlux";
    }

    @GetMapping("/")
    @ResponseBody
    public Publisher<String> handler() {
        return Flux.just("Hola mundo!", "Esto es Weblfux");
    }

    @GetMapping("/numbers")
    @ResponseBody
    public Publisher<Long> handleSeries() {
        Flux<Long> fibonacciGenerator = Flux.generate(() -> Tuples.<Long,
                Long>of(0L, 1L), (state, sink) -> {
            if (state.getT1() < 0)
                sink.complete();
            else
                sink.next(state.getT1());
            return Tuples.of(state.getT2(), state.getT1() + state.getT2());
        });
        return  fibonacciGenerator;
    }
}
