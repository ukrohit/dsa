
# Stack 
## Constructor 
    
## stack push 
    So now we're going to create our push method. We'll bring up our stack like this.
    And push is going to look like this. So this is going to be very similar to Prepending an item to a linked list.So now let's start writing our code.
    We're going to call this push. he return type is void. And then we'll pass it a value.We'll use that value to create the node that we're going to push on to the stack like this.
    So the first situation we're going to code for is if the stack is empty.
    So we'll say if the height is equal to zero that is this situation where top is equal to null.
    And then we'll say top equals new node like this.
    So the other situation we're going to code for is if the stack already has items in the stack.
    So we'll say else.And now let's build out this else statement.
    So the first thing we'll do is say new node dot next equals top.
    So that is new node dot next equals top which is going to make that arrow point to the same node that
    top is pointing to.And then we'll say top equals new node.
    That moves that up there and adds that into our stack.
    So now let's add this into the rest of our code.
    And the only thing left to do is to increase the height by one.
    So we'll look at this code in a moment in IntelliJ.
    And when we do we're going to create this stack that just has one node in it.
    And then we'll push a new node onto this with a value of one.
    And then we'll do a print stack.And we should see a stack with values of one and two.Okay.
    So let's flip over to IntelliJ and take a look at this.
    So there is our push method that we just created having been added to our stack class.
    So now I'm going to come up here to our main class that contains our main method.
    So this line here creates our new stack with one node with a value of two.
    And this line here will print out that stack.I will run this.
    And you can see that to begin with, we have a stack with that one item with a value of two.
    So I'm going to come over here.And I'm going to paste in this line.
    And this is going to push a new node with a value of one onto the stack.
    And then we will run print stack again.And we should see one and two.So I'll run this.
    And you can see that we now have one and two.
    
## Stack Pop
    So now let's create our pop method for our stack.We'll bring our stack up like this.Pop is going to look like this.
    That is if the stack is not empty.So our method starts out like this.Our return type is node, which is the node that we are popping.
    We will return that.So we'll start out by coding for this situation where we have an empty stack.We'll say if the height is equal to zero,
    return null.You could also say if top is equal to null, return null either way.So now let's code for when we do have items in the stack.
    Since we are returning that top node, we'll need a variable that points to it.So we'll say temp equals top.
    That'll do this.And then we'll say top equals top dot.Next that is top equals top dot next.And that's going to move top down to this node 
    Then we'll say temp dot next equals null.That is temp dot next equals nullAnd that will break that off from our stack 
    And let's put these three lines of code in with the rest of our code like this.And the only things left to do are to decrement the height by one.
    And to return temp, which is the pointer to that node that we just removed.So we'll look at this code in a moment in IntelliJ.And 
    when we do we'll create this stack.And we'll pop that top item from the stack.And we should be left with a stack that has items three,
    23 and seven.So let's flip over to intelligence and take a look at this.So there is our Pop method there that has been added to our stack class.
    And then I'll come up here to this tab to bring up our main class that contains our main method.And these lines of code here are going to create
    that stack that we just saw in the diagram.And then we'll run this line here to print this out.So I'll run this.And you can see here that
    we have a stack with 11 323 and seven.So I'll come over here.And I'll paste in this line of code.And that will pop off that top item and 
    I'll run this.And you can see that our stack now contains three, 23 and seven And that is our method for pop.