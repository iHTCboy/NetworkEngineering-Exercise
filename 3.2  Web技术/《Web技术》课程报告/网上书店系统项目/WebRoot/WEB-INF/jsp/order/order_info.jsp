<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/page_bottom.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%@include file="/common/head1.jsp"%>
		<div class="login_step">
			生成订单骤:
			<span class="red_bold">1.确认订单</span> > 2.填写送货地址 > 3.订单成功
		</div>
		<div class="fill_message">

			<table class="tab_login">
				<tr>
					<td valign="top" class="w1" style="text-align: left">
						<b>序号</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品名称</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品单价</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>商品数量</b>
					</td>
					<td valign="top" class="w1" style="text-align: left">
						<b>小计</b>
					</td>
				</tr>
				<s:iterator value="#session.cartList">
                      <s:if test="type">
				<!-- 订单开始 -->
					<tr>
						<td valign="top">
							1
						</td>
						<td valign="top">
							<s:property value="book.productName"/>
						</td>
						<td valign="top">
							<s:property value="book.dangPrice"/>
						</td>
						<td valign="top">
							<s:property value="qty"/>
						</td>
						<td valign="top">
							<s:property value="book.dangPrice*qty"/>
						</td>
					</tr>
						
					
				<!-- 订单结束 -->
				</s:if>
						</s:iterator>
				<tr>
					<td valign="top" class="w1" style="text-align: left" colspan="5">
						<b>总价￥<s:property value="totalAccount"/></b>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<br />
			<div class="login_in">
				<a href="${pageContext.request.contextPath}/cart/cartListAction"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="取消" /></a>
			
				<a href="${pageContext.request.contextPath}/order/addressFormAction"><input id="btnClientRegister" class="button_1" name="submit"
					type="submit" value="下一步" /></a>
		
			</div>

		</div>
		<%@include file="/common/foot1.jsp"%>
	</body>
</html>

