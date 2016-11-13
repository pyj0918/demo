package com.dm.cj.factory3;

public class HibernateFactory extends DaoFacory {

	@Override
	public IUserDao createUser() {
		return new UserDaoHibernate();
	}

	@Override
	public ISchoolDao createSchool() {
		return new SchoolDaoHibernate();
	}

}
