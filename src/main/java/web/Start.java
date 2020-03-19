package web;
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
	@GetMapping("/check") @ResponseBody
	String check() {
		return "OK";
	}
}