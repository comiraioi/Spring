package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMovieDao")
public class MovieDao {
	private String namespace = "movie.MovieBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* select */
	public List<MovieBean> getAllMovie(Map<String, String> map, Paging pageInfo){
		List<MovieBean> lists = new ArrayList<MovieBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace+".MovieList", map, rowbounds);
		
		return lists;
	}

	/* count */
	public int getTotalCount(Map<String, String> map) {
		int totalcount = sqlSessionTemplate.selectOne(namespace+".TotalCount", map);
		
		return totalcount;
	}

	/* insert */
	public int insertMovie(MovieBean mb) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace+".InsertMovie", mb);
		}catch(Exception e){
			
		}
		
		return cnt;
	}
	
	/* select by num */
	public MovieBean getMoviebyNum(int num) {
		MovieBean mb = new MovieBean();
		mb = sqlSessionTemplate.selectOne(namespace+".MovieDetail", num);
				
		return mb;
	}
	
	/* update */
	public int updateMovie(MovieBean mb) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.update(namespace+".UpdateMovie", mb);
		}catch(Exception e){
			
		}
		
		return cnt;
	}
	
	/* delete */
	public int deleteMovie(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteMovie", num);
		
		return cnt;
	}

	/* duplication */
	public boolean searchTitle(String inputTitle) {
		boolean result = true;
		int cnt = -1;
		
		cnt = sqlSessionTemplate.selectOne(namespace+".SearchTitle", inputTitle);
		
		System.out.println("cnt: "+cnt);
		if(cnt>0) {	//ม฿บน
			result = false;
		}
		
		return result;
	}
	
}
