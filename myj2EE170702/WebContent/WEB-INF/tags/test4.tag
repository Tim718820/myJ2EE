<%@ tag dynamic-attributes="product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1" width="100%">
	<tr>
		<th>ITEM</th>
		<th>VALUE</th>
	</tr>
	<c:forEach var="prod" items="${product }">
		<tr>
			<td>${prod.key }</td>
			<td>${prod.value }</td>
		</tr>
	
	</c:forEach>


</table>