package web;
import java.util.*;
import javax.persistence.*;
import javax.servlet.http.*;
import org.springframework.ui.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
class Start {

	@GetMapping("/")
	String showIndex(HttpSession session, Model model) {
		String current = (String)session.getAttribute("language");
		if (current == null) {
			current = "english";
		}
		model.addAttribute("language", current);
		return "index";
	}

	@GetMapping("/change-language")
	String changeLanguage(HttpSession session, String value) {
		session.setAttribute("language", value);
		return "redirect:/";
	}

	@GetMapping("/signup")
	String showSignUp(String type) {
		switch (type) {
			case "enterprise": break;
			default: break;
		}
		return "signup";
	}

	@GetMapping("/subscribe")
	String showSubscrie(Model model) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
		EntityManager manager = factory.createEntityManager();
		Query queryService = manager.createQuery(
								"select s from Service s   " +
								"where s.subscribe = true  ");
		model.addAttribute("services", queryService.getResultList());

		Query queryCenter = manager.createQuery(
								"select d from DataCenter d  " +
								"where d.type = 'Google'     ");
		model.addAttribute("centers", queryCenter.getResultList());

		manager.close();
		return "subscribe";
	}

	@PostMapping("/subscribe")
	String saveSubscription(Model model,
				String email,
				String domain,
				int id,
				int center,
				String info)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
		EntityManager manager = factory.createEntityManager();
		ServiceOrder order = new ServiceOrder();
		order.email        = email;
		order.domainName   = domain;
		order.service      = id;
		order.dataCenter   = center;
		order.info         = info;
		manager.getTransaction().begin();
		manager.persist(order);
		manager.getTransaction().commit();
		model.addAttribute("order", order);

		Service service = null;
		try {
			service = manager.find(Service.class, id);
		} catch (Exception e) { }
		model.addAttribute("service", service);
		manager.close();
		return "subscribe-payment";
	}

	@GetMapping("/service")
	String showService(Model model) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
		EntityManager manager = factory.createEntityManager();
		Query queryService = manager.createQuery(
								"select s from Service s   " +
								"where s.subscribe = false ");
		model.addAttribute("services", queryService.getResultList());
		manager.close();
		return "service";
	}

	@PostMapping("/service")
	String saveService(Model model,
				String email,
				String domain,
				int id,
				String info)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
		EntityManager manager = factory.createEntityManager();
		ServiceOrder order = new ServiceOrder();
		order.email        = email;
		order.domainName   = domain;
		order.service      = id;
		order.info         = info;
		manager.getTransaction().begin();
		manager.persist(order);
		manager.getTransaction().commit();
		model.addAttribute("order", order);

		Service service = null;
		try {
			service = manager.find(Service.class, id);
		} catch (Exception e) { }
		model.addAttribute("service", service);
		manager.close();
		return "service-payment";
	}
	
	@GetMapping("/check") @ResponseBody
	String check() {
		return "OK";
	}
}