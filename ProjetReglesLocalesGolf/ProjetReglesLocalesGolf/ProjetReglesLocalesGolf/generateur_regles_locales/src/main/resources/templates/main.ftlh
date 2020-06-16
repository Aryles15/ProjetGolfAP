<#macro page title>
    <!doctype html>
    <html lang="fr">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>R & A</title>
        <!-- CSS only -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
              crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
                integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
                crossorigin="anonymous"></script>

    </head>
    <body>
    <!--
        <nav class="navbar navbar-toggleable-sm navbar-trans navbar-inverse text-dark">
            <div class="container">
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarToggler-1" aria-controls="navbarToggler-1" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#">R & A</a>
                    <div class="collapse navbar-collapse pull-xs-right justify-content-end" id="navbarToggler-1">
                        <ul class="navbar-nav">
                            <li class="nav-item active">
                                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/categories">Règles</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Règles Locales</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#">Connexion</a>
                            </li>
                        </ul>
                    </div>
                </div>
        </nav>
         -->


    <nav class="navbar fixed-top navbar-expand-lg  navbar-light bg-light">
        <a class="navbar-brand " href="https://www.randa.org/en/rog/2019/pages/local-rules-creator" target="_blank">R&A</a>
        <button class="navbar-toggler text-white" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-white" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/index">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/categories">Règles Locales</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/checkrules">Generator</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " href="/connexion">Connexion</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="allbody-exeptedNavBar">
        <h1>${title}</h1>
        <#nested>
    </div>
    </body>
    </html>
</#macro>