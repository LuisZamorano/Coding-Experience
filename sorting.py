#  File: sorting.py
#  Description: A program that allows us to check the time it takes for certain sorting algorithms to execute
#  Student's Name: Luis Zamorano    
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: November 30, 2017 
#  Date Last Modified: December, 2017
import random
import time
import sys
sys.setrecursionlimit(10000)




def bubbleSort(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i] > alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp


def insertionSort(alist):
    for index in range(1,len(alist)):
        currentvalue = alist[index]
        position = index

        while position>0 and alist[position-1]>currentvalue:
            alist[position] = alist[position-1]
            position = position-1

        alist[position] = currentvalue


def mergeSort(alist):
    if len(alist) > 1:
        mid = len(alist) // 2
        lefthalf = alist[:mid]
        righthalf = alist[mid:]

        mergeSort(lefthalf)
        mergeSort(righthalf)

        i = 0
        j = 0
        k = 0

        while i<len(lefthalf) and j<len(righthalf):
            if lefthalf[i] < righthalf[j]:
                alist[k] = lefthalf[i]
                i += 1
            else:
                alist[k] = righthalf[j]
                j += 1
            k += 1

        while i < len(lefthalf):
            alist[k] = lefthalf[i]
            i += 1
            k += 1

        while j < len(righthalf):
            alist[k] = righthalf[j]
            j += 1
            k += 1


def quickSort(alist):
    quickSortHelper(alist,0,len(alist)-1)

def quickSortHelper(alist,first,last):
    if first < last:
        splitpoint = partition(alist,first,last)
        quickSortHelper(alist,first,splitpoint-1)
        quickSortHelper(alist,splitpoint+1,last)

def partition(alist,first,last):
    pivotvalue = alist[first]
    leftmark = first + 1
    rightmark = last
    done = False

    while not done:

        while leftmark <= rightmark and alist[leftmark] <= pivotvalue:
            leftmark += 1

        while alist[rightmark] >= pivotvalue and rightmark >= leftmark:
            rightmark -= 1

        if rightmark < leftmark:
            done = True
        else:
            temp = alist[leftmark]
            alist[leftmark] = alist[rightmark]
            alist[rightmark] = temp

    temp = alist[first]
    alist[first] = alist[rightmark]
    alist[rightmark] = temp

    return rightmark
 
 #function we will use to time all the bubble algorithms
def timeBubble(list10,list100,list1k):
   
         
         j=0#control variable for outer loop
         timeAvg=0.0 #we will add the times to avg out for the bubble sort
         avgsList=[]
         
         while j<3:
            if j==0:
               currentList=list10.copy()
            elif j==1:
               currentList=list100.copy()
            elif j==2:
               currentList=list1k.copy()
                  
            for i in range(5):
               startTime = time.time()
               # block of code to time here
               bubbleSort(currentList)
               endTime = time.time()
               elapsedTime = endTime - startTime
               timeAvg+=elapsedTime
            timeAvg=timeAvg/5.0 #we divide the function in order to get the average of the time  
            avgsList.append(timeAvg)   
            timeAvg=0 #resets the time 
            j+=1  
         space1="        "#spacing if 0 num
         space2="                "#spacing for the second num subject to change 
         space3="                        "
         if avgsList[0]>0.0:
            space2=" "   
         if avgsList[1]>0.0:
            space3="     "
  
         print("      bubbleSort" +space1+ str(avgsList[0]) + space2 +str(avgsList[1]) + space3 +str(avgsList[2]))    
         
         

 #function that helps us time the insertion sort list algorithm
def timeInsertSort(list10,list100,list1k):
   
         
         j=0#control variable for outer loop
         timeAvg=0.0 #we will add the times to avg out for the bubble sort
         avgsList=[]
         
         while j<3:
            if j==0:
               currentList=list10.copy()
            elif j==1:
               currentList=list100.copy()
            elif j==2:
               currentList=list1k.copy()
                  
            for i in range(5):
               startTime = time.time()
               # block of code to time here
               insertionSort(currentList)
               endTime = time.time()
               elapsedTime = endTime - startTime
               timeAvg+=elapsedTime
            timeAvg=timeAvg/5.0 #we divide the function in order to get the average of the time  
            avgsList.append(timeAvg)   
            timeAvg=0 #resets the time 
            j+=1  
         space1="        "#spacing if 0 num
         space2="                "#spacing for the second num
         space3="                        "
         if avgsList[0]>0.0:
            space2=" "   
         if avgsList[1]>0.0:
            space3="     "


         print("   insertionSort" +space1+ str(avgsList[0]) + space2 +str(avgsList[1]) +space3+str(avgsList[2]))    
         
         
 #function that helps us time the mergeSort list algorithm
def timeMergeSort(list10,list100,list1k):
   
         
         j=0#control variable for outer loop
         timeAvg=0.0 #we will add the times to avg out for the bubble sort
         avgsList=[]
         
         while j<3:
            if j==0:
               currentList=list10.copy()
            elif j==1:
               currentList=list100.copy()
            elif j==2:
               currentList=list1k.copy()
                  
            for i in range(5):
               startTime = time.time()
               # block of code to time here
               mergeSort(currentList)
               endTime = time.time()
               elapsedTime = endTime - startTime
               timeAvg+=elapsedTime
            timeAvg=timeAvg/5.0 #we divide the function in order to get the average of the time  
            avgsList.append(timeAvg)   
            timeAvg=0 #resets the time 
            j+=1  
         space1="        "#spacing if 0 num
         space2="                "#spacing for the second num
         space3="                       "
         if avgsList[0]>0.0:
            space2=" "   
         if avgsList[1]>0.0:
            space3="     "
         print("       mergeSort" +space1+ str(avgsList[0]) + space2 +str(avgsList[1]) +space3+str(avgsList[2]))    
         
         
#function that will help us time quickSort        
def timeQuickSort(list10,list100,list1k):
   
         
         j=0#control variable for outer loop
         timeAvg=0.0 #we will add the times to avg out for the bubble sort
         avgsList=[]
         
         while j<3:
            if j==0:
               currentList=list10.copy()
            elif j==1:
               currentList=list100.copy()
            elif j==2:
               currentList=list1k.copy()
                  
            for i in range(5):
               startTime = time.time()
               # block of code to time here
               quickSort(currentList)
               endTime = time.time()
               elapsedTime = endTime - startTime
               timeAvg+=elapsedTime
            timeAvg=timeAvg/5.0 #we divide the function in order to get the average of the time  
            avgsList.append(timeAvg)   
            timeAvg=0 #resets the time 
            j+=1  
         space1="        "#spacing if 0 num
         space2="                "#spacing for the second num
         space3="                        "
         if avgsList[0]>0.0:
            space2=" "   
         if avgsList[1]>0.0:
            space3="     "

         print("       quickSort" +space1+ str(avgsList[0]) + space2 +str(avgsList[1]) +space3+str(avgsList[2]))   
         
# a special function used to randomly swap elements of a list
def swapRandom(listToSwap):
    swappedList=listToSwap.copy()
    i=0#keeps track of the loop
    randl=[]
    while i<(len(swappedList)/10):
       randomIndex1 = random.randint(0,len(swappedList)-1) # gives us a random index of a number
       randomIndex2 = random.randint(0,len(swappedList)-1)
       randl.append(randomIndex1)
       randl.append(randomIndex2)
       
       # we store in temp values the number of the randomly selected indexes
       swap1=swappedList[randomIndex1]
       swap2=swappedList[randomIndex2]
       
       # we swap the numbers in the randomly selected indexes with each other
       swappedList[randomIndex1]=swap2
       swappedList[randomIndex2]=swap1   
       i+=1  
    return swappedList   
             
#main program
def main():
      #these are main variables and functions we will use to time all the different types of algorithms
      #creates presorted lists of 10 , 100,1000
      list10=list(range(1,11)) 
      list100=list(range(1,101))
      list1k=list(range(1,1001))
      
      #we make a sort variable so we can freely change it
      
      # base strings for the headers of the functions
      headerR= "Input type = " + "Random" +"\n                      avg time                      avg time                     avg time\n"\
               +"   Sort function       (n=10)                       (n=100)                      (n=1000)\n"\
               +"-----------------------------------------------------------------------------------------------------"
               
      #------------------------------------------------
      #random list section
      #the random lists for 10,100 and 1000
      
      random10=list10.copy()
      random100=list100.copy()
      random1k=list1k.copy()
      #randomizes all the lists
      random.shuffle(random10)
      random.shuffle(random100)
      random.shuffle(random1k)
      print(headerR)
      # the timing for all the algorithms
      timeBubble(random10,random100,random1k)
      timeInsertSort(random10, random100, random1k)
      timeMergeSort(random10, random100, random1k)
      timeQuickSort(random10, random100, random1k)
      
      #---------------------------------------------------------
      #Sorted list section
      # we will used the original lists as they are already sorted
      headerS= "\n\nInput type = " + "Sorted" +"\n                      avg time                      avg time                     avg time\n"\
               +"   Sort function       (n=10)                       (n=100)                      (n=1000)\n"\
               +"-----------------------------------------------------------------------------------------------------"
            
      print(headerS)
      #we execute to see how long it will take to sort an already sorted list
      timeBubble(list10, list100, list1k)
      timeInsertSort(list10, list100, list1k)
      timeMergeSort(list10, list100, list1k)
      timeQuickSort(list10, list100, list1k)  
      
      #----------------------------------------------
      #Reversed list section
      # we will use a reversed version of the original lists
      headerRev= "\n\nInput type = " + "Reversed" +"\n                      avg time                      avg time                     avg time\n"\
               +"   Sort function       (n=10)                       (n=100)                      (n=1000)\n"\
               +"-----------------------------------------------------------------------------------------------------"
     # we make copys of the original list so the already sorted list won't be altered
      reversed10=list10.copy()
      reversed100=list100.copy()
      reversed1k=list1k.copy()
      # we now reverse said copies
      reversed10.reverse()
      reversed100.reverse()
      reversed1k.reverse()
      print(headerRev)
      #execute the functions to time how long it takes for a reversed sorted list to be sorted again
      timeBubble(reversed10, reversed100, reversed1k)
      timeInsertSort(reversed10, reversed100, reversed1k)
      timeMergeSort(reversed10, reversed100, reversed1k)
      timeQuickSort(reversed10, reversed100, reversed1k)
      
      #--------------------------------
      #Almost sorted list section
      headerAlmost= "\n\nInput type = " + "Almost Sorted" +"\n                      avg time                      avg time                     avg time\n"\
               +"   Sort function       (n=10)                       (n=100)                      (n=1000)\n"\
               +"-----------------------------------------------------------------------------------------------------"
      # we will alter a sorted list by randomizing some of the values by swapping pairs in it by a 10% base, ie: 10 integers we swap 1 pair, 100 integers we swap 10 pairs etc etc
      almostSort10=list10.copy()
      almostSort100=list100.copy()
      almostSort1k=list1k.copy()
      
      # we change our almost sorted lists by using our special function to randomly swap n pairs depending on the list
      almostSort10=swapRandom(almostSort10)
      almostSort100=swapRandom(almostSort100)
      almostSort1k=swapRandom(almostSort1k)
      
      #printed times of algorithms
      print(headerAlmost)
      timeBubble(almostSort10,almostSort100, almostSort1k)
      timeInsertSort(almostSort10,almostSort100, almostSort1k)
      timeMergeSort(almostSort10, almostSort100, almostSort1k)
      timeQuickSort(almostSort10, almostSort100, almostSort1k)
      
main() 