document.addEventListener('DOMContentLoaded', () => {

    let isGameStarted = false,
        isGameEnded = false,
        playerTurn = 0;

    const elulp1 = document.getElementById('p1');
    const elulp2 = document.getElementById('p2');
    const elpturn = document.getElementById('pturn');

    function createNode(element) {
        return document.createElement(element);
    }

    function append(parent, el) {
        return parent.appendChild(el);
    }

    fetch("http://localhost:8888/isgamestarted")
        .then(function (responseGameStarted) {
            return responseGameStarted.json();
        })
        .then(jsonDataGameStarted => {
            // console.log("is game started json parse" + JSON.parse(jsonData));
            // console.log("isGameStarted before " + isGameStarted);
            isGameStarted = JSON.parse(jsonDataGameStarted);
            // console.log("isGameStarted after " + isGameStarted);
        })
        .catch(function (error) {
            console.log(JSON.stringify(error));
        });

    fetch("http://localhost:8888/isgameend")
        .then(function (responseIsGameEnd) {
            return responseIsGameEnd.json();
        })
        .then(jsonDataIsGameEnd => {
            isGameEnded = JSON.parse(jsonDataIsGameEnd);
        })
        .catch(function (error) {
            console.log(JSON.stringify(error));
        });

    fetch("http://localhost:8888/playerturn")
        .then(function (responsePlayerTurn) {
            return responsePlayerTurn.json();
        })
        .then(jsonDataPlayerTurn => {
            // playerTurn = JSON.parse(jsonDataPlayerTurn);
            playerTurn = jsonDataPlayerTurn;
            console.log("Assigned player turn " + playerTurn);
            elpturn.textContent += "Player " + playerTurn + " Turn";
        })
        .catch(function (error) {
            console.log(JSON.stringify(error));
        });

    console.log("Player turn after fetch " + playerTurn);

    // setup game    
    if (!isGameStarted && !isGameEnded) {

        console.log("current player turn " + playerTurn);

        fetch('http://localhost:8888/game')
            .then(function (responseGame) {
                return responseGame.json();
            })
            .then(function (jsonDataGame) {
                // console.log(JSON.stringify(jsonData));
                // console.log("a1 " + JSON.stringify(jsonData[0]));
                // console.log("a2 " + JSON.stringify(jsonData[1]));
                let arrayp1 = jsonDataGame[0];
                let arrayp2 = jsonDataGame[1];
                let i, j, val;

                for (i = 0; i < arrayp1.length; i++) {
                    let li = createNode('li'),
                        h4 = createNode('h4');

                    li.id = "p1pit" + i;

                    li.addEventListener('click', function () {
                        console.log("added click event to " + li.id);
                    }, false);

                    val = arrayp1[i];
                    h4.innerHTML = "Pit " + (i + 1);
                    append(li, h4);
                    for (j = 0; j < val; j++) {
                        let ipit = createNode('i');
                        ipit.className = "far fa-dot-circle";
                        append(li, ipit);
                    }
                    append(elulp1, li);


                }
                for (i = 0; i < arrayp2.length; i++) {
                    let li = createNode('li'),
                        h4 = createNode('h4');

                    li.id = "p2pit" + i;

                    li.addEventListener('click', function () {
                        console.log("added click event to " + li.id);
                    }, false);

                    val = arrayp2[i];
                    h4.innerHTML = "Pit " + (i + 1);
                    append(li, h4);
                    for (j = 0; j < val; j++) {
                        let ipit = createNode('i');
                        ipit.className = "far fa-dot-circle";
                        append(li, ipit);
                    }
                    append(elulp2, li);
                }

            })
            .catch(function (error) {
                console.log(JSON.stringify(error));
            });

    }

});