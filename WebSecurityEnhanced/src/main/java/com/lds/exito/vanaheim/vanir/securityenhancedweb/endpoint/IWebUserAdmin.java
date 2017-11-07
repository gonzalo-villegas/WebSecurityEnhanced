/**
 * 
 */
package com.lds.exito.vanaheim.vanir.securityenhancedweb.endpoint;

import javax.ws.rs.core.Response;

/**
 * @author jorge.lima
 *
 */
public interface IWebUserAdmin 
{
	public abstract Response securityEnhancedAvalible();
	public abstract Response isUserValid(String userId, String userPassword);
	public abstract Response createPassword(String userID, String passwordUserAdmin, String userIdOperator, String newPassword);
}
