package iducs.spring.mvcblog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import iducs.spring.mvcblog.domain.Blog;
import iducs.spring.mvcblog.repository.BlogRepository;
import iducs.spring.mvcblog.util.Pagination;
import iducs.spring.mvcblog.util.Search;

@Service
public class BlogServiceImpl implements BlogService {
	private BlogRepository blogRepository;
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	
	@Override
	public Blog getBlog(long id) {
		// TODO Auto-generated method stub
		Blog blog = new Blog();
		blog.setId(id);		
		return blogRepository.read(blog);
	}

	@Override
	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return blogRepository.readList();
	}

	@Override
	public List<Blog> getBlogsByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogByBlogger(String blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> getBlogByPage(Pagination pagination) {
		// TODO Auto-generated method stub
		return blogRepository.readPage(pagination);
	}
	
	@Override
	public int postBlog(Blog blog) {		
		// TODO Auto-generated method stub
		int count = blogRepository.create(blog);
		return count;
	}
	@Override
	public int updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		int count = blogRepository.update(blog);
		return count;
	}
	@Override
	public int deleteBlog(long id) {
		// TODO Auto-generated method stub
		Blog blog = new Blog();
		blog.setId(id);	
		int count = blogRepository.delete(blog);
		return count;
	}


	@Override
	public int getTotalRowCount() {
		// TODO Auto-generated method stub
		return blogRepository.readTotalRowCount();
	}


	@Override
	public List<Blog> getBlogsRegDateDesc() {
		// TODO Auto-generated method stub
		return blogRepository.readListRegDate();
	}


	@Override
	public List<Blog> searchList(Search search) {
		return blogRepository.searchPage(search);
	}
}
