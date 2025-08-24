package org.cardoza.sec04.assignment;

import reactor.core.publisher.Flux;

import java.nio.file.Path;

public interface FileReaderService {

    Flux<String> read(Path path);
}
