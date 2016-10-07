# httfail

echoes whatever http status you're asking for

## Build

    $ mvn package

## Run

    $ java -jar target/httfail-0.0.1-SNAPSHOT.jar server config.yml


## Test

    $ curl -X DELETE -v http://localhost:8080/417
    ...
    < HTTP/1.1 417 Expectation Failed