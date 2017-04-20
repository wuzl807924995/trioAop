package test.path.business;

import org.springframework.stereotype.Service;


@Service
public class LoggerDemo {

	public String t1(Object object) {
		System.out.println("LoggerDemo.t1");
		return object.toString();
	}

	public String t1_xml(Object object) {
		System.out.println("LoggerDemo.t1_xml");
		return object.toString();
	}
}
