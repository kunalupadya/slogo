package Parser;

/**
 * @author Louis Lee
 */

public enum Token {
    COMMENT,
    CONSTANT,
    VARIABLE,
    COMMAND,
    LIST_START,
    LIST_END,
    GROUP_START,
    GROUP_END,
    WHITESPACE,
    NEWLINE,
    ERROR
}