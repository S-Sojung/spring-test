<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="../layout/header.jsp"%>
        <form action="/userInfo" method="post">
            <div class="table__box">
                <table border="1">
                    <tr>
                        <th>유저네임</th>
                        <td><input type="text" name="username" value="${user.username}" placeholder="username Enter" readonly></td>
                    </tr>
                    <tr>
                        <th>패스워드</th>
                        <td><input type="password" name="password" value="${user.password}" placeholder="password Enter" required></td>
                    </tr>
                    <tr>
                        <th>email</th>
                        <td><input type="email" name="email" value="${user.email}" placeholder="email Enter" readonly></td>
                    </tr>
                </table>
                <button type="submit">회원 수정 완료</button>
            </div>
        </form>
<%@ include file ="../layout/footer.jsp"%>