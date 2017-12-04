from abc import ABC, abstractmethod


class Computer(ABC):
	def __init__(self):
        super().__init__()
	
	 @abstractmethod
	 def attachMonitor(self):
		 pass
		
	 @abstractmethod
	 def attachCPU(self):
		 pass
	 
	 @abstractmethod
	 def attachHarddisk(self):
		 pass
	 @abstractmethod
	 def attachRam(self):
		 pass
		