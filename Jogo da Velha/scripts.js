
const cellElements = document.querySelectorAll("[data-cell]");
const board = document.querySelector("[data-board]");
const winningMessageTextElement = document.querySelector("[data-winning-message-text]");
const winningMessage = document.querySelector("[data-winning-message]");
const restartButton = document.querySelector("[data-restart-button]");

let isCircleTurn;
let gameInProgress = false;
let isPlayerVsComputer = false; // Variável para controlar o modo de jogo

const winningCombinations = [
  [0, 1, 2],
  [3, 4, 5],
  [6, 7, 8],
  [0, 3, 6],
  [1, 4, 7],
  [2, 5, 8],
  [0, 4, 8],
  [2, 4, 6],
];

const startGame = () => {
  isCircleTurn = false;
  gameInProgress = true;

  for (const cell of cellElements) {
    cell.classList.remove("circle");
    cell.classList.remove("x");
    cell.removeEventListener("click", handleClick);
    cell.addEventListener("click", handleClick, { once: true });
  }

  setBoardHoverClass();
  winningMessage.classList.remove("show-winning-message");

  if (isPlayerVsComputer) {
    computerTurn();
  }
};

const endGame = (isDraw) => {
  gameInProgress = false;
  if (isDraw) {
    winningMessageTextElement.innerText = "Empate!";
  } else {
    winningMessageTextElement.innerText = isCircleTurn ? "O Venceu!" : "X Venceu!";
  }

  winningMessage.classList.add("show-winning-message");
};

const checkForWin = (currentPlayer) => {
  return winningCombinations.some((combination) => {
    return combination.every((index) => {
      return cellElements[index].classList.contains(currentPlayer);
    });
  });
};

const checkForDraw = () => {
  return [...cellElements].every((cell) => {
    return cell.classList.contains("x") || cell.classList.contains("circle");
  });
};

const placeMark = (cell, classToAdd) => {
  cell.classList.add(classToAdd);
};

const setBoardHoverClass = () => {
  board.classList.remove("circle");
  board.classList.remove("x");

  if (isCircleTurn) {
    board.classList.add("circle");
  } else {
    board.classList.add("x");
  }
};

const swapTurns = () => {
  isCircleTurn = !isCircleTurn;
  setBoardHoverClass();
};

const computerTurn = () => {
  if (gameInProgress && isCircleTurn) {
    const emptyCells = [...cellElements].filter(
      (cell) => !cell.classList.contains("x") && !cell.classList.contains("circle")
    );
    if (emptyCells.length > 0) {
      const randomCell = emptyCells[Math.floor(Math.random() * emptyCells.length)];
      setTimeout(() => {
        placeMark(randomCell, "circle");
        if (checkForWin("circle")) {
          endGame(false);
        } else if (checkForDraw()) {
          endGame(true);
        } else {
          swapTurns();
        }
      }, 1000);
    }
  }
};

const handleClick = (e) => {
  if (!gameInProgress) {
    return;
  }

  const cell = e.target;
  const classToAdd = isCircleTurn ? "circle" : "x";

  placeMark(cell, classToAdd);

  const isWin = checkForWin(classToAdd);
  const isDraw = checkForDraw();

  if (isWin) {
    endGame(false);
  } else if (isDraw) {
    endGame(true);
  } else {
    swapTurns();

    if (isPlayerVsComputer && isCircleTurn) {
      setTimeout(computerTurn, 1000);
    }
  }
};

const gameModeSelector = document.getElementById("game-mode");
const startGameButton = document.getElementById("start-game-button");

startGameButton.addEventListener("click", () => {
  const selectedGameMode = gameModeSelector.value;
  isPlayerVsComputer = selectedGameMode === "player-vs-computer";
  startGame();
});

restartButton.addEventListener("click", startGame);

startGame(); // Inicie o jogo quando a página é carregada
