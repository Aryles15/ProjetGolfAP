<#import "main.ftlh" as m>

<@m.page title="">

    <!--Assigne valeur Security [habilitation & user]-->
    <#assign
    known=Session.SPRING_SECURITY_CONTEXT??>
    <#if known>
        <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        habilitations= user.authorities>
    <#else>
        <#assign name="unknown">
    </#if>
    <!---->
    <!--Top page-->
    <div class="row col-lg-12" style="margin-top: 5%;">
        <#if habilitations??>
            <div class="card formcard col-md-4" style="text-align: center">
                <div class="card-header row">
                    <p>User: ${name}</p>
                    <#list habilitations as habilitation>
                        <p>Habilitation: (${habilitation})<#assign habilitation="${habilitation}"></p>
                    </#list>
                </div>
                <div class="card-body ">
                    <a role="button" class="btnCo btn-sm" href="/deconnexion"><span>Deconnexion</span></a>
                </div>
            </div>
        </#if>
        <div class="DivTitreTopPage col-lg-8">
            <h3 class="SousTitreTopPage">Liste des rubriques</h3>
        </div>
    </div>
    <!--Top page-->

    <!--Corp page-->
    <form action="/regleselect" method="post">
        <div class="row">
            <div class="col-1">
                <div class="fixedbutton">
                    <button class="btn couleurvert text-light align-center" type="submit">Ajout à la liste</button>
                </div>
            </div>
            <div class="col-11">
                <ul class="TouteLesListe">
                    <#if habilitation??>  <#if habilitation=="GESTIONNAIRE"||habilitation=="ADMIN">
                        <a href="/Gestionnaire/newcateg" class="btn btn-sm btn-outline-light lienHref">Nouvelle
                            Rubriques</a>
                    </#if></#if>
                    <#list categories as categorie>
                        <div class="categorieAll ">
                            <div class="card row shadow p-1 mb-2 sm-white rounded titrecateg"
                                 onclick="AfficherMasquerCateg(${categorie.id})">
                                <div class="card-body">
                                    <h5>${categorie.code}.${categorie.title}</h5>
                                </div>
                            </div>

                            <div id="${categorie.id}" class="divCateg" style="display:none;">
                                <#if habilitation??>  <#if habilitation=="EDITEUR" ||habilitation=="GESTIONNAIRE"||habilitation=="ADMIN">
                                    <a href="/Editeur/changecateg/${categorie.id}" role="button"
                                       class="btn btn-sm btn-outline-light lienHref">Changer titre rubriques</a>
                                </#if></#if>
                                <#if habilitation??>  <#if habilitation=="GESTIONNAIRE"||habilitation=="ADMIN">
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
                                            <a href="/Editeur/changesouscateg/${souscat.id}"
                                               class="btn btn-sm btn-outline-light lienHref">Changer titre
                                                Sous-Rubriques</a>
                                            <a href="Editeur/changesouscategobjet/${souscat.id}"
                                               class="btn btn-sm btn-outline-light lienHref">Changer l'objet</a>
                                        </#if></#if>
                                        <#if habilitation??>  <#if habilitation=="ADMIN">
                                            <a href="/Admin/souscategoriedelete/${souscat.id}"
                                               class="btn btn-sm btn-outline-light lienHref">Suprimer la
                                                Sous-Rubrique </a>
                                        </#if></#if>
                                        <#if habilitation??>  <#if habilitation=="GESTIONNAIRE" || habilitation=="ADMIN">
                                            <a href="/Gestionnaire/newnextregle/${souscat.id}"
                                               class="btn btn-sm btn-outline-light lienHref">Nouvelle Regle</a>
                                        </#if></#if>


                                        <!--<p>Objet: </br>${souscat.objet}</p>-->


                                        <#list souscat.getRegles() as regles>
                                            <div class="card shadow p-3 mb-5 bg-white rounded divRegle">
                                                <div class="card-body">

                                                    <div class="row">
                                                        <div class="col-1">
                                                            <div class="wrapInputCheckbox">
                                                                <input type="checkbox" class="col-1 inputCheckbox changeItem-js itemChange-js" id="defaultUnchecked${regles.id}" name="idregles" value="${regles.id}">
                                                                <label class="col-11 label-wrapText"
                                                                       for="defaultUnchecked${regles.id}">
                                                                <span class="input-psevdo"></span>
                                                                <span class="customTextCheckbox"></span>
                                                                </label>
                                                            </div>
                                                        </div>
                                                        <div class="col-11 text-justify">
                                                            <h9>${categorie.code}.${souscat.numordre}-${regles.numordre}
                                                                .${regles.corpus}</h9>

                                                        </div>

                                                    </div>
                                                    <div class="row" style="justify-content: center">
                                                        <#if habilitation??>  <#if habilitation=="EDITEUR" || habilitation=="GESTIONNAIRE" || habilitation=="ADMIN">
                                                            <a href="Editeur/changeregle/${regles.id}"
                                                               class="btn btn-sm btn-outline-muted lienHref">Editer la
                                                                Regle</a>
                                                        </#if></#if>
                                                        <#if habilitation??>  <#if habilitation=="ADMIN">
                                                            <a href="Admin/regledelete/${regles.id}"
                                                               class="btn btn-sm btn-outline-muted lienHref">Suprimer la
                                                                Regle </a>
                                                        </#if></#if>
                                                    </div>


                                                </div>

                                            </div>
                                        </#list>

                                    </div>
                                </#list>
                            </div>
                        </div>
                    </#list>


                </ul>
            </div>

        </div>


    </form>
    <script type="text/javascript">


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