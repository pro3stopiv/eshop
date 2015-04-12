<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<form class="form-horizontal" id="form-registrace">
    <h2 class="form-signin-heading">Registrace</h2>
    <div class="row">
        <div class="col-sm-4">        
            <input type="text" class="form-control" placeholder="Jméno" required>
            <input type="text" class="form-control" placeholder="Příjmení" required>
            <input type="email" id="inputEmail" class="form-control" placeholder="Zadejte email" required>
            <input type="text" class="form-control" placeholder="Telefon">
            <input type="password" id="inputPassword" class="form-control" placeholder="Heslo" required>   
            <input type="password" id="inputPassword" class="form-control" placeholder="Zopakujte heslo" required>   
        </div>
        <div class="col-sm-4">
            <input type="text" class="form-control" placeholder="Ulice" required>
            <input type="text" class="form-control" placeholder="Číslo popisné" required>
            <input type="text" class="form-control" placeholder="Město" required>
            <input type="text" class="form-control" placeholder="PSČ" required>

        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-2" >
            <div class="col-sm-4">
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Registrovat</button>
            </div>
        </div>
    </div>
</form>

