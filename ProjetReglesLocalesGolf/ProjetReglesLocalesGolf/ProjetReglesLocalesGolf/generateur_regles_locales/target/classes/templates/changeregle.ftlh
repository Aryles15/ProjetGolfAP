<#import "main.ftlh" as m>

<@m.page title="">



    <!--<form style="margin-top: 20%;" action="/Editeur/changeregleformulaire/${regle.id}" method="post">
        <div class="form-group">
            <label for="texarea1"> Nouvelle Regle ?</label>
            <textarea class="form-control" name="newregle" id="texarea1" rows="3"></textarea>

        </div>
    </form>-->

    <div class="ajoutcateg">
        <form action="/Editeur/changeregleformulaire/${regle.id}" method="post">
            <h3>Nouvelle Regle ?</h3>
            <div class="form-group">
                <label for="titre">Règle</label>
                <textarea class="form-control" name="newregle" id="texarea1" rows="3"></textarea>
                <small id="textplus" class="form-text text-muted"></small>
            </div>
            <div class="form-group">
            </div>
            <button type="submit" class="btn btn-warning">Ajouter</button>
        </form>
    </div>

</@m.page>