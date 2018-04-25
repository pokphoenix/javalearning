<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/functions" prefix="f"%>

<jsp:useBean id="cons" class="com.pok.tutorial.web.utility.Constants"
	scope="page" />

<%@ page import="com.pok.tutorial.web.utility.Constants"%>

<%@ page import="java.io.*,java.util.*"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js" integrity="sha384-lZmvU/TzxoIQIOD9yQDEpvxp6wEU32Fy0ckUgOH4EIlMOCdR823rg4+3gWRwnX1M" crossorigin="anonymous"></script>
</head>
<body>

	<c:if test="${customFunction != null }">
		<h4>function string</h4>
		<p>${f:hello('pok')}</p>

		<h4>function int</h4>
		<p>12 + 30 = ${f:getSum(12,30)}</p>

		<h4>function long</h4>

		<c:set var="today" value="<%=new Date().getTime()%>" />

		<c:set var="postDate"
			value="<%=new Date().getTime() - (1000 * 60 * 60 * 24 * 2)%>" />

		<p>${ f:daysUntilToday(postDate) }</p>

		<c:set var="today" value="<%=new Date()%>" />
		<c:set var="postDate"
			value="<%=new Date(new Date().getTime() - 1000 * 60 * 60 * 24 * 2)%>" />
			Today: <fmt:formatDate type="both" value="${today}"
			pattern="${Constants.DATE_FORMATT} " />
		<BR>
			PostDate: <fmt:formatDate type="both" value="${postDate}"
			pattern="${Constants.DATE_FORMATT} " />

		<h4>Constants</h4>
		DATE_FORMATT : ${Constants.DATE_FORMATT}

	</c:if>



	<c:if test="${customArrays != null }">
			
		<c:forEach var="customArray" items="${customArrays}"
			varStatus="status">
			${customArray.t} : ${customArray.s} <BR>
		</c:forEach>

	</c:if>
	<c:if test="${intArray != null }">
			
		<c:forEach var="arr" items="${intArray}"
			varStatus="status">
			${arr} <BR>
		</c:forEach>

	</c:if>

	<c:if test="${sorts != null }">

		<c:forEach var="sort" items="${sorts}" varStatus="status">
			
			<BR> [${sort.key.t}] ${sort.key.s} ${sort.value.s}<BR>
			
		
			<c:forEach var="t" items="${sort.value.t}" >
				Key ${t.key} : [${t.value}] <BR>
			</c:forEach>
			
			
		<%-- 	
			${sort.value.t}
			<BR>
			
			<c:forEach var="t" items="${sort.value.s.s}" varStatus="status">
			Key ${t.key} : [${t.value}] <BR>
			</c:forEach>  --%>
			
		</c:forEach>

	</c:if>
	
	<c:if test="${genericSort !=null }">
		<c:forEach var="list" items="${genericSort}">
			<h2>${list.t}</h2>
			<div class="row text-center">
				
				<c:forEach var="s" items="${list.s}" >
					<div class="col-sm-2">
					<h4>${s.t}</h4>
						<c:forEach var="sort" items="${s.s}" >
							${sort.key } : ${sort.value }<BR>
						</c:forEach>
					</div>
				</c:forEach>
				
			</div>
			
			
			
			
			<%-- <c:forEach var="s" item="${sort.s}">
			 ${s}
			 </c:forEach>
			 --%>
			
		</c:forEach>
	</c:if>

	<c:if test="${sortGenericJava !=null}">
	
	 	
	
		<c:forEach var="list" items="${sortGenericJava}" >
			
			
			<H2>${list.key} </H2>
			
			<c:choose>
			  <c:when test="${list.value.result}">
			    	ID : ${list.value.id}<BR> 
					Name : ${list.value.name}<BR> 
				
				<c:if test="${list.key == 'company'}" >
					Address : ${list.value.address}
				</c:if>
			  </c:when>
			  
			  <c:otherwise>
			   		Error : ${list.value.error}
			  </c:otherwise>
			</c:choose>
						
		</c:forEach>
	
	
		<%--  result : ${sortGenericJava.result}<BR>
		 error : ${sortGenericJava.error}<BR>
		 
		 response<BR>
		 
		 ID : ${sortGenericJava.response.id}<BR>
		 NAME : ${sortGenericJava.response.name}<BR> --%>
		 
	
		<%-- ID : ${sortGenericJava.id}<BR>
		Name : ${sortGenericJava.name}<BR>
		Result : ${sortGenericJava.result}<BR>
		Error : ${sortGenericJava.error}<BR>
		Response : ${sortGenericJava.response}<BR> --%>
	</c:if>


	<%-- <c:set var="curDate" value="<%=  new Date().getTime() %>"/>
	${curDate}<BR>
	
	<c:set var="postDate" value="<%=  new Date().getTime()-(1000*60*60*24*7) %>"/>
	${postDate}<BR>
	
	${ f:daysUntilToday(curDate) } <BR> --%>


	<%-- <c:set var="postDate" value="${ new Date().getTime()-(1000*60*60*24*7) }"/>
	${postDate} <BR>
	<c:set var="curDate" value="${ new Date().getTime() }"/>
	${curDate} --%>
	<%-- ${f:getSum(12,30)} --%>

	<%-- 
	
	

	
	<h1>${f:daysUntilToday(postDate)}</h1>
	
	<P>The time on the server is ${serverTime}.</P>
 --%>
</body>
</html>
