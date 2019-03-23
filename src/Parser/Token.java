package Parser;

/**
 * enum token that will be used to decide "Types" of each word in the input
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