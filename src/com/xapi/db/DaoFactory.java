package com.xapi.db;
public class DaoFactory {
	/**
	 * 单例对象返回
	 */
	private static final DaoFactory factory = new DaoFactory();
	private DaoFactory(){}
	public static DaoFactory getInstance(){
		return factory;
	}
	/**
	 * 
	 * @param className
	 * @param clazz
	 * @return使用泛型返回类实例
	 */
	public <T> T createDao(String className, Class<T> clazz){
		try{
			T t = (T) Class.forName(className).newInstance();
			return t;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}