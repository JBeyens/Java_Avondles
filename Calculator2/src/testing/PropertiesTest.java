package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.properties.PropertyFileReader;
import model.properties.PropertyManager;

public class PropertiesTest {
	private String configPath;
	private int minimumNumber;
	private int maximumNumber;
	private int numberOfQuestions;
	private boolean isRoundNumber;
	private String[] operatorArray;
	private String[] stringArray;
	
	@Before
	public void setUp(){
		configPath = "resources/config.properties";
		stringArray = new String[4];
		stringArray[0] = new String("+");
		stringArray[1] = new String("-");
		stringArray[2] = new String("*");
		stringArray[3] = new String("/");
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_When_File_Found() {
		PropertyManager propMan = PropertyManager.CreationMethod();
		
		operatorArray = propMan.getProperty("operators").split(",");
		
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(propMan.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);
		Assert.assertArrayEquals(stringArray, operatorArray);
	}
	
	@Test
	public void test_Reading_Properties_Only_Operators_From_Config_File_When_File_Found() {
		PropertyManager propMan = PropertyManager.CreationMethod();
		
		operatorArray = propMan.getProperty("operators").split(",");
		
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(propMan.getProperty("isRoundNumber"));

		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);
		assertArrayEquals(stringArray, operatorArray);
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_Not_Found_Expect_Default_Settings(){
		PropertyManager propMan = PropertyManager.CreationMethod();
		propMan.setProperty(configPath, "invalid path");
		
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(propMan.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);	
	}
	
	
	@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Value_Expect_Default_Settings(){
		PropertyManager propMan = PropertyManager.CreationMethod();
			
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(propMan.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);	
	}

}
