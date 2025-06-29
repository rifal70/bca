# BCA CreditSim

## How to Build
```bash
mvn clean package
```

## How to Run
```bash
# Without file input
java -jar -jar target/bca-1.0-SNAPSHOT-jar-with-dependencies.jar

# With file input
java -jar -jar target/bca-1.0-SNAPSHOT-jar-with-dependencies.jar file_inputs.txt
```

## Docker

### Without File
```bash
docker build -t bca .
docker run --rm -it bca
```

### With File
```bash
docker run --rm -v "${PWD}:/inputs" rifal70/bca /inputs/file_inputs.txt
```

docker run --rm -v "${PWD}:/inputs" rifal70/bca /inputs/file_inputs.txt

## Notes
- Java SE only
- No external dependencies unless needed for HTTP/JSON