package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingList;
import member.model.MemberBean;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {
	private final String command = "/list.mall";
	private String listPage = "cartList";
	
	@Autowired
	ProductDao pdao;
	
	/* ��ٱ��� ��� ����: CartAddController���� ��û */
	@RequestMapping(value=command)
	public String doAction(HttpSession session, Model model) {
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		
		//key: ��ǰ��ȣ(num), value: �ֹ�����(orderqty)
		Map<Integer, Integer> mapLists = mycart.getOrderlists();	
		
		Set<Integer> keylist = mapLists.keySet();	//��ǰ��ȣ(key) ����Ʈ
		System.out.println("��ٱ���(��ǰ��ȣ) ����Ʈ: "+keylist);
		
		int totalAmount = 0;
		List<ShoppingList> slist = new ArrayList<ShoppingList>();
		
		for(Integer pnum : keylist) {
			ShoppingList shopping = new ShoppingList();
			
			ProductBean pb = pdao.getProductbyNum(pnum);
			
			shopping.setPnum(pb.getNum());
			shopping.setPname(pb.getName());
			shopping.setQty(mapLists.get(pnum));	//key(pnum)�� value(orderqty) ��������
			shopping.setPrice(pb.getPrice());
			shopping.setAmount(pb.getPrice() * mapLists.get(pnum));
			totalAmount += pb.getPrice() * mapLists.get(pnum);
			
			slist.add(shopping);
		}
	
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("slist", slist);
		
		return listPage;
	}
	
}
