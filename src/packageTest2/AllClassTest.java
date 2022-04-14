package packageTest2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import packageTest.MatrizAdyacenciaTest;

@RunWith(JUnitPlatform.class)

@SelectClasses( MatrizAdyacenciaTest.class )
public class AllClassTest {

}
