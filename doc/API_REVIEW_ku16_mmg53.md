1. What about your API/design is intended to be flexible?
    * The commands possible are intended to be flexible. Also
2. How is your API/design encapsulating your implementation decisions?
    * We encapsulate our implementations decisions by only having the grid, pen, and turtle classes accessible to the frontend. The frontend can only access the backend by inputting string commands into the ParseCommand class.
3. What exceptions (error cases) might occur in your part and how will you handle them (or not, by throwing)? 
    * We will check errors regarding improper commands being inputted in, these will be handled by HandleError.
4. Why do you think your API/design is good (also define what your measure of good is)?
    *  The API design is good because it encapsulates the backend from the frontend, while also allowing the frontend to get all the things that it would ever possibly need.

Part 2
1. How do you think Design Patterns are currently represented in the design or could be used to help improve the design?
    * The design patterns currently represented are inheritance, in the case of the commands, and encapsulation, in the case of the grid, pen, and turtle classes.
2. What feature/design problem are you most excited to work on?
    * I am most excited to work on the Turtle and Pen classes, I think that they will be interesting and challenging to work on.
3. What feature/design problem are you most worried about working on?
    * I am most worried about working on the commands class - it is going to be very challenging as the interitance will pose interesting challenges.
4. Come up with at least five use cases for your part (it is absolutely fine if they are useful for both teams).
    * To have an encapsulated method of communicating results from backend to frontend
    * To have a way of changing the backend using commands
    * To change turtle images
    * To change the pen color
    * To input turtle commands and see them onscreen