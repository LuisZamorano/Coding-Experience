#  File: htmlChecker.py
#  Description: A program that allows us to use linked lists to implement the "friend" functionality of a Facebook-like application.
#  Student's Name: Luis Zamorano    
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: November 10, 2017 
#  Date Last Modified: November 11, 2017
class Node (object):
   
   def __init__(self,initData):
      self.data = initData
      self.next = None            # always do this – saves a lot
                                  # of headaches later!
   def getData (self):
      return self.data            # returns a POINTER

   def getNext (self):
      return self.next            # returns a POINTER

   def setData (self, newData):
      self.data = newData         # changes a POINTER

   def setNext (self,newNext):
      self.next = newNext         # changes a POINTER
      
   def __str__(self):
      return str(self.data)   
   
   
# I copied and modified a few of the methods of the unordered list class we have previously used in other assignments
# I created new methods as well that are specific for this functionality of this assignment   
class UnorderedList ():

   def __init__(self):
      self.head = None

   def isEmpty (self): # Return True if a list is empty, or False otherwise
      empty=True
     
      if self.head!=None:#simply checks if there are any elements
         empty=False
        
      return empty   

   def add (self,item):
      # add a new Node to the beginning of an existing list
      temp = Node(item)
      temp.setNext(self.head)
      self.head = temp

   def length (self):
      current = self.head
      count = 0

      while current != None:
         count += 1
         current = current.getNext()

      return count
   def __str__ (self):
     # Return a string representation of data suitable for printing.
     #    Long lists (more than 10 elements long) should be neatly
     #    printed with 10 elements to a line, two spaces between elements   
      listStr=""
      current = self.head
      count = 0 # keeps count of numbers
      checkTen=0 # keeps track if it's 10 elements in the string
      while current != None:
        
         listStr+=current.__str__()+"  "
         if checkTen==10:# if statement that lets us if we have 10, print a new line
            checkTen=0
            listStr+="\n"
         count += 1
         checkTen+=1
         current = current.getNext()
         
      return listStr  
         
   def addLast (self, item): #adds an item to the ends of a list
      previous=None
      current=self.head #current string 
      while current!=None:
         previous=current
         current=current.getNext()
         
      temp=Node(item) # the following lines change the places of the data in the node    
      if previous == None: # if the current pointer is empty we must include an exception
         temp.setNext(self.head)
         self.head = temp
      else:
         temp.setNext(current)
         previous.setNext(temp)       
     
   
    
   
           
   def copyList (self):
     # Return a new linked list that's a copy of the original,
     #    made up of copies of the original elements
      linkCopy=UnorderedList()
      linkNode=self.head
      while linkNode!=None:
         linkCopy.addLast(linkNode.getData()) # does deep copying of the information
         linkNode=linkNode.getNext()
     
      return linkCopy
   
   # we will have from here on a bunch of new functions that help us work with this particular list
   
   def searchUser (self,user): #new function that will be used to see if a user exists
      current = self.head
      found = False

      while current != None and not found:
         if current.getData().name == user:
            found = True
         else:
            current = current.getNext()
      
         
            
      return found
   
   def searchFriend (self,friend): #new function that will search a friend on the users list
      current = self.head
      found = False

      while current != None and not found:
         if current.getData() == friend:
            found = True
         else:
            current = current.getNext()
         
      return found

   def userFriends(self,user):# returns a list with the friends of the selected user
      currentUser = self.head
      found = False
      friendL=UnorderedList()
      while currentUser != None and not found:
         if currentUser.getData().name == user:
            found = True
            friendL=currentUser.getData().friends.copyList() # we will return a list with the names 
            
         else:
            currentUser = currentUser.getNext()
          
      return friendL
   
   def newFriends(self,friend1,friend2): # adds two people to their respective friends list 
      currentUser = self.head
 
      while currentUser != None:
         if currentUser.getData().name == friend1: # will add friend2 to friend1 list of friends 
            currentUser.getData().addFriend(friend2)
            currentUser = currentUser.getNext()
            
         elif currentUser.getData().name == friend2 :# will add friend2 to friend1 list of friends 
            currentUser.getData().addFriend(friend1)
            currentUser = currentUser.getNext()
            
         else:
            currentUser = currentUser.getNext()
          
   def deleteFriends(self,friend1,friend2): # breaks apart the friendship of two users by removing them from each others list 
      currentUser = self.head
 
      while currentUser != None:
         if currentUser.getData().name == friend1: # will delete friend2 from friend1's list
            currentUser.getData().removeFriend(friend2)
            currentUser = currentUser.getNext()
            
         elif currentUser.getData().name == friend2 : # will delete friend1 from friend2's list
            currentUser.getData().removeFriend(friend1)
            currentUser = currentUser.getNext()
            
         else:
            currentUser = currentUser.getNext()   
   def remove (self,item):
      current = self.head
      previous = None
      found = False

      while not found:
         if current.getData() == item:
            found = True
         else:
            previous = current
            current = current.getNext()

      if previous == None:
         self.head = current.getNext()
      else:
         previous.setNext(current.getNext() )   
         
         
         
         
class User(): 
   
   def __init__(self,name):
      self.name=name
      self.friends=UnorderedList()    
          
   def __str__(self):
      return str(self.name)
   
   def addFriend(self,friend):
      self.friends.add(friend)    
   def removeFriend(self,friend):
      self.friends.remove(friend)   
      
      
def main():
   with open('FriendData.txt','r') as FriendFile :
      fPeople=UnorderedList()
      for line in FriendFile:
         fCommand=line.split()# splits all the words  so we can separate them into a list 
                              # which we use for the commands
                              
         if fCommand[0]=='Person':#person command that creates a new user
            if fPeople.searchUser(fCommand[1]):
               print("A person with the name " + str(fCommand[1])+" already exists.")
               
            else:
               account=User(fCommand[1])  
               fPeople.add(account)
               print(str(fCommand[1])+" now has an account.")    
            
              
         
         elif fCommand[0]=='Friend': # the friend command that puts people in each others friends lists 
            
            if fPeople.searchUser(fCommand[1]) and fPeople.searchUser(fCommand[2]):  # checks to see if both users exist
               fList1=fPeople.userFriends(fCommand[1]) # two lists with the respective friendlists of the users
               fList2=fPeople.userFriends(fCommand[2])
               
               
               if (fCommand[1]==fCommand[2]): #checks to see if they aren't friending themselves
                  print("A person cannot friend him/herself.")
                  
               elif (not fList1.isEmpty() and not fList2.isEmpty()) and(fList1.searchFriend(fCommand[2]) and fList2.searchFriend(fCommand[1])): #checks to see if the users are already friends 
                  print(str(fCommand[1]) + " and " + str(fCommand[2])+" are already friends.")
                  
               else: # makes both the users add each other to their friend list 
                  fPeople.newFriends(fCommand[1],fCommand[2])
                  print(str(fCommand[1])+" and "+str(fCommand[2]) +" are now friends.")       
            
            else:# will check to see who the invalid users are then print out the ones who don't have an account
               
               if not fPeople.searchUser(fCommand[1]):
                  print("A person with the name "  + str(fCommand[1])  +" does not currently exist.")
                  
               if not fPeople.searchUser(fCommand[2]):
                  print("A person with the name "  + str(fCommand[2])  +" does not currently exist.")
                  
         elif fCommand[0]=='List':  #prints a list of the desired users friends
            
              list1=fPeople.userFriends(fCommand[1]) # a variable that stores the friendlist of the current user
              if not fPeople.searchUser(fCommand[1]): #checks to see if the user exists
                 print("A person with the name "  + str(fCommand[1])  +" does not currently exist.")
                
              elif list1.isEmpty():   
                 print(str(fCommand[1])+" has no friends.")
              else: #prints the list 
                print("[  "+str(fPeople.userFriends(fCommand[1]))+"]")
         
         elif fCommand[0]=='Unfriend': #unfriends respective users
            if fPeople.searchUser(fCommand[1]) and fPeople.searchUser(fCommand[2]):  # checks to see if both users exist
               fList1=fPeople.userFriends(fCommand[1]) # two lists with the respective friendlists of the users
               fList2=fPeople.userFriends(fCommand[2])
               
               if(fCommand[1]==fCommand[2]): #checks to see if a person tries to unfriend themselves
                  print("A person cannot unfriend him/herself.")
                  
               elif not fList1.searchFriend(fCommand[2]): #checks to see if the users are friends 
                  print(str(fCommand[1]) + " and " + str(fCommand[2])+" aren't friends, so you can't unfriend them.")
               
               else:
                 fPeople.deleteFriends(fCommand[1],fCommand[2])
                  
                 print(str(fCommand[1])+" and "+str(fCommand[2]) +" are no longer friends.")     
            
            
            else:# will check to see who the invalid users are then print out the ones who don't have an account
               
               if not fPeople.searchUser(fCommand[1]):
                  print("A person with the name "  + str(fCommand[1])  +" does not currently exist.")
                  
               if not fPeople.searchUser(fCommand[2]):
                  print("A person with the name "  + str(fCommand[2])  +" does not currently exist.")   
               
            
            
            
                    
         elif fCommand[0]=='Query': #checks to see if the selected users are friends 
              fList1=fPeople.userFriends(fCommand[1]) # two lists with the respective friendlists of the users
              fList2=fPeople.userFriends(fCommand[2])
              if fPeople.searchUser(fCommand[1]) and fPeople.searchUser(fCommand[2]):# checks to see if both users exist\
                 if (not fList1.isEmpty() and not fList2.isEmpty()) and(fList1.searchFriend(fCommand[2]) and fList2.searchFriend(fCommand[1])): #checks to see if the users are  friends 
                  print(str(fCommand[1]) + " and " + str(fCommand[2])+" are friends.")# will check to see who the invalid users are then print out the ones who don't have an account
                 
                 else:
                  print(str(fCommand[1]) + " and " + str(fCommand[2])+" are not friends.")   
              
              else:
                  if not fPeople.searchUser(fCommand[1]):
                     print("A person with the name "  + str(fCommand[1])  +" does not currently exist.")
                  
                  if not fPeople.searchUser(fCommand[2]):
                     print("A person with the name "  + str(fCommand[2])  +" does not currently exist.")
                    
                           
         elif fCommand[0]=='Exit': # checks to see if we are exiting the program       
            print("Exiting...")                                           
            break #stops the loop upon wishing to exit the program
main()