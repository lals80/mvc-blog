package iducs.spring.mvcblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iducs.spring.mvcblog.service.BlogService;
import iducs.spring.mvcblog.util.Search;

@Controller
public class SearchController {
	private BlogService blogService;
		public SearchController(BlogService blogService) { // 생성자를 활용한 주입
		this.blogService = blogService;
	}
		
	@GetMapping("/blogs/search")
	public String getBlogsByPagination(
		@RequestParam(required = false, defaultValue = "1") int curPage,
		@RequestParam(required = false, defaultValue = "title") String searchType,
		@RequestParam(required = false) String keyword,
		Model model) { 
		Search search = new Search();
		search.setSearchType(searchType);
		search.setKeyword(keyword);
		search.setCurPage(curPage);
		search.setTotalRowCount(blogService.getTotalRowCount());
		model.addAttribute("pagination", search);
		model.addAttribute("blogList", blogService.searchList(search));
		return "/blogs/get-blogs";
	}
}