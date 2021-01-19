package automaton.potions;


import automaton.FunctionHelper;
import automaton.actions.AddToFuncAction;
import automaton.cards.SpaghettiCode;
import basemod.abstracts.CustomPotion;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import com.megacrit.cardcrawl.relics.SacredBark;
import downfall.util.SelectCardsCenteredAction;

import java.util.ArrayList;


public class BuildAFunctionPotion extends CustomPotion {
    public static final String POTION_ID = "bronze:BuildAFunctionPotion";
    private static final PotionStrings potionStrings = CardCrawlGame.languagePack.getPotionString(POTION_ID);
    public static final String NAME = potionStrings.NAME;
    public static final String[] DESCRIPTIONS = potionStrings.DESCRIPTIONS;

    public BuildAFunctionPotion() {
        super(NAME, POTION_ID, PotionRarity.RARE, PotionSize.BOTTLE, PotionColor.ANCIENT);
        this.isThrown = false;
        this.targetRequired = false;
    }

    public void initializeData() {
        this.potency = getPotency();
        if (AbstractDungeon.player != null && AbstractDungeon.player.hasRelic(SacredBark.ID)) {
            this.description = potionStrings.DESCRIPTIONS[1];
        } else {
            this.description = potionStrings.DESCRIPTIONS[0];
        }
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
    }

    public void use(AbstractCreature target) {
        for (int i = 0; i < (FunctionHelper.max - FunctionHelper.held.size()); i++) {
            ArrayList<AbstractCard> cardsList = SpaghettiCode.getRandomEncodeChoices(3);
            addToBot(new SelectCardsCenteredAction(cardsList, 1, "Choose a Card to Encode.", (cards) -> {
                AbstractDungeon.actionManager.addToTop(new AddToFuncAction(cards.get(0), null));
            }));
        }
        if (AbstractDungeon.player.hasRelic(SacredBark.ID)) {
            FunctionHelper.doExtraNonSpecificCopy = true;
        }
    }

    public CustomPotion makeCopy() {
        return new BuildAFunctionPotion();
    }

    public int getPotency(int ascensionLevel) {
        return 1;
    }
}