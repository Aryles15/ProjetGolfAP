<#import "main.ftlh" as m>

<@m.page title="">

    <h1 class="TitreTopPage">Liste des Regles séléctionné</h1>

    <div class="TouteLesListe">
        <button class="btn-copy btn btn-danger" id="copy" type="button">Copier les Regles Locales dans le presse-papier
        </button>
        <div class="presse-papier">
            <#list listeregles as regle>
                <li>
                    ${regle.getCorpus()}
                </li>
            </#list>
        </div>
    </div>

    <script>
        var toCopy = document.querySelector('.presse-papier').innerText,
            btnCopy = document.getElementById('copy');

        btnCopy.addEventListener('click', function () {
            navigator.clipboard.writeText(toCopy);
            document.execCommand('copy');
            return false;
        });

    </script>
</@m.page>