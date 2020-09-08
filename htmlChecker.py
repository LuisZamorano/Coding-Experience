#  File: htmlChecker.py
#  Description: A program that allows us to check valid and invalid  tags in an html txt document
#               as well as create lists of the ones that dont have proper pairing.
#  Student's Name: Luis Zamorano    
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: Oct. 12 2017 
#  Date Last Modified: Oct. 15 2017 (LATE 2 days)


class Stack (object):
   def __init__(self):
      self.items = [ ]

   def isEmpty (self):
      return self.items == [ ]

   def push (self, item):
      self.items.append (item)

   def pop (self):
      return self.items.pop ()

   def peek (self):
      return self.items [len(self.items)-1]

   def size (self):
      return len(self.items)

   def __str__ (self):
      return str(self.items)
 


def htmlChecker(htmlCode): # meat and bones of the program the htmlChecker method
    stacking = Stack() # the stack that will help check if the tags are correctly matched 
    VALIDTAGS=[] # the list of tags that are valid 
    EXCEPTIONS=['br','meta','hr'] # the exceptions list  for tags that dont need matching
                                    # 'hr' was the plot twist tag that requires no end as well 
    i=0 # used for while loop
    while  i < len(htmlCode):
        currentTag=htmlCode[i]
        if currentTag in EXCEPTIONS: # we first check to see if the stack is an exception
            print("Tag " + currentTag+ " does not need to match:  stack is still  " +str(stacking))
        elif "/" not in currentTag:
            stacking.push(currentTag)
            print("Tag " + currentTag+ " pushed:  stack is now: " + str(stacking))
            
        elif "/" in currentTag: 
            cTagCopy=currentTag[1:10] # the rest of the string without the backslash
            stackTop= stacking.pop() # gives us the item in the top of stack
            if cTagCopy==stackTop:
                print("Tag " + currentTag + " matches top of stack:   stack is now " + str(stacking))
                if(cTagCopy not in VALIDTAGS):
                  print("New tag "+ cTagCopy +" found and added to list of valid tags")
                  VALIDTAGS.append(cTagCopy)  
                
            else: # will print out an error if the stacks are incorrectly matched ie: /h with a /t, etc. 
                print("Error:  tag is " + currentTag + " but top of stack is " + str(stackTop))
                break
            
        
        i+=1
         
  
    if stacking.isEmpty(): # condition for no tag mismatches 
        print("\nProcessing complete.  No mismatches found.")

    elif not stacking.isEmpty():
        print("\nProcessing complete.  Unmatched tags remain on stack: " + str(stacking))   

    print("\nThese are the tags that don't need matching " +str(EXCEPTIONS))
    print("These are the VALIDTAGS for the htmlCode for the webpage " + str(VALIDTAGS))        
def main():
    ## the initial sequence gets the list of tags in the document 
      with open('htmlfile.txt','r') as htmlFile :
         htmlStr=""
         tagList=[]
         while True:
            c = htmlFile.read(1)  # c is the character 
            if c=='<':
            
               while True:
                  tag=htmlFile.read(1)
               
                  if tag=='>' or tag==' ':
                     tagList.append(htmlStr)
                     htmlStr=""
                     break 
                  else:
                     htmlStr+=tag
            if not c:
               print ("End of file")
               break
      #previous code was for getting a list of the      
      print("This is my tagList: " + str(tagList)+"\n")
      htmlChecker(tagList)  
       
         
         
main()