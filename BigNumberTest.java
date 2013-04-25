import static org.junit.Assert.*;
import org.junit.*;

public class BigNumberTest{
  BigNumber a1;
	
	
	@Before
    public void setUp() throws Exception {
   	a1 = new BigNumber();

   	}
	
	
	@Test
    public void testSample1(){
		assertEquals("110003",a1.standardize("0000000000000000000000110003"));
		assertEquals("12341234",a1.standardize("000000000000000000000012341234"));
		assertEquals("7654",a1.standardize("00000000000000000000007654"));
		assertEquals("0",a1.standardize("0000000000000000000000000000"));
		assertEquals("1",a1.standardize("00000000000000000000001"));		
    }
    
    @Test
    public void testSample2(){
		assertEquals("110003",a1.addition("0000000000000000000000110003","0"));
		assertEquals("110004",a1.addition("0000000000000000000000110003","1"));
		assertEquals("1111112111111111111111111111111111110"
					,a1.addition("1111111111111111111111111111111111111"
								,"999999999999999999999999999999"));
		
		assertEquals("1000000000000000000000000000000"
					,a1.addition("1"
								,"999999999999999999999999999999"));
    }
    @Test
    public void testSample3(){
		assertEquals("<0",a1.subtraction("0000000000000000000000110003"
										,"88888888888888888888888888888"));
		assertEquals("20000212009021400059",a1.subtraction("0020000213121011110062","1111989710003"));
		assertEquals("1",a1.subtraction("10","9"));
		assertEquals("4",a1.subtraction("98","94"));
		assertEquals("1234567889",a1.subtraction("1234567890","1"));
		
    }
    @Test
    public void testSample4(){
		assertEquals("1100030",a1.multiplication("0000000000000000000000110003","10"));
		assertEquals("110003",a1.multiplication("0000000000000000000000110003","1"));
		assertEquals("0",a1.multiplication("0000000000000000000000110003","0"));
		assertEquals("1987654323456787765435897413406303217024561220971237750003280"
					,a1.multiplication("1000000000000000000000110003"
										,"1987654323456787765435678765467760"));
		assertEquals("19640119605058777864529827371209847490689068246036184881465664932479722384470760771244"
					,a1.multiplication("10465918746359817639476023846128736837451876"
								,"1876578643598763495187085761038576187435619"));
		assertEquals("0",a1.multiplication("0","0"));
		
    }
    @Test
    public void testSample5(){
		assertEquals("#",a1.div("10","0"));
		assertEquals("10111112312312312",a1.div("10111112312312312","1"));
		assertEquals("0",a1.div("10","23456789876543456789765430"));
		assertEquals("5",a1.div("897465738491829372849372839403","192837463528192037492038293042"));
		assertEquals("4",a1.div("98","20"));
		assertEquals("1",a1.div("9","7"));
		
    }

}
