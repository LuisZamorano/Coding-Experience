
#  File: War.py
#  Description: A python based computer program that simulates the War! card game 
#  Student's Name: Luis Zamorano
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 
#
#  Date Created: October 5th 2017
#  Date Last Modified: October 6th 2017
import random
class Card(object): #the Card class that assigns a suit and rank
   type="C D H S".split()#creates a list of types of cards 
   ranking="2 3 4 5 6 7 8 9 10 J Q K A".split() #creates a list of numbers of the cards
   
   def __init__ (self,suit,rank):
      self.suit=suit #declares suit and rank to itself
      self.rank=rank
   
   def cValue(self,rankV):# gives cards rankings
      if rankV == "A":
        return 14
      elif rankV == "2":
        return  2
      elif rankV == "3":
        return  3
      elif rankV == "4":
        return 4
      elif rankV == "5":
        return  5
      elif rankV == "6":
        return  6
      elif rankV == "7":
        return  7
      elif rankV == "8":
        return  8
      elif rankV == "9":
        return  9
      elif rankV == "10":
        return  10
      elif rankV == "J":
        return  11
      elif rankV == "Q":
        return  12
      elif rankV == "K":
        return  13
      else:
        return  0
       
    
   def __str__(self):
      cardPrint=str(self.rank) + str(self.suit)
      return cardPrint
     
class Deck(object):
   
   def __init__(self):
      
      self.cardList= [Card(suit,rank) for suit in Card.type for rank in Card.ranking]
  
   def shuffle(self):#shuffles the deck
      
      random.shuffle(self.cardList)   
   
   def dealOne(self,pHand):
      
      pHand.hand.append(self.cardList.pop(0))#pops the first element
  
      pHand.handTotal+=1
   
   def __str__(self): 
      
      cardP="  " #made sure to create space in the list 
      mRow=0 # max number of cards per row
      cardN=0 # number of cards in the list 
      listLen=self.cardList.__len__()
     
      while cardN < listLen:#main while loop that processes how we will return the string for the deck
     
             
         if len(str(self.cardList[cardN]))>2: #created an exception so that it prints neat 
            
               if mRow==12:
                  cardP+= str(self.cardList[cardN])+" \n  "
                  mRow=0
               else:
                  cardP+= str(self.cardList[cardN])+" "     
                  mRow+=1
                  
         elif mRow==12: #checks for the max number of row 
               cardP+=str(self.cardList[cardN])+"  \n  "
               mRow=0
            
         else: # the basic processing if nothing else works 
               cardP+= str(self.cardList[cardN])+"  "
               mRow+=1         
         cardN+=1  
      cardP+="\n"
      
      return cardP


class Player(object):# the class that creates the players         
   
   def __init__(self):
        self.hand = []
        self.handTotal=0
   
   def __str__(self):
      maxRow=0
      cardN=0 #placeholder to keep track of card
      handP="  "
      
      if self.hand:
           for cardN in range(self.hand.__len__()):
              if len(str(self.hand[cardN]))>2: #created an exception so that it prints neat 
            
                 if maxRow==12:
                  handP+= str(self.hand[cardN])+" \n  "
                  maxRow=0
                 else:
                  handP+= str(self.hand[cardN])+" "     
                  maxRow+=1
                  
              elif maxRow== 12:
                 handP+= str(self.hand[cardN])+"  \n  "   
                 maxRow=0
                 
              else:   
                 handP+= str(self.hand[cardN])+"  "
                 maxRow+=1
       
      else:
            handP = "Player has no hand"
        
      
      return handP
     
   def handNotEmpty(self): #checks to see if hand is empty
      if self.hand:
         return True
      else:
         return False
         
class BattleField(Card):
   
   def __init__(self):
      self.round=0
      self.p1Value=0
      self.p2Value=0
   def playGame(self,Deck,p1,p2):
       while p1.handNotEmpty() and p2.handNotEmpty():
        
         self.round+=1
         print("ROUND "+str(self.round)+":")
         p1Play=str(p1.hand[0])
         p2Play=str(p2.hand[0])
         print("Player 1 plays:  "+p1Play)
         print("Player 2 plays:  "+p2Play)
         self.p1Value=p1.hand[0].cValue(p1.hand[0].rank)
         self.p2Value=p2.hand[0].cValue(p2.hand[0].rank)
         p1Down=[]# we created new lists to place the cards temporarily elsewhere so we can move it to the other palyer's hands
         p2Down=[]
         
         if(self.p1Value>self.p2Value):
            print("\nPlayer 1 wins round " +str(self.round)+":  " +p1Play+" > " +p2Play+"\n")
            p1Down.append(p1.hand.pop(0))# we reorder the cards and add them to the winner 
            p2Down.append(p2.hand.pop(0))
            p1.hand.extend(p1Down)
            p1.hand.extend(p2Down)
         elif(self.p1Value==self.p2Value):
            print("\nWar starts " +p1Play+" = "+p2Play )
            
            p1Down.append(p1.hand.pop(0))# we initially pop the already face up cards so that we can append it to our temporary list
            p2Down.append(p2.hand.pop(0))
            
            i=1 #placeholder for facedown loop
            
            while i<4: # a while loop for the war part of the facedown cards
                  p1Down.append(p1.hand.pop(0))
                  print("Player 1 puts " +str(p1Down[i])+" face down")
                  p2Down.append(p2.hand.pop(0))
                  print("Player 2 puts " +str(p2Down[i])+" face down")
             
                  i+=1   
                  
            print("Player 1 puts " +str(p1.hand[0])+" face up")   # facedown part of the program
            print("Player 2 puts " +str(p2.hand[0])+" face up")
            
            if (p1.hand[0].cValue(p1.hand[0].rank)>p2.hand[0].cValue(p2.hand[0].rank)):# this is if player 1 wins war else we print out p2 statement
               p1Down.append(p1.hand.pop(0))   
               p2Down.append(p2.hand.pop(0))   
               p1.hand.extend(p1Down)
               p1.hand.extend(p2Down)
               print("\nPlayer 1 wins round " +str(self.round)+":  " +str(p1Down[4])+" > " +str(p2Down[4])+"\n") # prints out the result of the round winnner for highes face up card
            else:
               p1Down.append(p1.hand.pop(0))   
               p2Down.append(p2.hand.pop(0))   
               p2.hand.extend(p1Down)
               p2.hand.extend(p2Down)
               print("\nPlayer 2 wins round " +str(self.round)+":  " +str(p2Down[4])+" > " +str(p1Down[4])+"\n")   
         else:
            print("\nPlayer 2 wins round " +str(self.round)+":  " +p2Play+" > " + p1Play+"\n")
            p1Down.append(p1.hand.pop(0))# we reorder the cards and add them to the winner 
            p2Down.append(p2.hand.pop(0))
            p2.hand.extend(p1Down)
            p2.hand.extend(p2Down)
            
            
         print("Player 1 now has " + str(p1.handTotal)+" card(s) in hand:")
         print(p1)
         print("Player 2 now has " + str(p2.handTotal)+" card(s) in hand:")
         print(p2)   
         print("\n")

def main():
     
      
      cardDeck = Deck()               # create a deck of 52 cards called "cardDeck"
      print("Initial deck:")
      print(cardDeck)                 # print the deck so we can see that you built it correctly
    
      random.seed(15)                 # leave this in for grading purposes
      cardDeck.shuffle()              # shuffle the deck
      print("Shuffled deck:")
      print(cardDeck)                 # print the deck so we can see that your shuffle worked
     
      player1 = Player()              # create a player
      player2 = Player()              # create another player
 
      for i in range(26):             # deal 26 cards to each player, one at 
         cardDeck.dealOne(player1)       # a time, alternating between players
         cardDeck.dealOne(player2)
      wargame=BattleField()
      wargame.playGame(cardDeck,player1,player2)


      if player1.handNotEmpty():
          print("\n\nGame over.  Player 1 wins!")
      else:
          print("\n\nGame over.  Player 2 wins!")
 
      print ("\n\nFinal hands:")    
      print ("Player 1:   ")
      print (player1)                 # printing a player object should print that player's hand
      print ("\nPlayer 2:")
      print (player2)                 # one of these players will have all of the cards, the other none
    
main()