<#import "main.ftlh" as m>

<@m.page title="Cahngez Titre de la Sous Categorie">
    <h1>Changer le titre de la Sous Rubrique</h1>
<!--
    <form style="margin-top: 20%;" action="/changesouscategorie/${souscategorie.id}" method="post" class="row">
        Nom Sous Rubriques ?<input type="text" name="newtitre">
        <button type="submit">Ajout</button>

   </form>
   -->
    <form action="/changesouscategorie/${souscategorie.id}" method="post">
        <div class="form-group">
            <label for="texarea1"> Nouvelle Regle ?</label>
            <input type="text" class="form-control" name="newtitre" id="texarea1"></input>
            <button class="btn btn-primary" type="submit">Ajout</button>
        </div>
    </form>
</@m.page>