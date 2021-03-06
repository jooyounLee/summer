package summer.article.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
	@GetMapping("/article")
	public String goWritePage(Model model) {
		return "/article/write";
	}

	@GetMapping("/articles")
    public @ResponseBody Map<String, Object> list(Integer page, Integer perPage) {
	   Map<String, Object> result = new HashMap<String, Object>();
	   Map<String, Object> articles = new HashMap<String, Object>();
	   Map<String, Object> pagination = new HashMap<String, Object>();
	   
	   pagination.put("page", page);
	   pagination.put("totalCount", articleService.count());
	   
	   articles.put("contents", articleService.findArticles(page, perPage));
	   articles.put("pagination", pagination);
	   
	   result.put("result", true);
	   result.put("data", articles);
	   
	   return result;
    }
   
   @PostMapping("/article")
   public @ResponseBody int insert(@ModelAttribute Article article) {
	   return articleService.insertArticle(article);
   }
   
   @GetMapping("/article/{idx}")
   public @ResponseBody Article select(@PathVariable Integer idx) {
	   Article article = articleService.findByIdx(idx);
	   return article;
   }
  
}

