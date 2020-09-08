import random

#@author: Luis Zamorano
#Eid: ljz238 

class randomClass:
 
  
  
     
        
        
    def main():
        random.seed(1314)  
        
        
        sides=int(input("How many sides does the dice have? ")) #asks for number of sides 
        diceNum=int(input("How many dice are you rolling? ")) # asks for number of dice
        rolls=int(input("How many times do you want to roll the dice? ")) #prompts user to select number of rolls
        
        combo=(sides*diceNum)-(diceNum-1) # as long as dice number is > 1 will subtract the number of dice -1 since for 3 dice we can't get a 1 or a 2 and for 4 only 4 and up , etc.  
        diceTotal= diceNum *sides # gives us the possible dice numbers range we will get ie: 2 to 12 , 3 to 18, etc. 
        
        def roll(diceNum, sides, rolls, combo):
          i=0 # variable for the looping process value is intended to be 0
           
          output=[0]*combo # I made a list to store the output of each roll  
          
          while i < rolls: #loop function that does the random output for the number of rolls
               
            output[sum(random.randint(1, sides) for _ in range(diceNum))-diceNum]+=1 #sums the number of times each dice is used 
             
            i+=1  
             
          return output 
           
        rollDice = roll(diceNum, sides, rolls, combo)
          
        maxNum=max(rollDice)# gives me number that has the highest amount of results
        
        print("Results ",rollDice) 
        if rolls<=100:
          maxHolder=maxNum #placeholder for the maxNum 
          maxNew=maxNum
        else: 
          maxHolder=int(round(maxNum*(100/rolls))) #placeholder for the maxNum
          maxNew=int(round(maxNum*(100/rolls)))
        
        asteriskTop=0 # variable for number of lines we will print 
        
        if rolls <=100:
          while asteriskTop<maxNew:
            print("|  ",end='')
            linePos=0 # the placeholder for every new line  
            
            while linePos < diceTotal-1: #inner loop that creates the asterisks
             
              if(rollDice[linePos]>=maxHolder or rollDice[linePos]==maxNum ): # sets the condition for an asterisk to be printed 
                
                print("*  ",end='')
                
              else:
                print("   ",end='')
              linePos+=1
            
            print("") 
            asteriskTop+=1
            maxHolder-=1 
        
        else:
          while asteriskTop<maxNew:
            print("|  ",end='')
            linePos=0 # the placeholder for every new line  
            
            while linePos < diceTotal-1: #inner loop that creates the asterisks
             
              if(int(rollDice[linePos]*(100/rolls))>=maxHolder): # sets the condition for an asterisk to be printed and scaled according to the graph 
                
                print("*  ",end='')
                
              else:
                print("   ",end='')
              linePos+=1
            
            print("") 
            asteriskTop+=1
            maxHolder-=1    
           
           
        diceP=0 # used for the printing loop
        j=diceNum # used for printing numbers loop
        for diceP in range(diceTotal-1):
          print("+--",end='')
          diceP+=1
        print("+-")
        print(" ",end='')
        while j <(diceTotal+1):
           if j <10:
             print("  ",end='')
             print(j,end='')
           else:
             print(" ",end='')
             print(j,end='')
           j+=1
        
            
            
            
      
              
          
        
        
        
        
        
    main()