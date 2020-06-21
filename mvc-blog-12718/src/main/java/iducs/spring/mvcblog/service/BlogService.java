package iducs.spring.mvcblog.service;

import java.util.List;

import iducs.spring.mvcblog.domain.Blog;
import iducs.spring.mvcblog.util.Pagination;
import iducs.spring.mvcblog.util.Search;

public interface BlogService {
	Blog getBlog(long id);		// primary key에 해당하는 id로  조회
	List<Blog> getBlogs(); // 모든 사용자 조회
	List<Blog> getBlogsByTitle(String title); // name으로 조회
	List<Blog> getBlogByBlogger(String blogger); // company으로 조회
	List<Blog> getBlogByPage(Pagination pagination); // 페이지로 조회
	List<Blog> getBlogsRegDateDesc(); //작성일 내림차순으로 정렬
	List<Blog> searchList(Search search); // 검색
	int postBlog(Blog blog); // 생성
	int updateBlog(Blog blog); // 수정
	int deleteBlog(long id); // 삭제
	int getTotalRowCount();
}
