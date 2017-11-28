package com.cpf.resources;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GetTreeNodeUtil_Reflect {
		
	/***
		 * 菜单树形结构 通过反射方式，可通用
		 * @author jml 
		 * @param allList
		 * @return
		 * @throws ClassNotFoundException 
		 * @throws IllegalAccessException 
		 * @throws InstantiationException 
		 */
	
	@SuppressWarnings("unchecked")
	public static List  getOrgsTree(List allList,String obj,String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		List  oo=new ArrayList();
		
		List<Object>  parents=new ArrayList<Object>();
		
		for( Object pp  : allList ){
			
			String parentId = getter(pp,"Parentid");
			
			if(parentId != null && parentId.equals("0")){
				parents.add(pp);
			}
		}
		
		for(int i=0;i<parents.size();i++){
			Object rootNode = parents.get(i);
			//查询第一级菜单
				rootNode = constructTree(rootNode, allList, 0,obj,key);
				
			oo.add(rootNode);
		}
		return oo;
	}
	
	
	public static Object constructTree(Object rootNode, List<Object> orgList, int rootLevel,String path,String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		List<Object> childNodeList = new ArrayList<Object>();
		for(int i=0; i<orgList.size(); i++){
			Object org = orgList.get(i);
			String parentId = getter(org,"Parentid");
			String ProCategoryId = getter(rootNode,key);
			
			if(parentId.equals(ProCategoryId)){
				Object childNode  = org;
				setter(childNode,"Level",rootLevel+1,int.class);
				childNodeList.add(childNode);
			}
		}
		setter(rootNode,"Childs",childNodeList,List.class);
		if(childNodeList.size()==0){
			setter(rootNode,"Leaf",true,boolean.class);
		} else {
			setter(rootNode,"Leaf",false,boolean.class);
		}
		for(int j=0; j<childNodeList.size();j++){
			constructTree(childNodeList.get(j), orgList, ++rootLevel,path,key);
			--rootLevel;
		}
		return rootNode;
	}
	
	
	/**
     * @param obj
     *            操作的对象
     * @param att
     *            操作的属性
	 * @return 
     * */
    public static String getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            return method.invoke(obj)+"";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    /**
     * @param obj
     *            操作的对象
     * @param att
     *            操作的属性
     * @param value
     *            设置的值
     * @param type
     *            参数的属性
     * */
    public static void setter(Object obj, String att, Object value,
            Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		
//		List<ProCategory>  allList= new ArrayList<ProCategory>();
//		
//		ProCategory pro=new ProCategory();
//		pro.setProCategoryId("001");
//		pro.setCategoryName("父类1");
//		pro.setParentId("0");
//		allList.add(pro);
//		
//		ProCategory pro2=new ProCategory();
//		pro2.setProCategoryId("002");
//		pro2.setCategoryName("父类2");
//		pro2.setParentId("0");
//		allList.add(pro2);
//		
//		ProCategory pro3=new ProCategory();
//		pro3.setProCategoryId("001001");
//		pro3.setCategoryName("子类1");
//		pro3.setParentId("001");
//		allList.add(pro3);
//		
//		ProCategory pro4=new ProCategory();
//		pro4.setProCategoryId("002001");
//		pro4.setCategoryName("子类2");
//		pro4.setParentId("002");
//		allList.add(pro4);
//		ProCategory pro5=new ProCategory();
//		pro5.setProCategoryId("001002");
//		pro5.setCategoryName("子类3");
//		pro5.setParentId("001");
//		allList.add(pro4);
//		
//		allList =	GetTreeNodeUtil_Reflect.getOrgsTree(allList, "com.all.entitys.ProCategory","ProCategoryId");
	
	}
}
