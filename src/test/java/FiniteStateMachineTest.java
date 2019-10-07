import com.orka.FiniteStateMachine;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FiniteStateMachineTest {

    FiniteStateMachine fsm = new FiniteStateMachine();
    List<String> validFinalStates = Arrays.asList("S0", "S1", "S2");

    @Test
    public void test_currentStateS0_input0_resultStateS0_OfValue0() {
        Assert.assertTrue(fsm.run("0", "S0", validFinalStates).equalsIgnoreCase("0"));
    }

    @Test
    public void test_currentStateS0_input1_resultStateS1_OfValue1() {
        Assert.assertTrue(fsm.run("1", "S0", validFinalStates).equalsIgnoreCase("1"));
    }

    @Test
    public void test_currentStateS1_input1_resultStateS2_OfValue2() {
        Assert.assertTrue(fsm.run("0", "S1", validFinalStates).equalsIgnoreCase("2"));
    }

    @Test
    public void test_currentStateS1_input1_resultStateS0_OfValue0() {
        Assert.assertTrue(fsm.run("1", "S1", validFinalStates).equalsIgnoreCase("0"));
    }

    @Test
    public void test_currentStateS2_input0_resultStateS1_OfValue1() {
        Assert.assertTrue(fsm.run("0", "S2", validFinalStates).equalsIgnoreCase("1"));
    }

    @Test
    public void test_currentStateS2_input1_resultStateS2_OfValue2() {
        Assert.assertTrue(fsm.run("1", "S2", validFinalStates).equalsIgnoreCase("2"));
    }
}
