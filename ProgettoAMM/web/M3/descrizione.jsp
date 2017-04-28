<%-- 
    Document   : descrizione
    Created on : 26-apr-2017, 11.56.41
    Author     : Davide Fara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook: Descrizione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Davide Fara">
        <meta name="keywords" content="Nerd Book social network friends about info">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="header.jsp"/>

        <c:set var="title" value="Bacheca Personale" scope="request"/>
        <jsp:include page="sidebar1.jsp"/>
        
        <div class="bodyDescrizione" id="divBody">
            <div id="faqSito">
                <div id="intestazione">
                    <h2>FAQ del sito</h2>
                    <p>In questa sezione potrai trovare le informazioni di base sul sito</p>
                </div>
                <div id="scopoEUtenti">
                    <h3>Q: A chi e a cosa serve NerdBook?</h3>
                    <p>NerdBook è l'ultima frontiera del social-network! Iscriviti e inizia a comunicare con tutti i tuoi amici Nerd sulle ultime tendenze del mondo tecnologico!</p>
                    <p>Su questo sito potrai avere a che fare con tantissime persone che condividono i tuoi stessi interessi e, con un po' di fortuna, potrai anche trovare una fidanzata!</p>
                    <p>Ci sono un'infinit&agrave; di possibili incontri che puoi fare! Non perdere tempo ed iscriviti!</p>
                    <h6>NerdBook non si assume nessuna responsabilità riguardo eventuali fallimenti in campo amoroso.</h6>
                </div>
                <div id="comeIscriversi">    
                    <h3>Q: Come ci si iscrive a NerdBook?</h3>
                    <p>Per iscriverti a NerdBook è sufficiente fornire un'email, una password, il codice fiscale e l'atto di proprietà della casa.</p>
                    <p>L'iscrizione è veloce ed intuitiva, basta conoscere le basi di giapponese ed essere fluenti in coreano!</p>
                    <p>Clicca <a href="login.html" target="_blank">qui</a> per connetterti a NerdBook!</p>
                </div>    
                <div id="sitoGratuito">   
                    <h3>Q: Il sito è gratuito?</h3>
                    <p>NerdBook è un sito completamente(?) <b>GRATUITO</b>, nessun membro dello staff richiederà mai di effettuare un pagamento per l'iscrizione (ma magari per altro si...).</p>
                    <h6>NerdBook non si assume responsabilità riguardo lo stalking o lo spam dai parte dei weirdo.</h6>
                </div>
                <p><a href="#title">Torna su</a></p>
            </div>
        </div>
    </body>
</html>
