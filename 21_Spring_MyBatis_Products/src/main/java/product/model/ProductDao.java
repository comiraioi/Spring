package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class ProductDao {
	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	/* count */
	public int getTotalCount(Map<String, String> map) {
		int count = -1;
		
		count = sqlSessionTemplate.selectOne(namespace+".ProductCount", map);
		
		return count;
	}
	
	/* select */
	public List<ProductBean> getAllProduct(Map<String, String> map, Paging pageInfo) {
		List<ProductBean> lists = new ArrayList<ProductBean>();
		
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".ProductList", map, rowbounds);
		
		return lists;
	}
	
	/* insert */
	public int insertProduct(ProductBean pb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertProduct", pb);
		
		return cnt;
	}
	
	/* detail */
	public ProductBean getProductbyNum(int num) {
		ProductBean pb = sqlSessionTemplate.selectOne(namespace+".ProductDetail", num);
		
		return pb;
	}
	
	/* update */
	public int updateProduct(ProductBean pb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateProduct", pb);
		
		return cnt;
	}
	
	/* update stock */
	public int updateStock(ProductBean pb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateStock", pb);
		
		return cnt;
	}
	
	/* delete */
	public int deleteProduct(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteProduct", num);
		
		return cnt;
	}
	
}
