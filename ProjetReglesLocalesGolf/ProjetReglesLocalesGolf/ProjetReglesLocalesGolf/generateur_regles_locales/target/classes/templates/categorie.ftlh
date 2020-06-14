<#import "main.ftlh" as m>

<@m.page title="">
    <!---->
    <#assign
    known=Session.SPRING_SECURITY_CONTEXT??>
    <#if known>
        <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        habilitations= user.authorities>
    <#else>
        <#assign
        name="unknown"
        >
    </#if>
    <h1>${name}</h1>
    <#if habilitations??>
        <#list habilitations as habilitation>
            ${habilitation}<#assign habilitation="${habilitation}">
        </#list>
    </#if>
    <!---->

    <div class="DivTitreTopPage">
        <h1 class="TitreTopPage">R & A</h1>
        <h3 class="SousTitreTopPage">Liste des rubriques</h3>
        <a href="/deconnexion">Deconnexion</a>
    </div>

    <form action="/regleselect" method="post">
        <ul class="TouteLesListe">
            <#list categories as categorie>

                <div class="categorieAll ">
                    <div class="card row shadow p-1 mb-2 sm-white rounded titrecateg"
                         onclick="AfficherMasquerCateg(${categorie.id})">
                        <div class="card-body">
                            <h5>${categorie.code}.${categorie.title}</h5>
                            <!--   <input value="Afficher / Masquer" type="button" class="btn btn-success" onclick="AfficherMasquerCateg(${categorie.id})"></input>-->

                        </div>
                    </div>


                    <div id="${categorie.id}" class="divCateg" style="display:none;">
                        <#if habilitation??>  <#if habilitation=="EDITEUR" ||habilitation=="GESTIONNAIRE"||habilitation=="ADMIN">
                        <a href="/Editeur/changecateg/${categorie.id}" role="button" class="btn btn-sm btn-outline-light lienHref">Changer titre rubriques</a>
                        </#if></#if>
                         <#if habilitation??>  <#if habilitation=="GESTIONNAIRE"||habilitation=="ADMIN">
                        <a href="/Gestionnaire/newcateg/${categorie.id}" class="btn btn-sm btn-outline-light lienHref">Nouvelle
                            Rubriques</a>
                        <a href="/Gestionnaire/newsouscateg/${categorie.id}"
                           class="btn btn-sm btn-outline-light lienHref">Nouvelle Sous Rubrique</a>
                        </#if></#if>
                        <#if habilitation??>  <#if habilitation=="ADMIN">
                            <a href="/Admin/categoriedelete/${categorie.id}"
                               class="btn btn-sm btn-outline-light lienHref">Suprimer la Rubrique </a>
                        </#if></#if>


                        <#list categorie.getSousCategories() as souscat>
                            <div class="card row shadow-sm p-1 mb-2 sm-white rounded titresouscateg"
                                 onclick="AfficherMasquerCateg(1${souscat.id})">
                                <div class="card-body">
                                    <h6>${categorie.code}.${souscat.numordre}.${souscat.title}</h6>
                                    <!--  <input value="Afficher/Masquer" type="button" class="btn btn-success" onclick="AfficherMasquerCateg(1${souscat.id})"></input>-->
                                </div>
                            </div>

                            <div id="1${souscat.id}" class="divSousCateg " style="display:none;">
                                  <#if habilitation??>  <#if habilitation=="EDITEUR"|| habilitation=="GESTIONNAIRE"|| habilitation=="ADMIN">
                                      <a href="/Editeur/changesouscateg/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Changer titre Sous-Rubriques</a>
                                      <a href="Editeur/changesouscategobjet/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Changer l'objet</a>
                                  </#if></#if>
                                <#if habilitation??>  <#if habilitation=="GESTIONNAIRE" || habilitation=="ADMIN">
                                    <a href="/Gestionnaire/newnextregle/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Nouvelle Regle</a>
                                </#if></#if>
                                <#if habilitation??>  <#if habilitation=="ADMIN">
                                        <a href="/Admin/souscategoriedelete/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Suprimer la Sous-Rubrique </a>
                                </#if></#if>


                                <!--<p>Objet: </br>${souscat.objet}</p>-->


                                <#list souscat.getRegles() as regles >
                                    <div class="card shadow p-3 mb-5 bg-white rounded">
                                        <div class="card-body">
                                            <h9>${categorie.code}.${souscat.numordre}-${regles.numordre}
                                                .${regles.corpus}</h9>

                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input"
                                                       id="defaultUnchecked${regles.id}"
                                                       name="idregles" value="${regles.id}">
                                                <label class="custom-control-label"
                                                       for="defaultUnchecked${regles.id}"></label>
                                            </div>
                                    <#if habilitation??>  <#if habilitation=="EDITEUR" || habilitation=="GESTIONNAIRE" || habilitation=="ADMIN">
                                            <a href="Editeur/changeregle/${regles.id}" class="btn btn-sm btn-outline-muted lienHref">Editer la Regle</a>
                                    </#if></#if>
                                             <#if habilitation??>  <#if habilitation=="ADMIN">
                                                <a href="Admin/regledelete/${regles.id}" class="btn btn-sm btn-outline-muted lienHref">Suprimer la Regle </a>
                                             </#if></#if>
                                        </div>

                                    </div>
                                </#list>

                            </div>
                        </#list>
                    </div>
                </div>
            </#list>


        </ul>

        <div class="fixedbutton">
            <button class="btn btn-warning" type="submit">Ajout à la liste</button>
        </div>
    </form>
    <script type="text/javascript">

        //La putain dsa race, peut pas utiliser la meme fonction car id categ ce confond avec id sous categ
        // .; arrive pas a utiliser deux param ca grand mere
        function AfficherMasquerCateg(id) {
            div = document.getElementById(id);
            if (div.style.display === "none") {
                div.style.display = "block";
            } else {
                div.style.display = "none";
            }
        }


    </script>



</@m.page>