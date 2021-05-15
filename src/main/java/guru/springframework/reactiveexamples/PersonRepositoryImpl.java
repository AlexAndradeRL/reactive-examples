package guru.springframework.reactiveexamples;

import guru.springframework.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 2/27/21.
 */
public class PersonRepositoryImpl implements PersonRepository {

    private final Person michael = Person.builder().id( 1 ).firstName("Michael").lastName( "Weston" ).build();
    private final Person fiona   = Person.builder().id( 2 ).firstName("Fiona").lastName( "Glenanne" ).build();
    private final Person sam     = Person.builder().id( 3 ).firstName("Sam").lastName( "Axe" ).build();
    private final Person jessy   = Person.builder().id( 4 ).firstName("Jesse").lastName( "Porter" ).build();

    @Override
    public Mono<Person> getById( Integer id ) {
        return Mono.just( michael );
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just( michael, fiona, sam, jessy );
    }
}
