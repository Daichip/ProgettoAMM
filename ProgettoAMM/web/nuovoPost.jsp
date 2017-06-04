<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:choose>
    <c:when test="${empty newpost}">
        <div id="formNewPost">
            <h1>Nuovo Post</h1>
            <form id="nuovoPostForm" action="NuovoPost" method="post">
                <div id="postType">
                    <div id="text">
                        <label for="textType">Post di Testo</label>
                        <input type="radio" name="postType" value="textType" id="textType" checked="checked">
                    </div>
                    <div id="image">
                        <label for="imgType">Post con Foto</label>
                        <input type="radio" name="postType" value="imgType" id="imgType">
                    </div>
                </div>
                <div id="postContent">
                    <div>
                        <label for="textPost">Contenuto</label>
                        <textarea name="textPost" id="textPost"></textarea>
                    </div>
                </div>
                <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
            </form>     
        </div>
    </c:when>
    <c:otherwise>
        <div id="formNewPost">
            <form action="NuovoPost" method="post">
                <c:if test="${typePost == 'textType'}">
                    <p>${content}</p>
                </c:if>
                <c:if test="${typePost == 'imgType'}">
                    <img src="${content}" alt="downloadedImage">
                </c:if>
                <input type="text" hidden name="textPost" value="${content}">
                <input type="text" hidden name="postType" value="${typePost}">
                <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
            </form>
        </div>
    </c:otherwise>
</c:choose>
 