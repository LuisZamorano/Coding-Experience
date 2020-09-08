 
#  File: MultiwayTree.py
#  Description: A program that 
#  Student's Name: Luis Zamorano    
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: December 7, 2017 
#  Date Last Modified: december 10, 2017(2dayslate)
class MultiwayTree:
      
         def __init__(self,pyTree): # given "pyTree", a Python representation of a tree, 
            self.root=pyTree[0]
            self.left=pyTree[1]
            self.right=pyTree[2]
            self.rBranch=0
            self.lBranch=0 #will help us determine the count to see if the trees are isomorphic
            self.pyTree=pyTree
            self.len=len(pyTree)
            
         def isIsomorphicTo(self,other): # return True if the tree "self" has the same structure as the tree "other", "False" otherwise.
            return None
         
         
def preOrder(content): # print out the node-and-pointer representation of a tree using preorder.
          if content != []:
             i=0
             while i<(len(content)):
                print(content[i],end=" ")
                i+=1
            
def getRootVal(root):
            return root[0]

def setRootVal(root, newVal):
   root[0] = newVal

def getLeftChild(root):
   return root[1]

def getRightChild(root):
   return root[2]   
         
def BinaryTree(initdata):
   return [ initdata, [], [] ]


def insertLeft(root,newBranch):
   t = root.pop(1)                       # temporarily break the tree   
   if len(t) > 1:                        # if something already
      root.insert(1,[newBranch,t,[] ] )  # there, push it down as
   else:                                 # the new left child
      root.insert(1,[newBranch,[],[] ] )

def insertRight(root,newBranch):
   t = root.pop(2)
   if len(t) > 1:                        # if something already
      root.insert(2,[newBranch,[],t ] )  # there, push it down as
   else:                                 # the new right child
      root.insert(2,[newBranch,[],[] ] )
         

           
def main():
      #simple values to keep track of the tree we are on
      treeA=1
      treeB=2
      with open('MultiwayTreeInput.txt','r') as treesF :
       for line in treesF: 
         
         firstL=line
         #we get the root
         root=""
         for c in firstL:
            if c!=",":
               root+=c
            else:
               root=root[1:]
               break 
         print(root)
         leftB=0 #keeps track of number of branches
         rightB=0
         commaC=0#num of commas
         quoteC=str(list(range(0, 11))) # will cover for list numbers 
         content=""
         treeContent=[]
         bracketC=[] # left and right will be
         i=len(root)+2
         for c in firstL[len(root)+2:-2]:
             
            if c =="[":
               leftB+=1
            elif c=="]":   
               rightB+=1
            elif c==",":
               commaC+=1
            elif c=="\"":
               content+=c
               if len(content)>=3:
                  bracketC.append(leftB)
                  treeContent.append(content)
                  content="" 
            elif c!=" ":
               content+=c
            if c in quoteC and (c!="," and c!=" " and c!="]" and c!="["): # used for numbers in the given lists 
               next=firstL[i+1] # to see if its a two digit number
               temp=c 
               if next!="," and next!=" " and next!="]" and next!="[":  
                  temp=c+next
               
               treeContent.append(temp)
               content=""
               
               
            i+=1             
         treeContent.insert(0,root)     
         #checks if there is something more than just the root
         
         myTree=BinaryTree(root)
         multiWayTreeA=MultiwayTree(myTree)
         print("Tree "+str(treeA)+":  ",end="")
         print(firstL)
         print("Tree "+str(treeA)+" preorder:  ",end="")
         preOrder(treeContent)
         print("\n")
         
         firstL2=treesF.readline()
         #we get the root
         root2=""
         for ch in firstL2:
            if ch==",":
               root2+=ch
            else:
               root2=root2[1:]
               break 
         leftB2=0 #keeps track of number of branches
         rightB2=0
         commaC2=0#num of commas
         quoteC2=str(list(range(0, 11))) # will cover for list numbers 
         content2=""
         treeContent2=[]
         bracketC2=[] # left and right will be
         i2=len(root2)+2
         for c in firstL2[len(root)+3:-2]:
             
            if c =="[":
               leftB2+=1
            elif c=="]":   
               rightB2+=1
            elif c==",":
               commaC2+=1
            elif c=="\"":
               content2+=c
               if len(content2)>=3:
                  bracketC2.append(leftB2)
                  treeContent2.append(content2)
                  content2="" 
            elif c!=" ":
               content2+=c
            if c in quoteC2 and (c!="," and c!=" " and c!="]" and c!="["): # used for numbers in the given lists 
               next=firstL2[i2+1] # to see if its a two digit number
               temp=c 
               if next!="," and next!=" " and next!="]" and next!="[":  
                  temp=c+next
               
               treeContent2.append(temp)
               content2=""
               
               
            i2+=1
            
         treeContent2.insert(0,root2)     
         #checks if there is something more than just the root
         
         myTree2=BinaryTree(root2)
         multiWayTreeB=MultiwayTree(myTree2)
         print("Tree "+str(treeB)+":  ",end="")
         print(firstL2)
         print("Tree "+str(treeB)+" preorder:  ",end="")
         preOrder(treeContent2)
         print("\n")
         
         
         treeA+=2
         treeB+=2
      
         #.preorder
         
main()