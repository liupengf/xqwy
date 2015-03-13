/**
 * 
 */
package org.thcic.ejw.core.web.back;

import java.io.Serializable;
import org.thcic.ejw.core.dto.Dto;
import org.thcic.ejw.core.qo.Qo;
import org.thcic.ejw.core.ro.ControllerResult;
import org.thcic.ejw.core.service.BaseService;

/**
 * BackController基类
 * 
 * @param <T>
 * @param <V>
 * 
 */
public abstract class BackBaseController<T, V> {

	protected abstract BaseService<T, V> getService();

	/**
	 * 获得分页列表
	 * 
	 * @param qo
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult queryPageList(Qo qo) throws Exception {
		return ControllerResult.valueOf(ControllerResult.SUCCESS, getService()
				.queryPageList(qo));
	}

	/**
	 * 获得详细信息
	 * 
	 * @param seq
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult queryById(Serializable seq) throws Exception {
		return ControllerResult.valueOf(ControllerResult.SUCCESS, getService()
				.queryById(seq));
	}

	/**
	 * 添加一条数据
	 * 
	 * @param dto
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult add(Dto dto) throws Exception {
		getService().add(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}
	public ControllerResult addEntity(T t) throws Exception {
		getService().addEntity(t);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}

	/**
	 * 修改一条数据
	 * 
	 * @param dto
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult edit(Dto dto) throws Exception {
		getService().edit(dto);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}
	public ControllerResult editEntity(T t) throws Exception {
		getService().editEntity(t);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}

	/**
	 * 删除一条或多条数据
	 * 
	 * @param seqArray
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult del(int... seqArray) throws Exception {
		getService().del(seqArray);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}

	/**
	 * 删除一条或多条数据
	 * 
	 * @param seqArray
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult del(String... seqArray) throws Exception {
		getService().del(seqArray);
		return ControllerResult.valueOf(ControllerResult.SUCCESS, "操作成功！");
	}



}
