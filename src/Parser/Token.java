package Parser;

/**
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