package NO5;

public class Student {
	
	public int ID;
	public String FirstName;
	public String LastName;
	public String Course;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String fn, String ln, String course) {
		this.ID = id;
		this.FirstName = fn;
		this.LastName = ln;
		this.Course = course;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}
	
	@Override
	public String toString() {
		return "ID: " + ID + "  FirstName: " + FirstName + "  LastName: " + LastName + "  Course: " + Course;
	}
}
