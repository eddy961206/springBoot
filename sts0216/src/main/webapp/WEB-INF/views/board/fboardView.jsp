<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판 뷰 페이지</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
			table,th,td{border: 1px solid black; border-collapse: collapse;}
			h2{text-align:center;}
			table{width:920px; margin: 0 auto; text-align:center;}
			th,td{height:40px;}
			td{text-align:left; padding-left:30px;}
			div{width:500px; height:60px; margin:12px auto 0;}
			button{display: inline-block; width:120px; height:40px; }
			#content{height:500px;}
			img{width:500px;}
		</style>
		<script>
			function deleteBtn(){
				if(confirm("게시글을 삭제하시겠습니까?")) 
					location.href="doFboardDelete.do?bno=${bBean.bno}&page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
			} // deleteBtn()
			
			function updateBtn(){
				if(confirm("게시글을 수정하시겠습니까?")) 
					location.href="fboardUpdate.do?bno=${bBean.bno}&page=${page}&searchTitle=${searchTitle}&searchWord=${searchWord}";
			}//updateBtn()
		</script>
	</head>
	<body>
		<h2>자유게시판 뷰 페이지</h2>
		<table>
			<colgroup>
				<col width="30%">
				<col width="70%">
			</colgroup>
			<tr>
				<th>제목</th>
				<td>${board.btitle}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.id}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${board.bdate}</td>
				
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.bhit}</td>
			</tr>
			<tr id="content">
				<th>내용</th>
				<td>${board.bcontent}</td>
			</tr>
			<tr>
				<th>파일명</th>
				<td>
					<c:if test="${board.bfile != null}">
						<a href="./upload/${board.bfile}" download>${board.bfile}</a>
					</c:if>
					<c:if test="${board.bfile == null}">파일없음</c:if>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${board.bfile != null}">
						<img src="./upload/${board.bfile}">
					</c:if>
					<c:if test="${board.bfile == null}">파일없음</c:if>
				</td> <!--f12눌러서 링크 잘 확인해봐  -->
				<!-- 톰캣의 server.xml 맨 아래에 
				<Context docBase="C:/upload" path="jsp0116/upload" reloadable="true"/>를 넣어주면 
				톰캣안의 주소인"jsp0116/upload"에 저장된 파일이 "C:/upload"로 넘어가서 저장됨. 톰캣안에 저장되면
				f11눌러서 실행할 때마다 빈 upload폴더가 덮어씌워지니까 계속 사라짐. -->
			</tr>
		</table>
		<div>
			<a href=""><button type="button">목록</button></a>
			<a href=""><button type="button">답변달기</button></a>
			<button type="button" onclick="updateBtn()">수정</button>
			<button type="button" onclick="deleteBtn()">삭제</button>
		</div>
	</body>
</html>