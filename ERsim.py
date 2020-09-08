#  File: ERsim.py
#  Description: A python based computer program that simulates the way queues would operate in an emergency room   
#  Student's Name: Luis Zamorano
#  Student's UT EID: ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#  Date Created: October 19th 2017
#  Date Last Modified: October 20th 2017



class Queue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0,item)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)
     
    def __str__(self):
       return str(self.items) 


def main():

   criticalCon=Queue()
   seriousCon=Queue()
   fairCon=Queue()
   with open('ERsim.txt','r') as ERFile :
      
      for line in ERFile:
         queueR=line.split()# splits all the words  so we can separate them into a list 
                              # which we use for the names, conditions etc
                              
         if 'add'== queueR[0]:#checks for add command      
                               
            if 'Critical' == queueR[1]:
               pName=queueR[2]  #gets the patient name 
               criticalCon.enqueue(pName)
            if 'Serious' == queueR[1]:
               pName=queueR[2] 
               seriousCon.enqueue(pName)
            elif 'Fair' == queueR[1]:   
               pName=queueR[2]
               fairCon.enqueue(pName)
               
            print("Command: Add patient " + pName + " to "+ str(queueR[1]) +" queue")
            print("Queues are:\nFair:     "+str(fairCon)+"\nSerious:  " +str(seriousCon)+"\nCritical: "+str(criticalCon)+"\n")
            
         elif 'treat' and 'next'in queueR:  
            patientN="" #sets the patient name (that also gets dequeued
            qType=""    #sets the queue type 
            pN=True     # used so we won't print out queue information if we no longer have patients 
            print("Command: Treat next patient")
            
            if  not criticalCon.isEmpty():# makes sure to check each queue based on condition in order to treat critical and downwards checks if queue is empty or not
               qType="Critical"
               patientN=str(criticalCon.dequeue()) 
               
            elif not seriousCon.isEmpty(): 
               qType="Serious"   
               patientN=seriousCon.dequeue()
               
            elif not fairCon.isEmpty():
               qType="Fair"
               patientN=fairCon.dequeue() 
            else:
                pN=False # sets pN to false
               
            if pN==True:   # when we have a patient 
                print("Treating " + patientN + " from "+ qType  +" queue")
                print("Queues are:\nFair:     "+str(fairCon)+"\nSerious:  " +str(seriousCon)+"\nCritical: "+str(criticalCon)+"\n")    
            
            else:# when we have no patients 
                print("Treat next patient on Critical queue")
                print("No patients in queues\n")
                
         elif 'treat' in queueR and ('Critical' or 'Serious' or 'Fair' in queueR)and 'all'not in queueR: # checks the condition of patient to be treated if specified
        
            if queueR[1]=='Critical': #treats if critical
               patientN=criticalCon.dequeue()
                
            elif queueR[1]=='Serious': #treats if serious
               patientN=seriousCon.dequeue()   
           
            elif queueR[1]=='Fair':   
               patientN=fairCon.dequeue()  
            else:
               print("Command: Treat next patient on Critical queue")   
               print("No patients in qeueu\n")
    
            ##The information about what patient got treated etc 
            print("Command: Treat next patient on " + queueR[1]+" queue")    
            print("Treating " + patientN + " from "+ str(queueR[1])  +" queue")
            print("Queues are:\nFair:     "+str(fairCon)+"\nSerious:  " +str(seriousCon)+"\nCritical: "+str(criticalCon)+"\n")#prints updated queue 
         
         elif 'treat' in queueR and 'all' in queueR: # treat all command 
             
             qSize= criticalCon.size()+seriousCon.size()+fairCon.size() # size of all the elements
             i=0 # used in the while loop
             print("Command: Treat all patients")
             
             while True:
               if  not criticalCon.isEmpty():# makes sure to check each queue based on condition in order to treat critical and downwards checks if queue is empty or not
                     qType="Critical"
                     patientN=str(criticalCon.dequeue()) 
                     print("Treating " + patientN + " from "+ qType  +" queue")
               
               elif not seriousCon.isEmpty(): 
                   qType="Serious"   
                   patientN=seriousCon.dequeue()
                   print("Treating " + patientN + " from "+ qType  +" queue") 
               
               elif not fairCon.isEmpty():
                   qType="Fair"
                   patientN=fairCon.dequeue() 
                   print("Treating " + patientN + " from "+ qType  +" queue")
                   
               else:
                   print("No patients in queues")
                   break
               print("Queues are:\nFair:     "+str(fairCon)+"\nSerious:  " +str(seriousCon)+"\nCritical: "+str(criticalCon)+"\n")
            
              
         else: #exit command printing
            print("Command: Exit")   
main()     