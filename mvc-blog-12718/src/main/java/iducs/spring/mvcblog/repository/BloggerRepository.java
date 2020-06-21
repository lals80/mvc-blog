package iducs.spring.mvcblog.repository;

import java.util.List;

import iducs.spring.mvcblog.domain.Blogger;

public interface BloggerRepository {
	int create(Blogger blogger);
	Blogger read(Blogger blogger);
	
	Blogger findByBid(String bid);
	
	List<Blogger> readList();
	int update(Blogger blogger);
	int delete(Blogger blogger);
}
