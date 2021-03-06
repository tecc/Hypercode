package me.tecc.hypercode.language.lexing;

/**
 * Enumerator for all possible keywords.
 * See language reference for more information.
 */
public enum Keyword {
    ON("on"),
    IF("if"), ELSE("else"),
    VAR("var"),
    PROCESS("process"), FUNCTION("function"),
    MACRO("macro"),
    NATIVE("native");

    String word;
    Keyword(String word) {
        this.word = word.toLowerCase();
    }

    public static Keyword getKeyword(String word) {
        for (Keyword keyword : Keyword.values()) {
            if (keyword.is(word))
                return keyword;
        }
        return null;
    }

    public static boolean isKeyword(String word) {
        return getKeyword(word) != null;
    }

    /**
     * Checks if {@code word} is equal to this {@link Keyword}'s word string.
     *
     * @param word the word to check.
     * @return True if equal; false otherwise.
     */
    public boolean is(String word) {
        return this.word.equals(word);
    }

    /**
     * Checks if {@code keyword} is equal to this.
     * Alias of {@link #equals(Object)}
     *
     * @param keyword The keyword to check.
     * @return True if equal; false otherwise.
     */
    public boolean is(Keyword keyword) {
        return this.equals(keyword);
    }
}
