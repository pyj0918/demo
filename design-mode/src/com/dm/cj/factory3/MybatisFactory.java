package com.dm.cj.factory3;

public class MybatisFactory extends DaoFacory {

	@Override
	public IUserDao createUser() {
		return new UserDaoMybatis();
	}

	@Override
	public ISchoolDao createSchool() {
		return new SchoolDaoMybatis();
	}

}
