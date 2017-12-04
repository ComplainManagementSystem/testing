class ComputerBuilder(MachineBuilder):
	
	 def __init__(self,cc):
         c = cc
		
	 Computer c;
	 def buildMachine(self):
		 c.attachMonitor();
		 c.attachCPU();
		 c.attachHarddisk();
		 c.attachRam();
		 
		 
     def makeComputer():
		 buildMachine()
		 return self.c
		 
	 def IncreaseRam():
		 c = makeComputer()
		 c.r = ExtendedRam(c)
		 print(c.r.b)
		 
	 def IncreaseRam():
		 c = makeComputer()
		 c.h = ExtendedHarddisk(c)
		 print(c.h.b)