<#import "main.ftlh" as m>


<@m.page title="">

   <!--FORMULAIRE DE CONNEXION USER-->
    <form action="/login" method="post">
        <h3>Connexion</h3>
        <div class="form-group">
            <label for="titre">User name</label>
            <input type="text" name="username" id="username" class="form-control" aria-describedby="username"
                   placeholder="user name">
            <small id="textplus" class="form-text text-muted"></small>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" class="form-control" placeholder="Mot de passe">
        </div>
        <button type="submit" class="btn btn-warning">Connexion</button>
    </form>

</@m.page>