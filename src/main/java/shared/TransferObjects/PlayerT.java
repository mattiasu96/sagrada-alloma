package shared.TransferObjects;

import shared.Overlay;
import shared.Position;
import shared.cardsShared.privateOC.PrivateOC;

import java.io.Serializable;

public class PlayerT implements Serializable {
    public final Character privateO;
    public final WindowT window;
    public final Overlay overlay;
    public final Integer tokens;
    public final Integer turno;
    public final Integer score;
    public final Integer privateTurn;
    public final Position lastPlaced;

    public PlayerT(Character privateOC,
                   WindowT window, Overlay overlay,
                   Integer tokens, Integer turno,
                   Integer score, Integer privateTurn,
                   Position lastPlaced) {

        this.privateO = privateOC;
        this.window = window;
        this.overlay = overlay;
        this.tokens = tokens;
        this.turno = turno;
        this.score = score;
        this.privateTurn = privateTurn;
        this.lastPlaced = lastPlaced;

    }
}