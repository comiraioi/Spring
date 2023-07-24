package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class BoardDao {
private String namespace = "board.model.Board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* count */
	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		
		count = sqlSessionTemplate.selectOne(namespace+".BoardCount", map);
		
		return count;
	}
	
	/* select */
	public List<BoardBean> getBoardList(Map<String, String> map, Paging pageInfo) {
		List<BoardBean> lists = new ArrayList<BoardBean>();
		
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".BoardList", map, rowbounds);
		
		return lists;
	}

	/* insert */
	public int writeArticle(BoardBean article) {
		int cnt = -1;
		cnt= sqlSessionTemplate.insert(namespace+".WriteArticle", article);
		
		return cnt;
	}

	/* select by num */
	public BoardBean getArticlebyNum(int num) {
		BoardBean article = sqlSessionTemplate.selectOne(namespace+".GetArticle", num);
		
		return article;
	}
	
	/* search passwd */
	public int searchPasswd(Map<String,String> map) {
		int count = -1;
		count = sqlSessionTemplate.selectOne(namespace+".SearchPasswd", map);
		
		return count;
	}

	/* update */
	public int updateArticle(BoardBean article) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateArticle", article);
		
		return cnt;
	}

	/* delete */
	public int deleteArticle(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".DeleteArticle", num);
		
		return 0;
	}
	
	/* update restep */
	public int updateRestep(Map<String,Integer> map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateRestep", map);
		
		return cnt;
	}

	/* insert reply */
	public int replyArticle(BoardBean article) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".ReplyArticle", article);
		
		return cnt;
	}

	
}
