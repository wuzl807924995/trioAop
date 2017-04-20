package test;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.path.business.LoggerDemo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class T_Logger {

    @Autowired
    public LoggerDemo loggerDemo;

    public Scanner scanner = new Scanner(System.in);

    @Test
    public void testName() throws Exception {
        loggerDemo.t1(this);
    }

    @Test
    public void tes1() throws Exception {

        loggerDemo.t1_xml(this);
        System.out.println("time over");
        scanner.nextLine();
    }
}
