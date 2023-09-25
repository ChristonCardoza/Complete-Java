package com.handson.iostreams;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class IOServiceImp implements IOService{

    @Autowired
    ResourceLoader resourceLoader;
    @Override
    public void readFileStream() throws FileNotFoundException, IOException {

        Resource resource = resourceLoader.getResource("classpath:io/abc.txt");
        File file = resource.getFile();

        FileInputStream fis = new FileInputStream(file);

        int data;
        while((data=fis.read()) != -1){
            System.out.println("data: " + (char)data);
        }

        fis.close();
    }

    @Override
    public void writeFileStream() throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream("./src/main/resources/io/bbc.txt");

        fos.write(7);
        fos.write(0);
        fos.write(8);

        fos.flush();

        System.out.print("data is saved");

        fos.close();
    }

    @Override
    public void copyFileStream() throws FileNotFoundException, IOException {

        Resource resource = resourceLoader.getResource("classpath:io/abc.txt");
        File file = resource.getFile();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("./src/main/resources/io/copy.txt");

        int data;

        while((data = fis.read()) != -1){

            fos.write(data);
        }

        System.out.println("File copied");

        fis.close();
        fos.flush();
        fos.close();
    }

    @Override
    public void listAllFile() throws IOException {

        int count =0;

        File file = new File("./src/main/resources/io/");

        String[] s = file.list();

        for(String s1: s){

            File f1 = new File(file, s1);

            if(f1.isFile()){
                count ++;

                System.out.println(s1);
            }

        }

        System.out.println("The total number : " + count);

    }

    @Override
    public void writeFileWriter() throws IOException {

        FileWriter fw = new FileWriter("./src/main/resources/io/writer.txt");

        fw.write(100);
        fw.write("\n");

        fw.write("Christu's world...........");
        fw.write("\n");

        char[] ch = { 'a', 'b', 'c'};

        fw.write(ch);
        fw.write("\n");
        fw.flush();

        System.out.print("data is saved");

        fw.close();
    }

    @Override
    public void readFileReader() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:io/abc.txt");
        File file = resource.getFile();

        FileReader fr = new FileReader(file);

        char[] ch = new char[(int)file.length()];

        fr.read(ch);

        for(char ch1: ch){
            System.out.println(ch1);
        }

        fr.close();

        System.out.println("******************************************");

        FileReader fr1 = new FileReader(file);

        int data;

        while((data=fr1.read()) != -1){
            System.out.println((char) data);
        }

        fr1.close();
    }

    @Override
    public void writeBufferedWriter() throws IOException {

        FileWriter fw = new FileWriter("./src/main/resources/io/bufferedWriter.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(100);
        bw.newLine();
        char[] ch1 = {'a', 'b', 'c', 'd'};
        bw.write(ch1);
        bw.newLine();
        bw.write("Christon");
        bw.newLine();
        bw.write("Cardoza");

        bw.flush();
        bw.close();

        System.out.print("data is saved");
    }

    @Override
    public void readerBufferedReader() throws IOException {

        Resource resource = resourceLoader.getResource("classpath:io/abc.txt");
        File file = resource.getFile();

        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        String line;

        while ((line= br.readLine()) != null){

            System.out.println(line);
        }

        br.close();
    }

    @Override
    public void writePrintWriter() throws IOException {

        FileWriter fw = new FileWriter("./src/main/resources/io/printWriter.txt");

        PrintWriter out = new PrintWriter(fw);

        out.write(100);
        out.println();
        out.println(100);
        out.println(true);
        out.println('c');
        out.println("Christon");

        out.flush();
        out.close();

        System.out.print("data is saved");
    }

    @Override
    public void mergeFile() throws IOException {

        FileReader fr = new FileReader("./src/main/resources/io/bufferedWriter.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("./src/main/resources/io/merge.txt");
        PrintWriter pw = new PrintWriter(fw);

        String line;

        while((line = br.readLine()) != null){
            pw.println(line);
        }

        fr = new FileReader("./src/main/resources/io/printWriter.txt");
        br = new BufferedReader(fr);

        while ((line = br.readLine()) !=null){
            pw.println(line);
        }

        br.close();

        pw.flush();
        pw.close();

        System.out.println("File Merged Successfully");
    }

    @Override
    public void mergeFileLineByLine() throws IOException {

        FileReader fr = new FileReader("./src/main/resources/io/bufferedWriter.txt");
        FileReader fr1 = new FileReader("./src/main/resources/io/printWriter.txt");

        BufferedReader br = new BufferedReader(fr);
        BufferedReader br1 = new BufferedReader(fr1);

        PrintWriter pw = new PrintWriter("./src/main/resources/io/mergeLineByLine.txt");

        String line = br.readLine();
        String line1 = br1.readLine();

        while(line != null || line1  !=null){

            if(line != null){

                pw.println(line);
                line = br.readLine();
            }

            if(line1 != null){

                pw.println(line1);
                line1 = br1.readLine();
            }
        }

        pw.flush();
        pw.close();

        br.close();
        br1.close();

        System.out.println("Successfully Merged File Line By Line");
    }

    @Override
    public void fileExtractor() throws IOException {

        FileReader contentFile = new FileReader("./src/main/resources/io/content.txt");

        BufferedReader contentReader = new BufferedReader(contentFile);

        PrintWriter pw = new PrintWriter("./src/main/resources/io/filteredData.txt");

        String line = contentReader.readLine();

        while(line != null){
            boolean available = false;

            FileReader filterFile = new FileReader("./src/main/resources/io/filter.txt");
            BufferedReader filterReader = new BufferedReader(filterFile);
            String target = filterReader.readLine();

            while(target != null){

                if(line.equals(target)){
                    available = true;
                    break;
                }
                target = filterReader.readLine();
            }

            if(!available){

                pw.println(line);
            }

            line = contentReader.readLine();
        }

        pw.flush();
        pw.close();

        contentReader.close();

        System.out.println("Successfully Filtered File Content");
    }

    @Override
    public void duplicateFileEliminator() throws IOException {

        FileReader duplicatedFile = new FileReader("./src/main/resources/io/duplicateFile.txt");
        BufferedReader contentReader = new BufferedReader(duplicatedFile);

        PrintWriter pw = new PrintWriter("./src/main/resources/io/duplicateEliminated.txt");

        String line;

        while((line = contentReader.readLine()) != null){

            boolean available = false;

            BufferedReader eliminated = new BufferedReader(new FileReader("./src/main/resources/io/duplicateEliminated.txt"));

            String target;

            while((target=eliminated.readLine()) != null){

                if(line.equals(target)){

                    available = true;
                    break;
                }
            }

            if(!available){

                pw.println(line);
                pw.flush();
            }
        }

        pw.close();

        System.out.println("Successfully Eliminate Duplicate Content");
    }
}
