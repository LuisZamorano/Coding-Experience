#  File: RPG.py
#  Description: An RPG game simulation
#  Student's Name:Luis Zamorano
#  Student's UT EID:ljz238
#  Course Name: CS 313E 
#  Unique Number: 51465
#
#  Date Created: 9/22/2017
#  Date Last Modified: 9/23/2017


class Weapon(object):
    

    def __init__(self, name):
      self.name=name
     
    def damage(self):  #returns the value of damage depending on the type of weapon
        if self.name=="dagger":
          return(4)
        elif self.name=="axe":
          return(6)
        elif self.name=="staff":
          return(6)
        elif self.name=="sword":
          return(10)
        else:return(1)
           
class Armor(object):        
    def __init__(self,name):
      self.name=name
      
    def armorClass(self):  # returns the armor rating of the mail type 
        if self.name=="plate":
          return(2)
        elif self.name=="chain":
          return(5)
        elif self.name=="leather":
          return(8)
        else:
          return(10)
      
class RPGCharacter(object):#the superclass for the RPG characters in the game 
    hp=40#default max HP 
    armor=Armor("none")#default characters will not wear armor
    weapon=Weapon("none")#default characters have no weapons equipped 
    arch="Fighter" # the type of character setting to default for warrior
    spellPoints=0
    def __init__(self,name):
      self.name=name
      
    def putOnArmor(self,mail):#general armor equipping
      self.armor=mail
      print(self.name+" is now wearing "+str(self.armor.name)) 
     
      
    def takeOffArmor(self): #function that takes armor off 
      self.armor=Armor("none")
      print(self.name + " is no longer wearing anything") 

    def wield(self,equip):#function that makes a character wield a weapon
      self.weapon= equip
      print(self.name+ " is now wielding a(n) " + str(self.weapon.name) )
    
    def unWield(self):  #function that unequip a weapon to the character
      self.weapon= Weapon("none")
      print(self.name + " is no longer wielding anything")
      
    def checkForDefeat(self):#function that checks if a character is defeated based on their hp 
     
      if self.hp<=0:
        print(self.name,"has been defeated!")  
    
    def __str__(self):#the method that defines and prints the current status of your character
        status="\n"+str(self.name) +"\nCurrent Health: " + str(self.hp) + "\nCurrent Spell Points: " + \
                 str(self.spellPoints)+ "\nWielding: " +str(self.weapon.name)+"\nWearing: " + \
                 str(self.armor.name)+"\nArmor Class: " +str(self.armor.armorClass())+"\n"
        return status
      
    def fight(self,enemy):   # the fighting method for a character that affects the target of the attack 
      weaponD=self.weapon.damage()
      enemy.hp-=weaponD
      print(self.name+" attacks " + enemy.name + " with a(n) " + self.weapon.name)     
      print(self.name+" does "+ str(weaponD) + " damage to " + enemy.name)  
      print(enemy.name +" is now down to " +str(enemy.hp) + " health")
      enemy.checkForDefeat()
      
       
class Fighter(RPGCharacter): 
# subclass of the RPGCharacter class for the fighter archetype   
# since the superclass defines most of these functions we just simply pass the class as RPGCharacter 
    pass


class Wizard(RPGCharacter):  # subclass of the RPGCharacter class for the wizard archetype 
      arch="Wizard" #changed from fighter default
      hp=16 # changed to wizard max hp
      spellPoints=20 #changed to wizard spellPoints
      
      def putOnArmor(self,mail):#since wizards can't wear armor we redefine it in the subclass so that they can't 
        if mail.name != "none":
          print("Armor not allowed for this character class.")
          
      def wield(self,equip):# wizards can't wield a sword or an axe  so we change this in the subclass 
          if equip.name == "sword" or equip.name== "axe":
            print("Weapon not allowed for this character class.")  
          else:
            self.weapon= equip
            print(self.name+ " is now wielding a(n) " + str(self.weapon.name) )  
            
      def castSpell(self,spell,target):
          fCost=3 #cost of casting a fire spell
          lCost=10 #cost of casting a lightning bolt 
          hCost=6 #cost of healing 
          fBall="Fireball" # fireball spell
          lBolt="Lightning Bolt" # lightning spell
          heal="Heal" #healing spell 
          
          if(spell==fBall):# actions that casting a fireball perform deducting the opponents health or my own and reducing the spell points
            
            if(self.spellPoints<fCost):
              print("Insufficient spell points ")
              return
            
            else:
              target.hp-= 5
              self.spellPoints-= 3
              print(self.name+" casts " + fBall +  " at " + target.name)     
              print(self.name+" does "+ "5" + " damage to " + target.name)  
              print(target.name +" is now down to " +str(target.hp) + " health")
              target.checkForDefeat()
          
          elif(spell==lBolt): # casts a lightning bolt at the target affecting their HP 
            
            if(self.spellPoints<lCost):
              print("Insufficient spell points ")
              return
            
            else:
              target.hp-= 10
              self.spellPoints-= 10
              print(self.name+" casts " + lBolt +  " at " + target.name)     
              print(self.name+" does "+ "10" + " damage to " + target.name)  
              print(target.name +" is now down to " +str(target.hp) + " health")
              target.checkForDefeat()
          
          elif(spell==heal): # heals the target and affects their spellPoints
              
              if(self.spellPoints<hCost):
                print("Insufficient spell points ")
                return
              
              else:
                target.hp+=6
                self.spellPoints-=6
                print(self.name+" casts "+ heal + " at " + target.name)      
                print(self.name+" heals "+target.name + " for 6 health points")  
                if target.arch=="Fighter" and target.hp>40: #checks to see if they are above max HP since they can't surpass their respective class HP
                                                            #it lowers it to the default max in case it does overheal a character
                  target.hp=40
                elif target.arch=="Wizard" and target.hp>16:
                  target.hp=16
                print(target.name + " is now at " + str(target.hp) + " health points ") 
          else:
            print("Unknown spell name. Spell failed") # this exception should handle any incorrect spell  or misspelling of the spell name
    
    
    
  
# I commented out the examples and characters I was using to test the functionality of my program before 
# using the expected output to check it     

#defining weapons
# dagger= Weapon("dagger") 
# axe= Weapon("axe")
# staff= Weapon("staff")
# sword= Weapon("sword")
# 
# 
# #defining armors 
# plateMail=Armor("plate")
# chainMail=Armor("chain")
# leatherMail=Armor("leather")


#defining characters
# rage=Fighter("RageSkylar")   
# cyclaz=Wizard("Cyclaz The Great")
# 
# 
# cyclaz.putOnArmor(plateMail)
# cyclaz.takeOffArmor()
# cyclaz.wield(dagger)
# rage.wield(axe)
# rage.wield(sword)
# cyclaz.castSpell("Fireball",cyclaz)
# cyclaz.castSpell("Fireball",cyclaz)
# cyclaz.castSpell("ice",cyclaz)
# cyclaz.fight(rage)
# print()
# cyclaz.__str__()
# print()
# rage.__str__()
def main():

    plateMail = Armor("plate")
    chainMail = Armor("chain")
    sword = Weapon("sword")
    staff = Weapon("staff")
    axe = Weapon("axe")

    gandalf = Wizard("Gandalf the Grey")
    gandalf.wield(staff)
    
    aragorn = Fighter("Aragorn")
    aragorn.putOnArmor(plateMail)
    aragorn.wield(axe)
    
    print(gandalf)
    print(aragorn)

    gandalf.castSpell("Fireball",aragorn)
    aragorn.fight(gandalf)

    print(gandalf)
    print(aragorn)
    
    gandalf.castSpell("Lightning Bolt",aragorn)
    aragorn.wield(sword)

    print(gandalf)
    print(aragorn)

    gandalf.castSpell("Heal",gandalf)
    aragorn.fight(gandalf)

    gandalf.fight(aragorn)
    aragorn.fight(gandalf)

    print(gandalf)
    print(aragorn)


main()

