package by.htp.epam.cinema.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.htp.epam.cinema.db.dao.UserDao;
import by.htp.epam.cinema.db.pool.ConnectionPool;
import by.htp.epam.cinema.domain.User;

public class UserDaoImpl implements UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private final String SQL_QUERY_USER_CREATE = "INSERT INTO `cinema_v2.0`.`users` (`login`, `email`, `password`, `role_id`) VALUES (?,?,?,?);";
	private final String SQL_QUERY_USER_READ = "SELECT `id`, `login`, `email`, `password`, `role_id` FROM `cinema_v2.0`.`users` WHERE `id`=?;";
	private final String SQL_QUERY_USER_READ_BY_LOGIN_AND_PASSWORD = "SELECT `id`, `login`, `email`, `password`, `role_id` FROM `cinema_v2.0`.`users` WHERE `login`=? AND `password`=?;";
	private final String SQL_QUERY_USER_READ_ALL = "SELECT `id`, `login`, `email`, `password`, `role_id` FROM `cinema_v2.0`.`users`;";
	private final String SQL_QUERY_USER_UPDATE = "UPDATE `cinema_v2.0`.`users` SET `login`=?, `email`=?, `password`=?, `role_id`=? WHERE `id`=?;";
	private final String SQL_QUERY_USER_DELETE = "DELETE FROM `cinema_v2.0`.`users` WHERE  `id`=?;";

	@Override
	public void create(User entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_CREATE)) {
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setInt(4, entity.getRole_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in create method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public User read(int id) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read(int id) method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public User read(String login, String password) {
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_READ_BY_LOGIN_AND_PASSWORD)) {
			ps.setString(1, login);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
				return buildUser(rs);
		} catch (SQLException e) {
			logger.error("SQLException in read(String login, String password) method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return null;
	}

	@Override
	public List<User> readAll() {
		List<User> users = null;
		ResultSet rs = null;
		Connection con = ConnectionPool.getConnection();
		try (Statement ps = con.createStatement()) {
			rs = ps.executeQuery(SQL_QUERY_USER_READ_ALL);
			users = new ArrayList<>();
			while (rs.next()) {
				users.add(buildUser(rs));
			}
		} catch (SQLException e) {
			logger.error("SQLException in readAll method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
			close(rs);
		}
		return users;
	}

	@Override
	public void update(User entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_UPDATE)) {
			ps.setString(1, entity.getLogin());
			ps.setString(2, entity.getEmail());
			ps.setString(3, entity.getPassword());
			ps.setInt(4, entity.getRole_id());
			ps.setInt(5, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in update method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	@Override
	public void delete(User entity) {
		Connection con = ConnectionPool.getConnection();
		try (PreparedStatement ps = con.prepareStatement(SQL_QUERY_USER_DELETE)) {
			ps.setInt(1, entity.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQLException in delete method of UserDaoImpl class", e);
		} finally {
			ConnectionPool.putConnection(con);
		}
	}

	private User buildUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setLogin(rs.getString("login"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setRole_id(Integer.parseInt(rs.getString("role_id")));
		return user;
	}

	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("SQLException in close method of UserDaoImpl class", e);
			}
		}
	}
}