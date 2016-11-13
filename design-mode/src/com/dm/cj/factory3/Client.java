package com.dm.cj.factory3;

public class Client {
	public static void main(String[] args) {
		DaoFacory daoFactory;
		IUserDao userDao = null;
		ISchoolDao schoolDao = null;

		daoFactory = new MybatisFactory();
		userDao = daoFactory.createUser();
		schoolDao = daoFactory.createSchool();

		daoFactory = new HibernateFactory();
		userDao = daoFactory.createUser();
		schoolDao = daoFactory.createSchool();

	}
}
