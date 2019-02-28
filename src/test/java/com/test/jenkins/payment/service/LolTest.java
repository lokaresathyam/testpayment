package com.test.jenkins.payment.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LolTest {

    private static final Logger LOG = LoggerFactory.getLogger(LolTest.class);

    @Test
    public void test() throws IOException{
        paymentResponse1();
    }

    private String paymentResponse1() throws IOException {
        String response = readFile("String.json");
        return response;
    }

    private String readFile(String pathname) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(pathname).getFile());
        LOG.info(file.getName());
        LOG.info(file.getAbsolutePath());
        LOG.info(file.getPath());
        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }
}
