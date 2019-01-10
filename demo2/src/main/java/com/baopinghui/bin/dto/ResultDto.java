package com.baopinghui.bin.dto;



public class ResultDto {

	private int status;
	private String msg;
	private Object data;

	public static ResultDto createSuccess() {
		return new ResultDto(ResultDto.code.success, ResultDto.Msg.success1, null);
	}

	public static ResultDto createSuccess(Object data) {
		return new ResultDto(ResultDto.code.success, ResultDto.Msg.success1, data);
	}
	

	public static ResultDto createSuccess2() {
		return new ResultDto(ResultDto.code.success, ResultDto.Msg.success2, null);
	}

	public static ResultDto createSuccess3() {
		return new ResultDto(ResultDto.code.success, ResultDto.Msg.success3, null);
	}
	

	public static ResultDto createError(String errorMsg) {
		return new ResultDto(ResultDto.code.error, errorMsg, null);
	}

	public static ResultDto createError(String errorMsg, Object data) {
		return new ResultDto(ResultDto.code.error, errorMsg, data);
	}

	public static ResultDto createError1() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error1, null);
	}

	public static ResultDto createError2() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error2, null);
	}

	public static ResultDto createError7() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error7, null);
	}

	public static ResultDto createError8() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error8, null);
	}

	public static ResultDto createError9() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error9, null);
	}

	public static ResultDto createError10() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error10, null);
	}

	// 查询为空
	public static ResultDto createError3() {
		return new ResultDto(ResultDto.code.error, ResultDto.Msg.error3, null);
	}

	public ResultDto(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public interface code {
		public static final int error = 0;
		public static final int success = 1;
	}

	public interface Msg {
		public static final String error1 = "查询失败";
		public static final String error2 = "必要传参有null或空串";
		public static final String error3 = "查询为空";
		public static final String error4 = "用户不能关注自己";
		public static final String error5 = "已经关注了";
		public static final String error6 = "已经取消关注了";
		public static final String error7 = "replyId查找不到对应评论";
		public static final String error8 = "根据topicId和topicType找不到对应主题";
		public static final String error9 = "搜索服务不可用";
		public static final String error10 = "已存在,不能创建";
		public static final String success1 = "处理成功";
		public static final String success2 = "关注成功";
		public static final String success3 = "取消关注成功";
	}

}
