package Todo;

public class Task {
	
	static int count = 0;
	
	int id;
	Boolean isDone;
	String name;
	
	public Task(String name, Boolean isDone) {
		super();
		this.isDone = isDone;
		this.name = name;
		this.id = count++;
		
	}

	public String getTaskname() {
		return name;
	}

	public void setTaskname(String name) {
		this.name = name;
	}

	public Boolean getisDone() {
		return isDone;
	}

	public void setLastName(Boolean isDone) {
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}
	
	

}