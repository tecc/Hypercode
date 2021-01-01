package me.tecc.hypercode.language.lexing;

public enum Operator {
    // bracket things
    PARAM_LIST_BEGIN("("), PARAM_LIST_END(")"),
    BLOCK_BEGIN("{"), BLOCK_END("}"),
    LIST_BEGIN("["), LIST_END("]"),
    LIST_SEPARATOR(","),
    // comparing operators
    EQUAL("=="), NOT_EQUAL("!="),
    GREATER_THAN(">"), GREATER_THAN_OR_EQUAL(">="),
    LESS_THAN("<"), LESS_THAN_OR_EQUAL("<="),
    // TODO: specialised comparing
    // algebra
    ADD("+"), SUBTRACT("-"),
    // these are equivalent to increment & decrement
    ADD_EQUALS("+="), SUBTRACT_EQUALS("-="),
    MULTIPLY("*"), DIVIDE("/"),
    // this is why i didn't name ADD_EQUALS and SUBTRACT_EQUALS INCREMENT and DECREMENT respectively
    // consistency: A+
    MULTIPLY_EQUALS("*="), DIVIDE_EQUALS("/="),
    // accessor operators
    SET("="), UNSET("~"),
    PROPERTY_ACCESS(".")
    ;

    public static final String ALPHABET = "(){}[]=!><+-*/.?:~,";
    private static int count = 0;
    String sequence;
    Operator(String seq) {
        for (char c : seq.toCharArray()) {
            if (!ALPHABET.contains("" + c))
                throw new RuntimeException("Invalid operator sequence! Using unreserved character " + c + ".");
        }
        // if (isOperator(seq))
        //     // has to be runtime because otherwise it isn't compilable
        //     throw new RuntimeException("Invalid operator sequence! Operator already exists.");

        this.sequence = seq;
    }

    public static boolean isOperator(String op) {
        return getOperator(op) != null;
    }

    public static Operator getOperator(String op) {
        for (Operator o : Operator.values()) {
            if (o.sequence.equals(op))
                return o;
        }
        return null;
    }
}
