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
	
	/* ��ٱ��� ��Ϻ��⿡�� ���� Ŭ�� */
	@RequestMapping(value=command)
	public ModelAndView doAction(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		String mid = mb.getId();
		
		/* orders ���̺�
		   : oid(������), mid(�α��� ���̵�), orderdate(sysdate) */
		int cnt = odao.insertOrder(mid);
		
		if(cnt!=-1) {
			System.out.println("order insert ����");
			
			int maxOid = odao.getMaxOid();
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			Map<Integer, Integer> mapList = mycart.getOrderlists();
			
			//key: ��ǰ��ȣ(pnum)
			Set<Integer> keyPnum = mapList.keySet();
			
			int cnt2 = -1;
			for(int key : keyPnum) {
				/* orderdetails ���̺�
				   : odid(������), oid(orders ���̺� ������), pnum(��ǰ ��ȣ), qty(�ֹ� ����) */ 
				OrderDetailBean odb = new OrderDetailBean();
				
				odb.setOid(maxOid);	//������ oid(�������̹Ƿ� max(oid))
				odb.setPnum(key);
				odb.setQty(mapList.get(key));	//value: �ֹ�����(qty)
				
				cnt2 += oddao.insertOrderDetail(odb);
				
				/* ��ǰ ������ ���� */
				ProductBean pb = pdao.getProductbyNum(key);
				System.out.println(key+"�� ���: "+pb.getStock());
				
				pb.setStock(pb.getStock() - mapList.get(key));
				
				int cnt3 = pdao.updateStock(pb);
				if(cnt3 != -1) {
					System.out.println("update ���: "+pb.getStock());
				}else {
					System.out.println("��� ���� update ����");
				}
			}
			
			if(cnt2!=-1) {
				System.out.println("�ֹ� ����");
				mav.setViewName(listPage);
				
				/* ȸ�� ����Ʈ �����ϱ� */
				System.out.println(mid+"�� ���� ����Ʈ: "+ mb.getMpoint());
				mb.setMpoint(mb.getMpoint()+100);
				
				int cnt4 = mdao.updatePoint(mb);
				if(cnt4!=-1) {
					System.out.println("update ����Ʈ: "+ mb.getMpoint());
				}else {
					System.out.println("����Ʈ update ����");
				}
				
			}else {
				System.out.println("�ֹ� ����");
				mav.setViewName(cartPage);
			}
			
		}else {
			System.out.println("order insert ����");
			mav.setViewName(cartPage);
		}
		
		return mav;
	}
	
}
