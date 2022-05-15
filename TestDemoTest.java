import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.spy;
import static org.junit.jupiter.params.provider.Arguments.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
 import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestDemoTest {
   private  TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b) == (expected));
		}else {
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a , b))
		        .isInstanceOf(IllegalArgumentException.class);

		}
	}
 static Stream<Arguments> argumentsForAddPositive(){
	 return Stream.of(
			 arguments(5, 6, 11, false),
			 arguments(0, 5, 5, true ),
			 arguments(-5, 6, 1, true),
			 arguments(5, -6, -1, true)
			 );
	 
 }
 
      @Test
    void  assertThatNumberedSquaredIsCorrect(){
    	  TestDemo mockDemo = spy(testDemo);
    	  doReturn(5).when(mockDemo).getRandomInt();
    	  int fiveSquared = mockDemo.randomNumberSquared();
    	  assertThat(fiveSquared).isEqualTo(25);
      }
}
