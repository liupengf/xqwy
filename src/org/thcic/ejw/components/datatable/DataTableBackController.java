package org.thcic.ejw.components.datatable;

import org.thcic.ejw.core.ro.ControllerResult;
import org.thcic.ejw.core.ro.PageList;
import org.thcic.ejw.core.web.back.BackBaseController;

public abstract class DataTableBackController<T, V> extends
		BackBaseController<T, V> {

	protected abstract Class<? extends DataTableQo> getQoClass();

	/**
	 * 获得分页列表
	 * 
	 * @param aoData
	 *            DataTable传值json
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult queryDataTablePageList(String aoData)
			throws Exception {
		DataTableQo dtq = DataTableUtil.parseDataTableQo(aoData, getQoClass());
		return queryDataTablePageList(dtq);
	}

	/**
	 * 获得分页列表
	 * 
	 * @param dtq
	 *            DataTableQo对象
	 * @return ControllerResult
	 * @throws Exception
	 */
	public ControllerResult queryDataTablePageList(DataTableQo dtq)
			throws Exception {
		return ControllerResult.valueOf(ControllerResult.SUCCESS,
				createDataTablePageList(getService().queryPageList(dtq), dtq));
	}




	/**
	 * 封装DataTablePageList对象
	 * 
	 * @param pageList
	 *            PageList对象
	 * @param dtq
	 *            DataTableQo对象
	 * @return DataTablePageList
	 */
	public DataTablePageList createDataTablePageList(PageList pageList,
			DataTableQo dtq) {
		DataTablePageList dtpl = new DataTablePageList();
		// 需要的三个参数
		dtpl.setiTotalRecords(String.valueOf(pageList.getTotal()));
		dtpl.setiTotalDisplayRecords(String.valueOf(pageList.getTotal()));
		dtpl.setAaData(pageList.getResultsList());
		// 获取页面参数再传递回去
		dtpl.setsEcho(dtq.getsEcho());
		dtpl.setsSearch(dtq.getsSearch());
		dtpl.setiDisplayStart(dtq.getiDisplayStart());
		dtpl.setiDisplayLength(dtq.getiDisplayLength());
		return dtpl;
	}
}
