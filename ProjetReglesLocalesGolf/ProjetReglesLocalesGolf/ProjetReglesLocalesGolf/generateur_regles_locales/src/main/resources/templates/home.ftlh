<#import "main.ftlh" as m>
<@m.page title="">

    <style>

        .wrapper {
            position: absolute;
            margin-bottom:  10%;
            marign-left: 40%;
        }

        .ball {
            width: 200px;
            height: 200px;
            position: absolute;
            border-radius: 50%;
            overflow: hidden;
            box-shadow: -5px -5x 5px red;
            left: 25%;
            top: 25%;
            box-shadow: -3px 3px 15px rgba(0, 0, 0, 0.35), 0px 0px 100px rgba(0, 0, 0, 0.25), 0px 0px 5px rgba(255, 255, 255, 0.5);
            z-index: 1;
        }

        .ball:before {
            position: absolute;
            content: '';
            height: 100%;
            width: 100%;
            background-image: linear-gradient(transparent 0%, rgba(0, 0, 0, 0.2) 50%);
            transform: rotate(-125deg);
        }

        .tee {
            position: relative;
            top: 100%;
        }

        .tee .top {
            margin-top: 197px;
            position: absolute;
            z-index: 2;
            margin-left: 70px;
            width: 0;
            height: 0;
            border-left: 30px solid transparent;
            border-right: 30px solid transparent;
            border-top: 26px solid grey;
            border-radius: 15px;
        }

        .stem {
            background-color: grey;
            height: 15em;
            position: absolute;
            top: 140px;
            width: 20px;
            margin-left: 90px;
        }

        .stem:after {
            content: '';
            width: 0;
            height: 0;
            border-left: 11px solid transparent;
            border-right: 12px solid transparent;
            border-top: 12px solid grey;
            border-radius: 16px;
            position: absolute;
            top: 239px;
            margin-left: -1px;
        }

        .texture {
            position: relative;
            animation: translateBackground 40s infinite linear;
            background: url(http://thumbs.dreamstime.com/x/golf-ball-texture-17926947.jpg) 0% 0 repeat-x;
            width: 200px;
            height: 200px;
            position: absolute;
            border-radius: 50%;
        }

        @keyframes translateBackground {
            0% {
                background-position-x: 0;
            }
            100% {
                background-position-x: -600px;
            }
        }
    </style>


    <div class="container">
        <div class="divBienvenue">
            <h1>Bienvenue</h1>
            <p>Vous pourez ici consulter la liste des règles locales en vigueur (2020)</p>
            <a href="/categories">Voir la liste des Rubriques</a>
        </div>
        <div class="wrapper">
            <div class="ball">
                <div class="texture"></div>
            </div>
            <div class="tee">
                <div class="top"></div>
                <div class="stem"></div>
            </div>
        </div>
    </div>



    <script>
    </script>
</@m.page>