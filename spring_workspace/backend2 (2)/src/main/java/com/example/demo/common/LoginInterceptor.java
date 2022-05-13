package com.example.demo.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//�꽌釉붾┸�쑝濡� 遺��꽣 以묎컙�뿉 媛�濡쒖콈�꽌 �꽭�뀡�뿉 �엳�뒗 濡쒓렇�삩 �젙蹂댁뿉 �뵲�씪�꽌 遺꾧린瑜� 寃곗젙�븷 �겢�옒�뒪
//HandlerInterceptorAdapter 瑜� �긽�냽諛쏆븘�빞留� �븳�떎 
public class LoginInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		System.out.println("*******************");
		System.out.println(" Login Interceptor ");
		System.out.println("*******************");
		
		//true 瑜� 由ы꽩�븯硫� �븯�뜕嫄� 留덉��븯怨� 
		//false 瑜� 諛섑솚�븯硫� �썝�옒 �슂泥��쓣 留됰뒗�떎. 
		//紐⑤뱺 url�슂泥��씠 �삤硫� �씠 �씤�꽣�뀎�꽣�쓽 preHandler媛� �샇異쒕맂�떎. 
		//濡쒓렇�씤�씠 �릺�뼱 �엳�쑝硫�  true 諛섑솚�븯硫� �썝�옒 媛��뜕湲몄슱 媛꾨떎. 
		//濡쒓렇�씤�씠 �븞�릺�뼱 �엳�쑝硫� false 瑜� 諛섑솚�빐�꽌 湲몄쓣 留됯퀬, 濡쒓렇�삩 �럹�씠吏�濡� �씠�룞�븳�떎
		//留뚮뱾�뼱留� �넃怨� servlet-context.xml�뿉�꽌 �씠 �뙆�씪�슱 �쟻�슜�븯�룄濡� �꽕�젙�쓣 �빐�빞 �븳�떎 
		Object userid=session.getAttribute("userid");
		if(userid!=null) //�씠誘� 濡쒓렇�삩�씠 �릺�뼱 �엳�뒗 �긽�깭�씠�떎
			return true;
		
		//濡쒓렇�삩�씠 �븞�릺�뼱 �엳�뒗 �긽�깭�씪硫� 
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false; 
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	//�븿�닔 �몢媛쒕�� �삤踰꾨씪�씠�뵫 
	//ctrl-space 
	//留덉슦�뒪 �삤瑜몄そ - souce - override 
	
}
