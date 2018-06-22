package AdTheorent.Automation;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReporterTest {
@Test
public  void testone(){
	Assert.assertTrue(true);
}
@Test
public void testtwo(){
	Assert.assertTrue(false);
}
@Test (dependsOnMethods = {"testtwo"})
public void testthree(){
	
	Assert.assertTrue(true);
}

}
