<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>
        <form action="" method="post">
            <div class="table__box">
                <table border="1">
                    <tr>
                        <th>유저네임</th>
                        <td><input type="text" name="username" placeholder="username Enter"></td>
                    </tr>
                    <tr>
                        <th>패스워드</th>
                        <td><input type="password" name="password" placeholder="password Enter"></td>
                    </tr>
                </table>
                <button type="submit">로그인</button>
            </div>
        </form>
        <%@ include file="../layout/footer.jsp" %>