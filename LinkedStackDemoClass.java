//Alec Arroyo 
/**
 * Infix to Postfix converter
 * Postfix to Infix converter
 * Prints Equations
 * Exits program
**/
import java.util.Scanner;
import java.util.Stack;
 
public class LinkedStackDemoClass<T> extends LinkedStackClass<T>
{
  public static void main(String[] args) 
  {
    /** Declared all stacks and linked lists **/
    //Stack for num = 1
    LinkedStackClass<String> stack = new LinkedStackClass();
    //Stack for num = 2
    LinkedStackClass<String> s = new LinkedStackClass();
    //Stack linked list to print all equaitons
    LinkedStackClass<String> allEqu = new LinkedStackClass();
    //Stack linked list to print all conversions
    LinkedStackClass<String> linked = new LinkedStackClass();
    
    //Declared string variables   
    String value1, end;
    //Declared num variable; holds user input for number option.
    int num = 0;
    //Declared string
    String linkval = ""; 
    Scanner keyboard = new Scanner(System.in);
    
    //Keep looping until user wants to exit(4)
    while (num != 4)
    { 
      String word1 = "";
      String word2 = ""; 
      char c = 'a';
      char p = 'b';
      boolean value = stack.isEmptyStack();
      
      //Asks user to input option number
      System.out.println();
      System.out.println("Please select what type of conversion you would like to do: ");
      System.out.println("1.Infix to postfix");
      System.out.println("2.Postfix to infix");
      System.out.println("3.Print Equations");
      System.out.println("4.Exit");
      num = keyboard.nextInt();
      
      //Option #1
      if(num == 1)
      {
        System.out.println("Enter equation without the x = portion of it for infix.(add ; at end) ");
        word1 = keyboard.next();
        
        //Error checking if user puts semicolon at end
        if(!word1.contains(";"))
        {
          System.out.println("Error no ; variable at the end of equation. Try again");
          System.exit(0);
        }
        //Push equation onto stack
        allEqu.push(word1);
        int next = 0;
        for(int i = 0; i <= next; i++)
        {
          c = word1.charAt(i);
          
          if(c != ';')
          {
            
            if(c == '^' || c == '*' || c == '/' || c == '+' || c == '-')
            {
              if(value == true)
              {
                String a_letter = Character.toString(c);
                stack.push(a_letter);
                value = false;
              }
            else if(value == false)
            {
              String a_letter = Character.toString(c);
              if(stack.peek().equals(a_letter))
              { 
                System.out.print(stack.peek());
                linkval = linkval + stack.peek();
                stack.pop();
                stack.push(a_letter);
              }
              else if(stack.peek().equals("+") && a_letter.equals("-"))
              {
                System.out.print(stack.peek());
                linkval = linkval + stack.peek();
                stack.pop();
                stack.push(a_letter);
              }
              else if(stack.peek().equals("-") && a_letter.equals("+"))
              {
                System.out.print(stack.peek());
                linkval = linkval + stack.peek();
                stack.pop();
                stack.push(a_letter);
              }
              else if(stack.peek().equals("*") && a_letter.equals("/"))
              {
                System.out.print(stack.peek());
                linkval = linkval + stack.peek();
                stack.pop();
                stack.push(a_letter);
              }
              else if(stack.peek().equals("/") && a_letter.equals("*"))
              {
                System.out.print(stack.peek());
                linkval = linkval + stack.peek();
                stack.pop();
                stack.push(a_letter);
              }
              else
              {
                stack.push(a_letter);
              }
            }
            }
             else
            {
              System.out.print(c);
              linkval = linkval + c;
            }
             next++;
           }
           else
           {
             //Prints postfix notation; stores in linked list
             while (!stack.isEmptyStack()) { 
             System.out.print(stack.peek());
             linkval = linkval + stack.peek();
             stack.pop();
             
             if(stack.first == null)
             {
               linked.push(linkval);
               linkval = "";
             }
           }
           }
         }
       }
      //Option #2
      else if(num == 2)
      {
        value = true;
        System.out.println("Enter equation without the x = portion of it for postfix.(add ; at end) ");
        word2 = keyboard.next();
        if(!word2.contains(";"))
        {
          System.out.println("Error no ; variable at the end of equation. Try again");
          System.exit(0);
        }
         allEqu.push(word2);
         int nex = 0;
         for(int i = 0; i <= nex; i++)
         {
           p = word2.charAt(i);
           
           if(p != ';')
           {
              if(p != '^' && p != '*' && p != '/' && p != '+' && p != '-')
              {
                  String a_letter = Character.toString(p);
                  s.push(a_letter);
              }
              else
              { 
                String a_letter = Character.toString(p);
                if(value == true)
                {
                  System.out.print(s.peek());
                  linkval = linkval + s.peek();
                  s.pop();
                  s.push(a_letter);
                  System.out.print(a_letter);
                  linkval = linkval + a_letter;
                  s.pop();
                  System.out.print(s.peek());
                  linkval = linkval + s.peek();
                  value = false;
                }
                else
                {
                  s.push(a_letter);
                }
              }
              nex++;
           }
           else
           {
             //Prints infix notation; stores in linked list
             while(!s.isEmptyStack())
             {
             System.out.print(p);
             linkval = linkval + p;
             s.pop();
             }
             if(s.first == null)
             {
               linked.push(linkval);
               linkval = "";
             }
           } 
         }
       }
      //Option #3
      else if(num == 3)
      {
        //Pops linkedstack and prints all equations till linkedstack is null
        while(!allEqu.isEmptyStack())
        {
          System.out.println(allEqu.peek());
          allEqu.pop();
        }
      }
      else if(num == 4)
      {
        //While loop to pop stack and print all conversions
        while(!linked.isEmptyStack())
        {
          System.out.println(linked.peek());
          linked.pop();
        }
      }
      //Error checking
      else
      {
        System.out.println("Invalid number. Enter number between 1 and 4");
        System.exit(0);
      }
    }
  } 
}