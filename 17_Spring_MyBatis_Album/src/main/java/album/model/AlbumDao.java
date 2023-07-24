package album.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/* AlbumDao myAlbumDao = new AlbumDao(); */
@Component("myAlbumDao")
public class AlbumDao {
	
	/* mapper 파일(album.xml) => namespace: album.AlbumBean */
	private String namespace = "album.AlbumBean";

	@Autowired	/* 자동으로 객체(root-context.xml에서 생성) 주입 */
	SqlSessionTemplate sqlSessionTemplate;
		
	public AlbumDao() {
		System.out.println("생성자: AlbumDao()");
	}//생성자
	
	/* select, search */
	public List<AlbumBean> getAlbumList(Map<String, String> map, Paging pageInfo){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		System.out.println("offset:"+pageInfo.getOffset());	//건너뛸 레코드 수
		System.out.println("limit:"+pageInfo.getLimit());	//한 페이지에 보여줄 레코드 수(=pageSize)
		
		lists = sqlSessionTemplate.selectList(namespace+".GetAlbumList",map,rowBounds);
		System.out.println("lists.size(): "+lists.size());
		
		return lists;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace+".GetTotalCount", map);
		
		return totalCount;
	}
	
	
	/* insert */
	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		//mapper 파일(album.xml) => namespace: album.AlbumBean / id: InsertAlbum
		cnt = sqlSessionTemplate.insert(namespace+".InsertAlbum",album);	//컨트롤러에서 넘긴 album 객체
		
		return cnt;
	}
	
	/* select by num */
	public AlbumBean selectAlbumbyNum(int num) {
		AlbumBean album = null;
		album = sqlSessionTemplate.selectOne(namespace+".GetAlbum", num);	//컨트롤러에서 넘긴 num
		
		return album;
	}
	
	/* update */
	public int updateAlbum(AlbumBean album) throws ParseException {
		/* 발매일 시간 지워서 넣기
		String day = album.getDay();
		day = day.substring(0, day.indexOf(" "));
		album.setDay(day); */
		
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateAlbum", album);	
		
		return cnt;
	}
	
	/* delete */
	public int deleteAlbum(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteAlbum", num);		
		
		return cnt;
	}
	
	
}
