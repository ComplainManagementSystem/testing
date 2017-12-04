class ExtendedHarddisk(ExtendedItems):
	 
	 
	 Computer c = None
	 
	 def __init__ (self,cc)
		 c =cc
	 
	 def attachMonitor(self):
		 self.a += "Monitor "
		
	 def attachCPU(self):
		 self.a += "CPU "
	 
	 
	 def attachHarddisk(self):
		 h = HardDisk()
		 h.updateHD("250gb")
		 return h
	 
	 def attachRam(self):
		 r = Ram()
		 return c.attachRam()