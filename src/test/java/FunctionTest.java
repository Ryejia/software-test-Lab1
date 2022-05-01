import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTest {

    final double eps = .001;//погрешность

    @ParameterizedTest
    @DisplayName("Check some Pi dots")
    @ValueSource(doubles = {0, Math.PI / 2, Math.PI, Math.PI * 2, Math.PI * 3})
    public void piDotsTest(double x) {
        Assertions.assertEquals(SinFunction.calculate(x), Math.sin(x), eps);
    }

    @ParameterizedTest
    @DisplayName("Check some negative Pi dots")
    @ValueSource(doubles = {0, -Math.PI / 2, -Math.PI, -Math.PI * 2, -Math.PI * 3})
    public void firstAreaEq(double x) {
        Assertions.assertEquals(SinFunction.calculate(x), Math.sin(x), eps);
    }

    @ParameterizedTest
    @DisplayName("Check some random values")
    @ValueSource(doubles = {1, 2, 3, -1, -2, -3, 0.5, 0.89, 0.123})
    public void secondAreaEq(double x) {
        Assertions.assertEquals(SinFunction.calculate(x), Math.sin(x), eps);
    }
}