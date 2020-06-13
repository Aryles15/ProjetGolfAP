<#import "main.ftlh" as m>

<@m.page title="">

    <div class="DivTitreTopPage">
        <h1 class="TitreTopPage">R & A</h1>
        <h3 class="SousTitreTopPage">Liste des rubriques</h3>
        <span><a href="/connexion">Se connecter</a></span>
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
                        <a href="/changecateg/${categorie.id}" role="button" class="btn btn-sm btn-outline-light lienHref">Changer titre rubriques</a>
                        <a href="/newcateg/${categorie.id}" class="btn btn-sm btn-outline-light lienHref">Nouvelle Rubriques</a>
                        <a href="/newsouscateg/${categorie.id}" class="btn btn-sm btn-outline-light lienHref">Nouvelle Sous Rubrique</a>
                        <a href="/categoriedelete/${categorie.id}" class="btn btn-sm btn-outline-light lienHref">Suprimer la Rubrique </a>


                        <#list categorie.getSousCategories() as souscat>
                            <div class="card row shadow-sm p-1 mb-2 sm-white rounded titresouscateg"
                                 onclick="AfficherMasquerCateg(1${souscat.id})">
                                <div class="card-body">
                                    <h6>${categorie.code}.${souscat.numordre}.${souscat.title}</h6>
                                    <!--  <input value="Afficher/Masquer" type="button" class="btn btn-success" onclick="AfficherMasquerCateg(1${souscat.id})"></input>-->
                                </div>
                            </div>

                            <div id="1${souscat.id}" class="divSousCateg " style="display:none;">

                                <a href="/changesouscateg/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Changer titre
                                    Sous-Rubriques</a>
                                <a href="/souscategoriedelete/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Suprimer la
                                    Sous-Rubrique </a>
                                <a href="/newnextregle/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Nouvelle Regle</a>
                                <a href="/changesouscategobjet/${souscat.id}" class="btn btn-sm btn-outline-light lienHref">Changer l'objet</a>

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

                                            <a href="/changeregle/${regles.id}" class="btn btn-sm btn-outline-muted lienHref">Editer la Regle</a>
                                            <a href="/regledelete/${regles.id}" class="btn btn-sm btn-outline-muted lienHref">Suprimer la Regle </a>

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