import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiniteStateMachine {

    private class State {

        private String value;
        private Map<String, String> outputStates;

        public State(String value, Map outputStates) {
            this.value = value;
            this.outputStates = outputStates;
        }

        public String getValue() {
            return value;
        }

        public String getOutputState(String input) {
            return outputStates.get(input);
        }
    }

    private Map<String, String> outputStatesOfS0 = new HashMap<String, String>() {{
        put("0", "S0");
        put("1", "S1");
    }};
    private Map<String, String> outputStatesOfS1 = new HashMap<String, String>() {{
        put("0", "S2");
        put("1", "S0");
    }};
    private Map<String, String> outputStatesOfS2 = new HashMap<String, String>() {{
        put("0", "S1");
        put("1", "S2");
    }};

    private Map<String, State> fsm = new HashMap<String, State>() {{
        put("S0", new State("0", outputStatesOfS0));
        put("S1", new State("1", outputStatesOfS1));
        put("S2", new State("2", outputStatesOfS2));
    }};

    public String run(String inputString, String initialState, List<String> validFinalStates) {
        String currentState = initialState;
        char[] inputChars = inputString.toCharArray();
        String[] inputArray = new String[inputChars.length];

        //Get Input String Array
        int index = -1;
        for (char c : inputChars) {
            inputArray[++index] = Character.toString(c);
        }

        //Get Final/Result State
        for (String input : inputArray) {
            currentState = fsm.get(currentState).getOutputState(input);
        }
        String finalState = currentState;

        //Check Final State is a Valid State
        if (index > -1) {
            for (String validFinalState : validFinalStates) {
                if (validFinalState.equalsIgnoreCase(finalState)) {
                    return fsm.get(finalState).getValue();
                }
            }
        }
        return "Invalid Input";
    }
}
