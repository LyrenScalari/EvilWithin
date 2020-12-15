package automaton.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class FireFromPileAction extends AbstractGameAction {
    private CardGroup g;
    private int repetitions;

    public FireFromPileAction(CardGroup t, int amount, int repetitions) {
        this.g = t;
        this.amount = amount;
        this.repetitions = repetitions;
    }

    public FireFromPileAction(CardGroup t, int amount) {
        this(t, amount, 0);
    }

    @Override
    public void update() {
        if (duration == startDuration) {
            AbstractDungeon.gridSelectScreen.open(g, amount, false, "Choose."); //TODO: Localize
            tickDuration();
        } else {
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                    if (repetitions > 0) {
                        for(int i = 0; i < repetitions; i++) {
                            addToTop(new EasyAutoplayAction(c));
                        }
                    }
                    addToTop(new NewQueueCardAction(c, true));
                }
                isDone = true;
            }
        }
    }
}