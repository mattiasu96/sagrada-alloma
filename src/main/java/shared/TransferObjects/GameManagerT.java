package shared.TransferObjects;

import shared.abstracts.PrivateOC;
import shared.abstracts.PublicOC;
import shared.abstracts.ToolC;
import shared.Dice;
import shared.RoundTrack;

import java.io.Serializable;
import java.util.ArrayList;

public class GameManagerT implements Serializable {

    public final ArrayList<PlayerT> vPlayers;
    public final ArrayList<PrivateOC> privateOCs;
    public final ArrayList<PublicOC> publicOCs;
    public final ArrayList<ToolC> toolCards;
    public final RoundTrack roundTrack;
    public final ArrayList<Dice> pool;
    public final ArrayList<Integer> tCtokens;
    public final Integer pos;

    public GameManagerT(ArrayList<PlayerT> vPlayers, ArrayList<PrivateOC> privateOCs, ArrayList<PublicOC> publicOCs,
                        ArrayList<ToolC> toolCards, RoundTrack roundTrack, ArrayList<Dice> pool,
                        ArrayList<Integer> tCtokens, Integer pos) {

        this.vPlayers = vPlayers;
        this.privateOCs = privateOCs;
        this.publicOCs = publicOCs;
        this.toolCards = toolCards;
        this.roundTrack = roundTrack;
        this.pool = pool;
        this.tCtokens = tCtokens;
        this.pos = pos;
    }
}