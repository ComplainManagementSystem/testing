from abc import ABC, abstractmethod
 
class MachineBuilder(ABC):
 
    def __init__(self):
        super().__init__()
    
    @abstractmethod
    def buildMachine(self):
        pass