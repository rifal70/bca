// === File: README.md ===
# Credit Simulator

## How to Build
```bash
mvn clean package
```

## How to Run
```bash
# Without file input
java -jar -jar target/bca-1.0-SNAPSHOT-jar-with-dependencies.jar

# With file input
java -jar -jar target/bca-1.0-SNAPSHOT-jar-with-dependencies.jar input.txt
```

## Docker
```bash
docker build -t bca .
docker run --rm -it bca
```

## Notes
- Java SE only
- No external dependencies unless needed for HTTP/JSON