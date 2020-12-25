package automaton.cards;

import automaton.actions.ChosenAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ChosenStrike extends AbstractBronzeCard {

    public final static String ID = makeID("ChosenStrike");

    //stupid intellij stuff attack, enemy, uncommon

    private static final int DAMAGE = 4;
    private static final int UPG_DAMAGE = 3;

    public ChosenStrike() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = 1;
        thisEncodes();
    }

    @Override
    public void applyPowers() {
        super.applyPowers();
        baseDamage = DAMAGE + misc;
        if (upgraded) baseDamage += UPG_DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    @Override
    public void onCompilePreCardEffectEmbed(boolean forGameplay) {
        if (forGameplay) {
            for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
                if (c.uuid.equals(this.uuid)) {
                    c.misc += magicNumber;
                    c.applyPowers();
                    // c.baseDamage = c.misc;
                }
            }

            for (AbstractCard c : GetAllInBattleInstances.get(this.uuid)) {
                c.misc += magicNumber;
                c.applyPowers();
            }
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}