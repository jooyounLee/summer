package summer.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import summer.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
    @GetMapping("/")
	public String home(Model model) {
		System.out.println(articleService.count());
		model.addAttribute("name", "aaa" );
        
        return "home";
    }
}
