package bt.edu.rub.todo_09;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)

public class ExampleUnitTest {
    private Calulator mcalculator;

    @Before

    public void setUp() {
        mcalculator = new Calulator();
    }
    @Test
    public void addTwoNumbers() {
        double result = mcalculator.add(1d, 2d);
        assertThat(result, (equalTo(3d)));

    }
    @Test
    public void addTwoNumbersNegative() {
        double result = mcalculator.add(1d, -2d);
        assertThat(result, (equalTo(-1d)));

    }
    @Test
    public void addTwoNumbersfloat() {
        double result = mcalculator.add(1.1f, 1.2d);
        assertThat(result, is(closeTo(2.3d,0.01d)));

    }

    @Test
    public void subTwoNumbers() {
        double result = mcalculator.sub(2d, 1d);
        assertThat(result, (equalTo(3d)));

    }

    @Test
    public void subWorksWithNegativeResults() {
        double result = mcalculator.sub(-1d, 2d);
        assertThat(result, (equalTo(-3d)));

    }
    @Test
    public void mulTwoNumbers() {
        double result = mcalculator.mul(1d, 2d);
        assertThat(result, (equalTo(2d)));

    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mcalculator.mul(1d, 0d);
        assertThat(result, (equalTo(0d)));

    }
    @Test
    public void divTwoNumbers(){
        double result = mcalculator.div(9d, 3d);
        assertThat(result, (equalTo(3d)));

    }
    @Test
    public void divTwoNumbersZero(){
        double result = mcalculator.div(9d, 0d);
        assertThat(result, (equalTo(Double.POSITIVE_INFINITY)));

    }


}