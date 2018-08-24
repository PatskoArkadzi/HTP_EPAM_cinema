package by.htp.epam.cinema.web.action.impl;

import static by.htp.epam.cinema.web.util.HttpRequestParamFormatter.getInt;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.isPost;
import static by.htp.epam.cinema.web.util.HttpRequestParamValidator.validateRequestParamNotNull;
import static by.htp.epam.cinema.web.util.constant.ContextParamNameConstantDeclaration.*;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ADMIN_CHANGE_USER_ROLE;
import static by.htp.epam.cinema.web.util.constant.PageNameConstantDeclaration.PAGE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CHANGE_USER_ROLE_ACTION_INDEFINITE_ERROR;
import static by.htp.epam.cinema.web.util.constant.ResourceBundleKeysConstantDeclaration.ERROR_MSG_CHANGE_USER_ROLE_ACTION_USER_IS_NOT_ADMIN;
import static by.htp.epam.cinema.web.util.constant.ActionNameConstantDeclaration.ACTION_NAME_CHANGE_USER_ROLE;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.epam.cinema.domain.Role;
import by.htp.epam.cinema.domain.User;
import by.htp.epam.cinema.service.RoleService;
import by.htp.epam.cinema.service.UserService;
import by.htp.epam.cinema.service.impl.RoleServiceImpl;
import by.htp.epam.cinema.service.impl.UserServiceImpl;
import by.htp.epam.cinema.web.action.BaseAction;
import by.htp.epam.cinema.web.util.HttpManager;
import by.htp.epam.cinema.web.util.ValidateNullParamException;

public class ChangeUserRoleAction implements BaseAction {

	private UserService userService = new UserServiceImpl();
	private RoleService roleService = new RoleServiceImpl();

	@Override
	public void executeAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!userService.isUserAdmin(request)) {
			request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_CHANGE_USER_ROLE_ACTION_USER_IS_NOT_ADMIN));
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
			return;
		}
		User user = null;
		List<Role> roles = roleService.getAll();
		try {
			if (isPost(request)) {
				String crudCommand = request.getParameter(REQUEST_PARAM_CRUD_COMMAND);
				validateRequestParamNotNull(crudCommand);
				switch (crudCommand) {
				case CRUD_COMMAND_READ:
					String userId = request.getParameter(REQUEST_PARAM_USER_ID);
					validateRequestParamNotNull(userId);
					user = userService.getUser(Integer.parseInt(userId));
					break;
				case CRUD_COMMAND_UPDATE:
					user = buildUser(request);
					userService.updateUser(user);
					break;
				}
				request.setAttribute(REQUEST_PARAM_FOUND_USER, user);
				request.setAttribute(REQUEST_PARAM_ROLELIST, roles);
				request.getRequestDispatcher(PAGE_ADMIN_CHANGE_USER_ROLE).forward(request, response);
				return;
			}
			request.getRequestDispatcher(PAGE_ADMIN_CHANGE_USER_ROLE).forward(request, response);
		} catch (ValidateNullParamException e) {
			request.setAttribute(REQUEST_PARAM_ERROR_MESSAGE,
					resourceManager.getValue(ERROR_MSG_CHANGE_USER_ROLE_ACTION_INDEFINITE_ERROR));
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
		}
	}

	private User buildUser(HttpServletRequest req) {
		String userId = req.getParameter(REQUEST_PARAM_USER_ID);
		String userLogin = req.getParameter(REQUEST_PARAM_USER_LOGIN);
		String userEmail = req.getParameter(REQUEST_PARAM_USER_EMAIL);
		String userPassword = req.getParameter(REQUEST_PARAM_USER_PASSWORD);
		String userSalt = req.getParameter(REQUEST_PARAM_USER_SALT);
		String userRoleId = req.getParameter(REQUEST_PARAM_USER_ROLE_ID);
		validateRequestParamNotNull(userId, userLogin, userEmail, userPassword, userSalt, userRoleId);

		User user = new User();
		user.setId(getInt(userId));
		user.setLogin(userLogin);
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		user.setSalt(userSalt);
		user.setRole_id(getInt(userRoleId));
		return user;
	}

}