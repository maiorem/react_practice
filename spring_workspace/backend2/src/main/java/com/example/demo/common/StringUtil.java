package com.example.demo.common;

//媛앹껜瑜� �븞留뚮뱾怨� �벐�뒗 �겢�옒�뒪 - �뿬湲곗�湲곗꽌 �떎紐⑹쟻�쑝濡� �궗�슜�븯�뒗 �겢�옒�뒪�뒗 �씠�젃寃� �꽕怨꾪븳�떎 
public class StringUtil {
	public static String nullToValue(Object ob, String value) {
		if(ob==null)
			return value;
		else
			return ob.toString();
		
		//�뼱�뼡媛믩뱾�씠  null 媛믪씠 �뱾�뼱�삤硫� �씠嫄� �몢踰덉㎏ �뙆�씪誘명꽣濡� �쟾�떖�맂 媛믪쓣 二쇨린�쐞�븳 �븿�닔�씠�떎
		
		//String pg = request.getParameter("pg");
		//if(pg==null) pg="";
		
		//String pg = StringUtil.nullToValue(request.getParameter("pg"), "0"); 
	}
}
