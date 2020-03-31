package web;
import javax.persistence.*;

@Entity @Table(name="data_centers")
public class DataCenter {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String name;
	public String type;

	public int    getId()   { return id;   }
	public String getName() { return name; }
	public String getType() { return type; }
}
