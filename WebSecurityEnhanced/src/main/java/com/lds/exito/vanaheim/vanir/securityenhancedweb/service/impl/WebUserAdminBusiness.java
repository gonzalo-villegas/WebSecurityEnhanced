/**
 * 
 */
package com.lds.exito.vanaheim.vanir.securityenhancedweb.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.OS4690.FlexosException;
import com.ibm.OS4690.security.AuthorizationRecord;
import com.ibm.OS4690.security.EnhancedSecurity;
import com.ibm.OS4690.security.EnhancedSecuritySession;
import com.lds.exito.vanaheim.vanir.securityenhancedweb.service.IWebUserAdminBusiness;
import com.lds.exito.vanaheim.vanir.securityenhancedweb.service.extension.ErrorCodesSecurityEnhanced;

/**
 * @author jorge.lima
 *
 */
public class WebUserAdminBusiness implements IWebUserAdminBusiness
{
	public WebUserAdminBusiness() 
	{

	}
	
	private static Logger logger = LoggerFactory.getLogger(WebUserAdminBusiness.class);
	
	@Override
	public boolean isAvalibleSecurityEnhanced() throws Exception 
	{
		logger.info("Inicia validacion isAvalibleSecurityEnhanced - WebUserAdminBusiness");
		boolean statusSecurityEnhanced = false;
		try {
			if (EnhancedSecurity.isAvailable()) 
			{
				statusSecurityEnhanced = true;
			}	
		} catch(Exception e)
		{	
			logger.error("Fnaliza en error en validacion isAvalibleSecurityEnhanced - WebUserAdminBusiness: {}", e.getLocalizedMessage());
			throw new Exception(e.getLocalizedMessage());
		}
		return statusSecurityEnhanced;
	}
	
	@Override
	public String isUserValid(String userId, String userPassword) throws FlexosException
	{
		EnhancedSecuritySession enhancedSecuritySession = null;
		logger.info("Inicia validacion isUserValid - WebUserAdminBusiness.");
		String userValid = null;
		AuthorizationRecord authorizationUser = null;
		try
		{
			enhancedSecuritySession = EnhancedSecurity.startSession(userId, userPassword);
			userValid = "true";
			authorizationUser = enhancedSecuritySession.getRecord(userId);
			authorizationUser.lock();
			enhancedSecuritySession.commit();
		} catch(FlexosException er)
		{
			ErrorCodesSecurityEnhanced errorCodesSecurityEnhanced = new ErrorCodesSecurityEnhanced(er.getReturnCode());
			userValid = errorCodesSecurityEnhanced.getMessageError();
			logger.error("mensaje de error " + userValid);
			enhancedSecuritySession.cancel();
		}
		return userValid;
	}

	@Override
	public String isUserAuthorizedSecurityEnhanced(String userId, String userPassword) throws FlexosException, NumberFormatException 
	{
		EnhancedSecuritySession enhancedSecuritySession = null;
		logger.info("Inicia validacion de permiso de usuario en security enhanced.");
		final String ENHANCED_SECURITY = "77";
		boolean isauthorized = false;
		String responseData = null;
		try
		{	
			enhancedSecuritySession = EnhancedSecurity.startSession(userId, userPassword);
			AuthorizationRecord authorizationUser = enhancedSecuritySession.getRecord(userId);
			isauthorized = authorizationUser.getAttribute(Integer.parseInt(ENHANCED_SECURITY));
			if (isauthorized)
			{
				responseData = "true";
				logger.info("user is authorized");
			} else 
			{
				responseData = "user ".concat(userId).concat(" is not authorized");
				logger.info("user is unauthorized");
			}
			authorizationUser.lock();
			enhancedSecuritySession.commit();
		} catch (FlexosException err)
		{
			logger.error(err.getLocalizedMessage());
			ErrorCodesSecurityEnhanced errorCodesSecurityEnhanced = new ErrorCodesSecurityEnhanced(err.getReturnCode());
			responseData = errorCodesSecurityEnhanced.getMessageError();
			enhancedSecuritySession.cancel();
		}
		return responseData;
	}

	@Override
	public String createUserPassword(String userIdAdmin, String passwordUserAdmin, String userIdOperator, String newPassword) 
	{
		logger.info("Inicia createUserPassword");
		String responseData = null;
		EnhancedSecuritySession enhancedSecuritySession = null;
		try
		{
			enhancedSecuritySession = EnhancedSecurity.startSession(userIdAdmin, passwordUserAdmin);
			AuthorizationRecord authorizationUser = enhancedSecuritySession.getRecord(userIdOperator);
			authorizationUser.setPassword(newPassword, true);
			responseData = "true";
			enhancedSecuritySession.commit();
		} catch(FlexosException err)
		{
			logger.error(err.getLocalizedMessage());
			ErrorCodesSecurityEnhanced errorCodesSecurityEnhanced = new ErrorCodesSecurityEnhanced(err.getReturnCode());
			responseData = errorCodesSecurityEnhanced.getMessageError();
			try {
				enhancedSecuritySession.cancel();
			} catch (FlexosException e) {
				logger.error(e.getLocalizedMessage());
			}
			
		} 
		return responseData;
	}
	
}
