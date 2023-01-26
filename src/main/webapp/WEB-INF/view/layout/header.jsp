<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>게시판 서버</title>
            <style>
                .box {
                    display: grid;
                    justify-content: center;
                }

                .page__box {
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    height: 100px;
                    background-color: rgb(214, 199, 199);
                }

                .nav ul {
                    display: grid;
                    grid-template-columns: auto auto;
                    justify-content: center;
                    grid-gap: 30px;
                    list-style-type: none;
                }
            </style>
        </head>

        <body>
            <div class="page__box">
                <h1>${page} 페이지</h1>
            </div>
            <hr />
            <div class="nav">
                <ul>
                    <c:choose>
                        <c:when test="${principal == null}">
                            <li><a href="/loginForm">로그인</a></li>
                            <li><a href="/joinForm">회원가입</a></li>
                        </c:when>

                        <c:otherwise>
                            <li><a href="/userInfoForm/${principal.id}">회원정보</a></li>
                            <li><a href="/logout">로그아웃</a></li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div>
            <div class="box">