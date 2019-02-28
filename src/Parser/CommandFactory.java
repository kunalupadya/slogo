package Parser;

import Parser.Commands.Command;
import Parser.Commands.ConstantCommand;
import Parser.Commands.Queries.*;
import Parser.Commands.Turtle_Command.*;
import Parser.Commands.Math.*;
import Parser.Commands.Boolean.*;

public class CommandFactory {

//    HandleError handleError;

    public Command getCommand(String word) {

        //Turtle_Command
        if (word.equalsIgnoreCase("forward") || word.equalsIgnoreCase("fd")) {
            return new ForwardCommand();
        } else if (word.equalsIgnoreCase("back") || word.equalsIgnoreCase("bk")) {
            return new BackCommand();
        } else if (word.equalsIgnoreCase("left") || word.equalsIgnoreCase("lt")) {
            return new LeftCommand();
        } else if (word.equalsIgnoreCase("right") || word.equalsIgnoreCase("rt")) {
            return new RightCommand();
        } else if (word.equalsIgnoreCase("setheading") || word.equalsIgnoreCase("seth")) {
            return new SetHeadingCommand();
        } else if (word.equalsIgnoreCase("towards")) {
            return new TowardsCommand();
        } else if (word.equalsIgnoreCase("setxy") || word.equalsIgnoreCase("goto")) {
            return new SetXYCommand();
        } else if (word.equalsIgnoreCase("pendown") || word.equalsIgnoreCase("pd")) {
            return new PenDownCommand();
        } else if (word.equalsIgnoreCase("penup") || word.equalsIgnoreCase("pu")) {
            return new PenUpCommand();
        } else if (word.equalsIgnoreCase("showturtle") || word.equalsIgnoreCase("st")) {
            return new ShowTurtleCommand();
        } else if (word.equalsIgnoreCase("hideturtle") || word.equalsIgnoreCase("ht")) {
            return new HideTurtleCommand();
        } else if (word.equalsIgnoreCase("home")) {
            return new HomeCommand();
        } else if (word.equalsIgnoreCase("clearscreen") || word.equalsIgnoreCase("cs")) {
            return new ClearScreenCommand();
        }
        //Queries Command
        else if (word.equalsIgnoreCase("xcor")) {
            return new XcorCommand();
        } else if (word.equalsIgnoreCase("ycor")) {
            return new YcorCommand();
        } else if (word.equalsIgnoreCase("heading")) {
            return new HeadingCommand();
        } else if (word.equalsIgnoreCase("pendown?") || word.equalsIgnoreCase("pendownup")) {
            return new PendownCommand();
        } else if (word.equalsIgnoreCase("showing?") || word.equalsIgnoreCase("showingup")) {
            return new ShowingCommand();
        }
        //Math Command
        else if (word.equalsIgnoreCase("sum") || word.equalsIgnoreCase("+")) {
            return new SumCommand();
        } else if (word.equalsIgnoreCase("difference") || word.equalsIgnoreCase("-")) {
            return new DifferenceCommand();
        } else if (word.equalsIgnoreCase("product") || word.equalsIgnoreCase("*")) {
            return new ProductCommand();
        } else if (word.equalsIgnoreCase("quotient") || word.equalsIgnoreCase("/")) {
            return new QuotientCommand();
        } else if (word.equalsIgnoreCase("remainder") || word.equalsIgnoreCase("%")) {
            return new RemainderCommand();
        } else if (word.equalsIgnoreCase("minus") || word.equalsIgnoreCase("~")) {
            return new MinusCommand();
        } else if (word.equalsIgnoreCase("random")) {
            return new RandomCommand();
        } else if (word.equalsIgnoreCase("sin")) {
            return new SinCommand();
        } else if (word.equalsIgnoreCase("cos")) {
            return new CosCommand();
        } else if (word.equalsIgnoreCase("tan")) {
            return new TanCommand();
        } else if (word.equalsIgnoreCase("atan")) {
            return new AtanCommand();
        } else if (word.equalsIgnoreCase("log")) {
            return new LogCommand();
        } else if (word.equalsIgnoreCase("pow")) {
            return new PowCommand();
        } else if (word.equalsIgnoreCase("pi")) {
            return new PiCommand();
        }
        // Boolean Command
        else if (word.equalsIgnoreCase("less?") || word.equalsIgnoreCase("lessp")) {
            return new LessCommand();
        } else if (word.equalsIgnoreCase("greater?") || word.equalsIgnoreCase("greaterp")) {
            return new GreaterCommand();
        } else if (word.equalsIgnoreCase("equal?") || word.equalsIgnoreCase("equalp")) {
            return new EqualCommand();
        } else if (word.equalsIgnoreCase("notequal?") || word.equalsIgnoreCase("notequalp")) {
            return new NotEqualCommand();
        } else if (word.equalsIgnoreCase("and")) {
            return new AndCommand();
        } else if (word.equalsIgnoreCase("or")) {
            return new OrCommand();
        } else if (word.equalsIgnoreCase("not")) {
            return new NotCommand();
        }
        //Not in this, then constant command
        return new ConstantCommand(Double.parseDouble(word));
    }
}
