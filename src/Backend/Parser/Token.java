package Backend.Parser;

public enum Token {
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

//TODO: implement some sort of toString()