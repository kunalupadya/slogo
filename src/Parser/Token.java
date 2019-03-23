package Parser;

/**
 * enum token that will be used to decide "Types" of each word in the input
 * @author Louis Lee
 */

public enum Token {
    Comment,
    Constant,
    Variable,
    Command,
    ListStart,
    ListEnd,
    GroupStart,
    GroupEnd,
    WhiteSpace,
    NewLine,
    Error
}