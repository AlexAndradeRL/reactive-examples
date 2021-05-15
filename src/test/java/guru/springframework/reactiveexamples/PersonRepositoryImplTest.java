package guru.springframework.reactiveexamples;

import guru.springframework.reactiveexamples.domain.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImplTest {

    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    public void getByIdBlock() {
        System.out.println( "=== getByIdBlock ===" );
        Mono<Person> personMono = personRepository.getById( 1 );
        Person person = personMono.block();
        System.out.println( person );
    }

    @Test
    public void getByIdSubscribe() {
        System.out.println( "=== getByIdSubscribe ===" );
        personRepository
                .getById( 1 )
                .subscribe( System.out::println );
    }

    @Test
    public void getByIdMapFunction() {
        System.out.println( "=== getByIdMapFunction ===" );
        personRepository
                .getById( 1 )
                .doOnNext( System.out::println )
                .map( Person::getFirstName )
                .subscribe( name ->  System.out.println( "from map: " + name ) );
    }


    @Test
    public void fluxTestBlockFirst() {
        System.out.println( "=== fluxTestBlockFirst ===" );
        Flux<Person> personFlux = personRepository.findAll();
        Person person = personFlux.blockFirst();
        System.out.println( person );



    }

























}