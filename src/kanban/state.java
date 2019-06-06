package kanban;

public class state {
	
	static int count = 0;
	
	int id;
	int col;
	String name;
	String desc;
	
	public state(String name,String desc ,int Col) {
		super();
		this.col = Col;
		this.name = name;
		this.desc = desc;
		this.id = count++;
		
	}

	
	public String getTaskname() {
		return name;
	}

	public void setTaskname(String name) {
		this.name = name;
	}
	
	public String getdesc() {
		return desc;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}


	public int getcol() {
		return col;
	}

	public int Setcol(int Col) {
		return this.col = Col;
	}

	public int getId() {
		return id;
	}
}
	
	
