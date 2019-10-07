package com.orka;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String args[]) {
        String inputExample1 = "110";
        String inputExample2 = "1010";
        String initialState = "S0";
        List<String> validFinalStates = Arrays.asList("S0", "S1", "S2");
        FiniteStateMachine fsm = new FiniteStateMachine();

        System.out.println("Output of " + inputExample1 + " is: " + fsm.run(inputExample1, initialState, validFinalStates));
        System.out.println("Output of " + inputExample2 + " is: " + fsm.run(inputExample2, initialState, validFinalStates));
    }
}
