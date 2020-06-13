<#import "main.ftlh" as m>

<@m.page title="Liste des Rubriques">

    <div class="ajoutcateg">
        <form action="/newcategorie" method="post">
            <h3>Nouvelle Catégorie ?</h3>
            <div class="form-group">
                <label for="titre">Titre</label>
                <input type="text" name="NewNameTitle" id="titre" class="form-control" aria-describedby="titre"
                       placeholder="titre">
                <small id="textplus" class="form-text text-muted"></small>
            </div>
            <div class="form-group">
                <label for="code">Code</label>
                <input type="text" name="NewNameCode" id="code" class="form-control" placeholder="Code">
            </div>
            <button type="submit" class="btn btn-warning">Ajouter</button>
        </form>
    </div>

</@m.page>