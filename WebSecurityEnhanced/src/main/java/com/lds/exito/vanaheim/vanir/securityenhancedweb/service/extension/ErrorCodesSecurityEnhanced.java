/**
 * 
 */
package com.lds.exito.vanaheim.vanir.securityenhancedweb.service.extension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jorge.lima
 *
 */
public class ErrorCodesSecurityEnhanced {
	
	private static Logger logger = LoggerFactory.getLogger(ErrorCodesSecurityEnhanced.class);
	private static final int ADX_CPW_ERR_ID_NOT_FOUND = 0x80E70001;
	private static final int ADX_CPW_ERR_ID_NOT_AUTHORIZED = 0x80E70002;
	private static final int ADX_CPW_ERR_PASSWORD_DOES_NOT_MATCH = 0x80E70003;
	private static final int ADX_CPW_ERR_PASSWORD_EXPIRED = 0x80E70004;
	private static final int ADX_CPW_ERR_ID_ALREADY_EXISTS = 0x80E70006;
	private static final int ADX_CPW_ERR_PASSWORD_SAME_AS_PREVIOUS = 0x80E70007;
	private static final int ADX_CPW_ERR_PASSWORD_CONTAINS_ID = 0x80E70008;
	private static final int ADX_CPW_ERR_PASSWORD_CONTAINS_SEQUENCE = 0x80E70009;
	private static final int ADX_CPW_ERR_PASSWORD_CONTAINS_REPETITION = 0x80E7000A;
	private static final int ADX_CPW_ERR_TOO_FEW_CHARACTERS_CHANGED = 0x80E7000B;
	private static final int ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_CHAR_OF_EACH_TYPE = 0x80E7000C;
	private static final int ADX_CPW_ERR_RECORD_LOCKED_BY_ANOTHER_SESSION = 0x80E7000D;
	private static final int ADX_CPW_ERR_SESSION_TIME_OUT = 0x80E7000E;
	private static final int ADX_CPW_ERR_INVALID_BUFFER = 0x80E7000F;
	private static final int ADX_CPW_ERR_SESSION_LIMIT_EXCEEDED = 0x80e70010;
	private static final int ADX_CPW_ERR_INVALID_SESSION_ID = 0x80E70011;
	private static final int ADX_CPW_ERR_INVALID_DATA = 0x80E70012;
	private static final int ADX_CPW_ERR_RECORD_NOT_LOCKED_BY_THIS_SESSION = 0x80E70013;
	private static final int ADX_CPW_ERR_INVALID_TARGET_ID = 0x80E70014;
	private static final int ADX_CPW_ERR_INVALID_PASSWORD = 0x80E70015;
	private static final int ADX_CPW_ERR_PASSWORD_TOO_SHORT = 0x80E70016;
	private static final int ADX_CPW_ERR_SERVICE_NOT_AVAILABLE = 0x80E70017;
	private static final int ADX_CPW_ERR_NOT_ACTING_MASTER = 0x80E70018;
	private static final int ADX_CPW_ERR_PASSWORD_FILE_FULL = 0x80E70019;
	private static final int ADX_CPW_ERR_UNEXPECTED_IO_ERROR = 0x80E7001A;
	private static final int ADX_CPW_ERR_UNSUPPORTED_FOR_MODELS = 0x80E7001B;
	private static final int ADX_CPW_ERR_MIN_PW_LENGTH_MISMATCH = 0x80E7001C;
	private static final int ADX_CPW_ERR_ATTRIBUTE_MISMATCH = 0x80E7001D;
	private static final int ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_ALPHA_AND_NUMERIC = 0x80E7001E;
	private static final int ADX_CPW_ERR_UNSUPPORTED_FOR_MASTER_RECORD = 0x80E7001F;
	private static final int ADX_CPW_ERR_UNAUTHORIZED_ATTRIBUTE_SET = 0x80E70020;
	private static final int ADX_CPW_ERR_AUTHORIZATION_LEVEL_ERROR = 0x80E70021;
	private static final int ADX_CPW_ERR_PASSWORD_SETTINGS_AUTHORIZATION_ERROR = 0x80E70022;
	private static final int ADX_CPW_ERR_TIMEOUT = 0x80E70023;
	
	
	
	
	
	
	
	private String messageError = null;
	
	public ErrorCodesSecurityEnhanced(int codeErrorOperation)
	{
		logger.info("Inicia ErrorCodesSecurityEnhanced");
		try
		{
			switch(codeErrorOperation)
			{
				case ADX_CPW_ERR_ID_NOT_FOUND: 
				{
					logger.error("ADX_CPW_ERR_ID_NOT_FOUND");
					setMessageError("user or password incorrect");
					break;
				}
				
				case ADX_CPW_ERR_ID_NOT_AUTHORIZED: 
				{
					logger.error("ADX_CPW_ERR_ID_NOT_AUTHORIZED");
					setMessageError("unauthorized userID");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_DOES_NOT_MATCH: 
				{
					logger.error("ADX_CPW_ERR_PASSWORD_DOES_NOT_MATCH");
					setMessageError("user or password incorrect");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_EXPIRED: 
				{
					logger.error("ADX_CPW_ERR_PASSWORD_EXPIRED");
					setMessageError("user password has expired");
					break;
				}
				
				case ADX_CPW_ERR_ID_ALREADY_EXISTS: 
				{
					logger.error("ADX_CPW_ERR_ID_ALREADY_EXISTS");
					setMessageError(" The given ID already exists and must be deleted before a record with this ID can be created or copied.");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_SAME_AS_PREVIOUS:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_SAME_AS_PREVIOUS");
					setMessageError(" The given ID already exists and must be deleted before a record with this ID can be created or copied.");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_CONTAINS_ID:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_CONTAINS_ID");
					setMessageError("The password contains the user’s ID. A\r\n" + 
							"different password must be selected.");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_CONTAINS_SEQUENCE:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_CONTAINS_SEQUENCE");
					setMessageError(" The password contains a sequence of more than 2 sequential characters ");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_CONTAINS_REPETITION:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_CONTAINS_REPETITION");
					setMessageError(" The password contains a string of more than 2 repeated characters.");
					break;
				}
				
				case ADX_CPW_ERR_TOO_FEW_CHARACTERS_CHANGED:
				{
					logger.error("ADX_CPW_ERR_TOO_FEW_CHARACTERS_CHANGED");
					setMessageError(" Too few characters in the new password have been changed.");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_CHAR_OF_EACH_TYPE:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_CHAR_OF_EACH_TYPE");
					setMessageError("The password does not contain at least one uppercase letter, "
							+ "one lowercase letter, one numeric character, and one special character");
					break;
				}
				
				case ADX_CPW_ERR_RECORD_LOCKED_BY_ANOTHER_SESSION:
				{
					logger.error("ADX_CPW_ERR_RECORD_LOCKED_BY_ANOTHER_SESSION");
					setMessageError("he user record is currently locked and cannot be accessed");
					break;
				}
				
				case ADX_CPW_ERR_SESSION_TIME_OUT:
				{
					logger.error("ADX_CPW_ERR_SESSION_TIME_OUT");
					setMessageError("The user’s session has been active for too long and has timed out.");
					break;
				}
				
				case ADX_CPW_ERR_INVALID_BUFFER:
				{
					logger.error("ADX_CPW_ERR_INVALID_BUFFER");
					setMessageError("This error is returned when there is a buffer error.");
					break;
				}
								
				case ADX_CPW_ERR_SESSION_LIMIT_EXCEEDED:
				{
					logger.error("ADX_CPW_ERR_SESSION_LIMIT_EXCEEDED");
					setMessageError("there are too many active sessions already in existence.");
					break;
				}
				
				case ADX_CPW_ERR_INVALID_SESSION_ID:
				{
					logger.error("ADX_CPW_ERR_INVALID_SESSION_ID");
					setMessageError("The session ID is not valid. This error is also " + 
							"returned on any API call that requires a session number, if the call is made when the enhanced " + 
							"security service is unavailable.");
					break;
				}
				
				case ADX_CPW_ERR_INVALID_DATA:
				{
					logger.error("ADX_CPW_ERR_INVALID_SESSION_ID");
					setMessageError("The data provided by the API is not valid. This error is " + 
							"returned when the provided data values or buffer contents are not valid or are out of range for the given API.");
					break;
				}
				
				case ADX_CPW_ERR_RECORD_NOT_LOCKED_BY_THIS_SESSION:
				{
					logger.error("ADX_CPW_ERR_INVALID_SESSION_ID");
					setMessageError("The record cannot be modified because it is not locked");
					break;
				}
				
				case ADX_CPW_ERR_INVALID_TARGET_ID:
				{
					logger.error("ADX_CPW_ERR_INVALID_SESSION_ID");
					setMessageError(" The requested target ID on a create or copy call is not valid.");
					break;
				}
				
				case ADX_CPW_ERR_INVALID_PASSWORD:
				{
					logger.error("ADX_CPW_ERR_INVALID_PASSWORD");
					setMessageError("The new password contains characters that are not valid.");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_TOO_SHORT:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_TOO_SHORT");
					setMessageError("The new password is too short.");
					break;
				}
				
				case ADX_CPW_ERR_SERVICE_NOT_AVAILABLE:
				{
					logger.error("ADX_CPW_ERR_SERVICE_NOT_AVAILABLE");
					setMessageError(" Enhanced Security is not configured and avalible");
					break;
				}
				
				case ADX_CPW_ERR_NOT_ACTING_MASTER:
				{
					logger.error("ADX_CPW_ERR_NOT_ACTING_MASTER");
					setMessageError("This controller is not the acting master or cannot contact the acting master");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_FILE_FULL:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_FILE_FULL");
					setMessageError("The password file is full, it contains the maximum 2048 entries");
					break;
				}
				
				case ADX_CPW_ERR_UNEXPECTED_IO_ERROR:
				{
					logger.error("ADX_CPW_ERR_UNEXPECTED_IO_ERROR");
					setMessageError("An unexpected file I/O error has occurred while processing this request.");
					break;
				}
				
				case ADX_CPW_ERR_UNSUPPORTED_FOR_MODELS:
				{
					logger.error("ADX_CPW_ERR_UNSUPPORTED_FOR_MODELS");
					setMessageError(" The ID is a model ID. The passwords for model records cannot be "
							+ "changed and model IDs cannot be used to validate a password.");
					break;
				}
				
				case ADX_CPW_ERR_MIN_PW_LENGTH_MISMATCH:
				{
					logger.error("ADX_CPW_ERR_MIN_PW_LENGTH_MISMATCH");
					setMessageError("This error is returned when the setting "+ 
							"change being made would result in an setting that is not valid for minimum password length");
					break;
				}
				
				case ADX_CPW_ERR_ATTRIBUTE_MISMATCH:
				{
					logger.error("ADX_CPW_ERR_ATTRIBUTE_MISMATCH");
					setMessageError("This error is returned when an attribute change " + 
							"being made would result in a set of attributes that is not valid");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_ALPHA_AND_NUMERIC:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_MUST_CONTAIN_ALPHA_AND_NUMERIC");
					setMessageError(" The password does not contain both an alphabetic character and a numeric character");
					break;
				}
				
				case ADX_CPW_ERR_UNSUPPORTED_FOR_MASTER_RECORD:
				{
					logger.error("ADX_CPW_ERR_UNSUPPORTED_FOR_MASTER_RECORD");
					setMessageError("The operation is not supported for "+ 
							"the master record of the file. Currently, the master record cannot be deleted.");
					break;
				}
				
				case ADX_CPW_ERR_UNAUTHORIZED_ATTRIBUTE_SET:
				{
					logger.error("ADX_CPW_ERR_UNAUTHORIZED_ATTRIBUTE_SET");
					setMessageError("This error is returned if a user tries to " + 
							"enable an attribute that is disabled in its own record");
					break;
				}
				
				case ADX_CPW_ERR_AUTHORIZATION_LEVEL_ERROR:
				{
					logger.error("ADX_CPW_ERR_AUTHORIZATION_LEVEL_ERROR");
					setMessageError(" This error is returned when a user " + 
							"attempts to lock a record that has an authorization level greater than its own");
					break;
				}
				
				case ADX_CPW_ERR_PASSWORD_SETTINGS_AUTHORIZATION_ERROR:
				{
					logger.error("ADX_CPW_ERR_PASSWORD_SETTINGS_AUTHORIZATION_ERROR");
					setMessageError(" This error is returned if the user tries to set global attributes "
							+ "and does not have Enhanced Security Password Settings enabled in the system attributes");
					break;
				}
				
				case ADX_CPW_ERR_TIMEOUT:
				{
					logger.error("ADX_CPW_ERR_TIMEOUT");
					setMessageError("This error is returned when an API request times out before completion.");
					break;
				}
			}
		} catch (Exception err)
		{
			logger.error(err.getLocalizedMessage());
		}	
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	
}
