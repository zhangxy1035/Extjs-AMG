package com.ow.action;

import java.io.IOException;
import java.util.List;
import net.sf.json.JSONArray;

import javax.annotation.Resource;

import com.ow.entity.WebOperator;
import com.ow.service.WebOperatorService;
import com.ow.util.ExtHelper;
import com.ow.util.Pager;




public class WebOperatorAction extends BaseAction {
	private static final long serialVersionUID = 6558439163716847431L;

	@Resource(name = "webOperatorServiceImpl")
	private WebOperatorService webOperatorService;

	private WebOperator webOperator;

	private int id;

	private Integer[] ids;

	// 显示校区
	public String index() {
		return INDEX;
	}

	// 获取校区数据
	public String getWebOperatorInfo() {
		int pageNo = Integer.parseInt(getRequest().getParameter("start"));
		int pageSize = Integer.parseInt(getRequest().getParameter("limit"));
		String hql = "from WebOperator webOperator";
		
		Pager<WebOperator> pager = webOperatorService.findByPage(pageNo, pageSize, hql);
		List<WebOperator> schoolList = pager.getPageList();
		System.out.println(schoolList+"schoolList打印数据");
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("results:" + pager.getTotalNum() + ",");
		sb.append("rows:");
		JSONArray jsonObject = JSONArray.fromObject(schoolList);
		System.out.println(schoolList+"打印数据");
		sb.append(jsonObject.toString());
		sb.append("}");
		getResponse().setContentType("text/json,charset=UTF-8");
		try {
			System.out.println(sb.toString());
			getResponse().getWriter().write(sb.toString());
		} catch (Exception e) {
		}
		return null;
	}

	// 添加校区
	public String add() {
		webOperatorService.save(webOperator);
		boolean success = true;
		getResponse().setContentType("text/json,charset=UTF-8");
		try {
			getResponse().getWriter().write("{success:" + success + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 修改校区
	public String update() {
		webOperatorService.merge(webOperator);
		boolean success = true;
		getResponse().setContentType("text/json,charset=UTF-8");
		try {
			getResponse().getWriter().write("{success:" + success + "}");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 删除校区
	public String delete() {
		webOperatorService.delete(ids);
		return null;
	}

	// 获取对应的校�?
	public String getSchoolById() {
		WebOperator webOperator = webOperatorService.findById(id);
		String json = null;
		if (webOperator != null) {
			json = "{success:true,data:" + ExtHelper.getJsonFromBean(webOperator)
					+ "}";
		} else {
			json = "{success:false}";
		}
		getResponse().setContentType("text/json,charset=UTF-8");
		try {
			getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	public WebOperator getWebOperator() {
		return webOperator;
	}

	public void setWebOperator(WebOperator webOperator) {
		this.webOperator = webOperator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
