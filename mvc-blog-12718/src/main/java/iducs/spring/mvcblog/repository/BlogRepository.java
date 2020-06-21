package iducs.spring.mvcblog.repository;

import java.util.List;

import iducs.spring.mvcblog.domain.Blog;
import iducs.spring.mvcblog.util.Pagination;
import iducs.spring.mvcblog.util.Search;

public interface BlogRepository {
	int create(Blog blog);
	Blog read(Blog blog);
	List<Blog> readList();
	List<Blog> readPage(Pagination pagination);
	List<Blog> readListRegDate();
	int update(Blog blog);
	int delete(Blog blog);
	int readTotalRowCount();
	List<Blog> searchPage(Search search);
}
