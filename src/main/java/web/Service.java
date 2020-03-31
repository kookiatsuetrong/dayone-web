package web;
import javax.persistence.*;

@Entity @Table(name="services")
public class Service {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String name;
	public double price;
	public boolean subscribe;
	
	public int getId()            { return id;         }
	public String getName()       { return name;       }
	public double getPrice()      { return price;      }
	public boolean getSubscribe() { return subscribe;  }
}