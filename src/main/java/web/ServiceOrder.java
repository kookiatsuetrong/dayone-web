package web;
import javax.persistence.*;

@Entity @Table(name="service_orders")
public class ServiceOrder {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;

	String email;
	int service;
	@Column(name="domain_name") String domainName;
	@Column(name="data_center") String dataCenter;
	String info;

	public String getEmail()      { return email;      }
	public int    getService()    { return service;    }
	public String getDomainName() { return domainName; }
	public String getDataCenter() { return dataCenter; }
	public String getInfo()       { return info;       }
}