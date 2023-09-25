package com.handson.iostreams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/iostream")
public class IOController {

    @Autowired
    IOService ioService;

    @GetMapping(path = "/readFileStream")
    public ResponseEntity<String> readFileStream() throws IOException {

        ioService.readFileStream();

        return ResponseEntity.ok("File Read Successfully");
    }

    @GetMapping(path = "/writeFileStream")
    public ResponseEntity<String> writeFileStream() throws  IOException {

        ioService.writeFileStream();

        return ResponseEntity.ok("File Wrote Successfully");
    }

    @GetMapping(path = "/copyFileStream")
    public ResponseEntity<String> copyFileStream() throws IOException {

        ioService.copyFileStream();

        return ResponseEntity.ok("File Copied Successfully");
    }

    @GetMapping(path = "/listAllFiles")
    public  ResponseEntity<String> listAllFiles() throws IOException {

        ioService.listAllFile();

        return ResponseEntity.ok("File Listed Successfully");
    }

    @GetMapping(path = "/writeFileWriter")
    public ResponseEntity<String> writeFileWriter() throws  IOException {

        ioService.writeFileWriter();

        return ResponseEntity.ok("File Wrote Successfully");
    }

    @GetMapping(path = "/readFileReader")
    public ResponseEntity<String> readFileReader() throws IOException {

        ioService.readFileReader();

        return ResponseEntity.ok("File Read Successfully");
    }

    @GetMapping(path = "/writeBufferWriter")
    public ResponseEntity<String> writeBufferWriter() throws  IOException {

        ioService.writeBufferedWriter();

        return ResponseEntity.ok("File Wrote Successfully");
    }

    @GetMapping(path = "/readBufferReader")
    public ResponseEntity<String> readBufferReader() throws IOException {

        ioService.readerBufferedReader();

        return ResponseEntity.ok("File Read Successfully");
    }

    @GetMapping(path = "/writePrintWriter")
    public ResponseEntity<String> writePrintWriter() throws  IOException {

        ioService.writePrintWriter();

        return ResponseEntity.ok("File Wrote Successfully");
    }

    @GetMapping(path = "/mergeFile")
    public  ResponseEntity<String> mergeFile() throws  IOException {

        ioService.mergeFile();

        return ResponseEntity.ok("File Merged Successfully");
    }

    @GetMapping(path = "/mergeFileLineByLine")
    public ResponseEntity<String> mergeFileLineByLine() throws IOException {

        ioService.mergeFileLineByLine();

        return ResponseEntity.ok("File Merged Line By Line Successfully");
    }

    @GetMapping(path = "/fileExtractor")
    public ResponseEntity<String> fileExtractor() throws  IOException {

        ioService.fileExtractor();

        return ResponseEntity.ok("File Extracted Successfully");
    }

    @GetMapping(path = "/fileDuplicateEliminator")
    public ResponseEntity<String> fileDuplicateEliminator() throws  IOException {

        ioService.duplicateFileEliminator();

        return ResponseEntity.ok("File Duplicate Content Eliminated Successfully");
    }
}
