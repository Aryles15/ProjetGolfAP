<#import "main.ftlh" as m>

<@m.page title="Liste des Rubriques">
    <div class="ajoutcateg">
    <h1>Ajouter le titre de la SousRubrique</h1>

    <form  action="/newsouscategorie/${categorie.id}" method="post" style="margin-top: 20%;" class="row">
        New name SousRubriques ?<input type="text" name="NewTitle">
        New OBJET SousRubriques ?<input type="text" name="newobjet">
        <input type="hidden" value="${incrementnumordre}" name="newnumordre">
        <button type="submit">Ajouter</button>
    </form>
    </div>
</@m.page>