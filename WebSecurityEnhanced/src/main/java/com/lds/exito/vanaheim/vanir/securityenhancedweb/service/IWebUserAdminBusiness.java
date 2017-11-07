package com.lds.exito.vanaheim.vanir.securityenhancedweb.service;

import com.ibm.OS4690.FlexosException;

public interface IWebUserAdminBusiness 
{
	public abstract boolean isAvalibleSecurityEnhanced()  throws Exception ;
	public abstract String isUserValid(String userId, String userPassword)  throws FlexosException;
	public abstract String isUserAuthorizedSecurityEnhanced(String userId, String userPassword) throws FlexosException, NumberFormatException;
	public abstract String createUserPassword(String userIdAdmin, String passwordUserAdmin, String userIdOperator, String newPassword);
}
