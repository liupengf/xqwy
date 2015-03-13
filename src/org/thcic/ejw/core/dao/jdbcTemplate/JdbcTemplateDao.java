package org.thcic.ejw.core.dao.jdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateDao<T> {

	private static final Logger logger = Logger
			.getLogger(JdbcTemplateDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// /**
	// * 查询分页DataTablePageList 返回Map<String,Object>
	// *
	// * @return
	// */
	// @SuppressWarnings("deprecation")
	// public DataTablePageList queryForDataTablePageListByJdbcTemplate(
	// String sql, Object[] object, int displayStart, int displayLength) {
	// PageInfo pageInfo = new PageInfo();
	//
	// // 设置每页显示记录数
	// pageInfo.setPerPageNum(displayLength);
	// // 设置要显示的页数
	// pageInfo.setCurrentPage(displayStart);
	// // 下一页
	// pageInfo.setNextPage(displayStart + 1);
	// // 上一页
	// pageInfo.setPrePage(displayStart - 1);
	//
	// // 计算总记录数
	// StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
	// totalSQL.append(sql);
	// totalSQL.append(" ) totalTable ");
	//
	// // 总记录数
	// long totalStartTime = new Date().getTime();
	// try {
	// pageInfo.setTotalRows(jdbcTemplate.queryForInt(totalSQL.toString(),
	// object));
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
	// }
	// logger.info(getSqlExecuteTimeLog(totalSQL.toString(),
	// new Date().getTime() - totalStartTime));
	//
	// // 计算总页数
	// pageInfo.setTotalPages();
	//
	// // 计算起始行数
	// int startIndex = displayStart;
	// // 计算结束行数
	// int LastIndext = displayStart + displayLength <= pageInfo
	// .getTotalRows() ? displayStart + displayLength : pageInfo
	// .getTotalRows();
	//
	// // 构造oracle数据库的分页语句
	// StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
	// paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
	// paginationSQL.append(sql);
	// paginationSQL.append("　) temp where ROWNUM <= " + LastIndext);
	// paginationSQL.append(" ) WHERE　num > " + startIndex);
	// // 装入结果集
	// long paginationSQLStartTime = new Date().getTime();
	// try {
	// pageInfo.setResultList(jdbcTemplate.queryForList(
	// paginationSQL.toString(), object));
	// } catch (Exception e) {
	// logger.error(this.getSqlExcuteErrorLog(paginationSQL.toString()),
	// e.getCause());
	// }
	// logger.info(getSqlExecuteTimeLog(paginationSQL.toString(),
	// new Date().getTime() - paginationSQLStartTime));
	//
	// DataTablePageList dtpl = new DataTablePageList(String.valueOf(pageInfo
	// .getTotalRows()), pageInfo.getResultList());
	// return dtpl;
	// }
	//
	// /**
	// * 查询分页DataTablePageList 返回Map<String,Object>
	// *
	// * @return
	// */
	// @SuppressWarnings("deprecation")
	// public DataTablePageList
	// queryForDataTablePageListByJdbcTemplateForObject(
	// String sql, Object[] object, int displayStart, int displayLength,
	// Object obj) {
	// PageInfo pageInfo = new PageInfo();
	//
	// // 设置每页显示记录数
	// pageInfo.setPerPageNum(displayLength);
	// // 设置要显示的页数
	// pageInfo.setCurrentPage(displayStart);
	// // 下一页
	// pageInfo.setNextPage(displayStart + 1);
	// // 上一页
	// pageInfo.setPrePage(displayStart - 1);
	//
	// // 计算总记录数
	// StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
	// totalSQL.append(sql);
	// totalSQL.append(" ) totalTable ");
	//
	// // 总记录数
	// long totalStartTime = new Date().getTime();
	// try {
	// pageInfo.setTotalRows(jdbcTemplate.queryForInt(totalSQL.toString(),
	// object));
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
	// }
	// logger.info(getSqlExecuteTimeLog(totalSQL.toString(),
	// new Date().getTime() - totalStartTime));
	//
	// // 计算总页数
	// pageInfo.setTotalPages();
	// // 计算起始行数
	// pageInfo.setStartIndex();
	// // 计算结束行数
	// pageInfo.setLastIndex();
	//
	// // 构造oracle数据库的分页语句
	// StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
	// paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
	// paginationSQL.append(sql);
	// paginationSQL.append("　) temp where ROWNUM <= "
	// + pageInfo.getLastIndex());
	// paginationSQL.append(" ) WHERE　num > " + pageInfo.getStartIndex());
	// // 装入结果集
	// long paginationSQLStartTime = new Date().getTime();
	// try {
	// // List<Object> objList=new ArrayList<Object>();
	// List<Map<String, Object>> mapList = jdbcTemplate.queryForList(
	// paginationSQL.toString(), object);
	// /*
	// * if(mapList!=null&&mapList.size()>0){ for (Map<String,Object>
	// * map:mapList) { ConvertUtil.mapToBean(map, obj); objList.add(obj);
	// * } }
	// */
	// pageInfo.setResultList(mapList);
	// } catch (Exception e) {
	// logger.error(this.getSqlExcuteErrorLog(paginationSQL.toString()),
	// e.getCause());
	// e.printStackTrace();
	// }
	// logger.info(getSqlExecuteTimeLog(paginationSQL.toString(),
	// new Date().getTime() - paginationSQLStartTime));
	//
	// DataTablePageList dtpl = new DataTablePageList(String.valueOf(pageInfo
	// .getTotalRows()), pageInfo.getResultList());
	// return dtpl;
	// }

	/**
	 * 查询分页对象
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public PageInfo queryForPageInfo(String sql, int currentPage, int perPageNum) {
		PageInfo pageInfo = new PageInfo();

		// 设置每页显示记录数
		pageInfo.setPerPageNum(perPageNum);
		// 设置要显示的页数
		pageInfo.setCurrentPage(currentPage);
		// 下一页
		pageInfo.setNextPage(currentPage + 1);
		// 上一页
		pageInfo.setPrePage(currentPage - 1);

		// 计算总记录数
		StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
		totalSQL.append(sql);
		totalSQL.append(" ) totalTable ");

		// 总记录数
		long totalStartTime = new Date().getTime();
		try {
			pageInfo.setTotalRows(jdbcTemplate.queryForInt(totalSQL.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
		}
		logger.info(getSqlExecuteTimeLog(totalSQL.toString(),
				new Date().getTime() - totalStartTime));

		// 计算总页数
		pageInfo.setTotalPages();
		// 计算起始行数
		pageInfo.setStartIndex();
		// 计算结束行数
		pageInfo.setLastIndex();

		// 构造oracle数据库的分页语句
		StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		paginationSQL.append(sql);
		paginationSQL.append("　) temp where ROWNUM <= "
				+ pageInfo.getLastIndex());
		paginationSQL.append(" ) WHERE　num > " + pageInfo.getStartIndex());
		// 装入结果集
		long paginationSQLStartTime = new Date().getTime();
		try {
			pageInfo.setResultList(jdbcTemplate.queryForList(paginationSQL
					.toString()));
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(paginationSQL.toString()),
					e.getCause());
		}
		logger.info(getSqlExecuteTimeLog(paginationSQL.toString(),
				new Date().getTime() - paginationSQLStartTime));
		return pageInfo;
	}

	/**
	 * 查询分页对象
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public PageInfo queryForPageInfo(String sql, Object[] object,
			int currentPage, int perPageNum) {
		PageInfo pageInfo = new PageInfo();

		// 设置每页显示记录数
		pageInfo.setPerPageNum(perPageNum);
		// 设置要显示的页数
		pageInfo.setCurrentPage(currentPage);
		// 下一页
		pageInfo.setNextPage(currentPage + 1);
		// 上一页
		pageInfo.setPrePage(currentPage - 1);

		// 计算总记录数
		StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
		totalSQL.append(sql);
		totalSQL.append(" ) totalTable ");

		// 总记录数
		long totalStartTime = new Date().getTime();
		try {
			pageInfo.setTotalRows(jdbcTemplate.queryForInt(totalSQL.toString(),
					object));
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
		}
		logger.info(getSqlExecuteTimeLog(totalSQL.toString(),
				new Date().getTime() - totalStartTime));

		// 计算总页数
		pageInfo.setTotalPages();
		// 计算起始行数
		pageInfo.setStartIndex();
		// 计算结束行数
		pageInfo.setLastIndex();

		// 构造oracle数据库的分页语句
		StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		paginationSQL.append(sql);
		paginationSQL.append("　) temp where ROWNUM <= "
				+ pageInfo.getLastIndex());
		paginationSQL.append(" ) WHERE　num > " + pageInfo.getStartIndex());
		// 装入结果集
		long paginationSQLStartTime = new Date().getTime();
		try {
			pageInfo.setResultList(jdbcTemplate.queryForList(
					paginationSQL.toString(), object));
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(paginationSQL.toString()),
					e.getCause());
		}
		logger.info(getSqlExecuteTimeLog(paginationSQL.toString(),
				new Date().getTime() - paginationSQLStartTime));
		return pageInfo;
	}

	/**
	 * 返回String
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public String queryForString(String sql) {
		long startTime = new Date().getTime();
		Object obj = null;
		try {
			obj = this.jdbcTemplate.queryForObject(sql, String.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return null != obj ? (String) obj : null;
	}

	/**
	 * 返回String
	 * 
	 * @param sql
	 * @param object
	 * @return
	 */
	public String queryForString(String sql, Object[] object) {
		long startTime = new Date().getTime();
		Object obj = null;
		try {
			obj = this.jdbcTemplate.queryForObject(sql, object, String.class);
		} catch (Exception e) {
			// e.printStackTrace();

			return null;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return null != obj ? (String) obj : null;
	}

	/**
	 * 根据一列或者几列查询返回对象
	 * 
	 * @param sql
	 * @param objectArray
	 * @param oclass
	 * @return
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object queryForObject(String sql, Class oclass) {
		long startTime = new Date().getTime();
		Object obj = null;
		try {
			obj = this.jdbcTemplate.queryForObject(sql,
					new BeanPropertyRowMapper(oclass));
		} catch (Exception e) {
			e.printStackTrace();
			return obj;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return obj;
	}

	/**
	 * 根据一列或者几列查询返回对象
	 * 
	 * @param sql
	 * @param objectArray
	 * @param oclass
	 * @return
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object queryForObject(String sql, Object[] object, Class oclass) {
		long startTime = new Date().getTime();
		Object obj = null;
		try {
			obj = this.jdbcTemplate.queryForObject(sql, object,
					new BeanPropertyRowMapper(oclass));
		} catch (Exception e) {
			e.printStackTrace();
			return obj;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return obj;
	}

	/**
	 * query.
	 * 
	 * 计算总记录数
	 * 
	 * @param sql
	 */
	@SuppressWarnings("deprecation")
	public int queryForInt(String sql, Object[] object) {
		long startTime = new Date().getTime();
		int n = 0;
		try {
			n = this.jdbcTemplate.queryForInt(sql, object);
		} catch (Exception e) {
			e.printStackTrace();
			return n;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * query.
	 * 
	 * 计算总记录数
	 * 
	 * @param sql
	 */
	@SuppressWarnings("deprecation")
	public int queryForInt(String sql) {
		long startTime = new Date().getTime();
		int n = 0;
		try {
			n = this.jdbcTemplate.queryForInt(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return n;
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * query.
	 * 
	 * 返回复合条件所有记录
	 * 
	 * @param sql
	 * @param object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<HashMap<String, Object>> queryForList(String sql,
			Object[] object) {
		long startTime = new Date().getTime();
		List list = null;
		try {
			list = this.jdbcTemplate.queryForList(sql, object);
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
		}
		long endTime = new Date().getTime();
		logger.info(getSqlExecuteTimeLog(sql, endTime - startTime));
		return list;
	}

	/**
	 * query.
	 * 
	 * 返回复合条件所有记录
	 * 
	 * @param sql
	 * @param object
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> queryForList(String sql, Object[] object, Class oclass) {
		long startTime = new Date().getTime();
		List<T> beanList = new ArrayList();

		try {
			List mapList = this.jdbcTemplate.queryForList(sql, object);
			for (int i = 0; null != mapList && i < mapList.size(); i++) {
				BeanUtils.populate(oclass, (HashMap) mapList.get(i));
				beanList.add((T) oclass);
			}
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
		}
		long endTime = new Date().getTime();
		logger.info(getSqlExecuteTimeLog(sql, endTime - startTime));
		return beanList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<HashMap<String, Object>> queryForList(String sql) {
		long startTime = new Date().getTime();
		List list = null;
		try {
			list = this.jdbcTemplate.queryForList(sql);
		} catch (Exception e) {
			logger.error(this.getSqlExcuteErrorLog(sql), e.getCause());
		}
		long endTime = new Date().getTime();
		logger.info(getSqlExecuteTimeLog(sql, endTime - startTime));
		return list;
	}

	/**
	 * UPDATE或INSERT.
	 * 
	 * 不带参数update or insert or delete
	 * 
	 * @param sql
	 */

	public int update(String sql) {
		long startTime = new Date().getTime();
		int n = this.jdbcTemplate.update(sql);
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
		return n;
	}

	/**
	 * UPDATE或INSERT.
	 * 
	 * 带参数update or insert or delete
	 * 
	 * @param sql
	 * @param object
	 */

	public int update(String sql, Object[] object) {
		long startTime = new Date().getTime();
		int n = this.jdbcTemplate.update(sql, object);
		long endTime = new Date().getTime();
		logger.info(getSqlExecuteTimeLog(sql, endTime - startTime));
		return n;
	}

	/**
	 * UPDATE或INSERT.
	 * 
	 * 批量update or insert or delete
	 * 
	 * @param sql
	 * @param object
	 */
	public int[] batchUpdate(String sql[]) {
		long startTime = new Date().getTime();
		int n[] = this.jdbcTemplate.batchUpdate(sql);
		long endTime = new Date().getTime();
		logger.info(getSqlExecuteTimeLog(sql.toString(), endTime - startTime));
		return n;
	}

	/**
	 * execute
	 * 
	 * 执行sql语句
	 * 
	 * @param sql
	 */

	public void execute(String sql) {
		long startTime = new Date().getTime();
		try {
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info(getSqlExecuteTimeLog(sql, new Date().getTime() - startTime));
	}

	/**
	 * 获得seq最大值
	 * 
	 * @param seqName
	 * @return
	 */
	public String getSeqByName(String seqName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append(seqName + "." + "nextVal");
		sql.append(" as seq from dual");

		String seq = (String) jdbcTemplate.queryForObject(sql.toString(),
				String.class);
		return seq;
	}

	/**
	 * 获取某列最大值
	 * 
	 * @param tableName
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int queryMaxValueForColumn(String tableName, String columnName) {
		StringBuffer sql = new StringBuffer();
		sql.append("select max(to_number(" + columnName + ")) from ");
		sql.append(tableName);
		int num = this.jdbcTemplate.queryForInt(sql.toString()) + 1;
		return num;
	}

	/**
	 * 生成log
	 * 
	 * @param sql
	 * @param time
	 * @return
	 */
	public String getSqlExecuteTimeLog(String sql, long time) {
		StringBuffer temp = new StringBuffer();
		temp.append(sql);
		temp.append(" --- ");
		temp.append(time);
		temp.append("毫秒");
		return temp.toString();
	}

	/**
	 * 
	 * @param sql
	 * @return
	 */
	public String getSqlExcuteErrorLog(String sql) {
		StringBuffer temp = new StringBuffer();
		temp.append("执行");
		temp.append(sql);
		temp.append("出现异常!原因如下:");
		return temp.toString();
	}

	public <E> List<E> queryForObjectList(String sql, Object[] args,
			Class<E> mappedClass) {
		return this.jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<E>(
				mappedClass));
	}
}
