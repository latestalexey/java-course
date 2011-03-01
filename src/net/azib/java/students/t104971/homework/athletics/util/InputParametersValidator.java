package net.azib.java.students.t104971.homework.athletics.util;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * @author Jaroslav Judin
 */
public class InputParametersValidator {

    private String inputMethod;
    private String inputParameter;
    private String outputMethod;
    private String outputParameter;

    public boolean isValid(String... args) {
        try {
            validate(args);
        } catch (UserInputException e) {
            return false;
        }
        return true;
    }

    public void validate(String... args) throws UserInputException {
        List<String> allowedInputMethods = Arrays.asList("-console", "-csv", "-db");
        List<String> allowedOutputMethods = Arrays.asList("-console", "-csv", "-xml", "-html");

        if (args.length < 2) {
            throw new UserInputException("Please, specify input(" + allowedInputMethods + ") and output(" + allowedOutputMethods + ") methods");
        }

        inputMethod = args[0];
        if (!allowedInputMethods.contains(inputMethod)) {
            throw new UserInputException(inputMethod + " input method doesn't exist");
        }

        if ("-console".equals(inputMethod)) {
            outputMethod = args[1];
        } else if (args.length < 3) {
            throw new UserInputException("Output method doesn't specified");
        } else {
            inputParameter = args[1];
            outputMethod = args[2];
        }
        if (!allowedOutputMethods.contains(outputMethod)) {
            throw new UserInputException(outputMethod + " output method doesn't exist");
        }

        if (!"-console".equals(inputMethod)) {
            if (args.length < 4) {
                throw new UserInputException("Output parameter doesn't specified for " + inputMethod);
            }
            outputParameter = args[3];
        }

    }


    public String getInputMethod() {
        return inputMethod;
    }

    public String getInputParameter() {
        return inputParameter;
    }

    public String getOutputMethod() {
        return outputMethod;
    }

    public String getOutputParameter() {
        return outputParameter;
    }
}