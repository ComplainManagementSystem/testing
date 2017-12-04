package CMS;

import java.io.IOException;

public interface IComplainManager {

	void setSuccessor(IComplainManager man);
	void ForwardTo(String s,Complain c,boolean yes) throws IOException, ClassNotFoundException;
	void ReadComplains() throws IOException, ClassNotFoundException;
	void RespondToAComplain(int id,String cname) throws IOException, ClassNotFoundException;
}
