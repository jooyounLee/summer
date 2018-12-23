package summer.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import summer.article.model.Article;
import summer.article.service.ArticleService;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
    @GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "aaa" );
        
        return "/article/list";
    }
    
   @GetMapping("/articles")
    public @ResponseBody List<Article> list() {
    	System.out.println(11);
    	return articleService.findArticles();
    }
   
   @PostMapping("/article")
   public @ResponseBody int insert(Article article) {
	   return articleService.insertArticle(article);
   }
   
  
}
