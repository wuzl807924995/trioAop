package test.demo.run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.demo.face.IFace;
import test.demo.face.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-logger.xml")
public class T_logger {

	@Autowired
	IFace iFace;

	@Test
	public void testName1() throws Exception {
		User u = new User();
		u.setId(12);
		iFace.test1(u);
	}

}
