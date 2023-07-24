package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartCalculateController {
	private final String command = "/calculate.mall";
	private String listPage = "redirect:/list.prd";
	private String cartPage = "redirect:/list.mall";
	
	@Autowired
	MemberDao mdao;
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	OrderDetailDao oddao;
	
	@Autowired
	ProductDao pdao;
	
	/* 장바구니 목록보기에서 결제 클릭 */
	@RequestMapping(value=command)
	public ModelAndView doAction(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		String mid = mb.getId();
		
		/* orders 테이블
		   : oid(시퀀스), mid(로그인 아이디), orderdate(sysdate) */
		int cnt = odao.insertOrder(mid);
		
		if(cnt!=-1) {
			System.out.println("order insert 성공");
			
			int maxOid = odao.getMaxOid();
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			Map<Integer, Integer> mapList = mycart.getOrderlists();
			
			//key: 상품번호(pnum)
			Set<Integer> keyPnum = mapList.keySet();
			
			int cnt2 = -1;
			for(int key : keyPnum) {
				/* orderdetails 테이블
				   : odid(시퀀스), oid(orders 테이블 시퀀스), pnum(상품 번호), qty(주문 수량) */ 
				OrderDetailBean odb = new OrderDetailBean();
				
				odb.setOid(maxOid);	//마지막 oid(시퀀스이므로 max(oid))
				odb.setPnum(key);
				odb.setQty(mapList.get(key));	//value: 주문수량(qty)
				
				cnt2 += oddao.insertOrderDetail(odb);
				
				/* 상품 재고수량 감소 */
				ProductBean pb = pdao.getProductbyNum(key);
				System.out.println(key+"번 재고: "+pb.getStock());
				
				pb.setStock(pb.getStock() - mapList.get(key));
				
				int cnt3 = pdao.updateStock(pb);
				if(cnt3 != -1) {
					System.out.println("update 재고: "+pb.getStock());
				}else {
					System.out.println("재고 수량 update 실패");
				}
			}
			
			if(cnt2!=-1) {
				System.out.println("주문 성공");
				mav.setViewName(listPage);
				
				/* 회원 포인트 적립하기 */
				System.out.println(mid+"님 기존 포인트: "+ mb.getMpoint());
				mb.setMpoint(mb.getMpoint()+100);
				
				int cnt4 = mdao.updatePoint(mb);
				if(cnt4!=-1) {
					System.out.println("update 포인트: "+ mb.getMpoint());
				}else {
					System.out.println("포인트 update 실패");
				}
				
			}else {
				System.out.println("주문 실패");
				mav.setViewName(cartPage);
			}
			
		}else {
			System.out.println("order insert 실패");
			mav.setViewName(cartPage);
		}
		
		return mav;
	}
	
}
