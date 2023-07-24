package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mall.cart.MyCartList;
import member.model.MemberBean;

@Controller
public class CartAddController {
	private final String command = "/add.mall";

	private String loginPage = "redirect:/login.mb";
	private String detailPage = "redirect:/detail.prd";
	private String cartPage = "redirect:/list.mall";	//CartListController
	
	/* 상품 상세보기 페이지 => 주문 클릭 */
	@RequestMapping(command)
	public ModelAndView doAction(@RequestParam("num") int num, @RequestParam("pageNumber") int pageNumber,
								@RequestParam("orderqty") int orderqty, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		//로그인 안했으면
		if(mb == null) {	
			//destination 속성 설정
			session.setAttribute("destination", detailPage+"?num="+num+"&pageNumber="+pageNumber);	//destination 속성 설정
			mav.setViewName(loginPage);	//memberLoginForm.jsp
		}
		else {	//로그인 했으면
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			
			if(mycart == null) {	//장바구니가 없으면
				mycart = new MyCartList();	//장바구니 객체 생성
			}
			
			mycart.addOrder(num,orderqty);	//장바구니에 상품번호,갯수 넣기
			session.setAttribute("mycart",mycart);	//장바구니 세션 설정 (회원당 장바구니 객체 1개)
			
			mav.setViewName(cartPage);	
		}
		
		return mav;
		
	}
}
