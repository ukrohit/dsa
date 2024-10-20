## Abstract Method 
    method defination :

        return_type methodName(argument arg );
    
        String convertToUppercase(String name);

         String convertToUppercase(String name)
        {
          return   name.toUpperCase();
        }

## Interface - 
    In inteface all the method are abstract 
    Processor 
    interface InterfaceOne{
        String abstractMethod(String name);
    }

## Abstract Class 
    in Abstract class if class contain at least one abstract method
    
    abstract class AbsctractClass{
     String abstractMethod(String name);
        
    }

## How to use abstract class and interface in class
- Abstract Class 
    class mainClass extends AbsctractClass
    {
        String abstractMethod(String name)
        {
            return "abcd";
        }
    }
  - Interface Class
      class mainClass implements InterfaceOne
      {
          String abstractMethod(String name)
          {
          return "abcd";
          }
      }


    
