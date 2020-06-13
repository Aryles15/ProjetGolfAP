<#import "main.ftlh" as m>

<@m.page title="Liste des Rubriques">
    <style>body{text-align: center;}</style>

    <h1>Ajouter le texte de la Regle</h1>

    <form style="margin-top: 20%;" action="/newregletexte/${souscategorie.id}" method="post" class="row">
        New texte Regle ?<input type="text" name="NewTitle">
        New Corpus Regle ?<input type="text" name="newcorpus">
        <input type="hidden" value="${incrementnumordre}" name="newnumordre">
        <button type="submit">Ajouter</button>
    </form>

</@m.page>