## Refactoring Discussion

Kunal Upadya (ku16@duke.edu)

Louis Lee (dl199@duke.edu)

David Liu (dwl23@duke.edu)

# Front End

Upon comments from Professor Duvall, the biggest change for the frontend was changing the public instance variables
to private instance variables and adding getters as the method of communication instead. This was done in the refactoring.
The second biggest change was magic values, which were apparent throughout FrontendController. This was also dealt with.

# Back End

No major changes were made in the backend but because backend had long methods, we refactored those to 
small methods. Also we found out that we were checking the input from both delete comment and token converter,which was unnecessary
Thus, we decided to the remove deletecomment class and use tokenconverter to tell which part of the string is comment or not. 
For the parsingtree, although we had multiple if statements, we could not refactor the tree since having several if statements was the
only way we could differentiate different type of commands. 