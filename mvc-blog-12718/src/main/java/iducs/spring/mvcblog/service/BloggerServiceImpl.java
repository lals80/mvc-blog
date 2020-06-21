package iducs.spring.mvcblog.service;

import java.util.List;

import iducs.spring.mvcblog.domain.Blogger;
import iducs.spring.mvcblog.repository.BloggerRepository;

public class BloggerServiceImpl implements BloggerService {
	private BloggerRepository bloggerRepository;
	public BloggerServiceImpl(BloggerRepository bloggerRepository) {
		this.bloggerRepository = bloggerRepository;
	}
	@Override
	public Blogger getBlogger(long id) {
		Blogger blogger = new Blogger();
		blogger.setId(id);
		return bloggerRepository.read(blogger);
	}
	
	@Override
	public Blogger getUserByBid(String bid) {
		return bloggerRepository.findByBid(bid);
	}
	
	@Override
	public List<Blogger> getBloggers() {
		// TODO Auto-generated method stub
		return bloggerRepository.readList();
	}

	@Override
	public int postBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		int count = bloggerRepository.create(blogger);
		return count;
	}

	@Override
	public int updateBlogger(Blogger blogger) {
		int count = bloggerRepository.update(blogger);
		return count;
	}

	@Override
	public int deleteBlogger(long id) {
		Blogger blogger = new Blogger();
		blogger.setId(id);
		int count = bloggerRepository.delete(blogger);
		return count;
	}

}
