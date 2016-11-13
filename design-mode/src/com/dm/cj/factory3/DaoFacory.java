package com.dm.cj.factory3;

public abstract class DaoFacory {
	public abstract IUserDao createUser();
	public abstract ISchoolDao createSchool();
}
