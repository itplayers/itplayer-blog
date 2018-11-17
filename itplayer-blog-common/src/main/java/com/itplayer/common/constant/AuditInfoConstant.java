package com.itplayer.common.constant;

/**  
* @author: libaigang
* @date: 2018年11月14日  
*/
public class AuditInfoConstant {

	
	public static final String AUDIT_TASK_ADD_INFO = "新增正式任务，任务名称为%s";
	public static final String AUDIT_TASK_UPDATE_INFO = "修改正式任务，任务名称为%s";
	public static final String AUDIT_TASK_DELETE_INFO = "删除正式任务，任务名称为%s";
	
	public static final String AUDIT_POLICY_ADD_INFO = "新增任务策略，策略编码为%s";
	public static final String AUDIT_POLICY_UPDATE_INFO = "修改任务策略，策略编码为%s";
	public static final String AUDIT_POLICY_DELETE_INFO = "删除任务策略，策略编码为%s";
	
	public static final String AUDIT_APP_UPDATE_INFO = "修改应用信息，应用名称为[%s]，编码为[%s]";
	public static final String AUDIT_APP_DELETE_INFO = "删除应用信息，应用名称为[%s]，编码为[%s]";
	
	public static final String AUDIT_APP_VERSION_UPDATE_INFO = "修改应用版本信息，版本所属应用[%s]，版本号为[%s]，版本说明[%s]";
	public static final String AUDIT_APP_VERSION_DELETE_INFO = "删除应用版本信息，版本所属应用[%s]，版本号为[%s]，版本说明[%s]";
	
	public static final String AUDIT_APP_SCOPE_FILE_UPDATE_INFO = "修改版本文件信息，所属应用[%s]，所属版本[%s]，厂商信息为[%s]";
	public static final String AUDIT_APP_SCOPE_FILE_DELETE_INFO = "删除版本文件信息，所属应用[%s]，所属版本[%s]，厂商信息为[%s]";
	
	public static final String AUDIT_CFG_UPDATE_INFO = "修改配置信息，配置名称为[%s]，配置编码为[%s]，配置版本为[%s]";
	public static final String AUDIT_CFG_DELETE_INFO = "删除配置信息，配置名称为[%s]，配置编码为[%s]，配置版本为[%s]";
	
	public static final String AUDIT_ADD_WAITING = "新增数据，等待审核";
	public static final String AUDIT_UPDATE_WAITING = "修改中，等待审核";
	public static final String AUDIT_DELETE_WAITING = "删除中，等待审核";
	public static final String AUDIT_STR = "审核中";
	public static final String AUDIT_FAIL = "审核不通过";
	public static final String AUDIT_SUCCESS = "审核通过";
	
}
