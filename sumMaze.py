
#  File: sumMaze.py
#  Description: A program that allows us to solve mazes using recursive depth-first search
#  Student's Name: Luis Zamorano    
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: November 17, 2017 
#  Date Last Modified: November 19, 2017(2 days late)

class State():
   
   def __init__(self,currentGrid,history,startRow,startColumn,currentSum,firstL):
      
      self.grid=currentGrid
      self.history=history
      self.startR=startRow
      self.startC=startColumn
      self.currentS=currentSum
      #values for the needed grid funcitions that are stable and won't change are down below!
      #
      self.firstLine=firstL # the line that contains the important information
      self.goalSum=int(firstL[0])
      self.gridRows=int(firstL[1])  
      self.gridCols=int(firstL[2])  
      self.endRow=int(firstL[5])
      self.endCol=int(firstL[6])
      
   def __str__(self):
      stateStr="Grid: \n"
      y=0
      x=0
      for x in range (len(self.grid)):
         stateStr+="   " 
         for y in range (len(self.grid[x])): # orders it neatly for printing and accounts for spacing based on size of number
            space="" # will give appropriate spacing to the numbers 
            if (len(str(self.grid[x][y]))>2):
               space+="  "
            elif(len(str(self.grid[x][y]))>1):
               space+="   "
            else:
               space+="    "
            stateStr+=str(self.grid[x][y])+space      
         stateStr+="\n"     
      stateStr+="history: "+str(self.history)+"\nStartPoint: "+"("+str(self.startR)+","+str(self.startC)+")" +\
                 "\nSum so far: "+str(self.currentS)  # appends the rest of the needed information for the string
         
      return stateStr       
   def goalState(self):
      goal=False
      if (self.startR==self.endRow)and(self.startC==self.endCol) and (self.currentS==self.goalSum): #checks to see if the condition is met for finding the maze
         goal=True      
      return goal
   
def isValidMove(currentGrid,gridSize,proposedRow,proposedCol,direction):
      valid=False
      gridSide=gridSize**(1/2)# gives us what one side would be
      
      print("Can I move "+ direction+"?")
      if (proposedRow <gridSide and gridSide>-1) and (proposedCol<gridSide and gridSide>-1)and(currentGrid[proposedRow][proposedCol]!="X"): #checks to make sure we arent going out of bound
            valid=True
            print("Yes.")
      else:
         print("No.")      
      return valid
def solve(thisState):
    
#    # this will recursively solve a maze represented by thisState 
   print("Is this a goal state?")
   if thisState.goalState():
      print("Yes!\nSolution found!")
      return thisState.history
   
   if not thisState.goalState():
      print("No")
      if thisState.currentS>thisState.goalSum:
         print("Target exceeded: abandoning path")
         return None
         
      else:
         # CHECKS IF MOVING TO THE RIGHT IS VALID
       if isValidMove(thisState.grid,thisState.gridRows*thisState.gridCols,thisState.startR,thisState.startC+1,"RIGHT"):
#          create a new State 
           newState=State(thisState.grid,thisState.history,thisState.startR,thisState.startC+1,thisState.currentS,thisState.firstLine)     

           newPosition=newState.grid[newState.startR][newState.startC] #we will use the value of the position multiple times before changing it so we must
           #copy of the grid
           newState.history.append(newPosition)#appends the new location to the state history
           newState.currentS+=newPosition   #updates the sum  
   #          changes the current position in the grid to a "X"
           newState.grid[newState.startR][newState.startC] ="X"
           print (newState)
           result = solve(newState)
           if result != None:
                return newState.history
           else:
                newState.grid[newState.startR][newState.startC] =newPosition
                newState.history.pop()
       # CHECKS IF MOVING UP IS VALID      
       if isValidMove(thisState.grid,thisState.gridRows*thisState.gridCols,thisState.startR-1,thisState.startC,"UP"):
#          create a new State
            newState=State(thisState.grid,thisState.history,thisState.startR-1,thisState.startC,thisState.currentS,thisState.firstLine)     
#            set the grid = a copy of the old grid# 
           
            newPosition=newState.grid[newState.startR][newState.startC] #we will use the value of the position multiple times before changing it so we must
           
            newState.history.append(newPosition)#appends the new location to the state history
            newState.currentS+=newPosition   #updates the sum  
    #          changes the current position in the grid to a "X"
            newState.grid[newState.startR][newState.startC] ="X"
            print (newState)
            result = solve(newState)
            if result != None:
               return newState.history
            else:
                newState.grid[newState.startR][newState.startC] =newPosition
                newState.history.pop()
        # CHECKS IF MOVING DOWN IS VALID      
       if isValidMove(thisState.grid,thisState.gridRows*thisState.gridCols,thisState.startR+1,thisState.startC,"DOWN"):
#          create a new State
            newState=State(thisState.grid,thisState.history,thisState.startR+1,thisState.startC,thisState.currentS,thisState.firstLine)     
#            set the grid = a copy of the old grid# 
        
            newPosition=newState.grid[newState.startR][newState.startC] #we will use the value of the position multiple times before changing it so we must
           
            newState.history.append(newPosition)#appends the new location to the state history
            newState.currentS+=newPosition   #updates the sum  
    #          changes the current position in the grid to a "X"
            newState.grid[newState.startR][newState.startC] ="X"
            print (newState)
            result = solve(newState)
            if result != None:
               return newState.history    
            else:
                newState.grid[newState.startR][newState.startC] =newPosition
                newState.history.pop()
         # CHECKS IF MOVING TO THE LEFT IS VALID
       if isValidMove(thisState.grid,thisState.gridRows*thisState.gridCols,thisState.startR,thisState.startC-1,"LEFT"):
#          create a new State 
           newState=State(thisState.grid,thisState.history,thisState.startR,thisState.startC-1,thisState.currentS,thisState.firstLine)     
#            set the grid = a copy of the old grid# 
           newPosition=newState.grid[newState.startR][newState.startC] #we will use the value of the position multiple times before changing it so we must
           
           newState.history.append(newPosition)#appends the new location to the state history
           newState.currentS+=newPosition   #updates the sum  
   #          changes the current position in the grid to a "X"
           newState.grid[newState.startR][newState.startC] ="X"
           print (newState)
           result = solve(newState)
           if result != None:
                return newState.history
           else:
                newState.grid[newState.startR][newState.startC] =newPosition
                newState.history.pop()
       print("Couldn't move in any direction.Backtracking.")
       return None


def main():
   
   
   with open('mazedata1.txt','r') as maze1 :
      
      firstL=maze1.readline().split()# splits the first line into a list of strings that we will alter convert to ints 
      #the following are the values of the file
      
      targetValue=int(firstL[0]) #the target sum
      grid_rows=int(firstL[1])  #the number of rows in the grid
      grid_cols=int(firstL[2])  #the number of columns in the grid
      start_row=int(firstL[3])  #the row number of the start point
      start_col=int(firstL[4])  #the column number of the start point
      end_row=int(firstL[5])  #the row number of the end point
      end_col=int(firstL[6])  #the column number of end point
      
      mazeRow=0
      mazeL=[]
      history=[]
      currentSum=0
      for line in maze1:
         col=0
         rowL=[]
         line=line.split()
         for item in line[:]:
            if col==start_col and mazeRow==start_row:
               rowL.append("X")
               history.append(int(item))
               currentSum+=int(item)
            else:
               rowL.append(int(item))   
            col+=1      
         mazeRow+=1
         mazeL.append(rowL)  
         
   # set up start state
   thisState = State(mazeL,history,start_row,start_col,currentSum,firstL)
   print(thisState)

 
   result = solve(thisState)    # result will be None or the goal state's history
 
   if result == None:
      print("No solution exists")
   else:
      print("The solution is: ",result)

main()
