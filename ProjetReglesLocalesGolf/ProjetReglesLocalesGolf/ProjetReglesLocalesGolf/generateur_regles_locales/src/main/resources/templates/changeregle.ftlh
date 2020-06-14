<#import "main.ftlh" as m>

<@m.page title="Changez la regle">

    <h1>Changer le contenue de la règle</h1>

    <form style="margin-top: 20%;" action="/Editeur/changeregleformulaire/${regle.id}" method="post">
        <div class="form-group">
            <label for="texarea1"> Nouvelle Regle ?</label>
            <textarea class="form-control" name="newregle" id="texarea1" rows="3"></textarea>
            <button class="btn btn-primary" type="submit">Ajout</button>
        </div>
    </form>

</@m.page>