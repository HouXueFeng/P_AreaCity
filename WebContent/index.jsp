<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {

		$("#province")
				.change(
						function() {
							/*选择新的省的时候删除原来所选省对应的市 */
							/*选择新的省的时候删除原来所选市对应的区 */
							$("#city option:gt(0)").remove();
							$("#area option:gt(0)").remove();
							/* 定位省份 */
							/* 获取选择的省份  */
							var pro = $("#province option:selected").val();
							$
									.ajax({
										url : '${pageContext.request.contextPath}/MyServlet2?time='
												+ new Date().getTime(),
										dataType : "JSON",
										type : "GET",
										/*把获取的编号传到ajax的data中进行省对应的市的判断  */
										data : {
											"code" : pro
										},
										success : function(data) {
											$.each(data,function(index,object) {
											var $option = $("<option value='"+object.code+"'>"
											+ object.name+ "</option>")
											$("#city").append($option);
											});
										},
										error : function(data) {
										}
								});
						});
	$("#city").change(
			function() {
				$("#area option:gt(0)").remove();
				/* 定位城市 */
				/* 获取选择的城市编号 */
				var pro = $("#city option:selected").val();
				$.ajax({
					/*把获取的编号传到ajax的data中进行地区的判断  */
					url : '${pageContext.request.contextPath}/MyServlet3?time='
							+ new Date().getTime(),
					dataType : "JSON",
					type : "GET",
					data : {
						"code" : pro
					},
					success : function(data) {
						$.each(data,function(index,object) {
							var $option = $("<option value='"+object.code+"'>"
							+ object.name+ "</option>")
							$("#area").append($option);
							});
					},
					error : function(data) {
					}
				});
			});

	});
</script>


</head>
<body>

	<select id="province">
		<c:forEach items="${proList}" var="province">
			<option value="${province.code}">${province.name}</option>
		</c:forEach>
	</select>

	<select id="city">
		<option>请选择城市</option>
	</select>
	<select id="area">
		<option>请选择</option>
	</select>
</body>
</html>