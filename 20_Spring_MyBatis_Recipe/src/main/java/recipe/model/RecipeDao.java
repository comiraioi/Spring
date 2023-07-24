package recipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myRecipeDao")
public class RecipeDao {
	private String namespace = "recipe.RecipeBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* select */
	public List<RecipeBean> getAllRecipe(Map<String, String> map, Paging pageInfo){
		List<RecipeBean> lists = new ArrayList<RecipeBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList(namespace+".RecipeList", map, rowbounds);
		
		return lists;
	}

	/* count */
	public int getTotalCount(Map<String, String> map) {
		int totalcount = sqlSessionTemplate.selectOne(namespace+".RecipeCount", map);
		
		return totalcount;
	}

	/* insert */
	public int insertRecipe(RecipeBean rb) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.insert(namespace+".InsertRecipe", rb);
		}catch(Exception e){
			
		}
		
		return cnt;
	}
	
	/* select by num */
	public RecipeBean getRecipebyNum(int num) {
		RecipeBean rb = new RecipeBean();
		rb = sqlSessionTemplate.selectOne(namespace+".RecipeDetail", num);
				
		return rb;
	}
	
	/* update */
	public int updateRecipe(RecipeBean rb) {
		int cnt = -1;
		
		try {
			cnt = sqlSessionTemplate.update(namespace+".UpdateRecipe", rb);
		}catch(Exception e){
			
		}
		
		return cnt;
	}
	
	/* delete */
	public int deleteRecipe(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteRecipe", num);
		
		return cnt;
	}

	/* duplication */
	public boolean searchDish(String inputDish) {
		boolean result = true;
		int cnt = -1;
		
		cnt = sqlSessionTemplate.selectOne(namespace+".SearchDish", inputDish);
		
		System.out.println("cnt: "+cnt);
		if(cnt>0) {	//ม฿บน
			result = false;
		}
		
		return result;
	}
	
}
