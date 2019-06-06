package midterm;

public class box {
	
	static int count = 0;
	
	int id;
	String name;
	String desc;
	int like;
	int dislike;
	
	public box(String name,String desc) {
		super();
		this.name = name;
		this.desc = desc;
		this.id = count++;
		this.like = 0;
		this.dislike = 0;
		
	}

	
	public String getboxname() {
		return name;
	}

	public void setboxname(String name) {
		this.name = name;
	}
	
	public String getdesc() {
		return desc;
	}

	public void setdesc(String desc) {
		this.desc = desc;
	}


	public int getlike() {
		return like;
	}

	public int pluslike() {
		return this.like++;
	}
	public int getdislike() {
		return dislike;
	}

	public int plusdislike() {
		return this.dislike++;
	}

	public int getId() {
		return id;
	}
}

