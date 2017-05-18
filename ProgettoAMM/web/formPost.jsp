<%-- 
    Document   : formPost
    Created on : 15-mag-2017, 15.46.10
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div id="formNewPost">
    <form action="Profilo" method="post">
        <div id="postType">
            <div id="textType">
                <label for="textType">Post di Testo</label>
                <input type="radio" name="postType" value="textType" id="textType">
            </div>
            <div id="imgType">
                <label for="imgType">Post con Foto</label>
                <input type="radio" name="postType" value="imgType" id="imgType">
            </div>
        </div>
        <div id="postContent">
            <div>
                <label for="textPost">Testo</label>
                <textarea name="textPost" id="textPost"></textarea>
            </div>
            <div>
                <label for="imgPost">File d'immagine</label>
                <input type="file" name="imgPost" id="imgPost">
            </div>
        </div>
        <button type="submit">Invia</button>
    </form>
</div>