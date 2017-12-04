package CMS;

import java.io.IOException;

public interface IObservable {

	void ForwardTo(String s,Complain c);
	void ReadComplains() throws IOException, ClassNotFoundException;
	void RespondToAComplain(int id,String s) throws IOException, ClassNotFoundException;
}
