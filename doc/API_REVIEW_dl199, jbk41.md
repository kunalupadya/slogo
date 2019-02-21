Part1


1.  What about your API/design is intended to be flexible?

Our design separated the command(backend) with the front-end so that front end. This allows us to add more commands in the backend 
which would not require modification in the front end. Also having turtle and pen as different classes in the back end would allow to add 
more turtles if needed.  

2. How is your API/design encapsulating your implementation decisions?

We have four packages that are each responsible for backend/frontend external and internal APIs. This would allow total separation between 
front end and back end so that the whole code would be more flexible to modifications. s

3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)?

* Syntax error, object not identified, out of bounds error, etc

We will have parsecommand class that would use regex to find out all possible errors and handleerror will make 
necessary error strings that would appear on the console. 


4. Why do you think your API/design is good (also define what your measure of good is)?

It is good in that you can clearly distinguish APIS. All packages have clear purposes and encapsulation. (Classes would not have to interact with other 
classes in different packages except the "bridge" classes)

Part2 


1. How do you think Design Patterns are currently represented in the design or could be used to help improve the design?

Instead of making new text files everytime user saves new commands, we could add a line to the existing command file(or a map)

2. What feature/design problem are you most excited to work on?

I'm excited to work on the parsecommand part since this part is the core part of the slogo project. Reading in the string from the console and 
parsing the command so that tree in the executecommand class can interpret is fundamental. 

3. What feature/design problem are you most worried about working on?

My group has not decided on how tree will be formed in the executecommand class. This would be necessary since level has to be set before I can parse the command string so
that execute command can understand ina tree format.

4. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).

* String contains comments
public void checkerror(String input){
String comment = "^#.*"; 
while(input.find()(
    String newstring;
    input.getindex(comment)
    )
}

* String does not contain command 

* User clicks change language to chinese

* User types some string that should be executed 

* User saves the user-defined commands and uses it 