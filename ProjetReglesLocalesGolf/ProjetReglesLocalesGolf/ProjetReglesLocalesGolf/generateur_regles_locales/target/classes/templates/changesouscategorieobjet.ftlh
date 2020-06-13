<#import "main.ftlh" as m>

<@m.page title="">
    <h1>Changer l'Objet de la Sous Rubrique</h1>

    <form style="margin-top: 20%;" action="/changesouscategorieobjet/${souscategorie.id}" method="post" class="row">
        Novelle Objet Sous Rubriques ?<input type="text" name="newobjet">
        <button type="submit">Ajout</button>
    </form>

</@m.page>