class Duck:
    def fly(self):
        print("Duck flying")

class Butterfly:
    def fly(self):
        print("Butterfly flying")

class Whale:
    def swim(self):
        print("Whale swimming")

def lift_off(entity):
    entity.fly()

animals = [Duck(), Butterfly(), Whale()] 

while 1:
	choice = input("Enter 1, 2, or 3: ")
	if (choice >= 1) and (choice <= 3):
		lift_off(animals[choice - 1])
	else:
		print("Invalid choice entered")
