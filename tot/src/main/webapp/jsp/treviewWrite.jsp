<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/review.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/treview.js"></script>
    <title>여행 후기 작성</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="mainDiv">
        <div class="reviewTitleDiv">
            <div class="bigTitle">여행 후기 작성</div>
        </div>
        <div class="reviewIntroDiv">
            <div>나의 여행 후기글을 작성해보세요!</div>
        </div>
        <!-- 여행 후기 작성 폼 -->
        <div class="reviewForm">
            <form id="reviewForm" action="${pageContext.request.contextPath}/review/all/add" method="post"
                enctype="multipart/form-data">
                
                <!-- 1. 여행 후기 제목 입력 -->
                <div class="formGroup">
                    <label for="reviewTitle">제목</label>
                    <input id="reviewTitle" type="text" class="titleInput" name="trevTitle">
                </div>

                <!-- 2.1 여행 항목 선택 -->
                <div class="formGroup">
                	<label for="trip">여행 항목</label>
                	<select id="travelTrip" class="treviewSelect" name="tripId">
                		<option value="" disabled selected>여행을 선택하세요</option>
                		<c:forEach var="trip" items="${trips}">
				            <option value="${trip.tripId}">${trip.tripName}</option>
				        </c:forEach>
                	</select>
                </div>
                
                <!-- 2.2 해당 여행의 코스 정보 출력 -->
                <div class="formGroup">
				    <label for="travelCourse">여행 코스</label>
				    <div id="travelCourse" class="courseDetails">
				        <c:forEach var="course" items="${courses}">
				            <div class="courseDetailItem">
				                <c:forEach var="detail" items="${course.courseDetail}">
				                    <c:if test="${not empty detail.dname}">
				                        <span>${detail.dname}</span>
				                        <span>${detail.daddress}</span><br/>
				                    </c:if>
				                </c:forEach>
				            </div>
				            <hr />
				        </c:forEach>
				    </div>
				</div>
				
                <!-- 3. 평점 입력 -->
				<div class="formGroup">
				    <div id="reviewRating" class="ratingDiv">
				    	<label>평점</label>
				        <div class="ratingOptions">
					        <input type="radio" id="rating1" name="trevRating" value="1" <c:if test="${review.trevRating == 1}">checked</c:if> />
					        <label for="rating1">⭐</label>
					        <input type="radio" id="rating2" name="trevRating" value="2" <c:if test="${review.trevRating == 2}">checked</c:if> />
					        <label for="rating2">⭐⭐</label>
					        <input type="radio" id="rating3" name="trevRating" value="3" <c:if test="${review.trevRating == 3}">checked</c:if> />
					        <label for="rating3">⭐⭐⭐</label>
					        <input type="radio" id="rating4" name="trevRating" value="4" <c:if test="${review.trevRating == 4}">checked</c:if> />
					        <label for="rating4">⭐⭐⭐⭐</label>
					        <input type="radio" id="rating5" name="trevRating" value="5" <c:if test="${review.trevRating == 5}">checked</c:if> />
					        <label for="rating5">⭐⭐⭐⭐⭐</label>
				        </div>
				    </div>
				</div>
                
                <!-- 4. 여행 후기 내용 입력 -->
                <div class="reviewContentDiv">
                    <label for="reviewContent">후기 내용</label>
                    <div id="reviewContentAndImgDiv" class="reviewContentAndImgDiv">
                        <input class="reviewContent" name="trevContent" />
                    </div>
                </div>
                
                <!-- 5. 이미지 파일 업로드 -->
                <div class="formGroup">
                    <label for="reviewImage">이미지 업로드</label>
                    <div class="reviewImageDiv">
                        <input id="reviewImage" type="file" name="image" multiple />
                    </div>
                </div>
                
                <!-- 6. 이용 약관 동의 -->
                <div class="formGroup">
                    <fieldset class="termsFieldset">
                        <legend>개인정보 수집 및 이용 동의</legend>
                        <label>
                            <input type="radio" name="trevAgree" value="agree" class="termsRadio" id="agreeRadio">
                            동의함
                        </label>
                        <label>
                            <input type="radio" name="trevAgree" value="disagree" class="termsRadio" id="disagreeRadio">
                            동의하지 않음
                        </label>
                    </fieldset>
                </div>
                
                <!-- 버튼 -->
                <div class="formGroup">
                    <div class="submitAndCancleBtnDiv">
                        <button id="submitButton" type="button" class="initButton active">글 작성하기</button>
                        <button id="cancleButton" type="button" class="initButton">취소하기</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- 여행 후기 작섬 폼 END -->
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>