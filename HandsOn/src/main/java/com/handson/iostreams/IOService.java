package com.handson.iostreams;

import java.io.IOException;

public interface IOService {

    void readFileStream() throws IOException;

    void writeFileStream() throws  IOException;

    void copyFileStream() throws IOException;

    void listAllFile() throws IOException;

    void writeFileWriter() throws IOException;

    void readFileReader() throws IOException;

    void writeBufferedWriter() throws IOException;

    void readerBufferedReader() throws IOException;

    void writePrintWriter() throws IOException;

    void mergeFile() throws IOException;

    void mergeFileLineByLine() throws IOException;

    void fileExtractor() throws IOException;

    void duplicateFileEliminator() throws IOException;
}
