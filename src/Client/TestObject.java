package Client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestObject {

	// Attribute
	String test1;
	int test2;

	// Default Konstruktor
	public TestObject() {

	}

	public TestObject(String test1, int test2) {
		this.test1 = test1;
		this.test2 = test2;
	}

	public String getTest1() {
		return test1;
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public int getTest2() {
		return test2;
	}

	public void setTest2(int test2) {
		this.test2 = test2;
	}

	@Override
	public String toString() {
		return "TestObject [test1=" + test1 + ", test2=" + test2 + "]";
	}

}
