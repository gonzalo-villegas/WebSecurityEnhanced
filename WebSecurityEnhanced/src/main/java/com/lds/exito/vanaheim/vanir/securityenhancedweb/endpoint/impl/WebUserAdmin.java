/**
 * 
 */
package com.lds.exito.vanaheim.vanir.securityenhancedweb.endpoint.impl;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.OS4690.FlexosException;
import com.lds.exito.vanaheim.vanir.securityenhancedweb.endpoint.IWebUserAdmin;
import com.lds.exito.vanaheim.vanir.securityenhancedweb.service.extension.ErrorCodesSecurityEnhanced;
import com.lds.exito.vanaheim.vanir.securityenhancedweb.service.impl.WebUserAdminBusiness;


/**
 * @author jorge.lima
 *
 */
@Path(value = "/validation")
public class WebUserAdmin implements IWebUserAdmin
{
	private static Logger logger = LoggerFactory.getLogger(WebUserAdmin.class);
	
	@GET
	@Path(value = "/isavalible")
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Response securityEnhancedAvalible() 
	{
		logger.info("Inicia isavalible/securityEnhancedAvalible - WebUserAdmin capa de servicios");
		String responseData = null;
		boolean statusSecurityEnhance = true;
		//WebUserAdminBusiness webUserAdminB = new WebUserAdminBusiness();
		try
		{
			//statusSecurityEnhance = webUserAdminB.isAvalibleSecurityEnhanced();
			if(statusSecurityEnhance)
			{
				logger.debug("SecurityEnhanced si avalible");
				responseData = "{\"isavalible\":\"true\"}";
			} else
			{
				responseData = "{\"isavalible\":\"false\"}";
			}
		} catch(Exception er)
		{
			responseData = "{\"status\":\"false\"}";
			logger.error("error validando estado de seguridad mejorada: {}", er.getLocalizedMessage());
			return Response.status(500).type(MediaType.APPLICATION_JSON).entity(responseData).build();
		}
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(responseData).build();
	}

	@Override
	@POST
	@Path(value = "/isvalid/{userId}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response isUserValid(@PathParam("userId") String userId, @PathParam("password") String userPassword) 
	{
		logger.info("Inicia isUserValid - WebUserAdmin capa de servicios");
		String userIdIsValid = null;
		String userIdIsAuthorized = null;
		WebUserAdminBusiness webUserAdminB = new WebUserAdminBusiness();
		try
		{
			userIdIsValid = webUserAdminB.isUserValid(userId, userPassword);
			if(userIdIsValid.equals("true"))
			{
				try
				{
					logger.info("usuario valido se procede a validar permiso \"ENHANCED_SECURITY\"");
					userIdIsAuthorized = webUserAdminB.isUserAuthorizedSecurityEnhanced(userId, userPassword);	
				} catch (Exception er)
				{
					logger.error(er.getLocalizedMessage());
				}
				
			} else 
			{
				userIdIsAuthorized = "{\"isvalid\":false}";
			}
		} catch(FlexosException e)
		{
			ErrorCodesSecurityEnhanced errorCodesSecurityEnhanced = new ErrorCodesSecurityEnhanced(e.getReturnCode());
			userIdIsAuthorized = "{\"status\":" + errorCodesSecurityEnhanced.getMessageError() + "}";
			logger.error("error validando si el usuario es valido: ".concat(userId));
			return Response.status(500).type(MediaType.APPLICATION_JSON).entity(userIdIsAuthorized).build();
		}
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(userIdIsAuthorized).build();
	}

	@Override
	@GET
	@Path(value = "/changepassword/{userIdAdmin}/{passwordUserAdmin}/{userIdOperator}/{passwordUserOperator}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPassword(@PathParam("userIdAdmin") String userIdAdmin, @PathParam("passwordUserAdmin") String passwordUserAdmin, 
			@PathParam("userIdOperator") String userIdOperator, @PathParam("passwordUserOperator") String newPassword) 
	{
		String changesPassword = null;
		try
		{
			WebUserAdminBusiness webUserAdminB = new WebUserAdminBusiness();
			changesPassword = webUserAdminB.createUserPassword(userIdAdmin, passwordUserAdmin, userIdOperator, newPassword);
			if(changesPassword.equals("true"))
			{
				changesPassword = "password successfully changed";
			} 
		}catch(Exception err)
		{
			changesPassword = err.getLocalizedMessage();
			logger.error(err.getLocalizedMessage());
			return Response.status(500).type(MediaType.APPLICATION_JSON).entity(changesPassword).build();
		}
		return Response.ok().type(MediaType.APPLICATION_JSON).entity(changesPassword).build();
	}
	
	
}
