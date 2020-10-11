package charbosses.bosses.Ironclad;

import charbosses.cards.anticards.ShieldSmash;
import charbosses.cards.colorless.EnBite;
import charbosses.cards.colorless.EnJAX;
import charbosses.cards.curses.EnDoubt;
import charbosses.cards.curses.EnPain;
import charbosses.cards.curses.EnRegret;
import charbosses.cards.curses.EnWrithe;
import charbosses.cards.red.*;
import charbosses.cards.status.EnWound;
import charbosses.relics.*;
import charbosses.relics.EventRelics.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class ArchetypeAct3Block extends ArchetypeBaseIronclad {

    public ArchetypeAct3Block() {
        super("IC_BLOCK_ARCHETYPE", "Block");
    }

    public void initialize() {
        //Tuning Recommendation per Act (CARDS): 1 Card Removal, 2 Upgrades, ~6-8 cards added to deck for act 1 plus ~3 per act beyond it
        //Tuning Recommendation per Act (RELICS): 2 relics and an Event relic (simulate what the Event did)
        //Tuning Recommendation for Act 2-3: At least 1 Rare and 1 Boss Relic in addition to above 2
        //Make the total cards always divisible by 3 - Shuffle should not occur on a partial hand

        //STARTER DECK - 5 Strikes, 4 Defends, 1 Bash

        //4 Strike Removed

        //14 Cards Added, 5 Upgrades:
        //Barricade
        //Body Slam+
        //Body Slam+
        //Impervious
        //Iron Wave+
        //Iron Wave
        //Ghostly Armor+
        //Ghostly Armor
        //Metallicize
        //Metallicize+
        //Armaments
        //Juggernaut
        //FlameBarrier
        //PowerThrough




        /////   RELICS   /////

        addRelic(new CBR_NeowsBlessing());


        addRelic(new CBR_ThreadAndNeedle());
        addRelic(new CBR_HornCleat());
        addRelic(new CBR_IncenseBurner());
        addRelic(new CBR_CursedKey());  //2 curse remaining in the deck
        addRelic(new CBR_Calipers());
        addRelic(new CBR_OrnamentalFan());
        addRelic(new CBR_RedMask());  // gremlin mask
       // addRelic(new CBR_MatchAndKeep());   //excuse for having both jug and barricade
        //addRelic(new CBR_AncientWriting());   //upgraded all defends
        //addRelic(new CBR_TombOfRedMask());  // gain mask


        /////   CARDS   /////
        boolean extraUpgrades = AbstractDungeon.ascensionLevel >= 4;//Turn 1
        addToList(cardsList, new EnMetallicize(), extraUpgrades); //removed
        addToList(cardsList, new EnIronWave(), true);
        addToList(cardsList, new EnWrithe(), true);

        //Turn 2
        addToList(cardsList, new EnIronWave(), false);
        addToList(cardsList, new EnArmaments(), false);
        addToList(cardsList, new EnBodySlam(), true);

        //Turn 3
        addToList(cardsList, new EnDefendRed(), true);
        addToList(cardsList, new EnGhostlyArmor(), true);
        addToList(cardsList, new EnJuggernaut(), false);  //removed

        //Turn 4
        addToList(cardsList, new EnImpervious(), false);  //removed
        addToList(cardsList, new EnBodySlam(), true);
        addToList(cardsList, new EnMetallicize(), true);  //removed

        //Turn 5
        addToList(cardsList, new EnPowerThrough(), extraUpgrades);
        addToList(cardsList, new EnFlameBarrier(), false);
        addToList(cardsList, new EnTrueGrit(), false);
        //Removes 1st Wound automatically

        //turn 6
        addToList(cardsList, new EnJuggernaut(), false);
        addToList(cardsList, new EnTrueGrit(), false);
        addToList(cardsList, new EnWound(), true);  //removed

        //Turn 7
        addToList(cardsList, new EnBarricade(), extraUpgrades);  //removed
        addToList(cardsList, new EnGhostlyArmor(), false);
        addToList(cardsList, new EnDefendRed(), true);
    }

    @Override
    public ArrayList<AbstractCard> getThisTurnCards() {
        ArrayList<AbstractCard> cardsList = new ArrayList<>();
        boolean extraUpgrades = AbstractDungeon.ascensionLevel >= 4;
        if (looped) {
            switch (turn) {
                case 0:
                    addToList(cardsList, new EnJAX(), extraUpgrades);
                    addToList(cardsList, new EnClothesline(), true);
                    addToList(cardsList, new EnDefendRed(), false);
                    break;
                case 1:
                    addToList(cardsList, new EnFlameBarrier(), false);
                    addToList(cardsList, new EnArmaments(), true);
                    addToList(cardsList, new EnRegret(), false);
                    break;
                case 2:
                    addToList(cardsList, new EnIronWave(), extraUpgrades);
                    addToList(cardsList, new EnBite(), false);
                    addToList(cardsList, new EnBash(), false);
                    break;
                case 3:
                    addToList(cardsList, new EnTwinStrike(), false);
                    addToList(cardsList, new EnIronWave(), true);
                    addToList(cardsList, new EnBite(), false);
                    break;
                case 4:
                    addToList(cardsList, new EnHeavyBlade(), false);
                    addToList(cardsList, new EnDefendRed(), false); // upgraded from armaments
                    addToList(cardsList, new EnBite(), false);
                    break;
            }
        } else {
            switch (turn) {
                case 0:
                    addToList(cardsList, new EnInflame(), true); // removed
                    addToList(cardsList, new EnArmaments(), true);
                    addToList(cardsList, new EnDefendRed(), false); // now upgraded
                    break;
                case 1:
                    addToList(cardsList, new EnTwinStrike(), false);
                    addToList(cardsList, new EnIronWave(), extraUpgrades);
                    addToList(cardsList, new EnRegret(), false);
                    break;
                case 2:
                    addToList(cardsList, new EnFlameBarrier(), false);
                    addToList(cardsList, new EnJAX(), extraUpgrades);
                    addToList(cardsList, new EnBite(), false);
                    break;
                case 3:
                    addToList(cardsList, new EnHeavyBlade(), false);
                    addToList(cardsList, new EnDefendRed(), false);
                    addToList(cardsList, new EnIronWave(), true);
                    break;
                case 4:
                    addToList(cardsList, new EnBash(), false);
                    addToList(cardsList, new EnBite(), false);
                    addToList(cardsList, new EnBite(), false);
                    break;
                case 5:
                    addToList(cardsList, new EnDemonForm(), extraUpgrades); // removed
                    addToList(cardsList, new EnSeeingRed(), false); // removed
                    addToList(cardsList, new EnClothesline(), true);
                    break;
            }
        }
        turn++;
        if (turn > 5 && !looped) looped = true;
        else if (turn > 4 && looped) {
            turn = 0;
        }
        return cardsList;
    }

    @Override
    public void initializeBonusRelic() {
        addRelic(new CBR_SmoothStone());
    }
}