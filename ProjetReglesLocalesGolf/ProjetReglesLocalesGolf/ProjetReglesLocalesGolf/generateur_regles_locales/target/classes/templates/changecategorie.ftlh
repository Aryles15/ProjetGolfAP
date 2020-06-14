<#import "main.ftlh" as m>

<@m.page title="">
    <style>.changecateg{text-align: center;}</style>

    <h1>Changez le Titre de la Rubrique</h1>
    <div class="changecateg">

        <form  action="/Editeur/changecategorie/${categorie.id}" method="post" class="row">
            New name Rubriques ?<input type="text" name="newtitre">
            <button type="submit">Ajout</button>
        </form>
    </div>
</@m.page>