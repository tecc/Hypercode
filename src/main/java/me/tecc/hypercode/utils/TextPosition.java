package me.tecc.hypercode.utils;

public class TextPosition {
    public long line, column;

    public TextPosition(long line, long column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return line + ":" + column;
    }
}
