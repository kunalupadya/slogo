## SLogo API Design

Dhanush Madabusi (dm322@duke.edu)

Januario Carreiro (jjc70@duke.edu)

Kunal Upadya (ku16@duke.edu)

Louis Lee (dl199@duke.edu)

David Liu (dwl23@duke.edu)

## Questions
#### When does parsing need to take place and what does it need to start properly?

Parsing takes place after recieving commands from the shell. It needs the commands from the shell to start properly. It is in the backend internal.

#### What is the result of parsing and who receives it?

The result of parsing is changes to the backend (in grid and turtle). This is performed by ExecuteCommands 

#### When are errors detected and how are they reported?

Errors in the parsing are detected by the HandleError class, which is used by ParseCommands.

#### What do commands know, when do they know it, and how do they get it?

Commands know their action type - they always know this, but the parameters are fed into 

#### How is the GUI updated after a command has completed execution?

The gui is updated by looking at the grid, turtle, prevcommands, and availablevars classes.