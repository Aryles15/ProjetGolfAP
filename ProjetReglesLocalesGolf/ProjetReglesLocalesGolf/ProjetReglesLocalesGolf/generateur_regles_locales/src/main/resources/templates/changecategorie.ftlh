<#import "main.ftlh" as m>

<@m.page title="Cahngez de Titre de Rubrique">
    <style>.changecateg{text-align: center;}</style>
    <div class="changecateg">

        <form style="margin-top: 20%;" action="/changecategorie/${categorie.id}" method="post" class="row">
            New name Rubriques ?<input type="text" name="newtitre">
            <button type="submit">Ajout</button>
        </form>
    </div>
</@m.page>