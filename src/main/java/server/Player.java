package server;

import server.threads.GameManager;
import server.threads.MainServer;
import shared.*;

import java.util.ArrayList;

public class Player {
    private MatchManager matchManager = MatchManager.getInstance();
    private String uUID;
    private Character privateO;
    private ArrayList<Integer> possibleWindows;
    private Window window;
    private Overlay overlay = new Overlay();
    private Integer tokens;
    private Integer turno = 0;
    private Integer score = 0;
    private Integer privateTurn = 0; //can be either 1 or 2
    private Position lastPlaced = new Position(-1,-1);
    private boolean hasPlacedDice = false;
    private boolean hasUsedTc = false;
    private GameManager game;

    public Player(GameManager gameManager, String uUID) {
        this.uUID = uUID;
        this.game = gameManager;
        this.possibleWindows = new ArrayList<>();
    }

    public void setPossibleWindows(ArrayList<Integer> possibleWindows) {
        this.possibleWindows.addAll(possibleWindows);
    }

    public Integer getScore() {
        return score;
    }

    public Integer setScore() {

        score = game.usePublicO(this.overlay);

        int i = 0;
        int j = 0;

        while (i < 4) {
            while (j < 5) {
                Dice dice = overlay.getDicePositions()[i][j];
                if (dice != null)
                    if (dice.color == privateO)
                        score = score + dice.value;
                j++;
            }
            i++;
        }

        score = score + tokens;
        Logger.log("Player: " + uUID + " total score is " + score.toString()+"\n");

        return score;
    }

    public synchronized boolean placedDice() {
        if (this.hasPlacedDice)
            return true;
        this.hasPlacedDice = true;
        return false;
    }

    public synchronized boolean usedTc() {
        if (this.hasUsedTc)
            return true;
        this.hasUsedTc = true;
        return false;
    }

    public synchronized boolean usedTcAndPlacedDice() {
        if (this.hasUsedTc || this.hasPlacedDice)
            return true;
        this.hasUsedTc = true;
        this.hasPlacedDice = true;
        return false;
    }

    public synchronized void clearUsedTcAndPlacedDice() {
        this.hasUsedTc = false;
        this.hasPlacedDice = false;
    }

    public Integer getTokens() {
        return tokens;
    }

    public void setGame(GameManager game) {
        this.game = game;
    }

    public Integer getTurno() {
        return turno;
    }

    public GameManager getGame() {
        return game;
    }

    public Integer getPrivateTurn() {
        return privateTurn;
    }

    public Overlay getOverlay() {
        return overlay;
    }

    public Character getPrivateO(){
        return privateO;
    }

    public Position getLastPlaced() {
        return lastPlaced;
    }

    public String getuUID() {
        return uUID;
    }

    public void setTokens(Integer tokens) {
        this.tokens = tokens;
    }

    public void incrementTurn() {
        this.turno++;
        if (this.privateTurn == 1)
            this.privateTurn = 2;
        else
            this.privateTurn = 1;
    }

    public Window getWindow() {
        return window;
    }

    public void setPrivateOC(Character ch) {
        this.privateO = ch;
        System.out.println("Player: " + uUID + ", Private Objective card " +
                "assigned with color " + ch);
    }

    public boolean setWindowFromC(Integer n) {
        if (this.window != null) {
            System.out.println("Player: " + uUID + " Server already assigned Window for this player");
            return false;
        }
        if (!this.possibleWindows.contains(n)) {
            System.out.println("Player: " + uUID + " Attempt to set improper Window");
            return false;
        }
        this.window = matchManager.getWindows().get(n);
        setTokens();
        System.out.println("Player: " + uUID + " choose Window: " + n + ". It has: " + window.getTokens() + " tokens");
        return true;
    }

    public boolean setWindow(Integer n) {
        this.window = matchManager.getWindows().get(n);
        setTokens();
        System.out.println("GameManager: "+game+" player " + uUID + " server assigned Window n° " + n + ". It has " + window.getTokens() +
                " tokens. Will be forced start client-side");
        return true;
    }

    public void setTokens() {
        this.tokens = this.window.getTokens();
    }

    public boolean placeDice(Integer index, Position position) {
        Dice dice;
        if (!this.placedDice()) {
            ArrayList<Dice> pool = game.getPool();
            if(index>=pool.size())
                return false;
            if (pool.get(index) == null)
                return false;
            dice = MainServer.deepClone(pool.get(index));
            if (this.window.setDiceFromPool(this, index, position)) {
                this.lastPlaced = position;
                System.out.println("GameManager: " + game + " player " + uUID + " effectively placed dice " +
                        dice + " in position " + position);
                return true;
            }
        }
        System.out.println("GameManager: "+game+" player "+uUID+" attempt of unauthorized placement of dice");
        return false;
    }
}