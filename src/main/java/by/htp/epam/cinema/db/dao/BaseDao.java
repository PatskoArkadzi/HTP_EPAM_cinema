package by.htp.epam.cinema.db.dao;

import java.util.List;

import by.htp.epam.cinema.domain.BaseEntity;

/**
 * Interface provides CRUD methods for access to database data.
 * 
 * @author Arkadzi Patsko
 */
public interface BaseDao<T extends BaseEntity> {
	/**
	 * Adds entity to database
	 * 
	 * @param entity
	 *            creating entity
	 */
	void create(T entity);

	/**
	 * Gets entity from database
	 * 
	 * @param id
	 *            id of entity
	 * @return found entity
	 */
	T read(int id);

	/**
	 * Gets all certain kind entities from database
	 * 
	 * @return List of all entities
	 */
	List<T> readAll();

	/**
	 * Updates entity in database
	 * 
	 * @param entity
	 *            entity for update
	 */
	void update(T entity);

	/**
	 * Deletes entity from database
	 * 
	 * @param entityId
	 *            id of entity
	 */
	void delete(int entityId);
}